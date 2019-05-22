package online.irishdictionary.servlet;

import java.io.InputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Properties;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.apache.commons.lang.time.StopWatch;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import com.javapoets.dbcp.ConnectionPool;
import com.javapoets.dbcp.ConnectionManager;

import online.irishdictionary.util.PropertiesUtil;

public class InitServlet extends HttpServlet {

    private static final Logger logger = LogManager.getLogger();
    public static final String EMPTY      = "";
    public static final String TEXT_HTML      = "text/html";
    public static final String TEXT_HTML_UTF8 = "text/html; charset=UTF-8";
    public static final String UTF_8 = "UTF-8";
    public static final String RESPONSE_COLON_SPACE = "RESPONSE: ";
    public static final String DIR_VIEW = "/view/";
    public static final String EIGHTY = "80";
    public static final String COLON = ":";
    public static final String FORWARDSLASH = "/";

    public ServletContext servletContext;
    public Properties properties = null;  // the init properties
    private ConnectionPool connectionPool;  // a database connection pool

    public ConnectionPool getConnectionPool() {
        logger.debug("getConnectionPool()");

        logger.debug("this = "+this);
        logger.debug("this.connectionPool = "+this.connectionPool);

        return this.connectionPool;
    }

    public void init(ServletConfig config) throws ServletException {
        logger.debug("init("+config+")");

        logger.info("InitServlet.class.getName() = "+InitServlet.class.getName());
        logger.info("getClass().getName() = "+getClass().getName());

        servletContext = config.getServletContext();
        logger.debug("servletContext = "+servletContext);

        // a boolean flag to make sure the init() method is only called once for this servlet.
        String contextInitialized = (String)servletContext.getAttribute("contextInitialized");
        logger.debug("contextInitialized = "+contextInitialized);

        if(contextInitialized == null) {

            try {

                InputStream initPropertiesIputStream = servletContext.getResourceAsStream("/WEB-INF/init.properties");

                this.properties = new Properties();

                try {

                    this.properties.load(initPropertiesIputStream);

                    servletContext.setAttribute("properties", this.properties); // Make the properties available in the ServletContext

                } catch(java.io.IOException ioException) {
                    StringWriter stringWriter = new StringWriter();
                    PrintWriter printWriter = new PrintWriter(stringWriter);
                    ioException.printStackTrace(printWriter);
                    logger.error(stringWriter.toString());
                }

                logger.debug(this.properties);

                String protocol = properties.getProperty("protocol");
                String server = properties.getProperty("server");
                String port = properties.getProperty("port");
                String contextPath = properties.getProperty("context-path");
                
                /**
                 * Environment variable
                 */
                
                String environment = properties.getProperty("environment");
                servletContext.setAttribute("environment", environment);


                /**
                 * Build the context URLs from the init properties
                 */

                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(protocol != null ? protocol : "http");
                stringBuilder.append("://");
                stringBuilder.append(server != null ? server : "localhost");
                if(!EMPTY.equals(port) && !EIGHTY.equals(port)) stringBuilder.append(COLON).append(port);

                String serverUrl = stringBuilder.toString() + FORWARDSLASH;

                if(contextPath != null && !contextPath.equals(EMPTY)) {
                    stringBuilder.append(contextPath);
                    if(!contextPath.equals(FORWARDSLASH)) stringBuilder.append("/");
                } else {
                    stringBuilder.append("/");
                }

                String contextUrl = stringBuilder.toString();

                logger.debug("protocol = "+protocol);
                logger.debug("server = "+server);
                logger.debug("port = "+port);
                logger.debug("contextPath = "+contextPath);
                logger.debug("serverUrl = "+serverUrl);
                logger.debug("contextUrl = "+contextUrl);

                
                String smtpServer = properties.getProperty("smtp.server");
                String smtpPort = properties.getProperty("smtp.port");
                String smtpUser = properties.getProperty("smtp.user");
                String smtpPass = properties.getProperty("smtp.pass");

                String emailAddressFromBlasts = properties.getProperty("email.address.from.blasts");
                String emailAddressFromSupport = properties.getProperty("email.address.from.support");
                String emailAddressToDevelopment = properties.getProperty("email.address.to.development");
                String emailAddressToFeedback = properties.getProperty("email.address.to.feedback");

                logger.debug("smtpServer = "+smtpServer);
                logger.debug("smtpPort = "+smtpPort);
                logger.debug("smtpUser = "+smtpUser);
                logger.debug("smtpPass = "+smtpPass);
                logger.debug("emailAddressFromBlasts = "+emailAddressFromBlasts);
                logger.debug("emailAddressFromSupport = "+emailAddressFromSupport);
                logger.debug("emailAddressToDevelopment = "+emailAddressToDevelopment);
                logger.debug("emailAddressToFeedback = "+emailAddressToFeedback);

                properties.setProperty("serverUrl", serverUrl);
                properties.setProperty("contextUrl", contextUrl);

                servletContext.setAttribute("serverUrl", serverUrl);
                servletContext.setAttribute("contextUrl", contextUrl);
                servletContext.setAttribute("smtpServer", smtpServer);
                servletContext.setAttribute("smtpPort", smtpPort);
                servletContext.setAttribute("smtpUser", smtpUser);
                servletContext.setAttribute("smtpPass", smtpPass);
                servletContext.setAttribute("emailAddressFromBlasts", emailAddressFromBlasts);
                servletContext.setAttribute("emailAddressFromSupport", emailAddressFromSupport);
                servletContext.setAttribute("emailAddressToDevelopment", emailAddressToDevelopment);
                servletContext.setAttribute("emailAddressToFeedback", emailAddressToFeedback);

                /**
                 * Load the prepared statements
                 */
                InputStream preparedStatementsInputStream = servletContext.getResourceAsStream("/WEB-INF/classes/prepared-statements.properties");
                logger.debug("preparedStatementsInputStream = " + preparedStatementsInputStream);
                if(preparedStatementsInputStream == null) preparedStatementsInputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("prepared-statements.properties");
                logger.debug("preparedStatementsInputStream = " + preparedStatementsInputStream);

                ConnectionManager.loadStatements(preparedStatementsInputStream);

                /**
                 * Configure the cookies
                 */
                this.configureCookies(properties);  // configure the javax.servlet.SessionCookieConfig
               
            } catch(Exception exception) {
                StringWriter stringWriter = new StringWriter();
                PrintWriter printWriter = new PrintWriter(stringWriter);
                exception.printStackTrace(printWriter);
                logger.error(stringWriter.toString());
            }

            servletContext.setAttribute("contextInitialized", "true");

        } else {

            logger.debug("Servlet Already Inited!!");

        } // if(contextInitialized != null) {

        /**
         * Check for and create the ConnectionPool object
         */
        this.connectionPool = (ConnectionPool) servletContext.getAttribute("connectionPool");
        logger.debug("this.connectionPool = "+this.connectionPool);

        if(this.connectionPool == null) {

            String jdbcDriver = properties.getProperty("database-driver");
            String databaseUrl = properties.getProperty("database-url");
            String databaseUsername = properties.getProperty("database-username");
            String databasePassword = properties.getProperty("database-password");
            String databaseMinimumConnections = properties.getProperty("database-mininimum-connections");
            String databaseMaximumConnections = properties.getProperty("database-maximum-connections");
            String databaseConnectionMaximumAgeDays = properties.getProperty("database-connection-maximum-age-days");
            String databaseConnectionMaximumIdleSeconds = properties.getProperty("database-connection-maximum-idle-seconds");

            logger.debug("jdbcDriver = " + jdbcDriver);
            logger.debug("databaseUrl = " + databaseUrl);
            logger.debug("databaseUsername = " + databaseUsername);
            logger.debug("databasePassword = " + databasePassword);
            logger.debug("databaseMinimumConnections = " + databaseMinimumConnections);
            logger.debug("databaseMinimumConnections = " + databaseMinimumConnections);
            logger.debug("databaseConnectionMaximumAgeDays = " + databaseConnectionMaximumAgeDays);
            logger.debug("databaseConnectionMaximumIdleSeconds = " + databaseConnectionMaximumIdleSeconds);

            properties.setProperty("databaseUrl", databaseUrl);
            servletContext.setAttribute("databaseUrl", databaseUrl);
            properties.setProperty("jdbcDriver", jdbcDriver);
            servletContext.setAttribute("jdbcDriver", jdbcDriver);
            properties.setProperty("databaseUsername", databaseUsername);
            servletContext.setAttribute("databaseUsername", databaseUsername);
            properties.setProperty("databasePassword", databasePassword);
            servletContext.setAttribute("databasePassword", databasePassword);

            properties.setProperty("databaseMinimumConnections", databaseMinimumConnections);
            //servletContext.setAttribute("databaseMinimumConnections", databaseMinimumConnections);
            properties.setProperty("databaseMaximumConnections", databaseMaximumConnections);
            properties.setProperty("databaseConnectionMaximumAgeDays", databaseConnectionMaximumAgeDays);
            properties.setProperty("databaseConnectionMaximumIdleSeconds", databaseConnectionMaximumIdleSeconds);

            java.util.Properties connectionPoolProperties = new java.util.Properties();
            connectionPoolProperties.setProperty("id", "-1");
            connectionPoolProperties.setProperty("url", databaseUrl);
            connectionPoolProperties.setProperty("driver", jdbcDriver);
            connectionPoolProperties.setProperty("username", databaseUsername);
            connectionPoolProperties.setProperty("password", databasePassword);
            connectionPoolProperties.setProperty("minConns", databaseMinimumConnections);
            connectionPoolProperties.setProperty("maxConns", databaseMaximumConnections);
            connectionPoolProperties.setProperty("maxAgeDays", databaseConnectionMaximumAgeDays);
            connectionPoolProperties.setProperty("maxIdleSeconds", databaseConnectionMaximumIdleSeconds);

            logger.debug("connectionPoolProperties = " + connectionPoolProperties);

            try {

                this.connectionPool = new ConnectionPool(connectionPoolProperties);
                logger.debug("this.connectionPool = " + this.connectionPool);

                servletContext.setAttribute("connectionPool", this.connectionPool);

            } catch(java.io.IOException ioException) {
                StringWriter stringWriter = new StringWriter();
                PrintWriter printWriter = new PrintWriter(stringWriter);
                ioException.printStackTrace(printWriter);
                logger.error(stringWriter.toString());
            }

        }

        super.init(config);
    }

    public Properties getProperties() {
        logger.debug("getProperties()");

        logger.debug("this.properties = "+this.properties);
        logger.debug("this.properties.size() = "+this.properties.size());
        return this.properties;
    }

    private void configureCookies(Properties properties) {
        logger.debug("configureCookies(properties)");

        String sessionCookieConfigPath = properties.getProperty("session.cookie.config.path");
        String sessionCookieConfigDomain = properties.getProperty("session.cookie.config.domain");
        String sessionCookieConfigComment = properties.getProperty("session.cookie.config.comment");
        String sessionCookieConfigMaxAgeSeconds = properties.getProperty("session.cookie.config.maxage.seconds");
        String sessionCookieConfigSecure = properties.getProperty("session.cookie.config.secure");
        String sessionCookieConfigHttpOnly = properties.getProperty("session.cookie.config.httponly");

        logger.debug("sessionCookieConfigPath = "+sessionCookieConfigPath);
        logger.debug("sessionCookieConfigDomain = "+sessionCookieConfigDomain);
        logger.debug("sessionCookieConfigComment = "+sessionCookieConfigComment);
        logger.debug("sessionCookieConfigMaxAgeSeconds = "+sessionCookieConfigMaxAgeSeconds);
        logger.debug("sessionCookieConfigSecure = "+sessionCookieConfigSecure);
        logger.debug("sessionCookieConfigHttpOnly = "+sessionCookieConfigHttpOnly);

        javax.servlet.SessionCookieConfig sessionCookieConfig = servletContext.getSessionCookieConfig();

        sessionCookieConfig.setPath(sessionCookieConfigPath); // Sets the path that will be assigned to any session tracking cookies created on behalf of the application represented by the ServletContext from which this SessionCookieConfig was acquired.
        sessionCookieConfig.setDomain(sessionCookieConfigDomain); // Sets the domain name that will be assigned to any session tracking cookies created on behalf of the application represented by the ServletContext from which this SessionCookieConfig was acquired.
        sessionCookieConfig.setComment(sessionCookieConfigComment);
        //sessionCookieConfig.setHttpOnly(false); // Marks or unmarks the session tracking cookies created on behalf of the application represented by the ServletContext from which this SessionCookieConfig was acquired as HttpOnly.
        if(sessionCookieConfigHttpOnly != null) {
            sessionCookieConfig.setHttpOnly(new Boolean(sessionCookieConfigHttpOnly).booleanValue()); // Marks or unmarks the session tracking cookies created on behalf of the application represented by the ServletContext from which this SessionCookieConfig was acquired as HttpOnly.
        }
        sessionCookieConfig.setMaxAge(Integer.parseInt(sessionCookieConfigMaxAgeSeconds)); // Sets the lifetime (in seconds) for the session tracking cookies created on behalf of the application represented by the ServletContext from which this SessionCookieConfig was acquired.
        //sessionCookieConfig.setName(java.lang.String name); // Sets the name that will be assigned to any session tracking cookies created on behalf of the application represented by the ServletContext from which this SessionCookieConfig was acquired.
        //sessionCookieConfig.setSecure(boolean secure); // Marks or unmarks the session tracking cookies created on behalf of the application represented by the ServletContext from which this SessionCookieConfig was acquired as secure.
        if(sessionCookieConfigSecure != null) {
            sessionCookieConfig.setSecure(new Boolean(sessionCookieConfigSecure).booleanValue()); // Marks or unmarks the session tracking cookies created on behalf of the application represented by the ServletContext from which this SessionCookieConfig was acquired as HttpOnly.
        }

        this.printSessionCookieConfig(sessionCookieConfig);
    }

    private void printSessionCookieConfig(javax.servlet.SessionCookieConfig sessionCookieConfig) {
        logger.debug("sessionCookieConfig.getComment() = "+sessionCookieConfig.getComment()); // Gets the comment that will be assigned to any session tracking cookies created on behalf of the application represented by the ServletContext from which this SessionCookieConfig was acquired.
        logger.debug("sessionCookieConfig.getDomain() = "+sessionCookieConfig.getDomain()); // Gets the domain name that will be assigned to any session tracking cookies created on behalf of the application represented by the ServletContext from which this SessionCookieConfig was acquired.
        logger.debug("sessionCookieConfig.getMaxAge() = "+sessionCookieConfig.getMaxAge()); // Gets the lifetime (in seconds) of the session tracking cookies created on behalf of the application represented by the ServletContext from which this SessionCookieConfig was acquired.
        logger.debug("sessionCookieConfig.getName() = "+sessionCookieConfig.getName()); // Gets the name that will be assigned to any session tracking cookies created on behalf of the application represented by the ServletContext from which this SessionCookieConfig was acquired.
        logger.debug("sessionCookieConfig.getPath() = "+sessionCookieConfig.getPath()); // Gets the path that will be assigned to any session tracking cookies created on behalf of the application represented by the ServletContext from which this SessionCookieConfig was acquired.
        logger.debug("sessionCookieConfig.isHttpOnly() = "+sessionCookieConfig.isHttpOnly()); // Checks if the session tracking cookies created on behalf of the application represented by the ServletContext from which this SessionCookieConfig was acquired will be marked as HttpOnly.
        logger.debug("sessionCookieConfig.isSecure() = "+sessionCookieConfig.isSecure()); // Checks if the session tracking cookies created on behalf of the application represented by the ServletContext from which this SessionCookieConfig was acquired will be marked as secure even if the request that initiated the corresponding session is using plain HTTP instead of HTTPS.
    }

    /*
            StopWatch sw = new StopWatch(); sw.start(); // Timing

            logger.warn("APPLICATION \""+config.getServletContext().getServletContextName()+"\" starting...");
            logger.warn("Servlet container's API version : \""+config.getServletContext().getMajorVersion()+"."+config.getServletContext().getMinorVersion()+"\"");
            logger.warn("Server Info : \""+config.getServletContext().getServerInfo()+"\"");
    */

    protected void include(HttpServletRequest request, HttpServletResponse response, String path) throws IOException, ServletException {
        include(request, response, path, TEXT_HTML_UTF8);
    }

    protected void include(HttpServletRequest request, HttpServletResponse response, String path, String contentType) throws IOException, ServletException {
        //logger.debug("include(request, response, '"+path+"', '"+contentType+"')");

        response.setContentType(contentType);

        /*
        StringBuilder sb = new StringBuilder();
        sb.append(RESPONSE_COLON_SPACE).append(path);
        logger.info(sb.toString());
        */

        try {

            //this.getServletConfig().getServletContext().getRequestDispatcher(path).include(request, response);
            servletContext.getRequestDispatcher(path).include(request, response);

        } catch(java.io.FileNotFoundException e) {
            //logger.error("FileNotFoundException: '"+path+"' "+e.getMessage());
            logger.error(e);
        }

    }

    protected void includeUtf8(HttpServletRequest request, HttpServletResponse response, String path) throws IOException, ServletException {
        logger.debug("includeUtf8(request, response, '"+path+"')");

        includeUtf8(
          request
          , response
          , path
          , TEXT_HTML_UTF8
        );
    }

    /**
     * @param contentType e.g. "text/html;charset=UTF-8";
     */
    protected void includeUtf8(HttpServletRequest request, HttpServletResponse response, String path, String contentType) throws IOException, ServletException {
        logger.debug("includeUtf8(request, response, '"+path+"', '"+contentType+"')");

        response.setContentType(contentType);
        response.setCharacterEncoding(UTF_8);

        // logging
        StringBuilder sb = new StringBuilder();
        sb.append(RESPONSE_COLON_SPACE);
        sb.append(path);

        /*
        HttpSession session = request.getSession(false);
        //logger.debug("session = "+session);

        if(session != null) {

            User user;
            if((user = (User)session.getAttribute("user")) != null) {
                sb.append(" - ").append(LEFT_PAREN);
                sb.append(user.getId()).append(SPACE).append(user.getUsername());
                sb.append(SPACE).append(session.getId());
                //sb.append(COLON).append(user.getCookieId());
                sb.append(SPACE).append(session.getAttribute(SESSION_HASH));
                sb.append(RIGHT_PAREN);

            }

        }
        */

        logger.info(sb.toString());

        try {

            //logger.debug("context = "+context);
            //logger.debug("servletContext = "+servletContext);
            //logger.debug("this.getServletConfig() = "+this.getServletConfig());
            //logger.debug("this.getServletConfig().getServletContext() = "+this.getServletConfig().getServletContext());

            //this.getServletConfig().getServletContext().getRequestDispatcher(path).include(request, response);
            //context.getRequestDispatcher(path).include(request, response);

            servletContext.getRequestDispatcher(path).include(request, response);

            /*
            try {
                //response.getOutputStream().flush(); // yes/no/why?
                response.getOutputStream().close(); // yes/no/why?
            } catch(Exception e){
                logger.error(e);

                StringWriter sr = new StringWriter();
                PrintWriter pw = new PrintWriter(sr);
                e.printStackTrace(pw);
                logger.error(sr.toString());
            }
            */

        } catch(java.io.FileNotFoundException e) {

            logger.error("FileNotFoundException: include(request, response, '"+path+"', '"+contentType+"'): e.getMessage() = "+e.getMessage());
            logger.error(e);

        }

    }

}

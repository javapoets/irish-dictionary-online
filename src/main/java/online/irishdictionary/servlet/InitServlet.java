package online.irishdictionary.servlet;

import java.io.InputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.Properties;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
//import org.apache.commons.lang.time.StopWatch;
import javapoets.dbcp.ConnectionPool;
import javapoets.dbcp.ConnectionManager;
import online.irishdictionary.util.PropertiesUtil;
import online.irishdictionary.database.VerbDatabaseManager;

public class InitServlet extends HttpServlet {

    private static final org.apache.logging.log4j.Logger log = org.apache.logging.log4j.LogManager.getLogger();
    public static final String EMPTY = "";
    public static final String TEXT_HTML = "text/html";
    public static final String TEXT_HTML_UTF8 = "text/html; charset=UTF-8";
    public static final String UTF_8 = "UTF-8";
    public static final String RESPONSE_COLON_SPACE = "RESPONSE: ";
    public static final String DIR_VIEW = "/view/";
    public static final String EIGHTY = "80";
    public static final String COLON = ":";
    public static final String FORWARDSLASH = "/";
    private final String LANG = "lang";
    protected final String IRISH = "irish";
    protected final String ENGLISH = "english";
    protected final String LANG_ENGLISH = "en";
    protected final String LANG_IRISH = "ga";
    protected final int IRISH_LANGUAGE_ID = 2;
    protected final int ENGLISH_LANGUAGE_ID = 1;
    public ServletContext servletContext;
    public Properties properties = null;  // the init properties
    private ConnectionPool connectionPool;  // a database connection pool
    private Executor executor = null;

    protected void execute(Runnable runnable) {
        log.debug("execute(runnable)");
        this.executor.execute(runnable);
    }

    public ConnectionPool getConnectionPool() {
        log.debug("getConnectionPool()");
        log.debug("this = " + this);
        log.debug("this.connectionPool = " + this.connectionPool);
        return this.connectionPool;
    }

    public void init(ServletConfig servletConfig) throws ServletException {
        log.debug("init(" + servletConfig + ")");
        log.info("InitServlet.class.getName() = " + InitServlet.class.getName());
        log.info("getClass().getName() =        " + getClass().getName());
        servletContext = servletConfig.getServletContext();
        log.debug("servletContext = "+servletContext);
        // a boolean flag to make sure the init() method is only called once for this servlet.
        String contextInitialized = (String)servletContext.getAttribute("contextInitialized");
        log.debug("contextInitialized = "+contextInitialized);
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
                    log.error(stringWriter.toString());
                }
                log.debug(this.properties);
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
                log.debug("protocol = "+protocol);
                log.debug("server = "+server);
                log.debug("port = "+port);
                log.debug("contextPath = "+contextPath);
                log.debug("serverUrl = "+serverUrl);
                log.debug("contextUrl = "+contextUrl);
                String smtpServer = properties.getProperty("smtp.server");
                String smtpPort = properties.getProperty("smtp.port");
                String smtpUser = properties.getProperty("smtp.user");
                String smtpPass = properties.getProperty("smtp.pass");
                String emailAddressFromBlasts = properties.getProperty("email.address.from.blasts");
                String emailAddressFromSupport = properties.getProperty("email.address.from.support");
                String emailAddressToDevelopment = properties.getProperty("email.address.to.development");
                String emailAddressToFeedback = properties.getProperty("email.address.to.feedback");
                log.debug("smtpServer = " + smtpServer);
                log.debug("smtpPort = " + smtpPort);
                log.debug("smtpUser = " + smtpUser);
                log.debug("smtpPass = " + smtpPass);
                log.debug("emailAddressFromBlasts = " + emailAddressFromBlasts);
                log.debug("emailAddressFromSupport = " + emailAddressFromSupport);
                log.debug("emailAddressToDevelopment = " + emailAddressToDevelopment);
                log.debug("emailAddressToFeedback = " + emailAddressToFeedback);
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
                log.debug("preparedStatementsInputStream = " + preparedStatementsInputStream);
                if(preparedStatementsInputStream == null) preparedStatementsInputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("prepared-statements.properties");
                log.debug("preparedStatementsInputStream = " + preparedStatementsInputStream);
                ConnectionManager.loadStatements(preparedStatementsInputStream);

                /**
                 * Configure the cookies
                 */
                this.configureCookies(properties);  // configure the jakarta.servlet.SessionCookieConfig
            } catch(Exception exception) {
                log.error(exception.getMessage(), exception);
            }
            servletContext.setAttribute("contextInitialized", "true");
        } else {
            log.debug("Servlet Already Inited!!");
        } // if(contextInitialized != null) {

        /**
         * Check for and create the ConnectionPool object
         */
        this.connectionPool = (ConnectionPool) servletContext.getAttribute("connectionPool");
        log.debug("this.connectionPool = "+this.connectionPool);

        if(this.connectionPool == null) {
            try {
                this.connectionPool = new ConnectionPool(this.properties);
                log.debug("this.connectionPool = " + this.connectionPool);
                servletContext.setAttribute("connectionPool", this.connectionPool);
                try {
                    int irishVerbsCount = VerbDatabaseManager.selectVerbCount(2, this.connectionPool);
                    servletContext.setAttribute("irishVerbsCount", irishVerbsCount);
                    int englishVerbsCount = VerbDatabaseManager.selectVerbCount(1, this.connectionPool);
                    servletContext.setAttribute("englishVerbsCount", englishVerbsCount);
                } catch (Exception e) {
                    log.error(e.getMessage(), e);
                }
            } catch (java.io.IOException ioException) {
                StringWriter stringWriter = new StringWriter();
                PrintWriter printWriter = new PrintWriter(stringWriter);
                ioException.printStackTrace(printWriter);
                log.error(stringWriter.toString());
            }
        }

        this.executor = new ThreadPoolExecutor (
            10
          , 10
          , 50000L
          , java.util.concurrent.TimeUnit.MILLISECONDS
          , new java.util.concurrent.LinkedBlockingQueue<Runnable>(100)
        );
        log.debug( "this.executor = " + this.executor );

        super.init(servletConfig);
    }

    public Properties getProperties() {
        log.debug("getProperties()");
        log.debug("this.properties = "+this.properties);
        log.debug("this.properties.size() = "+this.properties.size());
        return this.properties;
    }

    private void configureCookies(Properties properties) {
        log.debug("configureCookies(properties)");
        String sessionCookieConfigPath = properties.getProperty("session.cookie.config.path");
        String sessionCookieConfigDomain = properties.getProperty("session.cookie.config.domain");
        String sessionCookieConfigComment = properties.getProperty("session.cookie.config.comment");
        String sessionCookieConfigMaxAgeSeconds = properties.getProperty("session.cookie.config.maxage.seconds");
        String sessionCookieConfigSecure = properties.getProperty("session.cookie.config.secure");
        String sessionCookieConfigHttpOnly = properties.getProperty("session.cookie.config.httponly");
        log.debug("sessionCookieConfigPath = "+sessionCookieConfigPath);
        log.debug("sessionCookieConfigDomain = "+sessionCookieConfigDomain);
        log.debug("sessionCookieConfigComment = "+sessionCookieConfigComment);
        log.debug("sessionCookieConfigMaxAgeSeconds = "+sessionCookieConfigMaxAgeSeconds);
        log.debug("sessionCookieConfigSecure = "+sessionCookieConfigSecure);
        log.debug("sessionCookieConfigHttpOnly = "+sessionCookieConfigHttpOnly);
        jakarta.servlet.SessionCookieConfig sessionCookieConfig = servletContext.getSessionCookieConfig();
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

    private void printSessionCookieConfig(jakarta.servlet.SessionCookieConfig sessionCookieConfig) {
        log.debug("sessionCookieConfig.getComment() = "+sessionCookieConfig.getComment()); // the comment that will be assigned to any session tracking cookies created on behalf of the application represented by the ServletContext from which this SessionCookieConfig was acquired.
        log.debug("sessionCookieConfig.getDomain() = "+sessionCookieConfig.getDomain()); // the domain name that will be assigned to any session tracking cookies created on behalf of the application represented by the ServletContext from which this SessionCookieConfig was acquired.
        log.debug("sessionCookieConfig.getMaxAge() = "+sessionCookieConfig.getMaxAge()); // the lifetime (in seconds) of the session tracking cookies created on behalf of the application represented by the ServletContext from which this SessionCookieConfig was acquired.
        log.debug("sessionCookieConfig.getName() = "+sessionCookieConfig.getName()); // the name that will be assigned to any session tracking cookies created on behalf of the application represented by the ServletContext from which this SessionCookieConfig was acquired.
        log.debug("sessionCookieConfig.getPath() = "+sessionCookieConfig.getPath()); // the path that will be assigned to any session tracking cookies created on behalf of the application represented by the ServletContext from which this SessionCookieConfig was acquired.
        log.debug("sessionCookieConfig.isHttpOnly() = "+sessionCookieConfig.isHttpOnly()); // checks if the session tracking cookies created on behalf of the application represented by the ServletContext from which this SessionCookieConfig was acquired will be marked as HttpOnly.
        log.debug("sessionCookieConfig.isSecure() = "+sessionCookieConfig.isSecure()); // checks if the session tracking cookies created on behalf of the application represented by the ServletContext from which this SessionCookieConfig was acquired will be marked as secure even if the request that initiated the corresponding session is using plain HTTP instead of HTTPS.
    }

    protected void include(HttpServletRequest request, HttpServletResponse response, String path) throws IOException, ServletException {
        include(request, response, path, TEXT_HTML_UTF8);
    }

    protected void include(HttpServletRequest request, HttpServletResponse response, String path, String contentType) throws IOException, ServletException {
        //log.debug("include(request, response, '"+path+"', '"+contentType+"')");
        response.setContentType(contentType);
        /*
        StringBuilder sb = new StringBuilder();
        sb.append(RESPONSE_COLON_SPACE).append(path);
        log.info(sb.toString());
        */
        try {
            //this.getServletConfig().getServletContext().getRequestDispatcher(path).include(request, response);
            servletContext.getRequestDispatcher(path).include(request, response);
        } catch(java.io.FileNotFoundException e) {
            //log.error("FileNotFoundException: '"+path+"' "+e.getMessage());
            log.error(e);
        }
    }

    protected void includeUtf8(HttpServletRequest request, HttpServletResponse response, String path) throws IOException, ServletException {
        log.debug("includeUtf8(request, response, '"+path+"')");
        includeUtf8(request, response, path, TEXT_HTML_UTF8);
    }

    /**
     * @param contentType e.g. "text/html;charset=UTF-8";
     */
    protected void includeUtf8(HttpServletRequest request, HttpServletResponse response, String path, String contentType) throws IOException, ServletException {
        log.debug("includeUtf8(request, response, '"+path+"', '"+contentType+"')");
        response.setContentType(contentType);
        response.setCharacterEncoding(UTF_8);
        // logging
        StringBuilder sb = new StringBuilder();
        sb.append(RESPONSE_COLON_SPACE);
        sb.append(path);
        /*
        HttpSession session = request.getSession(false);
        //log.debug("session = "+session);
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
        log.info(sb.toString());
        try {
            //log.debug("context = "+context);
            //log.debug("servletContext = "+servletContext);
            //log.debug("this.getServletConfig() = "+this.getServletConfig());
            //log.debug("this.getServletConfig().getServletContext() = "+this.getServletConfig().getServletContext());
            //this.getServletConfig().getServletContext().getRequestDispatcher(path).include(request, response);
            //context.getRequestDispatcher(path).include(request, response);
            servletContext.getRequestDispatcher(path).include(request, response);
            /*
            try {
                //response.getOutputStream().flush(); // yes/no/why?
                response.getOutputStream().close(); // yes/no/why?
            } catch(Exception e){
                log.error(e);

                StringWriter sr = new StringWriter();
                PrintWriter pw = new PrintWriter(sr);
                e.printStackTrace(pw);
                log.error(sr.toString());
            }
            */
        } catch (java.io.FileNotFoundException e) {
            log.error(e.getMessage(), e);
        }
    }

    protected void checkForLangParameter(HttpServletRequest request, HttpServletResponse response) {
        log.debug("checkForLangParameter(request, response)");
        String lang  = request.getParameter(LANG);
        log.debug("lang = " + lang);
        if (lang != null) {
            if (lang.length() == 2) {
                request.setAttribute("lang", lang);
                HttpSession session = request.getSession(true);
                log.debug("session = " + session);
                session.setAttribute("lang", lang);
            }
        }
    }
}

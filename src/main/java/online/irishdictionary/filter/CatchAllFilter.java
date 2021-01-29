package online.irishdictionary.filter;

import java.io.InputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Map;
import java.util.HashMap;
import java.util.Properties;
import javax.servlet.annotation.WebFilter;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

    //urlPatterns = { "/dictionary/*" }

@WebFilter(
      urlPatterns = { "*", "/*" }
    , dispatcherTypes = { DispatcherType.REQUEST }
    , asyncSupported = false
)
public class CatchAllFilter implements Filter {

    private static final org.apache.logging.log4j.Logger log = org.apache.logging.log4j.LogManager.getLogger();
    private static final String EMPTY_STRING = "";
    private static final String EIGHTY = "80";
    private static final String COLON = ":";
    private static final String FORWARD_SLASH = "/";

    private ServletContext servletContext;
    private String contextUrl = null;
    private Map<String, String> redirectMap = null;
    public Properties properties = null;

    public void init(FilterConfig filterConfig) throws ServletException {
        log.debug("init("+filterConfig+")");

        //this.contextUrl = (String) filterConfig.getServletContext().getAttribute("contextUrl");
        servletContext = filterConfig.getServletContext();
        log.debug("servletContext = " + servletContext);

        try {
            InputStream initPropertiesIputStream = servletContext.getResourceAsStream("/WEB-INF/init.properties");
            this.properties = new Properties();
            try {
                this.properties.load(initPropertiesIputStream);
                servletContext.setAttribute("properties", this.properties);
            } catch (java.io.IOException ioException) {
                log.warn(ioException);
            }
            log.debug(this.properties);

            String protocol = properties.getProperty("protocol");
            String server = properties.getProperty("server");
            final String port = properties.getProperty("port");
            final String contextPath = properties.getProperty("context-path");

            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(protocol != null ? protocol : "http");
            stringBuilder.append("://");
            stringBuilder.append(server != null ? server : "localhost");
            if (!EMPTY_STRING.equals(port) && !EIGHTY.equals(port)) {
                stringBuilder.append(COLON).append(port);
            }
            String serverUrl = stringBuilder.toString() + FORWARD_SLASH;
            log.debug("serverUrl = " + serverUrl);
            if (contextPath != null && !contextPath.equals(EMPTY_STRING)) {
                stringBuilder.append(contextPath);
                if (!contextPath.equals(FORWARD_SLASH)) {
                    stringBuilder.append("/");
                }
            } else {
                stringBuilder.append("/");
            }

            this.contextUrl = stringBuilder.toString();
            log.debug("this.contextUrl = " + this.contextUrl);
            properties.setProperty("serverUrl", serverUrl);
            properties.setProperty("contextUrl", contextUrl);
            servletContext.setAttribute("serverUrl", serverUrl);
            servletContext.setAttribute("contextUrl", contextUrl);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.debug("doFilter(servletRequest, servletResponse, filterChain)");

        HttpServletRequest request = (HttpServletRequest)servletRequest;
        log.debug("request.getServletPath() = " + request.getServletPath());
        log.debug("request.getPathInfo() = " + request.getPathInfo());
        log.debug("request.getRequestURI() = " + request.getRequestURI());
        log.debug("request.getRequestURL() = " + request.getRequestURL());
        log.debug("request.getPathTranslated() = " + request.getPathTranslated()); // Returns any extra path information after the servlet name but before the query string, and translates it to a real path.

        String servletPath = request.getServletPath();
        log.debug("servletPath = " + servletPath);
        if (servletPath != null) {
            log.debug("servletPath.startsWith(\"/css\") = " + servletPath.startsWith("/css"));
            log.debug("servletPath.startsWith(\"/view/images\") = " + servletPath.startsWith("/view/images"));
            if (
                (servletPath.startsWith("/css"))
                || (servletPath.startsWith("/view/images"))
            ) {
                log.info("Bypassing...");
                filterChain.doFilter(servletRequest, servletResponse);
                return;
            }
        }

        try {
            servletContext.getRequestDispatcher("/view/system-down.jsp").include((HttpServletRequest)servletRequest, (HttpServletResponse)servletResponse);
        } catch(java.io.FileNotFoundException e) {
            log.error(e.getMessage(), e);
        }
    }
}

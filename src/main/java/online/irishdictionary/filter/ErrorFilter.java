package online.irishdictionary.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.annotation.WebFilter;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
/*
import java.io.InputStream;
import java.io.StringWriter;
import java.util.Map;
import java.util.HashMap;
import java.util.Properties;
import javax.servlet.DispatcherType;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
*/

/*
@WebFilter(
      filterName = "ErrorFilter"
    , urlPatterns = { "/*" }
    , dispatcherTypes = { DispatcherType.ERROR }
    , asyncSupported = false
)
*/
public class ErrorFilter implements Filter {

    private static final org.apache.logging.log4j.Logger log = org.apache.logging.log4j.LogManager.getLogger();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    /*
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
    */

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.debug("doFilter(servletRequest, servletResponse, filterChain)");
        filterChain.doFilter(servletRequest, servletResponse);
        PrintWriter printWriter = servletResponse.getWriter();
        printWriter.println("In the filter:");
        Exception exception = (Exception)servletRequest.getAttribute(RequestDispatcher.ERROR_EXCEPTION);
        printWriter.printf("Exception: %s%n", exception);
        Integer errorStatusCode = (Integer) servletRequest.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        printWriter.printf("Status Code: %s%n", errorStatusCode);
        String requestUri = (String)servletRequest.getAttribute(RequestDispatcher.ERROR_REQUEST_URI);
        printWriter.printf("Request URI: %s%n", requestUri);
        printWriter.printf("Dispatcher Type: %s%n", servletRequest.getDispatcherType());
        printWriter.println("Stack trace:");
        StringWriter stringWriter = new StringWriter();
        PrintWriter exceptionPrintWriter = new PrintWriter(stringWriter);
        exception.printStackTrace(exceptionPrintWriter);
        printWriter.println(stringWriter.toString());
    }

    @Override
    public void destroy() {}
}
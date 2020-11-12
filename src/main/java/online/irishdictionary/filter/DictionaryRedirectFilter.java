package online.irishdictionary.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Map;
import java.util.HashMap;

import javax.servlet.annotation.WebFilter;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(
    urlPatterns = { "/dictionary/*" }
    , dispatcherTypes = { DispatcherType.REQUEST }
    , asyncSupported = false
)
public class DictionaryRedirectFilter implements Filter {

    private static final org.apache.logging.log4j.Logger log = org.apache.logging.log4j.LogManager.getLogger();
    private String contextUrl = null;
    private Map<String, String> redirectMap = null;

    public void init(FilterConfig filterConfig) throws ServletException {
        log.debug("init("+filterConfig+")");
        this.contextUrl = (String) filterConfig.getServletContext().getAttribute("contextUrl");
        log.debug("this.contextUrl = "+this.contextUrl);
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.debug("doFilter(servletRequest, servletResponse, filterChain)");

        java.util.Enumeration parameterNames = (java.util.Enumeration)request.getParameterNames();
        log.debug("Parameters:");
        while (parameterNames.hasMoreElements()) {
            String parameterName = (String)parameterNames.nextElement();
            log.debug(parameterName+" = "+request.getParameter(parameterName));
        }

        //String wordParameter = request.getParameter("word");
        String wordParameter = null;
        try {
            wordParameter = request.getParameter("word");
        } catch (Exception e) {
            e.printStackTrace();
        }
        String language = request.getParameter("language");
        String languageIdParam = request.getParameter("languageId");
        String fromLanguage = request.getParameter("fromLanguage");
        String toLanguage = request.getParameter("toLanguage");
        String remoteAddr = request.getRemoteAddr();
        String locale = (request.getLocale()).toString();
        log.debug("remoteAddr = " + remoteAddr);

        StringBuilder stringBuilder = new StringBuilder()
            .append(locale)
            .append("/")
            .append(remoteAddr)
            .append(": ")
            .append(language)
            .append("/")
            .append(wordParameter);
        log.info(stringBuilder.toString());

        StringBuilder redirectUrl = new StringBuilder()
            .append(locale)
            //.append("http://").append(remoteAddr)
            .append(this.contextUrl)
            .append("/").append(language)
            .append("/").append(toLanguage)
            .append("/").append(wordParameter);
            .toString();
        log.debug("redirectUrl = " + redirectUrl);

        if (redirectUrl != null) {
            ((javax.servlet.http.HttpServletResponse)servletResponse).setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY); // 301 moved permanently
            ((javax.servlet.http.HttpServletResponse)servletResponse).setHeader("Location", redirectLocation);
            ((javax.servlet.http.HttpServletResponse)servletResponse).setHeader("Connection", "close");
            return;
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }
}

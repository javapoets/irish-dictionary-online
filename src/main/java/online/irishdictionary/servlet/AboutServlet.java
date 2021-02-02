package online.irishdictionary.servlet;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.ServletConfig;
import online.irishdictionary.database.VerbDatabaseManager;
import online.irishdictionary.model.Verb;

@WebServlet(name = "AboutServlet", asyncSupported = false, urlPatterns = {
    "about"
})
public class AboutServlet extends online.irishdictionary.servlet.InitServlet {

    private static final org.apache.logging.log4j.Logger log = org.apache.logging.log4j.LogManager.getLogger();
    private static final String ZERO = "0";
    private static final String FORWARD_SLASH = "/";

    public void init(ServletConfig config) throws ServletException {
        log.debug("init("+config+")");
        super.init(config);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        log.debug("doGet(request, response)");
        log.debug("request.getScheme()         = "  +request.getScheme());
        log.debug("request.getLocalAddr()      = " + request.getLocalAddr());
        log.debug("request.getLocalName()      = " + request.getLocalName());
        log.debug("request.getServerName()     = " + request.getServerName());
        log.debug("request.getServerPort()     = " + request.getServerPort());
        log.debug("request.getContextPath()    = " + request.getContextPath());
        log.debug("request.getHeader(\"Host\") = " + request.getHeader("Host"));
        log.debug("request.getPathInfo()       = " + request.getPathInfo());
        log.debug("request.getRequestURI()     = " + request.getRequestURI());
        log.debug("request.getLocale()         = " + request.getLocale());
        log.debug("request.getQueryString()    = " + request.getQueryString());
        log.debug("request.getRemoteAddr()     = " + request.getRemoteAddr());
        log.debug("request.getRemoteHost()     = " + request.getRemoteHost());
        log.debug("request.getRemoteUser()     = " + request.getRemoteUser());
        log.debug("request.getContentLength()  = " + request.getContentLength());
        log.debug("request.getContentLength()  = " + request.getContentLength());
        try {
            aboutRequest(request, response);  // Non-async request
        } catch(Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    /*
     * Constructor takes the AsyncContext, which contains the request/response.
     */
    /*
    public class AboutRequest implements Runnable {
        AsyncContext asyncContext;
        public AboutRequest(AsyncContext asyncContext) {
            log.debug("AboutRequest(asyncContext)");
            this.asyncContext = asyncContext;
            this.asyncContext.setTimeout(1000*5);  // 5 seconds timeout
        }
        public void run() {
            try {
                aboutRequest(
                    (HttpServletRequest)this.asyncContext.getRequest()
                  , (HttpServletResponse)this.asyncContext.getResponse()
                );
                this.asyncContext.complete();          // and complete the request.
            } catch(IOException e) {
                log.error(e.getMessage(), e);
            } catch(Exception e) {
                log.error(e.getMessage(), e);
            }
        }
    }
    */

    public void aboutRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        log.debug("aboutRequest(request, response)");
        try {
            includeUtf8(request, response, "/view/about.jsp");
        } catch(Exception e) {
            log.error(e.getMessage(), e);
        }
    }
}

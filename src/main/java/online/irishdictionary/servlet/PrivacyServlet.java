package online.irishdictionary.servlet;

import java.io.IOException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletConfig;

@WebServlet(name = "PrivacyServlet", asyncSupported = false, urlPatterns = {
    "privacy"
})
public class PrivacyServlet extends online.irishdictionary.servlet.InitServlet {

    private static final org.apache.logging.log4j.Logger log = org.apache.logging.log4j.LogManager.getLogger();

    public void init(ServletConfig config) throws ServletException {
        log.debug("init("+config+")");
        super.init(config);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        log.debug("doGet(request, response)");
        try {
            super.checkForLangParameter(request, response); // check for the "lang" parameter
            //super.execute(new PrivacyRequest(request.startAsync())); // Async
            privacyRequest(request, response);
        } catch(Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    /*
    public class PrivacyRequest implements Runnable {
        AsyncContext asyncContext;
        public PrivacyRequest(AsyncContext asyncContext) {
            log.debug("PrivacyRequest(asyncContext)");
            this.asyncContext = asyncContext;
            this.asyncContext.setTimeout(1000*5);  // 5 seconds timeout
        }
        public void run() {
            try {
                privacyRequest(
                    (HttpServletRequest)this.asyncContext.getRequest()
                  , (HttpServletResponse)this.asyncContext.getResponse()
                );
                this.asyncContext.complete();          // and complete the request.
            } catch (IOException e) {
                log.error(e);
            } catch (Exception e) {
                log.error(e);
            }
        }
    }
    */

    public void privacyRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        log.debug("privacyRequest(request, response)");
        try {
            include(request, response, "/view/privacy.jsp");
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }
}

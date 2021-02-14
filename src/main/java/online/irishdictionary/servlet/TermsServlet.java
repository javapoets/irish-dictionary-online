package online.irishdictionary.servlet;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.ServletConfig;

@WebServlet(name = "TermsServlet", asyncSupported = false, urlPatterns = {
    "terms"
})
public class TermsServlet extends online.irishdictionary.servlet.InitServlet {

    private static final org.apache.logging.log4j.Logger log = org.apache.logging.log4j.LogManager.getLogger();

    public void init(ServletConfig config) throws ServletException {
        log.debug("init("+config+")");
        super.init(config);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        log.debug("doGet(request, response)");
        try {
            termsRequest(request, response);
        } catch(Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    public void termsRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        log.debug("termsRequest(request, response)");
        try {
            super.checkForLangParameter(request, response);
            include(request, response, "/view/terms.jsp");
        } catch(Exception e) {
            log.error(e.getMessage(), e);
        }
    }
}

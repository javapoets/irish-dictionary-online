package online.irishdictionary.servlet;

import java.io.IOException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletConfig;

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

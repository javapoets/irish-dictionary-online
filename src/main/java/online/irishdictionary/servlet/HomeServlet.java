package online.irishdictionary.servlet;

import java.io.IOException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.ServletException;
import online.irishdictionary.servlet.InitServlet;

public class HomeServlet extends InitServlet {

    private static final org.apache.logging.log4j.Logger log = org.apache.logging.log4j.LogManager.getLogger();
    private final String JSP_HOME = DIR_VIEW + "home.jsp";
    private final String JSP_DICTIONARY_RESULTS = DIR_VIEW + "home.jsp";

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.debug("doGet(request, response)");
        super.checkForLangParameter(request, response);
        super.includeUtf8(request, response, JSP_HOME);
    }
}

package online.irishdictionary.servlet;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import online.irishdictionary.model.Word;
import online.irishdictionary.database.DictionaryDatabaseManager;
import online.irishdictionary.servlet.InitServlet;

@WebServlet(name = "VerbServlet", asyncSupported = false, urlPatterns = {
    "verb/*"
})
//@Log4j2
//public class VerbServlet extends online.irishdictionary.servlet.InitServlet {
public class VerbServlet extends online.irishdictionary.servlet.LegacyVerbServlet {

    private static final org.apache.logging.log4j.Logger log = org.apache.logging.log4j.LogManager.getLogger();
    private final String JSP_HOME = DIR_VIEW + "home.jsp";
    private final String JSP_RESULTS = DIR_VIEW + "results.jsp";
    private final String FORWARDSLASH = "/";
    private final String fromLanguage = "english";
    private final String toLanguage = "irish";

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.debug("doGet(request, response)");
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.debug("doPost(request, response)");
        java.util.Enumeration parameterNames = (java.util.Enumeration)request.getParameterNames();
        while(parameterNames.hasMoreElements()) {
            String parameterName = (String)parameterNames.nextElement();
            log.debug(parameterName+" = "+request.getParameter(parameterName));
        }
        String pathInfo = request.getPathInfo();
        log.debug("pathInfo = '"+pathInfo+"'");
        String[] split = pathInfo.split(FORWARDSLASH);
        log.debug("split.length = " + split.length);
        log.debug("split[0] = " + split[0] + ", split[1] = " + split[1] + ", split[2] = " + split[2]);
        String fromLanguage = split[1];
        String toLanguage = split[2];
        String verbParameter = split[3];
        log.debug("verbParameter = " + verbParameter);
        log.debug("fromLanguage = " + fromLanguage);
        log.debug("toLanguage = " + toLanguage);
        super.displayVerb(request, response, verbParameter, fromLanguage, toLanguage);
    }

    public void displayResults(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("pageType", "dictionary");
        include(request, response, JSP_RESULTS);
    }
}

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
public class VerbServlet extends online.irishdictionary.servlet.LegacyVerbServlet {

    private static final org.apache.logging.log4j.Logger log = org.apache.logging.log4j.LogManager.getLogger();
    private final String FORWARDSLASH = "/";

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.trace("doGet(request, response)");
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.trace("doPost(request, response)");
        String pathInfo = request.getPathInfo();
        if (pathInfo != null) {
            String[] split = pathInfo.split(FORWARDSLASH);
            /*
            log.debug("pathInfo = " + pathInfo );
            log.debug("split.length = " + split.length);
            log.debug("split[0] = " + split[0] + ", split[1] = " + split[1] + ", split[2] = " + split[2]);
            */
            String fromLanguage = split[1];
            String toLanguage = split[2];
            String verbParameter = split[3];
            log.debug("verbParameter = " + verbParameter);
            log.debug("fromLanguage = " + fromLanguage);
            log.debug("toLanguage = " + toLanguage);
            super.displayVerb(request, response, verbParameter, fromLanguage, toLanguage);
            return;
        }
        //includeUtf8(request, response, "/view/verb/verbs.jsp");
        //response.sendRedirect(java.net.URLDecoder.decode(thisReqURI, "UTF-8"));
        request.getRequestDispatcher("verbs").forward(request, response);
    }
}

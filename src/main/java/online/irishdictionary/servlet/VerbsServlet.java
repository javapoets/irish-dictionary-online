package online.irishdictionary.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;
import online.irishdictionary.database.VerbDatabaseManager;
import online.irishdictionary.model.Verb;

@WebServlet(name = "VerbsServlet", asyncSupported = false, urlPatterns = {
      "verbs"
    , "verbs/*"
})
public class VerbsServlet extends online.irishdictionary.servlet.InitServlet {

    private static final org.apache.logging.log4j.Logger log = org.apache.logging.log4j.LogManager.getLogger();
    private final String FORWARDSLASH = "/";

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.debug("doGet(request, response)");
        log.debug("request.getServletPath() = " + request.getServletPath());
        log.debug("request.getPathInfo() = " + request.getPathInfo());
        log.debug("request.getRequestURI() = " + request.getRequestURI());
        log.debug("request.getRequestURL() = " + request.getRequestURL());
        log.debug("request.getPathTranslated() = " + request.getPathTranslated()); // Returns any extra path information after the servlet name but before the query string, and translates it to a real path.

        super.checkForLangParameter(request, response);  // check for the "lang" param
        
        String pathInfo = request.getPathInfo();
        log.debug("pathInfo =  " + pathInfo);
        if (pathInfo == null) {
            try {
                List<Verb> englishVerbList = new ArrayList<Verb>();  // English verbs
                VerbDatabaseManager.selectAllVerbs(englishVerbList, ENGLISH_LANGUAGE_ID, getConnectionPool());
                log.debug("englishVerbList.size() " + englishVerbList.size());
                request.setAttribute("englishVerbList", englishVerbList);
                List<Verb> irishVerbList = new ArrayList<Verb>();  // Irish verbs
                VerbDatabaseManager.selectAllVerbs(irishVerbList, IRISH_LANGUAGE_ID, getConnectionPool());
                log.debug("irishVerbList.size() " + irishVerbList.size());
                request.setAttribute("irishVerbList", irishVerbList);
                includeUtf8(request, response, "/view/verb/verbs-english-irish.jsp");
                return;
            } catch (Exception e) {
                log.error(e.getMessage(), e);
            }
        }

        String[] pathInfoSplit = pathInfo.split(FORWARDSLASH);
        log.debug("pathInfoSplit.length = " + pathInfoSplit.length);
        for (String pathElement: pathInfoSplit) log.debug("pathElement = " + pathElement);
        String language = pathInfoSplit[1];
        request.setAttribute("language", language);
        int languageId = -1;
        String toLanguage;
        if (ENGLISH.equals(language)) {
            languageId = 1;
            toLanguage = IRISH;
        } else {
            languageId = 2;
            toLanguage = ENGLISH;
        }
        request.setAttribute("toLanguage", toLanguage);
        log.debug("languageId = " + languageId);

        try {
            List<Verb> verbList = new ArrayList<Verb>();
            VerbDatabaseManager.selectAllVerbs(verbList, languageId, getConnectionPool());
            log.debug("verbList.size() " + verbList.size());
            request.setAttribute("verbList", verbList);
            includeUtf8(request, response, "/view/verb/verbs.jsp");
        } catch(Exception e) {
            log.error(e.getMessage(), e);            
        }
    }
}

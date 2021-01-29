package online.irishdictionary.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
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
        
        /*
        String languageId = request.getParameter("languageId");
        if(languageId == null) languageId = "irish";
        */
        String pathInfo = request.getPathInfo();
        log.debug("pathInfo =  " + pathInfo);
        if (pathInfo == null) {
            try {
                List<Verb> englishVerbList = new ArrayList<Verb>();
                VerbDatabaseManager.selectAllVerbs(englishVerbList, ENGLISH_LANGUAGE_ID, getConnectionPool());
                log.debug("englishVerbList.size() " + englishVerbList.size());
                request.setAttribute("englishVerbList", englishVerbList);

                List<Verb> irishVerbList = new ArrayList<Verb>();
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

        /*
        //String language = request.getParameter("language");
        //String wordParam = request.getParameter("word");
        //String language = split[0];
        //String wordParam = pathInfo.substring(1);
        String fromLanguage = "english";
        String toLanguage = split[1];
        String wordParameter = split[2];
        log.debug("wordParameter = " + wordParameter);
        log.debug("fromLanguage = " + fromLanguage);
        log.debug("toLanguage = " + toLanguage);
        */
        String language = pathInfoSplit[1];
        request.setAttribute("language", language);

        int languageId = -1;
        String toLanguage;
        /*
        if (languageIdParameter != null) {
            try {
                languageId = Integer.parseInt(languageIdParam);
            } catch (Exception e) {
                log.error(e);
            }
        } else {
        */
            if (ENGLISH.equals(language)) {
                languageId = 1;
                toLanguage = IRISH;
            } else {
                languageId = 2;
                toLanguage = ENGLISH;
            }
        //}
        request.setAttribute("toLanguage", toLanguage);

        log.debug("languageId = " + languageId);
        //request.setAttribute("fromLanguage", fromLanguage);
        //request.setAttribute("toLanguage", toLanguage);

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

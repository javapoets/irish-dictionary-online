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
import online.irishdictionary.servlet.InitServlet;

@WebServlet(name = "VerbsServlet", asyncSupported = false, urlPatterns = {
      "verbs"
    , "verbs/*"
})
public class VerbsServlet extends InitServlet {

    private static final org.apache.logging.log4j.Logger log = org.apache.logging.log4j.LogManager.getLogger();
    private final String FORWARDSLASH = "/";
    private final String ENGLISH = "english";
    //private final String IRISH = "irish";

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.debug("doGet(request, response)");
        
        /*
        String languageId = request.getParameter("languageId");
        if(languageId == null) languageId = "irish";
        */
        String pathInfo = request.getPathInfo();
        log.debug("pathInfo = '"+pathInfo+"'");
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

        int languageId = -1;
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
            } else {
                languageId = 2;
            }
        //}

        log.debug("languageId = " + languageId);
        //request.setAttribute("fromLanguage", fromLanguage);
        //request.setAttribute("toLanguage", toLanguage);

        try {
            List<Verb> verbList = new ArrayList<Verb>();
            VerbDatabaseManager.selectAllVerbs(verbList, languageId, getConnectionPool());
            log.debug("verbList.size() " + verbList.size());
            request.setAttribute("verbList", verbList);
            include(request, response, "/view/verb/verbs.jsp");
        } catch(Exception e) {
            log.error(e.getMessage(), e);            
        }

    }
}

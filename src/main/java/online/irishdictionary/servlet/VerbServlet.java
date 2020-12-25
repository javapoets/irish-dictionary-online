package online.irishdictionary.servlet;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import online.irishdictionary.database.VerbDatabaseManager;
import online.irishdictionary.model.Verb;

@WebServlet(name = "VerbServlet", asyncSupported = false, urlPatterns = {
      "verb"
    //, "verb/*"
})
public class VerbServlet extends online.irishdictionary.servlet.InitServlet {

    private static final org.apache.logging.log4j.Logger log = org.apache.logging.log4j.LogManager.getLogger();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.debug("doGet(request, response)");
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.debug("doPost(request, response)");
        //*
        java.util.Enumeration parameterNames = (java.util.Enumeration)request.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String parameterName = (String)parameterNames.nextElement();
            log.debug("    " + parameterName + " = " + request.getParameter(parameterName));
            //log.debug("parameterName = "+parameterName);
        }
        //*/
        String verbParameter = (String)request.getParameter("verb");
        if (verbParameter == null) {
            log.debug("verbParameter = " + verbParameter);
            log.debug("doPost(request, response): verbParameter is null");
            include(request, response, "verb/verb.jsp");
            return;
        } else {
            verbParameter = verbParameter.trim();
        }
        log.debug("verbParameter = " + verbParameter);
        String fromLanguage = request.getParameter("language");
        log.debug("fromLanguage = " + fromLanguage);
        String toLanguage = request.getParameter("toLanguage");
        log.debug("toLanguage = " + toLanguage);
        //if(language == null) language = "irish";
        log.info(new StringBuilder().append(fromLanguage).append("/").append(toLanguage).append("/").append(verbParameter));
        int fromLanguageId = -1;
        int toLanguageId = -1;
        if (fromLanguage.equals("english")) {
            if (toLanguage == null) toLanguage = "irish";
            fromLanguageId = 1;
            toLanguageId = 2;
        } else {
            //fromLanguage = "irish";
            if (toLanguage == null) toLanguage = "english";
            fromLanguageId = 2;
            toLanguageId = 1;
        }
        log.debug("fromLanguageId = " + fromLanguageId);
        log.debug("toLanguageId = " + toLanguageId);
        request.setAttribute("toLanguage", toLanguage);
        request.setAttribute("fromLanguage", fromLanguage);
        //Verb verb = new Verb(verbParameter, language);
        //Verb verb = new Verb(verbParameter, languageId);
        Verb verb = new Verb(verbParameter, fromLanguageId, toLanguageId);
        try {
            boolean verbExists = VerbDatabaseManager.selectVerb(verb, getConnectionPool());
            log.debug("verbExists = " + verbExists);
            if (verbExists) {
                request.setAttribute("verb", verb);
            }
            include(request, response, "/view/verb/verb.jsp");
        } catch (Exception e) {
            log.error(e);
        }
    }
}

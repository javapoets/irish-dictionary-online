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
            log.debug(parameterName+" = "+request.getParameter(parameterName));
            //log.debug("parameterName = "+parameterName);
        }
        //*/
        String verbParam = (String)request.getParameter("verb");
        if (verbParam == null) {
            log.debug("verbParam = "+verbParam);
            log.debug("doPost(request, response): verbParam is null");
            include(request, response, "verb/verb.jsp");
            return;
        } else {
            verbParam = verbParam.trim();
        }
        String fromLanguage = null;
        String toLanguage = null;
        String language = request.getParameter("language");
        if(language == null) language = "irish";
        if(fromLanguage == null) fromLanguage = language;
        //log.debug("language = "+language);
        //log.debug("verbParam = "+verbParam);
        log.info(language+"/"+verbParam);
        int languageId = -1;
        if (fromLanguage.equals("english")) {
            toLanguage = "irish";
            languageId = 1;
        } else {
            fromLanguage = "irish";
            toLanguage = "english";
            languageId = 2;
        }
        request.setAttribute("toLanguage", toLanguage);
        request.setAttribute("fromLanguage", fromLanguage);
        //Verb verb = new Verb(verbParam, language);
        Verb verb = new Verb(verbParam, languageId);
        try {
            VerbDatabaseManager.selectVerb(verb, getConnectionPool());
        } catch (Exception e) {
            log.error(e);
        }
        request.setAttribute("verb", verb);
        include(request, response, "/view/verb/verb.jsp");
    }
}

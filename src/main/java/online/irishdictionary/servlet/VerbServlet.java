package online.irishdictionary.servlet;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import online.irishdictionary.database.VerbDatabaseManager;
import online.irishdictionary.model.Verb;
import online.irishdictionary.servlet.InitServlet;

public class VerbServlet extends InitServlet {

    private static final Logger logger = LogManager.getLogger();
    protected final String  DIR_VERB = DIR_VIEW + "verb/";
    private final String    JSP_VERB = DIR_VERB + "verb.jsp";

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.debug("doGet(request, response)");

        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.debug("doPost(request, response)");

        //*
        java.util.Enumeration parameterNames = (java.util.Enumeration)request.getParameterNames();
        while(parameterNames.hasMoreElements()) {
            String parameterName = (String)parameterNames.nextElement();
            logger.debug(parameterName+" = "+request.getParameter(parameterName));
            //logger.debug("parameterName = "+parameterName);
        }
        //*/

        String verbParam = (String)request.getParameter("verb");
        if(verbParam == null) {

            logger.debug("verbParam = "+verbParam);
            logger.debug("doPost(request, response): verbParam is null");
            include(request, response, DIR_VERB+"verb.jsp");
            return;

        } else {
            verbParam = verbParam.trim();
        }

        String fromLanguage = null;
        String toLanguage = null;

        String language = request.getParameter("language");
        if(language == null) {
            language = "irish";
        }
        if(fromLanguage == null) {
            fromLanguage = language;
        }

        logger.info(language+"/"+verbParam);

        //logger.debug("language = "+language);
        //logger.debug("verbParam = "+verbParam);

        int languageId = -1;
        if(fromLanguage.equals("english")) {
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
        } catch(Exception e) {
            logger.error(e);
        }

        request.setAttribute("verb", verb);
        include(request, response, DIR_VERB+"verb.jsp");
    }

}

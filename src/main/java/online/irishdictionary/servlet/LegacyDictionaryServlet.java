package online.irishdictionary.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;
import online.irishdictionary.model.Word;
import online.irishdictionary.database.DictionaryDatabaseManager;
import online.irishdictionary.servlet.InitServlet;

public class LegacyDictionaryServlet extends InitServlet {

    private static final org.apache.logging.log4j.Logger log = org.apache.logging.log4j.LogManager.getLogger();
    private final String JSP_HOME = DIR_VIEW + "home.jsp";
    private final String JSP_RESULTS = DIR_VIEW + "results.jsp";

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.debug("doGet(request, response)");
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.debug("doPost(request, response)");

        //* Debug parameters:
        java.util.Enumeration parameterNames = (java.util.Enumeration)request.getParameterNames();
        log.debug("Parameters:");
        while (parameterNames.hasMoreElements()) {
            String parameterName = (String)parameterNames.nextElement();
            log.debug(parameterName+" = "+request.getParameter(parameterName));
            //log.debug("parameterName = "+parameterName);
        }
        //*/

        //String wordParameter = request.getParameter("word");
        String wordParameter = null;
        try {
            wordParameter = request.getParameter("word");
        } catch (Exception e) {
            e.printStackTrace();
        }

        String language = request.getParameter("language");
        String languageIdParam = request.getParameter("languageId");
        String fromLanguage = request.getParameter("fromLanguage");
        String toLanguage = request.getParameter("toLanguage");
        String remoteAddr = request.getRemoteAddr();
        //log.debug("remoteAddr = "+remoteAddr);
        String locale = (request.getLocale()).toString();
        //log.debug("locale = "+locale);

        StringBuilder stringBuilder = new StringBuilder()
            .append(locale)
            .append("/")
            .append(remoteAddr)
            .append(": ")
            .append(language)
            .append("/")
            .append(wordParameter);
        log.info(stringBuilder.toString());

        if (wordParameter == null) {
            //response.sendRedirect(java.net.URLDecoder.decode(request.getContextPath()+"/dictionary", "UTF-8"));
            response.sendRedirect("home");
            return;
        }

        if (
            language == null
            || language.equals("null")
        ) {
            language = "irish";
            stringBuilder = new StringBuilder()
                .append(locale)
                .append("/")
                .append(remoteAddr)
                .append(": ")
                .append(language)
                .append("/")
                .append(wordParameter);
            log.info(stringBuilder.toString());
        }

        if (fromLanguage == null) {
            fromLanguage = language;
            request.setAttribute("fromLanguage", fromLanguage);
        }

        if (toLanguage == null) {
            if (fromLanguage != null) {
                toLanguage = fromLanguage.equals("english") ? "irish" : "english";
                request.setAttribute("toLanguage", toLanguage);
            }
        }

        int languageId = -1;
        if (languageIdParam != null) {
            try {
                languageId = Integer.parseInt(languageIdParam);
            } catch (Exception e) {
                log.error(e);
            }
        } else {
            if (fromLanguage != null && fromLanguage.equals("english")) {
                languageId = 1;
            } else {
                languageId = 2;
            }
        }

        if (!EMPTY.equals(wordParameter)) {
            Word word = new Word(wordParameter.trim());
            try {
                DictionaryDatabaseManager.populateWord(word, languageId, getConnectionPool());
                request.setAttribute("word", word);
            } catch (Exception e) {
                log.error(e);
                StringWriter stringWriter = new StringWriter();
                PrintWriter printWriter = new PrintWriter(stringWriter);
                e.printStackTrace(printWriter);
                log.error(stringWriter.toString());
            }
            include(request, response, JSP_RESULTS);
        } else {
            include(request, response, JSP_HOME);
        }
    }

    public void displayResults(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("pageType", "dictionary");
        include(request, response, JSP_RESULTS);
    }
}

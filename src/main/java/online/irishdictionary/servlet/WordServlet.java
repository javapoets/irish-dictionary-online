package online.irishdictionary.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;
import java.util.Map;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.ServletException;
import online.irishdictionary.model.Definition;
import online.irishdictionary.model.Word;
import online.irishdictionary.database.AnalyticsDatabaseManager;
import online.irishdictionary.database.DictionaryDatabaseManager;
import online.irishdictionary.servlet.InitServlet;

public class WordServlet extends InitServlet {

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
        String fromLanguage = request.getParameter("fromLanguage");
        String toLanguage = request.getParameter("toLanguage");
        String remoteAddr = request.getRemoteAddr();
        String locale = (request.getLocale()).toString();
        log.debug("wordParameter = "+wordParameter);
        log.debug("language = "+language);
        log.debug("remoteAddr = "+remoteAddr);
        log.debug("locale = "+locale);
        //log.debug("languageIdParameter = "+languageIdParameter);
        log.debug("fromLanguage = "+fromLanguage);
        log.debug("toLanguage = "+toLanguage);
        StringBuilder stringBuilder = new StringBuilder()
            .append(locale)
            .append("/").append(remoteAddr)
            .append(":").append(language)
            .append("/").append(wordParameter);
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
            //stringBuilder = new StringBuilder()
            //    .append(locale).append("/").append(remoteAddr).append(": ")
            //    .append(language).append("/").append(wordParameter);
            //log.info(stringBuilder.toString());
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
        Word word = displayWord(request, response, wordParameter, fromLanguage, toLanguage);
        boolean wordWasFound = false;
        boolean usageWasFound = false;
        if (word != null) {
            wordWasFound = word.getWord() != null;
            usageWasFound = word.getUsageList() != null;
            log.debug("wordWasFound = " + wordWasFound);
            log.debug("usageWasFound = " + usageWasFound);
        }
        try {
            AnalyticsDatabaseManager.insertWordSearched(
                wordParameter
                , fromLanguage
                , toLanguage
                , remoteAddr
                , locale
                , (wordWasFound ? 1 : 0)
                , (usageWasFound ? 1 : 0)
                , getConnectionPool()
            );
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    public Word displayWord(
        HttpServletRequest request
        , HttpServletResponse response
        , String wordParameter
        , String fromLanguage
        , String toLanguage
        //, String languageIdParameter
    ) throws ServletException, IOException {
        log.debug(new StringBuilder()
            .append("displayWord(request, response, '").append(wordParameter)
            .append("', '").append(fromLanguage)
            .append("', '").append(toLanguage)
            .append("')").toString());

        super.checkForLangParameter(request, response);

        int languageId = -1;
        if (fromLanguage != null && fromLanguage.equals("english")) {
            languageId = 1;
            request.setAttribute("toLang", LANG_IRISH);
            request.setAttribute("fromLang", LANG_ENGLISH);
        } else {
            languageId = 2;
            request.setAttribute("toLang", LANG_ENGLISH);
            request.setAttribute("fromLang", LANG_IRISH);
        }
        log.debug("languageId = " + languageId);
        request.setAttribute("fromLanguage", fromLanguage);
        request.setAttribute("toLanguage", toLanguage);
        request.setAttribute("wordParameter", wordParameter);

        Word word = null;
        if (!EMPTY.equals(wordParameter)) {
            //Word word = new Word(wordParameter.trim(), fromLanguage, toLanguage);
            try {
                //DictionaryDatabaseManager.selectWord(word, language, getConnectionPool());
                //Map<String, List<Definition>> definitionMap = word.createDefinitionMap();
                //DictionaryDatabaseManager.populateWord(word, languageId, getConnectionPool());
                word = DictionaryDatabaseManager.selectWord(wordParameter, fromLanguage, toLanguage, languageId, getConnectionPool());
                log.debug("word = " + word);
                if (word != null) {
                    //word.setFromLanguage(fromLanguage);
                    //word.setToLanguage(toLanguage);
                    request.setAttribute("word", word);
                    //if (word.getWord() != null) return true;
                }
                includeUtf8(request, response, JSP_RESULTS);
            } catch (Exception e) {
                log.error(e.getMessage(), e);
            }
        } else {
            includeUtf8(request, response, JSP_HOME);
        }
        return word;
    }

    //public void displayResults(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //    request.setAttribute("pageType", "dictionary");
    //    include(request, response, JSP_RESULTS);
    //}
}

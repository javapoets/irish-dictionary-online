package online.irishdictionary.servlet;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import online.irishdictionary.model.Word;
import online.irishdictionary.database.DictionaryDatabaseManager;
import online.irishdictionary.servlet.InitServlet;

@WebServlet(name = "IrishServlet", asyncSupported = false, urlPatterns = {
      "irish"
    , "irish/*"
})
//@Log4j2
//public class EnglishServlet extends InitServlet {
public class IrishServlet extends WordServlet {

    private static final org.apache.logging.log4j.Logger log = org.apache.logging.log4j.LogManager.getLogger();
    private final String JSP_HOME = DIR_VIEW + "home.jsp";
    private final String JSP_RESULTS = DIR_VIEW + "results.jsp";
    private final String FSLASH = "/";
    private final String fromLanguage = "irish";
    private final String toLanguage = "english";

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
            //log.debug("parameterName = "+parameterName);
        }

        String pathInfo = request.getPathInfo();
        log.debug("pathInfo = '"+pathInfo+"'");
        String[] split = pathInfo.split(FSLASH);
        log.debug("split.length = "+split.length);
        log.debug("split[0] = "+split[0]+", split[1] = "+split[1]+", split[2] = "+split[2]);

        //String language = request.getParameter("language");
        //String wordParam = request.getParameter("word");
        //String language = split[0];
        //String wordParam = pathInfo.substring(1);
        String fromLanguage = "irish";
        String toLanguage = split[1];
        String wordParameter = split[2];

        log.debug("wordParameter = " + wordParameter);
        log.debug("fromLanguage = " + fromLanguage);
        log.debug("toLanguage = " + toLanguage);

        super.displayWord(request, response, wordParameter, fromLanguage, toLanguage);
        //super.displayWord(request, response, wordParameter.toLowerCase(), fromLanguage, toLanguage);

        /*
        String letter;
        if(!"".equals(wordParam.trim())) {
            Word word = new Word(wordParam.trim());
            try {
                DictionaryDatabaseManager.selectEnglishWord(word, getConnectionPool());
                request.setAttribute("fromLanguage", fromLanguage);
                request.setAttribute("toLanguage", toLanguage);
                request.setAttribute("word", word);
            } catch(Exception e) {
                log.error(e);
            }
            //displayResults(request, response);
            include(request, response, JSP_RESULTS);
        } else {
            // Word select failed.  Redisplay the search Page
            // try looking up in the Irish dictionary
            String thisReqURI = request.getParameter("thisReqURI");
            if(thisReqURI == null || thisReqURI.equals("")){
                thisReqURI = request.getContextPath()+"/dictionary";
            }
            response.sendRedirect(java.net.URLDecoder.decode(thisReqURI, "UTF-8"));
            //request.getRequestDispatcher("dictionary").forward(request, response);
        }
        */
    }

    public void displayResults(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //HttpSession session = request.getSession(false);
        //User user = (User)session.getAttribute("user");
        request.setAttribute("pageType", "dictionary");
        include(request, response, JSP_RESULTS);
    }

}

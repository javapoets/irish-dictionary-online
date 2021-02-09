package online.irishdictionary.servlet;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import online.irishdictionary.database.AnalyticsDatabaseManager;
import online.irishdictionary.database.DictionaryDatabaseManager;
import online.irishdictionary.model.Word;
import online.irishdictionary.servlet.InitServlet;

@WebServlet(name = "IrishServlet"
    , asyncSupported = true
    , urlPatterns = {
          "irish"
        , "irish/*"
    }
)
public class IrishServlet extends WordServlet {

    private static final org.apache.logging.log4j.Logger log = org.apache.logging.log4j.LogManager.getLogger();
    private final String JSP_HOME = DIR_VIEW + "home.jsp";
    private final String JSP_RESULTS = DIR_VIEW + "results.jsp";
    private final String fromLanguage = "irish";
    private final String toLanguage = "english";

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.debug("doGet(request, response)");
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.debug("doPost(request, response)");
        try {
            super.execute(new IrishRequest(request.startAsync()));
            return;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    public class IrishRequest implements Runnable {
        AsyncContext asyncContext;
        public IrishRequest(AsyncContext asyncContext) {
            logger.debug("EnglishRequest(asyncContext)");
            this.asyncContext = asyncContext;
            this.asyncContext.setTimeout(1000*5);  // 5 seconds timeout
        }
        public void run() {
            try {
                doPostBak((HttpServletRequest)this.asyncContext.getRequest(), (HttpServletResponse)this.asyncContext.getResponse());
                this.asyncContext.complete();
            } catch (IOException e) {
                logger.error(e);
            } catch (Exception e) {
                logger.error(e);
            }
        }
    }

    public void doPostBak(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.debug("doPostBak(request, response)");
        java.util.Enumeration parameterNames = (java.util.Enumeration)request.getParameterNames();
        while(parameterNames.hasMoreElements()) {
            String parameterName = (String)parameterNames.nextElement();
            log.debug(parameterName+" = "+request.getParameter(parameterName));
        }
        String pathInfo = request.getPathInfo();
        log.debug("pathInfo = '"+pathInfo+"'");
        String[] split = pathInfo.split(FSLASH);
        log.debug("split.length = "+split.length);
        log.debug("split[0] = "+split[0]+", split[1] = "+split[1]+", split[2] = "+split[2]);
        String fromLanguage = "irish";
        String toLanguage = split[1];
        String wordParameter = split[2];
        String remoteAddr = request.getRemoteAddr();
        String locale = (request.getLocale()).toString();
        log.debug("remoteAddr = "+remoteAddr);
        log.debug("locale = "+locale);
        log.debug("wordParameter = " + wordParameter);
        log.debug("fromLanguage = " + fromLanguage);
        log.debug("toLanguage = " + toLanguage);
        StringBuilder stringBuilder = new StringBuilder()
            .append(locale)
            .append("/").append(remoteAddr)
            .append(":").append(fromLanguage)
            .append("/").append(wordParameter);
        log.info(stringBuilder.toString());        
        boolean wordWasFound = super.displayWord(request, response, wordParameter, fromLanguage, toLanguage);
        log.debug("wordWasFound = " + wordWasFound);
        AnalyticsDatabaseManager.insertWordSearched(
            wordParameter
            , fromLanguage
            , toLanguage
            , remoteAddr
            , locale
            , (wordWasFound ? 1 : 0)
            , connectionManager
        );
    }
}

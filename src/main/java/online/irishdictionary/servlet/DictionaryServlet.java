package online.irishdictionary.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import online.irishdictionary.model.Word;
import online.irishdictionary.database.DictionaryDatabaseManager;
import online.irishdictionary.servlet.InitServlet;

@WebServlet(name = "DictionaryServlet", asyncSupported = false, urlPatterns = {
      "dictionary"
    , "dictionary/*"
})
public class DictionaryServlet extends InitServlet {

    private static final org.apache.logging.log4j.Logger log = org.apache.logging.log4j.LogManager.getLogger();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.debug("doGet(request, response)");
        String locale = (request.getLocale()).toString();
        log.debug("locale = "+locale);
        super.checkForLangParameter(request, response);
        super.includeUtf8(request, response, DIR_VIEW + "dictionary.jsp");
    }
}

package online.irishdictionary.servlet;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import online.irishdictionary.servlet.InitServlet;

public class CssServlet extends InitServlet {

    private static final Logger logger = LogManager.getLogger();
    public static final String TEXT_CSS_UTF8 = "text/css;charset=UTF-8";
    private final String JSP_CSS = DIR_VIEW + "css.jsp";

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.debug("doGet(request, response)");

        super.includeUtf8(
          request
          , response
          , JSP_CSS
          , TEXT_CSS_UTF8
        );
    }
}

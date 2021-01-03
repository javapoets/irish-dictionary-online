package online.irishdictionary.servlet;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import online.irishdictionary.servlet.InitServlet;

public class HomeServlet extends InitServlet {

    private static final org.apache.logging.log4j.Logger log = org.apache.logging.log4j.LogManager.getLogger();
    private final String JSP_HOME = DIR_VIEW + "home.jsp";
    private final String JSP_DICTIONARY_RESULTS = DIR_VIEW + "home.jsp";

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.debug("doGet(request, response)");

        String locale = (request.getLocale()).toString();
        log.debug("locale = "+locale);

        String queryString  = request.getQueryString();
        log.debug("queryString = " + queryString);
        if(queryString != null) {
            if(queryString.length() == 2) {
                HttpSession session = request.getSession(true);
                session.setAttribute("lang", queryString);
            }
        }

        //include(request, response, JSP_HOME);
        super.includeUtf8(request, response, JSP_HOME);
        /*
        String requestURI = new StringBuilder().append(request.getContextPath()).append("/dictionary").append("?").append(locale).toString();
        logger.debug("requestURI = "+requestURI);
        response.sendRedirect(java.net.URLDecoder.decode(requestURI, "UTF-8"));
        //request.getRequestDispatcher("dictionary").forward(request, response);
        */
    }

}

package online.irishdictionary.servlet;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.ServletConfig;
import online.irishdictionary.database.VerbDatabaseManager;
import online.irishdictionary.model.Verb;

@WebServlet(name = "ContactServlet", asyncSupported = false, urlPatterns = {
    "contact"
})
public class ContactServlet extends online.irishdictionary.servlet.InitServlet {

    private static final org.apache.logging.log4j.Logger log = org.apache.logging.log4j.LogManager.getLogger();
    private static final String DIR_JSP = "/view/";

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.debug("doGet(request, response)");
        includeUtf8(request, response, "/view/contact.jsp");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /*
        if  ((contactBean.getQuery() != null) && !(contactBean.getQuery().equals(""))) {
            try {
                ContactManager.insertFeedback(contactBean);
                ContactMailer.send(contactBean);
                displayJsp(request, response, dir + "contactConfirm.jsp");
            } catch(Exception e){
                e.printStackTrace();
                errorBean.setMainErrorMessage(e.getMessage());
                request.setAttribute("errorBean", errorBean);
                contact(request, response);
            }
        }else{
            // Word lookup failed.  Redisplay the search Page
            errorBean.setMainErrorMessage("The query field is required!");
            request.setAttribute("errorBean", errorBean);
            contact(request, response);
        }
        */
        includeUtf8(request, response, "/view/contact-confirmation.jsp");
    }
}

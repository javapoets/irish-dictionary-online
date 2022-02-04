package online.irishdictionary.servlet;

import java.io.IOException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletConfig;
import online.irishdictionary.database.VerbDatabaseManager;
import online.irishdictionary.model.Verb;
import online.irishdictionary.database.ContactDatabaseManager;
import online.irishdictionary.model.ContactForm;

@WebServlet(name = "ContactServlet", asyncSupported = false, urlPatterns = {
    "contact"
    , "contact/*"
})
public class ContactServlet extends online.irishdictionary.servlet.InitServlet {

    private static final org.apache.logging.log4j.Logger log = org.apache.logging.log4j.LogManager.getLogger();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.debug("doGet(request, response)");
        super.checkForLangParameter(request, response);
        includeUtf8(request, response, "/view/contact.jsp");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.debug("doPost(request, response)");
        //super.checkForLangParameter(request, response);
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String message = request.getParameter("message");
        log.debug("name = " + name);
        log.debug("email = " + email);
        log.debug("message = " + message);
        ContactForm contactForm = new ContactForm(name, email, message);
        try {
            ContactDatabaseManager.insert(contactForm, getConnectionPool());
            includeUtf8(request, response, "/view/contact-confirmation.jsp");
            return;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        includeUtf8(request, response, "/view/contact.jsp");
    }
}

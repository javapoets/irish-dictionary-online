package online.irishdictionary.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import javax.servlet.ServletConfig;
import online.irishdictionary.database.VerbDatabaseManager;
import online.irishdictionary.model.Verb;
import online.irishdictionary.database.ContactDatabaseManager;
import online.irishdictionary.model.ContactForm;

@WebServlet(name = "CookieServlet", asyncSupported = false, urlPatterns = {
    "cookie"
})
public class CookieServlet extends online.irishdictionary.servlet.InitServlet {

    private static final org.apache.logging.log4j.Logger log = org.apache.logging.log4j.LogManager.getLogger();
    private final String ACCEPT = "accept";
    public static final String TEXT_PLAIN = "text/plain";

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.debug("doGet(request, response)");
        checkForAcceptParameter(request, response);
        //includeUtf8(request, response, "/view/contact.jsp");
        writeOut(response, 1);
    }

    protected void checkForAcceptParameter(HttpServletRequest request, HttpServletResponse response) {
        log.debug("checkForAcceptParameter(request, response)");
        String accept  = request.getParameter(ACCEPT);
        log.debug("accept = " + accept);
        if (accept != null) {
            HttpSession session = request.getSession(true);
            log.debug("session = " + session);
            session.setAttribute("acceptCookies", accept);
        }
    }

    public void writeOut(HttpServletResponse response, int x) throws IOException {
        writeOut(response, String.valueOf(x));
    }

    protected void writeOut(HttpServletResponse response, String text) throws IOException {
        writeOut(response, text, TEXT_PLAIN);
    }

    protected void writeOut(HttpServletResponse response, String text, String contentType) throws IOException {
        log.debug("writeOut(request, '"+text+"', '"+contentType+"')");
        response.setHeader("Content-Length", String.valueOf(text.length()));  // Set the "Content-Length" header.
        PrintWriter out = response.getWriter();
        //response.setContentLength(text.length());
        response.setContentType(contentType);
        out.write(text);
        out.flush();
        out.close();
    }


    /*
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
    */
}

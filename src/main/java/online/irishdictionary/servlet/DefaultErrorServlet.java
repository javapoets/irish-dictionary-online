package online.irishdictionary.servlet;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.IOException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;

@WebServlet(
    name = "DefaultErrorServlet",
    urlPatterns = { "/error/default-error" }
)
public class DefaultErrorServlet extends HttpServlet {

    private static final org.apache.logging.log4j.Logger log = org.apache.logging.log4j.LogManager.getLogger();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.debug("doGet(request, response)");
        Exception exception = (Exception)request.getAttribute(RequestDispatcher.ERROR_EXCEPTION);
        PrintWriter printWriter = response.getWriter();
        Integer errorStatusCode = (Integer)request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        String requestUri = (String)request.getAttribute(RequestDispatcher.ERROR_REQUEST_URI);
        log.debug("exception.getMessage() = " + exception.getMessage());
        log.error(exception.getMessage(), exception);
        printWriter.println("Default Error Servlet:");
        printWriter.printf("Exception: %s%n", exception.toString());
        printWriter.printf("Dispatcher Type: %s%n", request.getDispatcherType());
        printWriter.printf("Status Code: %s%n", errorStatusCode);
        printWriter.printf("Request URI: %s%n", requestUri);
        printWriter.println("Stack trace:");
        StringWriter stringWriter = new StringWriter();
        PrintWriter exceptionPrintWriter = new PrintWriter(stringWriter);
        exception.printStackTrace(exceptionPrintWriter);
        printWriter.println(stringWriter.toString());
    }
}
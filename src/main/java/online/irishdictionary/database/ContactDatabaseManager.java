package online.irishdictionary.database;

import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javapoets.dbcp.ConnectionPool;
import javapoets.dbcp.ConnectionManager;
import online.irishdictionary.model.ContactForm;
public class ContactDatabaseManager {

    private static final org.apache.logging.log4j.Logger log = org.apache.logging.log4j.LogManager.getLogger();

    public static void insert(ContactForm contactForm, Object connectionPoolObject) throws SQLException, Exception {
        insert(contactForm, (ConnectionPool) connectionPoolObject);
    }

    public static void insert(ContactForm contactForm, ConnectionPool connectionPool) throws SQLException, Exception {
        insert(contactForm, new ConnectionManager(connectionPool));
    }

    public static void insert(ContactForm contactForm, ConnectionManager connectionManager) throws SQLException, Exception {
        log.debug("insert(" + contactForm + ", " + connectionManager + ")");
        try {
            String sql = "INSERT INTO contact (name, email, message) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connectionManager.prepareStatement(sql);
            preparedStatement.setString(1, contactForm.getName());
            preparedStatement.setString(2, contactForm.getEmail());
            preparedStatement.setString(3, contactForm.getMessage());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            try {
              connectionManager.commit();
            } catch (Exception exception) {}
        }
    }
}

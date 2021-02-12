package online.irishdictionary.database;

import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javapoets.dbcp.ConnectionPool;
import javapoets.dbcp.ConnectionManager;
import online.irishdictionary.model.Definition;
import online.irishdictionary.model.Usage;
import online.irishdictionary.model.Verb;
import online.irishdictionary.model.VerbConjugation;
import online.irishdictionary.model.Word;

public class AnalyticsDatabaseManager {

    private static final org.apache.logging.log4j.Logger log = org.apache.logging.log4j.LogManager.getLogger();

    public static void insertWordSearched(
        String wordParameter
        , String fromLanguage
        , String toLanguage
        , String remoteAddr
        , String locale
        , int wordExists
        , int usageExists
        , ConnectionPool connectionPool
    ) throws SQLException, Exception {
        
        log.debug(new StringBuilder().append("insert('")
            .append(wordParameter)
            .append("', '").append(fromLanguage)
            .append("', '").append(toLanguage)
            .append("', '").append(remoteAddr)
            .append("', '").append(locale)
            .append("', ").append(wordExists)
            .append("', ").append(usageExists)
            .append(", ").append(connectionPool)
            .append(")").toString());

        insertWordSearched(
            wordParameter
            , fromLanguage
            , toLanguage
            , remoteAddr
            , locale
            , wordExists
            , usageExists
            , new ConnectionManager(connectionPool)
        );
    }

    public static void insertWordSearched(
        String wordParameter
        , String fromLanguage
        , String toLanguage
        , String remoteAddr
        , String locale
        , int wordExists
        , int usageExists
        , ConnectionManager connectionManager
    ) throws SQLException, Exception {
        log.debug(new StringBuilder().append("insert('")
            .append(wordParameter)
            .append("', '").append(fromLanguage)
            .append("', '").append(toLanguage)
            .append("', '").append(remoteAddr)
            .append("', '").append(locale)
            .append("', ").append(wordExists)
            .append("', ").append(usageExists)
            .append(", ").append(connectionManager)
            .append(")").toString());
        try {
            String sql = new StringBuilder()
                .append("INSERT INTO searched_word (")
                .append("word, from_language, to_language, remote_addr, locale, word_found, usage_found")
                .append(") VALUES (?, ?, ?, ?, ?, ?, ?)")
                .toString();
            PreparedStatement preparedStatement = connectionManager.prepareStatement(sql);
            preparedStatement.setString(1, wordParameter);
            preparedStatement.setString(2, fromLanguage);
            preparedStatement.setString(3, toLanguage);
            preparedStatement.setString(4, remoteAddr);
            preparedStatement.setString(5, locale);
            preparedStatement.setInt(6, wordExists);
            preparedStatement.setInt(7, usageExists);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            try {
              connectionManager.commit();
            } catch (Exception exception) {}
        }
    }

    /*
    java.util.Date dateNow = new java.util.Date();
    java.text.SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String currentTime = simpleDateFormat.format(dateNow);
    Then use setString in your prepared statement. 
    //.setDatePublished(resultSet.getDate(8));
    //.setDatetimePublished(resultSet.getDate(9));
    //new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime())
    */
}

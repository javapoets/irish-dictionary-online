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

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import javapoets.dbcp.ConnectionPool;
import javapoets.dbcp.ConnectionManager;

import online.irishdictionary.model.Definition;
import online.irishdictionary.model.Usage;
import online.irishdictionary.model.Verb;
import online.irishdictionary.model.VerbConjugation;
import online.irishdictionary.model.Word;

public class DictionaryDatabaseManager {

    private static final String className = DictionaryDatabaseManager.class.getName();
    private static final Logger logger = LogManager.getLogger();
    private static final String IRISH_WORD = "ie_";
    private static final String ENGLISH_WORD = "ei_";

    public static void selectWord(Word word, int languageId, Object connectionPoolObject) throws SQLException, Exception {
        logger.debug("selectWord("+word+", "+languageId+", "+connectionPoolObject+")");
        selectWord(word, languageId, (ConnectionPool) connectionPoolObject);
    }

    public static void selectWord(Word word, int languageId, ConnectionPool connectionPool) throws SQLException, Exception {
        logger.debug("selectWord("+word+", "+languageId+", "+connectionPool+")");
        selectWord(word, languageId, new ConnectionManager(connectionPool));
    }

    public static void selectWord(Word word, int languageId, ConnectionManager connectionManager) throws java.sql.SQLException, Exception {
        logger.debug("selectWord("+word.getWord()+", "+languageId+", connectionManager)");
        ResultSet rset = null;
        PreparedStatement stmt = null;
        try {
            List definitionList = new ArrayList();
            selectDefinition(word.getWord(), languageId, definitionList, connectionManager);
            word.setDefinitionList(definitionList);
            //logger.debug("definitionList.size() = "+definitionList.size());
            List usageList = new ArrayList();
            if(languageId == 1) {
                selectUsageByEnglishPhrase(word.getWord(), usageList, connectionManager);
            } else {
                selectUsageByIrishPhrase(word.getWord(), usageList, connectionManager);
            }
            word.setUsageList(usageList);
        } finally {
            connectionManager.commit();
        }
    }

    public static void selectDefinition(String word, int languageId, List definitionList, ConnectionManager connectionManager) throws java.sql.SQLException, Exception {
        logger.debug("selectDefinition('"+word+"', "+languageId+", definitionList, connectionManager)");
        PreparedStatement stmt = connectionManager.loadStatement("selectWordByWordAndLanguageId");
        stmt.setString(1, word);
        stmt.setInt(2, languageId);
        ResultSet rset = stmt.executeQuery();
        while(rset.next()){
            Definition definition = new Definition();
            definition.setId(rset.getInt(1));
            definition.setWord(rset.getString(2));
            definition.setWordAscii(rset.getString(3));
            definition.setDefinition(rset.getString(4));
            definition.setType(rset.getString(5));
            definition.setDescription(rset.getString(6));
            definition.setGender(rset.getString(7));
            definitionList.add(definition);
        }
    }

    public static void selectWord(Word word, ConnectionManager connectionManager) throws java.sql.SQLException, Exception {
        logger.debug("selectWord('"+word.getWord()+"')");
        ResultSet rset = null;
        PreparedStatement stmt = null;
        try {
            List definitionList = new ArrayList();
            selectDefinition(word.getWord(), definitionList, connectionManager);
            word.setDefinitionList(definitionList);
            logger.debug("definitionList.size() = "+definitionList.size());
            List usageList = new ArrayList();
            selectUsageByEnglishPhrase(word.getWord(), usageList, connectionManager);
            word.setUsageList(usageList);
        } finally {
            connectionManager.commit();
        }
    }

    public static void selectEnglishWord(Word word, Object connectionPoolObject) throws SQLException, Exception {
        logger.debug("selectEnglishWord("+word+", "+connectionPoolObject+")");
        selectEnglishWord(word, (ConnectionPool) connectionPoolObject);
    }

    public static void selectEnglishWord(Word word, ConnectionPool connectionPool) throws SQLException, Exception {
        logger.debug("selectEnglishWord("+word+", "+connectionPool+")");
        selectEnglishWord(word, new ConnectionManager(connectionPool));
    }

    public static void selectEnglishWord(Word word, ConnectionManager connectionManager) throws java.sql.SQLException, Exception {
        logger.debug("selectEnglishWord("+word.getWord()+", connectionManager)");
        ResultSet rset = null;
        PreparedStatement stmt = null;
        try {
            List definitionList = new ArrayList();
            //selectDefinition(word.getWord(), definitionList);
            selectDefinition(word.getWord(), definitionList, connectionManager);
            word.setDefinitionList(definitionList);
            logger.debug("selectEnglishWord('"+word.getWord()+"'): definitionList.size() = "+definitionList.size());
            List usageList = new ArrayList();
            //selectUsage(word.getWord(), usageList);
            //selectUsage(word.getWord(), usageList);
            selectUsageByEnglishPhrase(word.getWord(), usageList, connectionManager);
            word.setUsageList(usageList);
        } finally {
            connectionManager.commit();
        }
    }

    /*
    //public static void selectDefinition(Word word){
    public static void selectDefinition(String word, List definitionList) throws java.sql.SQLException, Exception {
        logger.debug("selectDefinition('"+word+"', definitionList)");

        //String statementName = "selectDefinition";
        String statementName = "selectWord";
        ConnectionManager connectionManager = new ConnectionManager(className, statementName);
        ResultSet rset = null;
        PreparedStatement stmt = null;

        try {

            stmt = connectionManager.loadStatement(statementName);
            stmt.setString(1, word);

            rset = stmt.executeQuery();
            while(rset.next()){
                Definition definition = new Definition();
                definition.setId(rset.getInt(1));
                definition.setWord(rset.getString(2));
                definition.setDefinition(rset.getString(3));
                definition.setType(rset.getString(4));
                definition.setDescription(rset.getString(5));
                definition.setGender(rset.getString(6));
                definitionList.add(definition);
            }
        } finally {
            connectionManager.commit();
        }
    }
    */

    /*
     * 7969 [qtp26528364-18] DEBUG ConnectionManager - addElementToShutDownList(com.mysql.jdbc.JDBC4PreparedStatement@1c05ffd: SELECT id,word,definition,type,description,gender
 FROM word WHERE word=** NOT SPECIFIED **)
     SELECT id,word,definition,type,description,gender FROM word WHERE word='test';
     */
    public static void selectDefinition(String word, List definitionList, ConnectionManager connectionManager) throws java.sql.SQLException, Exception {
        logger.debug("selectDefinition('"+word+"', definitionList, connectionManager)");
        //String statementName = "selectDefinition";
        PreparedStatement stmt = connectionManager.loadStatement("selectWordByWord");
        stmt.setString(1, word);
        ResultSet rset = stmt.executeQuery();
        while(rset.next()){
            Definition definition = new Definition();
            definition.setId(rset.getInt(1));
            definition.setWord(rset.getString(2));
            definition.setWordAscii(rset.getString(3));
            definition.setDefinition(rset.getString(4));
            definition.setType(rset.getString(5));
            definition.setDescription(rset.getString(6));
            definition.setGender(rset.getString(7));
            definitionList.add(definition);
        }
    }

    //public static void selectUsage(Word word){
    public static void selectUsage(String word, List usageList, ConnectionManager connectionManager) throws java.sql.SQLException, Exception {
        logger.debug("selectUsage('"+word+"', usageList, connectionManager)");
        String statementName = "selectUsage";
        ResultSet rset = null;
        PreparedStatement stmt = null;
        try {
            stmt = connectionManager.loadStatement(statementName);
            stmt.setString(1, " "+word+" ");
            stmt.setString(2, word+" ");
            stmt.setString(3, " "+word);
            rset = stmt.executeQuery();
            while(rset.next()){
                Usage usage = new Usage();
                /*
                usage.setUsageId(rset.getInt(1));
                usage.setWord(rset.getString(2));
                usage.setUsage(rset.getString(3));
                usage.setType(rset.getString(4));
                usage.setDescription(rset.getString(5));
                usage.setGender(rset.getString(6));
                usage.setUsageTranslated(rset.getString(7));
                */
                usage.setUsage(rset.getString(1));
                usage.setType(rset.getString(2));
                usage.setDescription(rset.getString(3));
                usage.setPlusSuffix(rset.getString(4));
                usage.setGender(rset.getString(5));
                usage.setUsageTranslated(rset.getString(6));
                usageList.add(usage);
            }
        } finally {
            connectionManager.commit();
        }
    }

    /*
    public static void selectUsageByEnglishPhrase(String word, List usageList, ConnectionManager connectionManager) throws java.sql.SQLException, Exception {
        logger.debug("selectUsageByEnglishPhrase('"+word+"', usageList, connectionManager)");

        String statementName = "selectUsageByEnglishPhrase";
        ResultSet rset = null;
        PreparedStatement stmt = null;

        try {

            stmt = connectionManager.loadStatement(statementName);
            stmt.setString(1, "%"+word+"%");
            stmt.setString(2, word+"%");
            stmt.setString(3, "%"+word);

            rset = stmt.executeQuery();
            while(rset.next()){
                Usage usage = new Usage();
                usage.setUsageId(rset.getInt(1));
                usage.setUsage(rset.getString(2));
                usage.setType(rset.getString(3));
                usage.setDescription(rset.getString(4));
                usage.setGender(rset.getString(5));
                usage.setUsageTranslated(rset.getString(6));
                usageList.add(usage);
            }

        } finally {
            connectionManager.commit();
        }
    }
    */

    public static void selectUsageByEnglishPhrase(String word, List usageList, ConnectionManager connectionManager) throws java.sql.SQLException, Exception {
        logger.debug("selectUsageByEnglishPhrase('"+word+"', usageList)");
        String statementName = "selectUsageByEnglishPhrase";
        PreparedStatement stmt = connectionManager.loadStatement(statementName);
        stmt.setString(1, "%"+word+"%");
        stmt.setString(2, word+"%");
        stmt.setString(3, "%"+word);
        ResultSet rset = stmt.executeQuery();
        while(rset.next()){
            Usage usage = new Usage();
            usage.setUsageId(rset.getInt(1));
            usage.setUsage(rset.getString(2));
            usage.setType(rset.getString(3));
            usage.setDescription(rset.getString(4));
            usage.setPlusSuffix(rset.getString(5));
            usage.setGender(rset.getString(6));
            usage.setUsageTranslated(rset.getString(7));
            usageList.add(usage);
        }
    }

    public static void selectIrishWord(Word word, Object connectionPoolObject) throws SQLException, Exception {
        logger.debug("selectIrishWord("+word+", "+connectionPoolObject+")");
        selectIrishWord(word, (ConnectionPool) connectionPoolObject);
    }

    public static void selectIrishWord(Word word, ConnectionPool connectionPool) throws SQLException, Exception {
        logger.debug("selectIrishWord("+word+", "+connectionPool+")");
        selectIrishWord(word, new ConnectionManager(connectionPool));
    }

    public static void selectIrishWord(Word word, ConnectionManager connectionManager) throws java.sql.SQLException, Exception {
        logger.debug("selectIrishWord("+word.getWord()+", connectionManager)");
        ResultSet rset = null;
        PreparedStatement stmt = null;
        try {
            List definitionList = new ArrayList();
            selectIrishDefinition(word, definitionList, connectionManager);
            word.setDefinitionList(definitionList);
            List usageList = new ArrayList();
            selectUsageByIrishPhrase(word.getWord(), usageList, connectionManager);
            word.setUsageList(usageList);
        } finally {
            connectionManager.commit();
        }
    }

    //public static void selectDefinition(Word word){
    public static void selectIrishDefinition(Word word, List definitionList, ConnectionManager connectionManager) throws java.sql.SQLException, Exception {
        logger.debug("selectIrishDefinition('"+word.getWord()+"', definitionList, connectionManager)");
        String statementName = "selectIrishDefinition";
        String irishWord = word.getWord();
        PreparedStatement stmt = connectionManager.loadStatement(statementName);
        stmt.setString(1, irishWord);
        ResultSet rset = stmt.executeQuery();
        while(rset.next()) {
            Definition definition = new Definition();
            definition.setId(rset.getInt(1));
            irishWord = rset.getString(2);
            definition.setWord(irishWord);
            definition.setWordAscii(rset.getString(3));
            definition.setDefinition(rset.getString(4));
            definition.setType(rset.getString(5));
            definition.setDescription(rset.getString(6));
            definition.setGender(rset.getString(7));
            definitionList.add(definition);
        }
        word.setWord(irishWord);
    }

    //public static void selectUsage(Word word){
    public static void selectIrishUsage(String word, List usageList, ConnectionManager connectionManager) throws java.sql.SQLException, Exception {
        logger.debug("selectIrishUsage('"+word+"', usageList, connectionManager)");
        String statementName = "selectIrishUsage";
        ResultSet rset = null;
        PreparedStatement stmt = null;
        try {
            stmt = connectionManager.loadStatement(statementName);
            stmt.setString(1, "% "+word+" %");
            rset = stmt.executeQuery();
            while(rset.next()){
                Usage usage = new Usage();
                usage.setUsageId(rset.getInt(1));
                usage.setWord(rset.getString(2));
                usage.setUsage(rset.getString(3));
                usage.setType(rset.getString(4));
                usage.setDescription(rset.getString(5));
                usage.setPlusSuffix(rset.getString(6));
                usage.setGender(rset.getString(7));
                usage.setUsageTranslated(rset.getString(8));
                usageList.add(usage);
            }
        } finally {
            connectionManager.commit();
        }
    }

    public static void selectUsageByIrishPhrase(String word, List usageList, ConnectionManager connectionManager) throws java.sql.SQLException, Exception {
        logger.debug("selectUsageByIrishPhrase('"+word+"', usageList, connectionManager)");
        PreparedStatement stmt = connectionManager.loadStatement("selectUsageByIrishPhrase");
        stmt.setString(1, "%"+word+"%");
        stmt.setString(2, word+"%");
        stmt.setString(3, "%"+word);
        ResultSet rset = stmt.executeQuery();
        while(rset.next()){
            Usage usage = new Usage();
            /*
            usage.setUsageId(rset.getInt(1));
            usage.setWord(rset.getString(2));
            usage.setUsage(rset.getString(3));
            usage.setType(rset.getString(4));
            usage.setDescription(rset.getString(5));
            usage.setGender(rset.getString(6));
            usage.setUsageTranslated(rset.getString(7));
            */
            usage.setUsageId(rset.getInt(1));
            usage.setUsage(rset.getString(2));
            usage.setType(rset.getString(3));
            usage.setDescription(rset.getString(4));
            usage.setPlusSuffix(rset.getString(5));
            usage.setGender(rset.getString(6));
            usage.setUsageTranslated(rset.getString(7));
            usageList.add(usage);
        }
    }

    public static void selectUsageByUsageId(Usage usage, ConnectionManager connectionManager) throws java.sql.SQLException, Exception {
        logger.debug("selectUsageByUsageId("+usage.getUsageId()+", connectionManager)");
        String statementName = "selectUsageByUsageId";
        ResultSet rset = null;
        PreparedStatement stmt = null;
        try {
            stmt = connectionManager.loadStatement(statementName);
            stmt.setInt(1, usage.getUsageId());
            rset = stmt.executeQuery();
            while(rset.next()){
                usage.setUsage(rset.getString(1));
                usage.setType(rset.getString(2));
                usage.setDescription(rset.getString(3));
                usage.setPlusSuffix(rset.getString(4));
                usage.setGender(rset.getString(5));
                usage.setUsageTranslated(rset.getString(6));
            }
        } finally {
            connectionManager.commit();
        }
    }

    /**
    * Looks up the dictionary database for the all words beginning with the @param letter
    */
    public static void selectWordByLetter(List letterWordList, String letter, ConnectionManager connectionManager) throws java.sql.SQLException, Exception {
        logger.debug("selectWordByLetter(letterWordList, "+letter+", connectionManager)");
        String statementName = "selectWordByLetter :: "+ letter;
        ResultSet rset = null;
        PreparedStatement stmt = null;
        try {
            stmt = connectionManager.prepareStatement("select word from "+ENGLISH_WORD+letter);
            rset = stmt.executeQuery();
            while(rset.next()) letterWordList.add(rset.getString(1));
        } finally {
            connectionManager.commit();
        }
    }

    /**
    * Looks up the dictionary database for the all words beginning with the @param letter
    */
    public static void selectWordByLetter(Set letterWordSet, String letter, ConnectionManager connectionManager) throws java.sql.SQLException, Exception {
        logger.debug("selectWordByLetter(letterWordSet, "+letter+", connectionManager)");
        String statementName = "selectWordByLetter :: "+ letter;
        ResultSet rset = null;
        PreparedStatement stmt = null;
        try {
            stmt = connectionManager.prepareStatement("select word from "+ENGLISH_WORD+letter);
            rset = stmt.executeQuery();
            while(rset.next()) letterWordSet.add(rset.getString(1));
        } finally {
            connectionManager.commit();
        }
    }

    public static void insertUsage(Usage usage, ConnectionManager connectionManager) throws java.sql.SQLException, Exception {
        logger.debug("insertUsage(usage, connectionManager)");
        String statementName = "insertUsage";
        PreparedStatement stmt = null;
        try {
            stmt = connectionManager.loadStatement(statementName);
            stmt.setString(1, usage.getWord());
            stmt.setString(2, usage.getUsage());
            stmt.setString(3, usage.getType());
            stmt.setString(4, usage.getDescription());
            stmt.setString(5, usage.getPlusSuffix());
            stmt.setString(6, usage.getGender());
            stmt.setString(7, usage.getUsageTranslated());
            stmt.setInt(8, usage.getPrevUsageId());
            stmt.executeUpdate();
        } finally {
            connectionManager.commit();
        }
    }
}

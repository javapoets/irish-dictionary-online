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

//import com.javapoets.db.ConnectionManager;
import com.ispaces.dbcp.ConnectionManager;

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

    public static void selectWord(Word word, int languageId) throws java.sql.SQLException, Exception {
        logger.debug("selectWord('"+word.getWord()+"', "+languageId+")");

        ConnectionManager connectionManager = new ConnectionManager(className);
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

    public static void selectWord(Word word) throws java.sql.SQLException, Exception {
        logger.debug("selectWord('"+word.getWord()+"')");

        ConnectionManager connectionManager = new ConnectionManager(className);
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


    /**
    * Looks up the dictionary database for the word entered
    */
    public static void selectEnglishWord(Word word) throws java.sql.SQLException, Exception {
        logger.debug("selectEnglishWord('"+word.getWord()+"')");

        ConnectionManager connectionManager = new ConnectionManager(className);
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
    public static void selectUsage(String word, List usageList) throws java.sql.SQLException, Exception {
        logger.debug("selectUsage('"+word+"', usageList)");

        String statementName = "selectUsage";
        ConnectionManager connectionManager = new ConnectionManager(statementName);
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
                usage.setGender(rset.getString(4));
                usage.setUsageTranslated(rset.getString(5));
                usageList.add(usage);
            }
        } finally {
            connectionManager.commit();
        }
    }

    public static void selectUsageByEnglishPhrase(String word, List usageList) throws java.sql.SQLException, Exception {
        logger.debug("selectUsageByEnglishPhrase('"+word+"', usageList)");

        String statementName = "selectUsageByEnglishPhrase";
        ConnectionManager connectionManager = new ConnectionManager(className, statementName);
        ResultSet rset = null;
        PreparedStatement stmt = null;

        try {

            stmt = connectionManager.loadStatement(statementName);
            /*
            stmt.setString(1, " "+word+" ");
            stmt.setString(2, word+" ");
            stmt.setString(3, " "+word);
             */
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
            usage.setGender(rset.getString(5));
            usage.setUsageTranslated(rset.getString(6));
            usageList.add(usage);
        }
    }

    /**
    * Looks up the dictionary database for the word entered
    */
    public static void selectIrishWord(Word word) throws java.sql.SQLException, Exception {
        logger.debug("selectIrishWord('"+word.getWord()+"')");

        ConnectionManager connectionManager = new ConnectionManager(className, "selectIrishWord");
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
    public static void selectIrishUsage(String word, List usageList) throws java.sql.SQLException, Exception {
        logger.debug("selectIrishUsage('"+word+"', usageList)");

        String statementName = "selectIrishUsage";
        ConnectionManager connectionManager = new ConnectionManager(statementName);
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
                usage.setGender(rset.getString(6));
                usage.setUsageTranslated(rset.getString(7));
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
            usage.setGender(rset.getString(5));
            usage.setUsageTranslated(rset.getString(6));

            usageList.add(usage);
        }
    }

    public static void selectUsageByUsageId(Usage usage) throws java.sql.SQLException, Exception {
        logger.debug("selectUsageByUsageId("+usage.getUsageId()+")");

        String statementName = "selectUsageByUsageId";
        ConnectionManager connectionManager = new ConnectionManager(statementName);
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
                usage.setGender(rset.getString(4));
                usage.setUsageTranslated(rset.getString(5));
            }

        } finally {
            connectionManager.commit();
        }
    }

    /**
    * Looks up the dictionary database for the all words beginning with the @param letter
    */
    public static void selectWordByLetter(List letterWordList, String letter) throws java.sql.SQLException, Exception {
        logger.debug("selectWordByLetter(letterWordList, "+letter+")");

        String statementName = "selectWordByLetter :: "+ letter;
        ConnectionManager connectionManager = new ConnectionManager(statementName);
        ResultSet rset = null;
        PreparedStatement stmt = null;

        try {

            //stmt = connectionManager.loadStatement(statementName);
            stmt = connectionManager.prepareStatement("select word from "+ENGLISH_WORD+letter);

            //stmt.setString(1, letter);
            rset = stmt.executeQuery();

            while(rset.next()) letterWordList.add(rset.getString(1));

        } finally {
            connectionManager.commit();
        }
    }

    /**
    * Looks up the dictionary database for the all words beginning with the @param letter
    */
    public static void selectWordByLetter(Set letterWordSet, String letter) throws java.sql.SQLException, Exception {
        logger.debug("selectWordByLetter(letterWordSet, "+letter+")");

        String statementName = "selectWordByLetter :: "+ letter;
        ConnectionManager connectionManager = new ConnectionManager(statementName);
        ResultSet rset = null;
        PreparedStatement stmt = null;

        try {

            //boolean changeDb = SQLUtil.setDatabaseToUseMysql("englishirishdictionary", conn);
            // Load up the correct SQL statement
            //stmt = connectionManager.loadStatement(statementName);
            stmt = connectionManager.prepareStatement("select word from "+ENGLISH_WORD+letter);

            //stmt.setString(1, letter);
            rset = stmt.executeQuery();

            while(rset.next()) letterWordSet.add(rset.getString(1));

        } finally {
            connectionManager.commit();
        }
    }

    public static void insertUsage(Usage usage) throws java.sql.SQLException, Exception {
        logger.debug("insertUsage(usage)");

        String statementName = "insertUsage";
        ConnectionManager connectionManager = new ConnectionManager(statementName);
        PreparedStatement stmt = null;

        try {

            stmt = connectionManager.loadStatement(statementName);
            stmt.setString(1, usage.getWord());
            stmt.setString(2, usage.getUsage());
            stmt.setString(3, usage.getType());
            stmt.setString(4, usage.getDescription());
            stmt.setString(5, usage.getGender());
            stmt.setString(6, usage.getUsageTranslated());
            stmt.setInt(7, usage.getPrevUsageId());
            stmt.executeUpdate();

        } finally {
            connectionManager.commit();
        }
    }

}

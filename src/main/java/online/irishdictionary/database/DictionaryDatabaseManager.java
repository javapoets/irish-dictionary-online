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

public class DictionaryDatabaseManager {

    private static final org.apache.logging.log4j.Logger log = org.apache.logging.log4j.LogManager.getLogger();
    //private static final String className = DictionaryDatabaseManager.class.getName();
    private final String className = getClass().getName();
    private static final String IRISH_WORD = "ie_";
    private static final String ENGLISH_WORD = "ei_";
    private static final String SPACE = " ";
    private static final String EMPTY = "";
    private static final String PERCENT_SIGN = "%";
    private static final String SELECT_DEFINITION_BY_WORD_AND_LANGUAGE_ID = "selectDefinitionByWordAndLanguageId";

    public static void populateWord(Word word, int languageId, Object connectionPoolObject) throws SQLException, Exception {
        log.trace("selectWord(" + word + ", " + languageId + ", "+connectionPoolObject+")");
        populateWord(word, languageId, (ConnectionPool) connectionPoolObject);
    }

    public static void populateWord(Word word, int languageId, ConnectionPool connectionPool) throws SQLException, Exception {
        log.trace("selectWord(" + word + ", " + languageId + ", " + connectionPool + ")");
        populateWord(word, languageId, new ConnectionManager(connectionPool));
    }

    public static void populateWord(Word word, int languageId, ConnectionManager connectionManager) throws java.sql.SQLException, Exception {
        log.debug("selectWord(" + word + ", " + languageId + ", connectionManager)");
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        try {
            selectWord(word, languageId, connectionManager);
            List<Definition> definitionList = new ArrayList<Definition>();
            selectDefinitions(word.getWord(), languageId, definitionList, connectionManager);
            word.setDefinitionList(definitionList);
            //log.debug("definitionList.size() = "+definitionList.size());
            List<Usage> usageList = new ArrayList<Usage>();
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

    public static void selectWord(Word word, int languageId, Object connectionPoolObject) throws SQLException, Exception {
        log.debug("selectWord(" + word + ", languageId, " + connectionPoolObject + ")");
        selectWord(word, languageId, (ConnectionPool) connectionPoolObject);
    }

    public static void selectWord(Word word, int languageId, ConnectionPool connectionPool) throws SQLException, Exception {
        log.debug("selectWord(" + word + ", languageId, " + connectionPool + ")");
        selectWord(word, languageId, new ConnectionManager(connectionPool));
    }

    public static void selectWord(Word word, int languageId, ConnectionManager connectionManager) throws java.sql.SQLException, Exception {
        log.debug("selectWord('" + word + "', " + languageId + ", connectionManager)");
        String sql = new StringBuilder()
            .append("SELECT id, word, word_ascii, word_description, definition, type, description, gender, declension, genitive_singular, nominative_singular, genitive_plural, nominative_plural")
            .append(" FROM word")
            .append(" WHERE word = ?")
            .append(" AND language_id = ?")
            //.append(" AND definition IS NULL")
            .toString();
        //PreparedStatement preparedStatement = connectionManager.loadStatement(SELECT_WORD_BY_LANGUAGE_ID);
        PreparedStatement preparedStatement = connectionManager.prepareStatement(sql);
        preparedStatement.setString(1, word.getWord());
        preparedStatement.setInt(2, languageId);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            word.setId(resultSet.getInt(1));
            word.setWord(resultSet.getString(2));
            //word.setWordAscii(resultSet.getString(3));
            //word.setDefinition(resultSet.getString(4));
            //word.setType(resultSet.getString(5));
            word.setWordDescription(resultSet.getString("word_description"));
            word.setType(resultSet.getString("type"));
            //word.setDescription(resultSet.getString(6));
            word.setDescription(resultSet.getString("description"));
            //word.setGender(resultSet.getString(7));
            word.setGender(resultSet.getString("gender"));
            word.setDeclension(resultSet.getString("declension"));
            word.setGenitiveSingular(resultSet.getString("genitive_singular"));
            word.setGenitivePlural(resultSet.getString("genitive_plural"));
            word.setNominativeSingular(resultSet.getString("nominative_singular"));
            word.setNominativePlural(resultSet.getString("nominative_plural"));
        }
    }

    public static void selectDefinitions(String word, int languageId, List<Definition> definitionList, ConnectionManager connectionManager) throws java.sql.SQLException, Exception {
        log.debug("selectDefinition('" + word + "', " + languageId + ", definitionList, connectionManager)");
        PreparedStatement preparedStatement = connectionManager.loadStatement(SELECT_DEFINITION_BY_WORD_AND_LANGUAGE_ID);
        preparedStatement.setString(1, word);
        preparedStatement.setInt(2, languageId);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            do {
                Definition definition = new Definition();
                definition.setId(resultSet.getInt(1));
                definition.setWord(resultSet.getString(2));
                definition.setWordAscii(resultSet.getString(3));
                definition.setDefinition(resultSet.getString(4));
                definition.setType(resultSet.getString(5));
                definition.setDescription(resultSet.getString(6));
                definition.setGender(resultSet.getString(7));
                definitionList.add(definition);
            } while(resultSet.next());
        }
    }

    /*
    public static void selectWord(Word word, ConnectionManager connectionManager) throws java.sql.SQLException, Exception {
        log.debug("selectWord('" + word + "', connectionManager)");
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        try {
            List definitionList = new ArrayList();
            selectDefinition(word.getWord(), definitionList, connectionManager);
            word.setDefinitionList(definitionList);
            log.debug("definitionList.size() = "+definitionList.size());
            List usageList = new ArrayList();
            selectUsageByEnglishPhrase(word.getWord(), usageList, connectionManager);
            word.setUsageList(usageList);
        } finally {
            connectionManager.commit();
        }
    }

    public static void selectEnglishWord(Word word, Object connectionPoolObject) throws SQLException, Exception {
        log.debug("selectEnglishWord(" + word + ", " + connectionPoolObject + ")");
        selectEnglishWord(word, (ConnectionPool) connectionPoolObject);
    }

    public static void selectEnglishWord(Word word, ConnectionPool connectionPool) throws SQLException, Exception {
        log.debug("selectEnglishWord(" + word + ", " + connectionPool + ")");
        selectEnglishWord(word, new ConnectionManager(connectionPool));
    }

    public static void selectEnglishWord(Word word, ConnectionManager connectionManager) throws java.sql.SQLException, Exception {
        log.debug("selectEnglishWord(" + word + ", connectionManager)");
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        try {
            List definitionList = new ArrayList();
            //selectDefinition(word.getWord(), definitionList);
            selectDefinitions(word.getWord(), definitionList, connectionManager);
            word.setDefinitionList(definitionList);
            log.debug("definitionList.size() = "+definitionList.size());
            List usageList = new ArrayList();
            //selectUsage(word.getWord(), usageList);
            //selectUsage(word.getWord(), usageList);
            selectUsageByEnglishPhrase(word.getWord(), usageList, connectionManager);
            word.setUsageList(usageList);
        } finally {
            connectionManager.commit();
        }
    }
    */

    /*
    //public static void selectDefinition(Word word){
    public static void selectDefinition(String word, List definitionList) throws java.sql.SQLException, Exception {
        log.debug("selectDefinition('"+word+"', definitionList)");

        //String statementName = "selectDefinition";
        String statementName = "selectWord";
        ConnectionManager connectionManager = new ConnectionManager(className, statementName);
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;

        try {

            preparedStatement = connectionManager.loadStatement(statementName);
            preparedStatement.setString(1, word);

            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Definition definition = new Definition();
                definition.setId(resultSet.getInt(1));
                definition.setWord(resultSet.getString(2));
                definition.setDefinition(resultSet.getString(3));
                definition.setType(resultSet.getString(4));
                definition.setDescription(resultSet.getString(5));
                definition.setGender(resultSet.getString(6));
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
    public static void selectDefinitions(String word, List<Definition> definitionList, ConnectionManager connectionManager) throws java.sql.SQLException, Exception {
        log.debug("selectDefinition('" + word + "', definitionList, connectionManager)");
        //String statementName = "selectDefinition";
        PreparedStatement preparedStatement = connectionManager.loadStatement("selectWordByWord");
        preparedStatement.setString(1, word);
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()){
            Definition definition = new Definition();
            definition.setId(resultSet.getInt(1));
            definition.setWord(resultSet.getString(2));
            definition.setWordAscii(resultSet.getString(3));
            definition.setDefinition(resultSet.getString(4));
            definition.setType(resultSet.getString(5));
            definition.setDescription(resultSet.getString(6));
            definition.setGender(resultSet.getString(7));
            definitionList.add(definition);
        }
    }

    //public static void selectUsage(Word word){
    public static void selectUsage(String word, List<Usage> usageList, ConnectionManager connectionManager) throws java.sql.SQLException, Exception {
        log.debug("selectUsage('" + word + "', usageList, connectionManager)");
        String statementName = "selectUsage";
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connectionManager.loadStatement(statementName);
            preparedStatement.setString(1, SPACE + word + SPACE);
            preparedStatement.setString(2, word + SPACE);
            preparedStatement.setString(3, SPACE + word);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Usage usage = new Usage();
                /*
                usage.setUsageId(resultSet.getInt(1));
                usage.setWord(resultSet.getString(2));
                usage.setUsage(resultSet.getString(3));
                usage.setType(resultSet.getString(4));
                usage.setDescription(resultSet.getString(5));
                usage.setGender(resultSet.getString(6));
                usage.setUsageTranslated(resultSet.getString(7));
                */
                usage.setUsage(resultSet.getString(1));
                usage.setType(resultSet.getString(2));
                usage.setDescription(resultSet.getString(3));
                usage.setPlusSuffix(resultSet.getString(4));
                usage.setGender(resultSet.getString(5));
                usage.setUsageTranslated(resultSet.getString(6));
                usageList.add(usage);
            }
        } finally {
            connectionManager.commit();
        }
    }

    /*
    public static void selectUsageByEnglishPhrase(String word, List usageList, ConnectionManager connectionManager) throws java.sql.SQLException, Exception {
        log.debug("selectUsageByEnglishPhrase('"+word+"', usageList, connectionManager)");

        String statementName = "selectUsageByEnglishPhrase";
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;

        try {

            preparedStatement = connectionManager.loadStatement(statementName);
            preparedStatement.setString(1, "%"+word+"%");
            preparedStatement.setString(2, word+"%");
            preparedStatement.setString(3, "%"+word);

            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Usage usage = new Usage();
                usage.setUsageId(resultSet.getInt(1));
                usage.setUsage(resultSet.getString(2));
                usage.setType(resultSet.getString(3));
                usage.setDescription(resultSet.getString(4));
                usage.setGender(resultSet.getString(5));
                usage.setUsageTranslated(resultSet.getString(6));
                usageList.add(usage);
            }

        } finally {
            connectionManager.commit();
        }
    }
    */

    public static void selectUsageByEnglishPhrase(String word, List<Usage> usageList, ConnectionManager connectionManager) throws java.sql.SQLException, Exception {
        log.debug("selectUsageByEnglishPhrase('" + word + "', usageList)");
        String statementName = "selectUsageByEnglishPhrase";
        PreparedStatement preparedStatement = connectionManager.loadStatement(statementName);
        preparedStatement.setString(1, PERCENT_SIGN  + word + PERCENT_SIGN);
        preparedStatement.setString(2, word + PERCENT_SIGN);
        preparedStatement.setString(3, PERCENT_SIGN + word);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Usage usage = new Usage();
            usage.setUsageId(resultSet.getInt(1));
            usage.setUsage(resultSet.getString(2));
            usage.setType(resultSet.getString(3));
            usage.setDescription(resultSet.getString(4));
            usage.setPlusSuffix(resultSet.getString(5));
            usage.setGender(resultSet.getString(6));
            usage.setUsageTranslated(resultSet.getString(7));
            usageList.add(usage);
        }
    }

    public static void selectIrishWord(Word word, Object connectionPoolObject) throws SQLException, Exception {
        log.debug("selectIrishWord(" + word + ", "+connectionPoolObject+")");
        selectIrishWord(word, (ConnectionPool) connectionPoolObject);
    }

    public static void selectIrishWord(Word word, ConnectionPool connectionPool) throws SQLException, Exception {
        log.debug("selectIrishWord(" + word + ", " + connectionPool + ")");
        selectIrishWord(word, new ConnectionManager(connectionPool));
    }

    public static void selectIrishWord(Word word, ConnectionManager connectionManager) throws java.sql.SQLException, Exception {
        log.debug("selectIrishWord(" + word + ", connectionManager)");
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        try {
            List<Definition> definitionList = new ArrayList<Definition>();
            selectIrishDefinition(word, definitionList, connectionManager);
            word.setDefinitionList(definitionList);
            List<Usage> usageList = new ArrayList<Usage>();
            selectUsageByIrishPhrase(word.getWord(), usageList, connectionManager);
            word.setUsageList(usageList);
        } finally {
            connectionManager.commit();
        }
    }

    //public static void selectDefinition(Word word){
    public static void selectIrishDefinition(Word word, List<Definition> definitionList, ConnectionManager connectionManager) throws java.sql.SQLException, Exception {
        log.debug("selectIrishDefinition(" + word + ", definitionList, connectionManager)");
        String statementName = "selectIrishDefinition";
        String irishWord = word.getWord();
        PreparedStatement preparedStatement = connectionManager.loadStatement(statementName);
        preparedStatement.setString(1, irishWord);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Definition definition = new Definition();
            definition.setId(resultSet.getInt(1));
            irishWord = resultSet.getString(2);
            definition.setWord(irishWord);
            definition.setWordAscii(resultSet.getString(3));
            definition.setDefinition(resultSet.getString(4));
            definition.setType(resultSet.getString(5));
            definition.setDescription(resultSet.getString(6));
            definition.setGender(resultSet.getString(7));
            definitionList.add(definition);
        }
        word.setWord(irishWord);
    }

    //public static void selectUsage(Word word){
    public static void selectIrishUsage(String word, List<Usage> usageList, ConnectionManager connectionManager) throws java.sql.SQLException, Exception {
        log.debug("selectIrishUsage('" + word + "', usageList, connectionManager)");
        String statementName = "selectIrishUsage";
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connectionManager.loadStatement(statementName);
            preparedStatement.setString(1, "% "+word+" %");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Usage usage = new Usage();
                usage.setUsageId(resultSet.getInt(1));
                usage.setWord(resultSet.getString(2));
                usage.setUsage(resultSet.getString(3));
                usage.setType(resultSet.getString(4));
                usage.setDescription(resultSet.getString(5));
                usage.setPlusSuffix(resultSet.getString(6));
                usage.setGender(resultSet.getString(7));
                usage.setUsageTranslated(resultSet.getString(8));
                usageList.add(usage);
            }
        } finally {
            connectionManager.commit();
        }
    }

    public static void selectUsageByIrishPhrase(String word, List<Usage> usageList, ConnectionManager connectionManager) throws java.sql.SQLException, Exception {
        log.debug("selectUsageByIrishPhrase('" + word + "', usageList, connectionManager)");
        PreparedStatement preparedStatement = connectionManager.loadStatement("selectUsageByIrishPhrase");
        preparedStatement.setString(1, PERCENT_SIGN + word + PERCENT_SIGN);
        preparedStatement.setString(2, word + PERCENT_SIGN);
        preparedStatement.setString(3, PERCENT_SIGN + word);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Usage usage = new Usage();
            /*
            usage.setUsageId(resultSet.getInt(1));
            usage.setWord(resultSet.getString(2));
            usage.setUsage(resultSet.getString(3));
            usage.setType(resultSet.getString(4));
            usage.setDescription(resultSet.getString(5));
            usage.setGender(resultSet.getString(6));
            usage.setUsageTranslated(resultSet.getString(7));
            */
            usage.setUsageId(resultSet.getInt(1));
            usage.setUsage(resultSet.getString(2));
            usage.setType(resultSet.getString(3));
            usage.setDescription(resultSet.getString(4));
            usage.setPlusSuffix(resultSet.getString(5));
            usage.setGender(resultSet.getString(6));
            usage.setUsageTranslated(resultSet.getString(7));
            usageList.add(usage);
        }
    }

    public static void selectUsageByUsageId(Usage usage, ConnectionManager connectionManager) throws java.sql.SQLException, Exception {
        log.debug("selectUsageByUsageId(" + usage + ", connectionManager)");
        String statementName = "selectUsageByUsageId";
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connectionManager.loadStatement(statementName);
            preparedStatement.setInt(1, usage.getUsageId());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                usage.setUsage(resultSet.getString(1));
                usage.setType(resultSet.getString(2));
                usage.setDescription(resultSet.getString(3));
                usage.setPlusSuffix(resultSet.getString(4));
                usage.setGender(resultSet.getString(5));
                usage.setUsageTranslated(resultSet.getString(6));
            }
        } finally {
            connectionManager.commit();
        }
    }

    /**
    * Looks up the dictionary database for the all words beginning with the @param letter
    */
    public static void selectWordByLetter(List letterWordList, String letter, ConnectionManager connectionManager) throws java.sql.SQLException, Exception {
        log.debug("selectWordByLetter(letterWordList, '" + letter + "', connectionManager)");
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connectionManager.prepareStatement("select word from " + ENGLISH_WORD + letter);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) letterWordList.add(resultSet.getString(1));
        } finally {
            connectionManager.commit();
        }
    }

    /**
    * Looks up the dictionary database for the all words beginning with the @param letter
    */
    public static void selectWordByLetter(Set letterWordSet, String letter, ConnectionManager connectionManager) throws java.sql.SQLException, Exception {
        log.debug("selectWordByLetter(letterWordSet, '" + letter + "', connectionManager)");
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connectionManager.prepareStatement("select word from "+ENGLISH_WORD+letter);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) letterWordSet.add(resultSet.getString(1));
        } finally {
            connectionManager.commit();
        }
    }

    public static void insertUsage(Usage usage, ConnectionManager connectionManager) throws java.sql.SQLException, Exception {
        log.debug("insertUsage(" + usage + ", connectionManager)");
        String statementName = "insertUsage";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connectionManager.loadStatement(statementName);
            preparedStatement.setString(1, usage.getWord());
            preparedStatement.setString(2, usage.getUsage());
            preparedStatement.setString(3, usage.getType());
            preparedStatement.setString(4, usage.getDescription());
            preparedStatement.setString(5, usage.getPlusSuffix());
            preparedStatement.setString(6, usage.getGender());
            preparedStatement.setString(7, usage.getUsageTranslated());
            preparedStatement.setInt(8, usage.getPrevUsageId());
            preparedStatement.executeUpdate();
        } finally {
            connectionManager.commit();
        }
    }
}

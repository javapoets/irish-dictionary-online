package online.irishdictionary.database;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javapoets.dbcp.ConnectionManager;
import javapoets.dbcp.ConnectionPool;
import online.irishdictionary.model.Verb;
import online.irishdictionary.model.VerbConjugation;

public class VerbDatabaseManager {

    private static final org.apache.logging.log4j.Logger log = org.apache.logging.log4j.LogManager.getLogger();
    private static final String className = VerbDatabaseManager.class.getName();

    public static boolean selectVerb(Verb verb, Object connectionPoolObject) throws SQLException, Exception {
        log.debug("selectVerb(" + verb + ", " + connectionPoolObject + ")");
        return selectVerb(verb, (ConnectionPool) connectionPoolObject);
    }

    public static boolean selectVerb(Verb verb, ConnectionPool connectionPool) throws SQLException, Exception {
        log.debug("selectVerb(" + verb + ", " + connectionPool + ")");
        return selectVerb(verb, new ConnectionManager(connectionPool));
    }

    public static boolean selectVerb(Verb verb, ConnectionManager connectionManager) throws SQLException, Exception {
        log.debug("selectVerb(" + verb + ", "+connectionManager+")");
        try {
            //PreparedStatement preparedStatement = connectionManager.loadStatement("selectVerb");
            //ResultSet resultSet = preparedStatement.executeQuery();
            //log.debug("resultSet = " + resultSet);
            boolean verbExists = selectVerbOnly(verb, connectionManager);
            log.debug("verbExists = " + verbExists);
            if (verbExists) {
                log.debug("verb.getVerb() = " + verb.getVerb());
                log.debug("verb.getFromLanguageId() = " + verb.getFromLanguageId());
                log.debug("verb.getToLanguageId() = " + verb.getToLanguageId());
                List<Integer> tenseIdArray = new ArrayList<Integer>();
                selectTenseIds(tenseIdArray, connectionManager);
                log.debug("tenseIdArray = " + tenseIdArray);
                Map<String, VerbConjugation> verbConjugationMap = new HashMap<String, VerbConjugation>();
                for (int i = 0; i < tenseIdArray.size(); i++) {
                    int tenseId = tenseIdArray.get(i);
                    //VerbConjugation verbConjugation = new VerbConjugation(verb.getVerb(), tenseId, verb.getToLanguageId());
                    VerbConjugation verbConjugation = new VerbConjugation(verb.getVerb(), tenseId, verb.getFromLanguageId(), verb.getToLanguageId());
                    //selectVerbConjugationByTenseIdAndVerb(verbConjugation, connectionManager);
                    selectVerbConjugationByTenseIdAndVerb(verbConjugation, verb.getFromLanguageId(), connectionManager);
                    verbConjugationMap.put(String.valueOf(tenseId), verbConjugation);
                }
                verb.setVerbConjugationMap(verbConjugationMap);
                List<Verb> verbList = new ArrayList<Verb>();
                selectMappedVerbsByVerb(verbList, verb, connectionManager);
                verb.setVerbList(verbList);
                //verb.setVerbList(verbList);
                return true;
            }
        } catch (Exception e) {
            log.error(e);
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            e.printStackTrace(printWriter);
            log.error(stringWriter.toString());
        } finally {
            // Free resources allocated.
            connectionManager.commit();
        }
        return false;
    }

    public static void selectTenseIds(List<Integer> tenseIdArray, ConnectionManager connectionManager) throws java.sql.SQLException, Exception {
        log.debug("selectTenseIds(tenseIdArray, connectionManager)");
        String statementName = "selectTenseIds";
        PreparedStatement preparedStatement = connectionManager.loadStatement(statementName);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            //log.debug("tenseIdArray.add("+resultSet.getInt(1)+")");
            tenseIdArray.add(resultSet.getInt(1));
        }
    }

    /*
    public static void selectVerbConjugationByTenseIdAndVerb(VerbConjugation verbConjugation, ConnectionManager connectionManager) throws java.sql.SQLException, Exception {
        log.debug("selectVerbConjugationByTenseIdAndVerb(verbConjugation, connectionManager)");
        log.debug("verbConjugation.getVerb() = " + verbConjugation.getVerb());
        log.debug("verbConjugation.getFromLanguageId() = " + verbConjugation.getFromLanguageId());
        log.debug("verbConjugation.getToLanguageId() = " + verbConjugation.getToLanguageId());
        int fromLanguageId = verbConjugation.getFromLanguageId();
        int toLanguageId = verbConjugation.getToLanguageId();
        log.debug("fromLanguageId = " + fromLanguageId);
        log.debug("toLanguageId = " + toLanguageId);
        PreparedStatement preparedStatement = connectionManager.loadStatement("selectVerbConjugationByTenseIdAndVerb");
        preparedStatement.setInt(1, verbConjugation.getTenseId());
        preparedStatement.setString(2, verbConjugation.getVerb());
        preparedStatement.setInt(3, toLanguageId);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            verbConjugation.setVerbConjugationId(resultSet.getInt(1));
            verbConjugation.setMe(resultSet.getString(2));
            verbConjugation.setYouSingular(resultSet.getString(3));
            verbConjugation.setHe(resultSet.getString(4));
            verbConjugation.setShe(resultSet.getString(5));
            verbConjugation.setWe(resultSet.getString(6));
            verbConjugation.setYouPlural(resultSet.getString(7));
            verbConjugation.setThey(resultSet.getString(8));
            verbConjugation.setAutonomous(resultSet.getString(9));
            verbConjugation.setNegative(resultSet.getString(10));
            verbConjugation.setQuestion(resultSet.getString(11));
            verbConjugation.setTenseIrish(resultSet.getString(12));
            verbConjugation.setTenseEnglish(resultSet.getString(13));
            //verbConjugationMap.put("verbIrishConditionalBean", verbConjugation);
        }
    }
    */

    public static void selectVerbConjugationByTenseIdAndVerb(VerbConjugation verbConjugation, int languageId, ConnectionManager connectionManager) throws java.sql.SQLException, Exception {
        log.debug("selectVerbConjugationByTenseIdAndVerb(verbConjugation, languageId:" + languageId + ", connectionManager)");
        log.debug("verbConjugation.getVerb() = " + verbConjugation.getVerb());
        //log.debug("verbConjugation.getFromLanguageId() = " + verbConjugation.getFromLanguageId());
        //log.debug("verbConjugation.getToLanguageId() = " + verbConjugation.getToLanguageId());
        //int fromLanguageId = verbConjugation.getFromLanguageId();
        //int toLanguageId = verbConjugation.getToLanguageId();
        //log.debug("fromLanguageId = " + fromLanguageId);
        //log.debug("toLanguageId = " + toLanguageId);
        PreparedStatement preparedStatement = connectionManager.loadStatement("selectVerbConjugationByTenseIdAndVerb");
        preparedStatement.setInt(1, verbConjugation.getTenseId());
        preparedStatement.setString(2, verbConjugation.getVerb());
        preparedStatement.setInt(3, languageId);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            verbConjugation.setVerbConjugationId(resultSet.getInt(1));
            verbConjugation.setMe(resultSet.getString(2));
            verbConjugation.setYouSingular(resultSet.getString(3));
            verbConjugation.setHe(resultSet.getString(4));
            verbConjugation.setShe(resultSet.getString(5));
            verbConjugation.setWe(resultSet.getString(6));
            verbConjugation.setYouPlural(resultSet.getString(7));
            verbConjugation.setThey(resultSet.getString(8));
            verbConjugation.setAutonomous(resultSet.getString(9));
            verbConjugation.setNegative(resultSet.getString(10));
            verbConjugation.setQuestion(resultSet.getString(11));
            verbConjugation.setTenseIrish(resultSet.getString(12));
            verbConjugation.setTenseEnglish(resultSet.getString(13));
            verbConjugation.setWeAlternative(resultSet.getString(14));
            verbConjugation.setTheyAlternative(resultSet.getString(15));
            //verbConjugationMap.put("verbIrishConditionalBean", verbConjugation);
        }
    }

    // SELECT stem,verbal_noun,verbal_adjective,infinitive,participle,gerund,regular,conjugation,broad_slender FROM verb WHERE language_id=? AND verb=?
    public static boolean selectVerbOnly(Verb verb, ConnectionManager connectionManager) throws java.sql.SQLException, Exception {
        log.debug("selectVerbOnly(" + verb + ", connectionManager)");
        log.debug("verb.getFromLanguageId() = " + verb.getFromLanguageId());
        log.debug("verb.getVerb() = " + verb.getVerb());
        try {
            String statementName = "selectVerb";
            PreparedStatement preparedStatement = connectionManager.loadStatement(statementName);
            preparedStatement.setInt(1, verb.getFromLanguageId());
            preparedStatement.setString(2, verb.getVerb());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                verb.setStem(resultSet.getString(1));
                verb.setVerbalNoun(resultSet.getString(2));
                verb.setVerbalAdjective(resultSet.getString(3));
                verb.setInfinitive(resultSet.getString(4));
                verb.setParticiple(resultSet.getString(5));
                verb.setGerund(resultSet.getString(6));
                //if(resultSet.getString(7).equals("regular")) {
                if (resultSet.getInt(7) == 1) {
                    verb.setIsRegular(true);
                }
                verb.setConjugation(resultSet.getInt(8));
                verb.setBroadOrSlender(resultSet.getString(9));
                return true;
            }
            log.debug("verb.getParticiple() = " + verb.getParticiple());
            log.debug("verb.getConjugation() = " + verb.getConjugation());
        } catch (Exception e) {
            log.error(e);
        }
        return false;
    }

    public static void selectAllVerbs(List<Verb> verbList, int languageId, Object connectionPoolObject) throws SQLException, Exception {
        log.debug("selectAllVerbs(verbList, "+languageId +", "+connectionPoolObject+")");
        selectAllVerbs(verbList, languageId, (ConnectionPool) connectionPoolObject);
    }

    public static void selectAllVerbs(List<Verb> verbList, int languageId, ConnectionPool connectionPool) throws SQLException, Exception {
        log.debug("selectAllVerbs(verbList, " + languageId +", "+connectionPool+")");
        selectAllVerbs(verbList, languageId, new ConnectionManager(connectionPool));
    }

    public static void selectAllVerbs(List<Verb> verbList, int languageId, ConnectionManager connectionManager) throws SQLException, Exception {
        log.debug("selectAllVerbs(verbList, '" + languageId +"', " + connectionManager + ")");
        String statementName = "selectAllVerbs";
        String sql = new StringBuilder()
            .append("SELECT verb, regular, conjugation, broad_slender")
            .append(" FROM verb")
            .append(" WHERE language_id = ?")
            .toString();
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        try {
            //preparedStatement = connectionManager.loadStatement(statementName);
            preparedStatement = connectionManager.prepareStatement(sql);
            preparedStatement.setInt(1, languageId);
            log.debug("preparedStatement.setString(1, "+languageId+");");
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Verb verb = null;
                do {
                    verb = new Verb();
                    verb.setVerb(resultSet.getString(1));
                    if(resultSet.getString(2).equals("regular")) {
                        verb.setIsRegular(true);
                    }
                    verb.setConjugation(resultSet.getInt(3));
                    verb.setBroadOrSlender(resultSet.getString(4));
                    verbList.add(verb);
                } while(resultSet.next());
            }
        } catch (Exception e) {
            e.printStackTrace(System.err);
            //log.logMessage(e, statementName, LogUtil.SEVERE);
        } finally {
            // Free resources allocated.
            connectionManager.commit();
        }
    }

    //public static void selectAllVerbs(List<Verb> verbList, String languageId, Object connectionPoolObject) throws SQLException, Exception {
    //    log.trace("selectAllVerbs(verbList, " + languageId + ", " + connectionPoolObject + ")");
    //    String languageCode = "english";
    //    selectAllVerbs(verbList, languageCode, (ConnectionPool) connectionPoolObject);
    //}

    public static int selectVerbCount(int languageId, Object connectionPoolObject) throws SQLException, Exception {
        log.trace("selectVerbCount(" + languageId + ", " + connectionPoolObject + ")");
        return selectVerbCount(languageId, (ConnectionPool) connectionPoolObject);
    }

    public static int selectVerbCount(int languageId, ConnectionPool connectionPool) throws SQLException, Exception {
        log.trace("selectVerbCount(" + languageId + ", " + connectionPool + ")");
        return selectVerbCount(languageId, new ConnectionManager(connectionPool));
    }

    public static int selectVerbCount(int languageId, ConnectionManager connectionManager) throws SQLException, Exception {
        String sql = new StringBuilder()
            .append("SELECT count(verb)")
            .append(" FROM verb")
            .append(" WHERE language_id = ?")
            .toString();
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connectionManager.prepareStatement(sql);
            preparedStatement.setInt(1, languageId);
            log.debug("preparedStatement.setInt(1, "+languageId+");");
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace(System.err);
            //log.logMessage(e, statementName, LogUtil.SEVERE);
        } finally {
            // Free resources allocated.
            connectionManager.commit();
        }
        return -1;
    }


    public static void selectAllVerbs(List<Verb> verbList, String languageId, Object connectionPoolObject) throws SQLException, Exception {
        log.trace("selectAllVerbs(verbList, " + languageId + ", " + connectionPoolObject + ")");
        selectAllVerbs(verbList, languageId, (ConnectionPool) connectionPoolObject);
    }

    public static void selectAllVerbs(List<Verb> verbList, String languageId, ConnectionPool connectionPool) throws SQLException, Exception {
        log.trace("selectAllVerbs(verbList, " + languageId + ", " + connectionPool + ")");
        selectAllVerbs(verbList, languageId, new ConnectionManager(connectionPool));
    }

    public static void selectAllVerbs(List<Verb> verbList, String languageId, ConnectionManager connectionManager) throws SQLException, Exception {
    //public static void selectAllVerbs(List<Verb> verbList, String languageId, ConnectionManager connectionManager) {
        log.debug("selectAllVerbs(verbList, '" + languageId +"', " + connectionManager + ")");
        String statementName = "selectAllVerbs";
        String sql = new StringBuilder()
            .append("SELECT verb, regular, conjugation, broad_slender")
            .append(" FROM verb")
            .append(" WHERE language_id = ?")
            .toString();
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        try {
            //preparedStatement = connectionManager.loadStatement(statementName);
            preparedStatement = connectionManager.prepareStatement(sql);
            preparedStatement.setString(1, languageId);
            log.debug("preparedStatement.setString(1, "+languageId+");");
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Verb verb = new Verb();
                do {
                    verb.setVerb(resultSet.getString(1));
                    if(resultSet.getString(2).equals("regular")) {
                        verb.setIsRegular(true);
                    }
                    verb.setConjugation(resultSet.getInt(3));
                    verb.setBroadOrSlender(resultSet.getString(4));
                    verbList.add(verb);
                } while(resultSet.next());
            }
        } catch (Exception e) {
            e.printStackTrace(System.err);
            //log.logMessage(e, statementName, LogUtil.SEVERE);
        } finally {
            // Free resources allocated.
            connectionManager.commit();
        }
    }

    public static void selectVerbMapByEnglishVerb(List<String> verbList, String englishVerb, ConnectionManager connectionManager) throws java.sql.SQLException, Exception {
        log.debug("selectVerbMapByEnglishVerb(verbList, '" + englishVerb + "', connectionManager)");
        PreparedStatement preparedStatement = connectionManager.loadStatement("selectVerbMapByEnglishVerb");
        preparedStatement.setString(1, englishVerb);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) verbList.add(resultSet.getString(1));
    }

    public static void selectVerbMapByIrishVerb(List<String> verbList, String irishVerb, ConnectionManager connectionManager) throws java.sql.SQLException, Exception {
        log.debug("selectVerbMapByIrishVerb(verbList, '" + irishVerb + "', connectionManager)");
        PreparedStatement preparedStatement = connectionManager.loadStatement("selectVerbMapByIrishVerb");
        preparedStatement.setString(1, irishVerb);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) verbList.add(resultSet.getString(1));
    }

    // SELECT vm.english,description,stem,verbal_noun,verbal_adjective,infinitive,participle,gerund,regular,conjugation,broad_slender FROM verb_map vm,verb v WHERE vm.irish=? AND vm.english=v.verb
    public static void selectMappedVerbsByVerb(List<Verb> verbList, Verb verb, ConnectionManager connectionManager) throws java.sql.SQLException, Exception {
        log.debug("selectMappedVerbsByVerb(verbList, '" + verb + "', connectionManager)");
        String statementName = null;
        //if(verb.getLanguageId().equals("irish")) {
        if (verb.getFromLanguageId() == 1) {
            statementName = "selectIrishVerbsByEnglishVerb";
        } else {
            statementName = "selectEnglishVerbsByIrishVerb";
        }
        try {
            PreparedStatement preparedStatement = connectionManager.loadStatement(statementName);
            //preparedStatement.setInt(1, verb.getLanguageId());
            preparedStatement.setString(1, verb.getVerb());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Verb mappedVerb = new Verb();
                mappedVerb.setVerb(resultSet.getString(1));
                mappedVerb.setDescription(resultSet.getString(2));
                mappedVerb.setStem(resultSet.getString(3));
                mappedVerb.setVerbalNoun(resultSet.getString(4));
                mappedVerb.setVerbalAdjective(resultSet.getString(5));
                mappedVerb.setInfinitive(resultSet.getString(6));
                mappedVerb.setParticiple(resultSet.getString(7));
                mappedVerb.setGerund(resultSet.getString(8));
                //if(resultSet.getString(9).equals("regular")) {
                if(resultSet.getInt(9) == 1) {
                    mappedVerb.setIsRegular(true);
                }
                mappedVerb.setConjugation(resultSet.getInt(10));
                mappedVerb.setBroadOrSlender(resultSet.getString(11));
                List<Integer> tenseIdArray = new ArrayList<Integer>();
                selectTenseIds(tenseIdArray, connectionManager);
                Map<String, VerbConjugation> verbConjugationMap = new HashMap<String, VerbConjugation>();
                for (int j = 0; j < tenseIdArray.size(); j++) {
                    int tenseId = tenseIdArray.get(j);
                    //VerbConjugation verbConjugation = new VerbConjugation(mappedVerb.getVerb(), tenseId);
                    VerbConjugation verbConjugation = new VerbConjugation(mappedVerb.getVerb(), tenseId, verb.getToLanguageId());
                    //selectVerbConjugationByTenseIdAndVerb(verbConjugation, connectionManager);
                    selectVerbConjugationByTenseIdAndVerb(verbConjugation, verb.getToLanguageId(), connectionManager);
                    verbConjugationMap.put(String.valueOf(tenseId), verbConjugation);
                }
                //log.debug("tenseIdArray.size() :"+tenseIdArray.size());
                mappedVerb.setVerbConjugationMap(verbConjugationMap);
                verbList.add(mappedVerb);
            }
        } catch (Exception e) {
            log.error(e);
        }
    }
}
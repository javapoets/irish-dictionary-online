package online.irishdictionary.database;

import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

//import com.javapoets.db.ConnectionManager;
import com.ispaces.dbcp.ConnectionManager;
import com.ispaces.dbcp.ConnectionPool;

import online.irishdictionary.model.Verb;
import online.irishdictionary.model.VerbConjugation;

public class VerbDatabaseManager {

    private static final String className = VerbDatabaseManager.class.getName();
    private static final Logger logger = LogManager.getLogger();

    public static void selectVerb(Verb verb, Object connectionPoolObject) throws SQLException, Exception {
        logger.debug("selectVerb("+connectionPoolObject+")");

        selectVerb(verb, (ConnectionPool) connectionPoolObject);
    }

    public static void selectVerb(Verb verb, ConnectionPool connectionPool) throws SQLException, Exception {
        logger.debug("selectVerb("+connectionPool+")");

        selectVerb(verb, new ConnectionManager(connectionPool));
    }

    public static void selectVerb(Verb verb, ConnectionManager connectionManager) throws SQLException, Exception {
        logger.debug("selectVerb('"+verb.getVerb()+"', "+connectionManager+")");

        try {

            PreparedStatement preparedStatement = connectionManager.loadStatement("selectVerb");
            ResultSet resultSet = preparedStatement.executeQuery();

            selectVerbOnly(verb, connectionManager);

            List<Integer> tenseIdArray = new ArrayList<Integer>();
            selectTenseIds(tenseIdArray, connectionManager);
            Map verbConjugationMap = new HashMap();

            for(int i = 0; i < tenseIdArray.size(); i++) {
                int tenseId = tenseIdArray.get(i);
                VerbConjugation verbConjugation = new VerbConjugation(verb.getVerb(), tenseId);
                selectVerbConjugationByTenseIdAndVerb(verbConjugation, connectionManager);
                verbConjugationMap.put(String.valueOf(tenseId), verbConjugation);
            }
            verb.setVerbConjugationMap(verbConjugationMap);

            List verbList = new ArrayList();
            selectMappedVerbsByVerb(verbList, verb, connectionManager);
            verb.setVerbList(verbList);
            //verb.setVerbList(verbList);

        } catch(Exception e) {
            logger.error(e);
        } finally {
            // Free resources allocated.
            connectionManager.commit();
        }
    }

    public static void selectTenseIds(List<Integer> tenseIdArray, ConnectionManager connectionManager) throws java.sql.SQLException, Exception {
        logger.debug("selectTenseIds(tenseIdArray, connectionManager)");

        String statementName = "selectTenseIds";
        ResultSet rset = null;
        PreparedStatement stmt = null;
        // Load up the correct SQL statement
        stmt = connectionManager.loadStatement(statementName);
        rset = stmt.executeQuery();
        while(rset.next()) {
            //logger.debug("tenseIdArray.add("+rset.getInt(1)+")");
            tenseIdArray.add(rset.getInt(1));
        }
    }

    public static void selectVerbConjugationByTenseIdAndVerb(VerbConjugation verbConjugation, ConnectionManager connectionManager) throws java.sql.SQLException, Exception {
        logger.debug("selectVerbConjugationByTenseIdAndVerb(verbConjugation, connectionManager)");

        PreparedStatement stmt = connectionManager.loadStatement("selectVerbConjugationByTenseIdAndVerb");
        stmt.setInt(1, verbConjugation.getTenseId());
        stmt.setString(2, verbConjugation.getVerb());

        ResultSet rset = stmt.executeQuery();
        while(rset.next()) {
            verbConjugation.setVerbConjugationId(rset.getInt(1));
            verbConjugation.setMe(rset.getString(2));
            verbConjugation.setYouSing(rset.getString(3));
            verbConjugation.setHe(rset.getString(4));
            verbConjugation.setShe(rset.getString(5));
            verbConjugation.setWe(rset.getString(6));
            verbConjugation.setYouPlur(rset.getString(7));
            verbConjugation.setThey(rset.getString(8));
            verbConjugation.setAut(rset.getString(9));
            verbConjugation.setNeg(rset.getString(10));
            verbConjugation.setQuestion(rset.getString(11));
            verbConjugation.setTenseIrish(rset.getString(12));
            verbConjugation.setTenseEnglish(rset.getString(13));
            //verbConjugationMap.put("verbIrishConditionalBean", verbConjugation);
        }
    }

    // SELECT stem,verbal_noun,verbal_adjective,infinitive,participle,gerund,regular,conjugation,broad_slender FROM verb WHERE language_id=? AND verb=?
    public static void selectVerbOnly(Verb verb, ConnectionManager connectionManager) throws java.sql.SQLException, Exception {
        logger.debug("selectVerbOnly("+verb.getVerb()+", connectionManager)");

        //logger.debug("verb.getLanguageId() = "+verb.getLanguageId());
        //logger.debug("verb.getVerb() = "+verb.getVerb());

        try {


            String statementName = "selectVerb";
            PreparedStatement stmt = connectionManager.loadStatement(statementName);
            stmt.setInt(1, verb.getLanguageId());
            stmt.setString(2, verb.getVerb());

            ResultSet rset = stmt.executeQuery();
            while(rset.next()) {
                verb.setStem(rset.getString(1));
                verb.setVerbalNoun(rset.getString(2));
                verb.setVerbalAdjective(rset.getString(3));
                verb.setInfinitive(rset.getString(4));
                verb.setParticiple(rset.getString(5));
                verb.setGerund(rset.getString(6));
                //if(rset.getString(7).equals("regular")) {
                if(rset.getInt(7) == 1) {
                    verb.setIsRegular(true);
                }
                verb.setConjugation(rset.getInt(8));
                verb.setBroadOrSlender(rset.getString(9));
            }

            //logger.debug("verb.getParticiple() ="+verb.getParticiple());
            //logger.debug("verb.getConjugation() ="+verb.getConjugation());

        } catch(Exception e) {
            logger.error(e);
        }

    }

    public static void selectAllVerbs(List verbList, String languageId) {
        logger.debug("selectAllVerbs(verbList, languageId)");

        try {

            String statementName = "selectAllVerbs";
            ConnectionManager connectionManager = new ConnectionManager(className, statementName);

            ResultSet rset = null;
            PreparedStatement stmt = null;

            try {

                stmt = connectionManager.loadStatement(statementName);
                stmt.setString(1, languageId);
                logger.debug("stmt.setString(1, "+languageId+");");
                rset = stmt.executeQuery();
                while(rset.next()){
                    Verb verb = new Verb();
                    verb.setVerb(rset.getString(1));
                    if(rset.getString(2).equals("regular")) {
                        verb.setIsRegular(true);
                    }
                    verb.setConjugation(rset.getInt(3));
                    verb.setBroadOrSlender(rset.getString(4));
                    verbList.add(verb);
                }

            } catch(Exception e) {
                e.printStackTrace(System.err);
                //logger.logMessage(e, statementName, LogUtil.SEVERE);
            } finally {
                // Free resources allocated.
                connectionManager.commit();
            }

        } catch(Exception e) {
            e.printStackTrace(System.err);
        }
    }

    public static void selectVerbMapByEnglishVerb(List verbList, String englishVerb, ConnectionManager connectionManager) throws java.sql.SQLException, Exception {
        logger.debug("selectVerbMapByEnglishVerb(verbList, '"+englishVerb+"', connectionManager)");

        PreparedStatement stmt = connectionManager.loadStatement("selectVerbMapByEnglishVerb");
        stmt.setString(1, englishVerb);
        ResultSet rset = stmt.executeQuery();
        while(rset.next()) verbList.add(rset.getString(1));
    }

    public static void selectVerbMapByIrishVerb(List verbList, String irishVerb, ConnectionManager connectionManager) throws java.sql.SQLException, Exception {
        logger.debug("selectVerbMapByIrishVerb(verbList, '"+irishVerb+"', connectionManager)");

        PreparedStatement stmt = connectionManager.loadStatement("selectVerbMapByIrishVerb");
        stmt.setString(1, irishVerb);
        ResultSet rset = stmt.executeQuery();
        while(rset.next()) verbList.add(rset.getString(1));
    }

    // SELECT vm.english,description,stem,verbal_noun,verbal_adjective,infinitive,participle,gerund,regular,conjugation,broad_slender FROM verb_map vm,verb v WHERE vm.irish=? AND vm.english=v.verb
    public static void selectMappedVerbsByVerb(List verbList, Verb verb, ConnectionManager connectionManager) throws java.sql.SQLException, Exception {
        logger.debug("selectMappedVerbsByVerb(verbList, '"+verb+"', connectionManager)");

        String statementName = null;
        //if(verb.getLanguageId().equals("irish")) {
        if(verb.getLanguageId() == 1) {
            statementName = "selectIrishVerbsByEnglishVerb";
        } else {
            statementName = "selectEnglishVerbsByIrishVerb";
        }

        try {

            PreparedStatement stmt = connectionManager.loadStatement(statementName);
            //stmt.setInt(1, verb.getLanguageId());
            stmt.setString(1, verb.getVerb());

            ResultSet rset = stmt.executeQuery();
            while(rset.next()) {
                Verb mappedVerb = new Verb();
                mappedVerb.setVerb(rset.getString(1));
                mappedVerb.setDescription(rset.getString(2));
                mappedVerb.setStem(rset.getString(3));
                mappedVerb.setVerbalNoun(rset.getString(4));
                mappedVerb.setVerbalAdjective(rset.getString(5));
                mappedVerb.setInfinitive(rset.getString(6));
                mappedVerb.setParticiple(rset.getString(7));
                mappedVerb.setGerund(rset.getString(8));
                //if(rset.getString(9).equals("regular")) {
                if(rset.getInt(9) == 1) {
                    mappedVerb.setIsRegular(true);
                }
                mappedVerb.setConjugation(rset.getInt(10));
                mappedVerb.setBroadOrSlender(rset.getString(11));

                List<Integer> tenseIdArray = new ArrayList<Integer>();
                selectTenseIds(tenseIdArray, connectionManager);
                Map verbConjugationMap = new HashMap();

                for(int j = 0; j < tenseIdArray.size(); j++) {
                    int tenseId = tenseIdArray.get(j);
                    VerbConjugation verbConjugation = new VerbConjugation(mappedVerb.getVerb(), tenseId);
                    selectVerbConjugationByTenseIdAndVerb(verbConjugation, connectionManager);
                    verbConjugationMap.put(String.valueOf(tenseId), verbConjugation);
                }
                //logger.debug("tenseIdArray.size() :"+tenseIdArray.size());

                mappedVerb.setVerbConjugationMap(verbConjugationMap);
                verbList.add(mappedVerb);
            }

        } catch(Exception e) {
            logger.error(e);
        }
    }

}

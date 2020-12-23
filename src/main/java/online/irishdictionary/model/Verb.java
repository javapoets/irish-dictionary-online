package online.irishdictionary.model;

import java.util.List;
import java.util.Map;

public class Verb {

    private static final org.apache.logging.log4j.Logger log = org.apache.logging.log4j.LogManager.getLogger();
    private int id = -1;
    private String verb = null;
    private String description = null;
    private String stem = null;
    private String verbalNoun = null;
    private String verbalAdjective = null;
    private String infinitive = null;
    private String participle = null;
    private String gerund = null;
    private boolean isRegular = false;
    private int conjugation = -1;
    private int fromLanguageId = -1;
    private int toLanguageId = -1;
    private String language = null;
    private String broadOrSlender = null;
    private Map<String, VerbConjugation> verbConjugationMap;
    private List<Verb> verbList = null;

    public Verb() {}

    public Verb(String verb) {
        this.verb = verb;
    }

    public Verb(String verb, String language) {
        log.trace("('" + verb + "', '" + language + "')");
        this.verb = verb;
        this.language = language;
    }
    
    public Verb(String verb, int fromLanguageId) {
        log.trace("('" + verb + "', " + fromLanguageId + ")");
        this.verb = verb;
        this.fromLanguageId = fromLanguageId;
    }

    public Verb(String verb, int fromLanguageId, int toLanguageId) {
        log.trace("('" + verb + "', fromLanguageId:" + fromLanguageId + ", toLanguageId:" + toLanguageId + ")");
        this.verb = verb;
        this.fromLanguageId = fromLanguageId;
        this.toLanguageId = toLanguageId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFromLanguageId() {
        return this.fromLanguageId;
    }

    public void setFromLanguageId(int fromLanguageId) {
        this.fromLanguageId = fromLanguageId;
    }

    public int getToLanguageId() {
        return this.toLanguageId;
    }

    public void setToLanguageId(int toLanguageId) {
        this.toLanguageId = toLanguageId;
    }

    public String getLanguage() {
        return this.language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getVerb() {
        return this.verb;
    }

    public void setVerb(String verb) {
        this.verb = verb;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStem() {
        return this.stem;
    }

    public void setStem(String stem) {
        this.stem = stem;
    }

    public String getVerbalNoun() {
        return this.verbalNoun;
    }

    public void setVerbalNoun(String verbalNoun) {
        this.verbalNoun = verbalNoun;
    }

    public String getVerbalAdjective() {
        return this.verbalAdjective;
    }

    public void setVerbalAdjective(String verbalAdjective) {
        this.verbalAdjective = verbalAdjective;
    }

    public String getInfinitive() {
        return this.infinitive;
    }

    public void setInfinitive(String infinitive) {
        this.infinitive = infinitive;
    }

    public String getParticiple() {
        return this.participle;
    }
    public void setParticiple(String participle) {
        this.participle = participle;
    }

    public String getGerund() {
        return this.gerund;
    }
    public void setGerund(String gerund) {
        this.gerund = gerund;
    }

    public boolean getIsRegular() {
        return this.isRegular;
    }

    public void setIsRegular(boolean isRegular) {
        this.isRegular = isRegular;
    }

    public int getConjugation() {
        return this.conjugation;
    }

    public void setConjugation(int conjugation) {
        this.conjugation = conjugation;
    }

    public String getBroadOrSlender() {
        return this.broadOrSlender;
    }

    public void setBroadOrSlender(String broadOrSlender) {
        this.broadOrSlender = broadOrSlender;
    }

    public Map<String, VerbConjugation> getVerbConjugationMap() {
        return this.verbConjugationMap;
    }

    public void setVerbConjugationMap(Map<String, VerbConjugation> verbConjugationMap) {
        this.verbConjugationMap = verbConjugationMap;
    }

    public List<Verb> getVerbList() {
        return this.verbList;
    }

    public void setVerbList(List<Verb> verbList) {
        this.verbList = verbList;
    }

    public String toString() {
        //return this.getVerb();
        return new StringBuilder().append("Verb{").append(this.verb).append("}").toString();
    }
}

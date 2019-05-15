package online.irishdictionary.model;

import java.util.List;
import java.util.Map;

public class Verb {

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
    private int languageId = -1;
    private String language = null;
    private String broadOrSlender = null;
    private Map verbConjugationMap;
    private List verbList = null;

    public Verb() {}

    public Verb(String verb) {
        this.verb = verb;
    }

    public Verb(String verb, String language) {
        this.verb = verb;
        this.language = language;
    }
    
    public Verb(String verb, int languageId) {
        this.verb = verb;
        this.languageId = languageId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVerb() {
        return this.verb;}

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

    public int getLanguageId() {
        return this.languageId;
    }

    public void setLanguageId(int languageId) {
        this.languageId = languageId;
    }

    public String getLanguage() {
        return this.language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getBroadOrSlender() {
        return this.broadOrSlender;
    }

    public void setBroadOrSlender(String broadOrSlender) {
        this.broadOrSlender = broadOrSlender;
    }

    public Map  getVerbConjugationMap() {
        return this.verbConjugationMap;
    }

    public void setVerbConjugationMap(Map verbConjugationMap) {
        this.verbConjugationMap = verbConjugationMap;
    }

    public List getVerbList() {
        return this.verbList;
    }

    public void setVerbList(List verbList) {
        this.verbList = verbList;
    }

}

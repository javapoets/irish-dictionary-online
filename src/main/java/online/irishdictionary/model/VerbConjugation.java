package online.irishdictionary.model;

public class VerbConjugation {

    private static final org.apache.logging.log4j.Logger log = org.apache.logging.log4j.LogManager.getLogger();
    private int verbConjugationId = 0;
    private int verbId = 0;
    //private int languageId = 0;
    private int toLanguageId = 0;
    private int fromLanguageId = 0;
    private String verb = null;
    private String me = null;
    private String youSingular = null;
    private String he = null;
    private String she = null;
    private String we = null;
    private String weAlternative = null;
    private String youPlural = null;
    private String they = null;
    private String theyAlternative = null;
    private String autonomous = null;
    private String negative = null;
    private String question = null;
    private int tenseId = 0;
    private String tenseIrish = null;
    private String tenseEnglish = null;

    public VerbConjugation() {
    }

    public VerbConjugation(String verb) {
        this.verb = verb;
    }

    public VerbConjugation(String verb, int tenseId) {
        log.trace("('" + verb + "', tenseId:" + tenseId + ")");
        this.verb = verb;
        this.tenseId = tenseId;
    }

    public VerbConjugation(String verb, int tenseId, int toLanguageId) {
        log.trace("('" + verb + "', tenseId:" + tenseId + ", toLanguageId:" + toLanguageId + ")");
        this.verb = verb;
        this.tenseId = tenseId;
        this.toLanguageId = toLanguageId;
    }

    public VerbConjugation(String verb, int tenseId, int fromLanguageId, int toLanguageId) {
        log.trace("('" + verb + "', tenseId:" + tenseId + ", fromLanguageId:" + fromLanguageId + ", toLanguageId:" + toLanguageId + ")");
        this.verb = verb;
        this.tenseId = tenseId;
        this.fromLanguageId = fromLanguageId;
        this.toLanguageId = toLanguageId;
    }

    public int getVerbConjugationId() {
        return verbConjugationId;
    }

    public int getVerbId() {
        return verbId;
    }

    /*
    public int getLanguageId() {
        return this.languageId;
    }

    public void setLanguageId(int languageId) {
        this.languageId = languageId;
    }    
    */

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

    public String getVerb() {
        return this.verb;
    }

    public String getMe() {
        return this.me;
    }

    public String getYouSingular() {
        return this.youSingular;
    }

    public String getHe() {
        return this.he;
    }

    public String getShe() {
        return this.she;
    }

    public String getWe() {
        return this.we;
    }

    public String getWeAlternative() {
        return this.weAlternative;
    }

    public String getYouPlural() {
        return this.youPlural;
    }

    public String getThey() {
        //return they;
        if (they != null) return they;
        return this.theyAlternative;
    }

    public String getAutonomous() {
        //return (autonomous != null) ? autonomous : "";
        return this.autonomous;
    }

    public String getNegative() {
        //return (negative != null) ? negative : "";
        return this.negative;
    }

    public String getQuestion() {
        //return (question != null) ? question : "";
        return this.question;
    }

    public int getTenseId() {
        return this.tenseId;
    }

    public String getTenseIrish() {
        return this.tenseIrish;
    }

    public String getTenseEnglish() {
        return this.tenseEnglish;
    }

    public void setVerbConjugationId(int verbConjugationId) {
        this.verbConjugationId = verbConjugationId;
    }

    public void setVerbId(int verbId) {
        this.verbId = verbId;
    }

    public void setVerb(String verb) {
        this.verb = verb;
    }

    public void setMe(String me) {
        this.me = me;
    }

    public void setYouSingular(String youSingular) {
        this.youSingular = youSingular;
    }

    public void setHe(String he) {
        this.he = he;
    }

    public void setShe(String she) {
        this.she = she;
    }

    public void setWe(String we) {
        this.we = we;
    }

    public void setWeAlternative(String weAlternative) {
        this.weAlternative = weAlternative;
    }

    public void setYouPlural(String youPlural) {
        this.youPlural = youPlural;
    }

    public void setThey(String they) {
        this.they = they;
    }

    public void setTheyAlternative(String theyAlternative) {
        this.theyAlternative = theyAlternative;
    }

    public void setAutonomous(String autonomous) {
        this.autonomous = autonomous;
    }

    public void setNegative(String negative) {
        this.negative = negative;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setTenseId(int tenseId) {
        this.tenseId = tenseId;
    }

    public void setTenseIrish(String tenseIrish) {
        this.tenseIrish = tenseIrish;
    }

    public void setTenseEnglish(String tenseEnglish) {
        this.tenseEnglish = tenseEnglish;
    }

    public String toString() {
        return new StringBuilder().append(this.getClass().getSimpleName()).append("{").append(this.verb).append("}").toString();
    }
}
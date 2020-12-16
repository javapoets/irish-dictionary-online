package online.irishdictionary.model;

public class VerbConjugation {

    private int verbConjugationId = 0;
    private int verbId = 0;
    private String verb = "";
    private String me = "";
    private String youSingular = "";
    private String he = "";
    private String she = "";
    private String we = "";
    private String youPlural = "";
    private String they = "";
    private String autonomous = "";
    private String negative = "";
    private String question = "";
    private int tenseId = 0;
    private String tenseIrish = "";
    private String tenseEnglish = "";

    public VerbConjugation() {
    }

    public VerbConjugation(String verb) {
        this.verb = verb;
    }

    public VerbConjugation(String verb, int tenseId) {
        this.verb = verb;
        this.tenseId = tenseId;
    }

    public int getVerbConjugationId() {
        return verbConjugationId;
    }

    public int getVerbId() {
        return verbId;
    }

    public String getVerb() {
        return verb;
    }

    public String getMe() {
        return me;
    }

    public String getYouSingular() {
        return youSingular;
    }

    public String getHe() {
        return he;
    }

    public String getShe() {
        return she;
    }

    public String getWe() {
        return we;
    }

    public String getYouPlural() {
        return youPlural;
    }

    public String getThey() {
        return they;
    }

    public String getAutonomous() {
        return (autonomous != null) ? autonomous : "";
    }

    public String getNegative() {
        return (negative != null) ? negative : "";
    }

    public String getQuestion() {
        return (question != null) ? question : "";
    }

    public int getTenseId() {
        return tenseId;
    }

    public String getTenseIrish() {
        return tenseIrish;
    }

    public String getTenseEnglish() {
        return tenseEnglish;
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

    public void setYouPlural(String youPlural) {
        this.youPlural = youPlural;
    }

    public void setThey(String they) {
        this.they = they;
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
}

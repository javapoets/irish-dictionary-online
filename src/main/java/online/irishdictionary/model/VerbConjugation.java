package online.irishdictionary.model;

public class VerbConjugation {

    private int verbConjugationId = 0;
    private int verbId = 0;
    private String verb = "";
    private String me = "";
    private String youSing = "";
    private String he = "";
    private String she = "";
    private String we = "";
    private String youPlur = "";
    private String they = "";
    private String aut = "";
    private String neg = "";
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

    public String getYouSing() {
        return youSing;
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

    public String getYouPlur() {
        return youPlur;
    }

    public String getThey() {
        return they;
    }

    public String getAut() {
        return (aut != null) ? aut : "";
    }

    public String getNeg() {
        return (neg != null) ? neg : "";
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

    public void setYouSing(String youSing) {
        this.youSing = youSing;
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

    public void setYouPlur(String youPlur) {
        this.youPlur = youPlur;
    }

    public void setThey(String they) {
        this.they = they;
    }

    public void setAut(String aut) {
        this.aut = aut;
    }

    public void setNeg(String neg) {
        this.neg = neg;
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

package online.irishdictionary.model;

public class Usage {

    private int usageId = -1;
    private String word = "";
    private String usage = "";
    private String type = "";           // n, adj, adv, vi, vt, npl
    private String description = "";
    private String gender = "";         // m1. m2, m3, m4, f1, f2, f3, f4, mpl1, fpl2
    private String usageTranslated = "";
    private int prevUsageId = -1;

    public Usage() {}

    public Usage(int usageId) {
        this.usageId = usageId;
    }

    public Usage(String word) {
        this.word = word;
    }

    public void setUsageId(int usageId) {
        this.usageId = usageId;
    }

    public int getUsageId() {
        return this.usageId;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getWord() {
        if ( word != null ) {
            return word;
        } else {
            return "";
        }
    }

    public void setUsage(String usage) {
        this.usage = usage;
    }

    public String getUsage() {
        if ( usage != null ) {
            return usage;
        } else {
            return "";
        }
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        if ( type != null ) {
            return type;
        } else {
            return "";
        }
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription(){
        if ( description != null ) {
            return description;
        } else {
            return "";
        }
    }

    public void setGender(String gender){
        this.gender = gender;
    }

    public String getGender(){
        if ( gender != null ) {
            return gender;
        } else {
            return "";
        }
    }

    public void setUsageTranslated(String usageTranslated){
        this.usageTranslated = usageTranslated;
    }

    public String getUsageTranslated(){
        if ( usageTranslated != null ) {
            return usageTranslated;
        } else {
            return "";
        }
    }

    public int getUsageLength(){
        return usage.length();
    }

    public int getUsageTranslatedLength(){
        return usageTranslated.length();
    }

    public void setPrevUsageId(int prevUsageId){
        this.prevUsageId = prevUsageId;
    }

    public int getPrevUsageId(){
        return prevUsageId;
    }

}

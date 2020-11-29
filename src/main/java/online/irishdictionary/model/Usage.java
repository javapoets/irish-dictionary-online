package online.irishdictionary.model;

public class Usage {

    private static final String EMPTY = "";
    private int usageId = -1;
    private String word = null;
    private String usage = null;
    private String type = null;           // n, adj, adv, vi, vt, npl
    private String description = null;
    private String plusSuffix = null;     // E.g. + genitive, + noun
    private String gender = null;         // m1. m2, m3, m4, f1, f2, f3, f4, mpl1, fpl2
    private String usageTranslated = null;
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
        if (word != null) {
            return word;
        } else {
            return EMPTY;
        }
    }

    public void setUsage(String usage) {
        this.usage = usage;
    }

    public String getUsage() {
        if (usage != null) {
            return usage;
        } else {
            return EMPTY;
        }
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        if (type != null) {
            return type;
        } else {
            return EMPTY;
        }
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        if (description != null) {
            return description;
        } else {
            return EMPTY;
        }
    }

    public void setPlusSuffix(String plusSuffix) {
        this.plusSuffix = plusSuffix;
    }

    public String getPlusSuffix() {
        if (plusSuffix != null) {
            return plusSuffix;
        } else {
            return EMPTY;
        }
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        if (gender != null) {
            return gender;
        } else {
            return EMPTY;
        }
    }

    public void setUsageTranslated(String usageTranslated) {
        this.usageTranslated = usageTranslated;
    }

    public String getUsageTranslated() {
        if (usageTranslated != null) {
            return usageTranslated;
        } else {
            return EMPTY;
        }
    }

    public int getUsageLength() {
        return usage.length();
    }

    public int getUsageTranslatedLength() {
        return usageTranslated.length();
    }

    public void setPrevUsageId(int prevUsageId) {
        this.prevUsageId = prevUsageId;
    }

    public int getPrevUsageId() {
        return prevUsageId;
    }
}

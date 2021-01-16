package online.irishdictionary.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import online.irishdictionary.util.Text;

public class WordType {

    private static final org.apache.logging.log4j.Logger log = org.apache.logging.log4j.LogManager.getLogger();
    private String EMPTY = "";
    private String COMMA = ",";
    private int id = -1;
    private String word = null;
    private String description = null;
    private String type = null;           // n, adj, adv, vi, vt, npl
    private String gender = null;         // m1. m2, m3, m4, f1, f2, f3, f4, mpl1, fpl2
    private String declension = null;         // 1st, 2nd, 3rd, 4th

    private HashMap<String, String> partsOfSpeech = new HashMap<String, String>() {
        {
            put("n", "noun");
            put("v", "verb");
            put("vt", "transitive verb");
            put("vi", "intransitive verb");
            put("vt, vi", "transitive and intransitive verb");
            put("adj", "adjective");
            put("adv", "adverb");
            put("num", "number");
            put("conj", "conjunction");
            put("pron", "pronoun");
        }
    };

    private HashMap<String, String> genderMap = new HashMap<String, String>() {
        {
            put("m", "masculine noun");
            put("m1", "masculine noun, 1st declension");
            put("m2", "masculine noun, 2nd declension");
            put("m3", "masculine noun, 3rd declension");
            put("m4", "masculine noun, 4th declension");
            put("f", "feminine noun");
            put("f1", "feminine noun, 1st declension");
            put("f2", "feminine noun, 2nd declension");
            put("f3", "feminine noun, 3rd declension");
            put("f4", "feminine noun, 4th declension");
        }
    };

    private Set<String> genderSet = new HashSet<String>() {
        {
            add("m");
            add("m1");
            add("m2");
            add("m3");
            add("m4");
            add("f");
            add("f1");
            add("f2");
            add("f3");
            add("f4");
        }
    };

    public WordType() {}

    public WordType(String type, String gender) {
        this.type = type;
        this.gender = gender;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    public void setDeclension(String declension) {
        this.declension = declension;
    }

    public String getDeclension() {
        return declension;
    }

    public String toString() {
        return new StringBuilder().append("WordType{").append(this.type).append(":").append(this.gender).append("}").toString();
    }

}
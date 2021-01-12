package online.irishdictionary.model;

import java.util.List;
import online.irishdictionary.util.Text;

public class Word {

    private String EMPTY = "";
    private int id = -1;
    private String word = null;
    private String wordDescription = null;
    private String description = null;
    private String type = null;           // n, adj, adv, vi, vt, npl
    private String gender = null;         // m1. m2, m3, m4, f1, f2, f3, f4, mpl1, fpl2
    private String declension = null;         // 1st, 2nd, 3rd, 4th
    private String genitiveSingular = null;
    private String genitivePlural = null;
    private String nominativeSingular = null;
    private String nominativePlural = null;
    private List definitionList = null;
    private List usageList = null;
    private int startUsageIndex = 0;
    private int endUsageIndex = 40;

    public Word() {}

    public Word(String word) {
        this.word = word;
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
        //if (word != null) {
            return word;
        //} else {
        //    return EMPTY;
        //}
    }

    public void setWordDescription(String wordDescription) {
        this.wordDescription = wordDescription;
    }

    public String getWordDescription() {
        return wordDescription;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        //if (description != null) {
            return description;
        //} else {
        //    return EMPTY;
        //}
    }

    public void setGenitiveSingular(String genitiveSingular) {
        this.genitiveSingular = genitiveSingular;
    }

    public String getGenitiveSingular() {
        return this.genitiveSingular;
    }

    public void setGenitivePlural(String genitivePlural) {
        this.genitivePlural = genitivePlural;
    }

    public String getGenitivePlural() {
        return this.genitivePlural;
    }

    public void setNominativeSingular(String nominativeSingular) {
        this.nominativeSingular = nominativeSingular;
    }

    public String getNominativeSingular() {
        return this.nominativeSingular;
    }

    public void setNominativePlural(String nominativePlural) {
        this.nominativePlural = nominativePlural;
    }

    public String getNominativePlural() {
        return this.genitivePlural;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        //if (type != null) {
            return type;
        //} else {
        //    return EMPTY;
        //}
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        //if (gender != null) {
            return gender;
        //} else {
        //    return EMPTY;
        //}
    }

    public void setDeclension(String declension) {
        this.declension = declension;
    }

    public String getDeclension() {
        return declension;
    }

    public void setDefinitionList(List definitionList) {
        this.definitionList = definitionList;
    }

    public List getDefinitionList() {
        return this.definitionList;
    }

    public void setUsageList(List usageList) {
        this.usageList = usageList;
    }

    public List getUsageList() {
        return this.usageList;
    }

    public void setStartUsageIndex(int startUsageIndex) {
        this.startUsageIndex = startUsageIndex;
    }

    public int getStartUsageIndex() {
        return startUsageIndex;
    }

    public void setEndUsageIndex(int endUsageIndex) {
        this.endUsageIndex = endUsageIndex;
    }

    public int getEndUsageIndex() {
        return endUsageIndex;
    }

    public String getTextNoFadas(String text) {
        text = Text.replaceCharactersInString(text, 'á', "a");
        text = Text.replaceCharactersInString(text, 'é', "e");
        text = Text.replaceCharactersInString(text, 'í', "i");
        text = Text.replaceCharactersInString(text, 'ó', "o");
        text = Text.replaceCharactersInString(text, 'ú', "u");
        text = Text.replaceCharactersInString(text, 'Á', "A");
        text = Text.replaceCharactersInString(text, 'É', "E");
        text = Text.replaceCharactersInString(text, 'Í', "I");
        text = Text.replaceCharactersInString(text, 'Ó', "O");
        text = Text.replaceCharactersInString(text, 'Ú', "U");
        return text;
    }

    public String getWordWildCarded() {
        if (word != null) {
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < word.length(); i++) {
                sb.append("%");
                sb.append(word.charAt(i));
            }
            return sb.toString();
        } else {
            return EMPTY;
        }
    }

    public String getWordWildCardedNoH(){
        if (word != null) {
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < word.length(); i++) {
                sb.append("%");
                if (word.charAt(i) != 'h') {
                    sb.append(word.charAt(i));
                }
            }
            return sb.toString();
        } else {
            return EMPTY;
        }
    }

    public String getWordWildCardedEverSecondLetter(){
        if (word != null) {
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < word.length(); i++) {
                sb.append("%");
                if ((i % 2) == 0) {
                    sb.append(word.charAt(i));
                }
            }
            return sb.toString();
        } else {
            return EMPTY;
        }
    }

    public String getWordWildCardedEverSecondLetter2(){
        if (word != null) {
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < word.length(); i++) {
                sb.append("%");
                if ((i % 2) == 1) {
                    sb.append(word.charAt(i));
                }
            }
            return sb.toString();
        } else {
            return EMPTY;
        }
    }

    public String getWhereWordLikeSQL() {
        /*
        if (this.word.length() == 1) {
        } else if (this.word.length() == 2) {
        } else if (this.word.length() == 3) {
        } else if (this.word.length() == 4) {
        } else if (this.word.length() == 5) {
        } else if (this.word.length() >= 6) {
        }
        */
        StringBuilder stringBuilder = new StringBuilder()
            .append("where word like '").append(getWordWildCarded()).append("' ")
            .append("or word like '").append(getWordWildCardedNoH()).append("' ")
            .append("or word like '").append(getWordWildCardedEverSecondLetter()).append("' ");
            //sb.append("or word like '").append(getWordWildCardedEverSecondLetter2()).append("'");
        return stringBuilder.toString();
    }

    public boolean resultsFound() {
        return ((definitionList != null) && definitionList.size() != 0) && ((usageList != null) && (usageList.size() > 0));
    }

    public String toString() {
        return this.getWord();
    }
}
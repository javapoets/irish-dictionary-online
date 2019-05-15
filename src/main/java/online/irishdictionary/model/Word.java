package online.irishdictionary.model;

import java.util.List;

import online.irishdictionary.util.Text;

public class Word {

    private String word = null;
    private List definitionList = null;
    private List usageList = null;
    private int startUsageIndex = 0;
    private int endUsageIndex = 40;

    public Word() {}

    public Word(String word) {
        this.word = word;
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

    public void setStartUsageIndex(int startUsageIndex){
        this.startUsageIndex = startUsageIndex;
    }

    public int getStartUsageIndex(){
        return startUsageIndex;
    }

    public void setEndUsageIndex(int endUsageIndex){
        this.endUsageIndex = endUsageIndex;
    }

    public int getEndUsageIndex(){
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

    public String getWordWildCarded(){
        if ( word != null ) {
            StringBuffer sb = new StringBuffer();
            for(int i=0; i < word.length(); i++){
                sb.append("%");
                sb.append(word.charAt(i));
            }
            return sb.toString();
        } else {
            return "";
        }
    }

    public String getWordWildCardedNoH(){
        if ( word != null ) {
            StringBuffer sb = new StringBuffer();
            for(int i=0; i < word.length(); i++){
                sb.append("%");
                if(word.charAt(i) != 'h') {
                    sb.append(word.charAt(i));
                }
            }
            return sb.toString();
        } else {
            return "";
        }
    }

    public String getWordWildCardedEverSecondLetter(){
        if ( word != null ) {
            StringBuffer sb = new StringBuffer();
            for(int i=0; i < word.length(); i++){
                sb.append("%");
                if((i % 2) == 0) {
                    sb.append(word.charAt(i));
                }
            }
            return sb.toString();
        } else {
            return "";
        }
    }

    public String getWordWildCardedEverSecondLetter2(){
        if ( word != null ) {
            StringBuffer sb = new StringBuffer();
            for(int i=0; i < word.length(); i++){
                sb.append("%");
                if((i % 2) == 1) {
                    sb.append(word.charAt(i));
                }
            }
            return sb.toString();
        } else {
            return "";
        }
    }

    public String getWhereWordLikeSQL(){

        if(this.word.length() == 1) {
        } else if(this.word.length() == 2) {
        } else if(this.word.length() == 3) {
        } else if(this.word.length() == 4) {
        } else if(this.word.length() == 5) {
        } else if(this.word.length() >= 6) {
        }

        StringBuffer sb = new StringBuffer();
        sb.append("where word like '");
        sb.append(getWordWildCarded());
        sb.append("' ");
        sb.append("or word like '");
        sb.append(getWordWildCardedNoH());
        sb.append("' ");
        sb.append("or word like '");
        sb.append(getWordWildCardedEverSecondLetter());
        sb.append("' ");
        //sb.append("or word like '");
        //sb.append(getWordWildCardedEverSecondLetter2());
        //sb.append("'");
        return sb.toString();
    }

    public boolean resultsFound() {
        return ((definitionList != null) && definitionList.size() != 0) && ((usageList != null) && (usageList.size() > 0));
    }

}
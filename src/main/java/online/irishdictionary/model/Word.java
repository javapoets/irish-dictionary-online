package online.irishdictionary.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import online.irishdictionary.util.Text;

public class Word {

    private static final org.apache.logging.log4j.Logger log = org.apache.logging.log4j.LogManager.getLogger();
    private String EMPTY = "";
    private String COMMA = ",";
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
    private List<Definition> definitionList = null;
    private List<Usage> usageList = null;
    private int startUsageIndex = 0;
    private int endUsageIndex = 40;

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

    public void setDefinitionList(List<Definition> definitionList) {
        this.definitionList = definitionList;
    }

    public List<Definition> getDefinitionList() {
        return this.definitionList;
    }

    public void setUsageList(List<Usage> usageList) {
        this.usageList = usageList;
    }

    public List<Usage> getUsageList() {
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

    public Map<String, List<Definition>> createDefinitionMap() {
        log.trace("createDefinitionMap()");
        Map<String, List<Definition>> definitionMap = new HashMap<String, List<Definition>>();
        if (definitionList != null && definitionList.size() != 0) {
            log.debug("definitionList.size() = " + definitionList.size());

            Definition definition = null;
            String type, gender, description;
            java.util.Set<String> typeSet = new java.util.HashSet();
            StringBuilder typeBuilder = new StringBuilder();
            for (int i = 0; i < definitionList.size(); i++) {
                definition = (Definition) definitionList.get(i);
                log.debug("definition.getType() = " + definition.getType());
                log.debug("definition.getGender() = " + definition.getGender());
                //log.debug("definition.getDescription() = " + definition.getDescription());
                type = definition.getType();
                gender = definition.getGender();
                description = definition.getDescription();
                boolean hasType = type != null && !type.equals("");
                boolean hasGender = gender != null && !gender.equals("");
                //boolean hasDescription = description != null && !description.equals("");

                if (hasType || hasGender) {
                    if (type != null) {
                        int indexOfComma = type.indexOf(COMMA);
                        log.debug("indexOfComma = " + indexOfComma);
                        if (indexOfComma != -1) {
                            String[] types = type.split(COMMA);
                            log.debug("types = " + types);
                            log.debug("types.length = " + types.length);
                            for (int j = 0; j < types.length; j++) {
                                if (!typeSet.contains(types[j])) {
                                    log.debug("typeSet.add("+types[j]+")");
                                    typeSet.add(types[j]);
                                    log.debug("typeSet.size() = " + typeSet.size());
                                }
                            }
                        } else {
                            if (!typeSet.contains(type)) {
                                log.debug("typeSet.add("+type+")");
                                typeSet.add(type);
                                log.debug("typeSet.size() = " + typeSet.size());
                            }
                        }
                    }
                }
                    /*
                    typeBuilder = new StringBuilder();
                    if (hasGender) {
                        String genderExpanded = genderMap.get(gender);
                        if (genderExpanded != null) {
                            typeBuilder.append(genderExpanded);
                        } else {    
                            typeBuilder.append(gender);
                        } 
                    } else if (hasType) {
                        String partOfSpeech = partsOfSpeech.get(type);
                        if (partOfSpeech != null) {
                            typeBuilder.append(partOfSpeech);
                        } else {    
                            typeBuilder.append(type);
                        } 
                    }
                    */
                    //if (!typeSet.contains(typeBuilder.toString())) {
                    //    typeSet.add(typeBuilder.toString());
                    //    log.debug("typeSet.size() = " + typeSet.size());
                    //}
                    //stringBuilder.append("</span>");
                    //stringBuilder.append(typeBuilder.toString());
                    //stringBuilder.append("</div>");

                /*
                if (!typeSet.contains(typeBuilder.toString())) {
                    if (typeSet.size() > 0) stringBuilder.append("</ol>");
                    typeSet.add(typeBuilder.toString());
                    log.debug("typeSet.size() = " + typeSet.size());
                    //stringBuilder.append("<div class=\"word\"")
                        //if (!lang.equals(fromLang)) { stringBuilder.append(" lang=\"").append(fromLang).append("\""); }
                    //    .append(">")
                    stringBuilder.append("<div class=\"word-line\">");
                    stringBuilder.append("<span class=\"numbering\">").append((++definitionCount)).append(". ").append("</span>");
                    stringBuilder.append("<span class=\"word\">").append(word.getWord()).append("</span>");
                    //if (ENGLISH.equals(toLanguage)) {
                        stringBuilder.append("<span class=\"type\">").append(typeBuilder.toString()).append("</span>");
                    //}
                    stringBuilder.append("</div>");
                    stringBuilder.append("<ol>");
                }
                */
            }  // for (int i = 0; i < definitionList.size(); i++)
        }
        return definitionMap;
    }
}
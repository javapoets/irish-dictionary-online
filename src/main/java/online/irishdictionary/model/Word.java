package online.irishdictionary.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import online.irishdictionary.util.Text;

public class Word {

    private static final org.apache.logging.log4j.Logger log = org.apache.logging.log4j.LogManager.getLogger();
    private String EMPTY = "";
    private String COMMA = ",";
    private String ENGLISH = "english";
    private String IRISH = "irish";
    private int id = -1;
    private String word = null;
    private String fromLanguage = null;
    private String toLanguage = null;
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

    public Word() {}

    public Word(String word) {
        this.word = word;
    }

    public Word(String word, String fromLanguage, String toLanguage) {
        log.debug("('"+word+"', '"+fromLanguage+"', '"+toLanguage+"')");
        this.word = word;
        this.fromLanguage = fromLanguage;
        this.toLanguage = toLanguage;
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

    //public Map<String, List<Definition>> createDefinitionMap() {
    public Map<WordType, List<Definition>> createDefinitionMap() {
        log.trace("createDefinitionMap()");
        //Map<String, List<Definition>> definitionMap = new HashMap<String, List<Definition>>();
        Map<WordType, List<Definition>> definitionMap = new LinkedHashMap<WordType, List<Definition>>();
        if (definitionList != null && definitionList.size() != 0) {
            log.debug("definitionList.size() = " + definitionList.size());

            String N = "n";
            Definition definition = null;
            String gender, description;
            String type = null;
            String wordType = null;
            WordType wordTypeObject = null;
            java.util.Map<String, WordType> typeMap = new java.util.HashMap<String, WordType>();
            for (int i = 0; i < definitionList.size(); i++) {
                definition = (Definition) definitionList.get(i);
                log.debug("definition.getWord() = " + definition.getWord());
                log.debug("definition.getDefinition() = " + definition.getDefinition());
                log.debug("definition.getType() = " + definition.getType());
                log.debug("definition.getGender() = " + definition.getGender());
                //log.debug("definition.getDescription() = " + definition.getDescription());
                wordType = definition.getType();
                gender = definition.getGender();
                description = definition.getDescription();
                boolean hasType = wordType != null && !wordType.equals("");
                boolean hasGender = gender != null && !gender.equals("");
                //boolean hasDescription = description != null && !description.equals("");
                if (!hasType && hasGender) {
                    if (genderSet.contains(gender)) {
                        wordType = N;
                    }
                }

                //*
                if (wordType != null && (wordType.equals("vt") || wordType.equals("vi"))) {
                    type = "v";
                    gender = null;
                } else {
                    type = wordType;
                }

                if (this.fromLanguage != null && this.fromLanguage.equals(ENGLISH)) {
                    if (wordType != null && wordType.equals(N)) gender = null;
                }
                    //    type = wordType;
                    //}
                //}
                if (type == null) {
                    type = "other";
                    wordType = "other";
                }
                //*/

                //java.util.Set<String> typeSet = new java.util.HashSet<String>();
                //if (!typeSet.contains(type)) {
                //    log.debug("typeSet.add("+type+")");
                //    typeSet.add(type);

                /*
                WordType wordTypeObject = typeMap.get(type);
                if (wordTypeObject == null) {
                    wordTypeObject = new WordType(wordType, gender);
                    log.debug("typeMap.add('"+type+"', "+wordTypeObject+")");
                    typeMap.put(type, wordTypeObject);
                    log.debug("typeMap.size() = " + typeMap.size());
                }
                log.debug("wordTypeObject = " + wordTypeObject);
                */

                //WordType wordTypeObject = new WordType(type, gender);

                if (wordType != null) {
                //if (wordType != null && wordType.indexOf(COMMA) != -1) {
                    int indexOfComma = wordType.indexOf(COMMA);
                    //log.debug("indexOfComma = " + indexOfComma);
                    if (indexOfComma != -1) {
                        String[] definitionTypes = wordType.split(COMMA);
                        //log.debug("types = " + types);
                        //log.debug("types.length = " + types.length);
                        String definitionType = null;
                        Definition definitionClone = null;
                        //StringBuilder typeBuilder = new StringBuilder();
                        //StringBuilder definitionTypeBuilder = null;
                        StringBuilder definitionTypeBuilder = new StringBuilder();

                        for (int j = 0; j < definitionTypes.length; j++) {
                            definitionType = definitionTypes[j].trim();
                            log.debug(j + ": definitionType = " + definitionType);

                            //if (!typeSet.contains(types[j])) {
                            //List<Definition> definitionList = definitionMap.get(type);
                            if (definitionType != null && (definitionType.equals("vt") || definitionType.equals("vi"))) {
                                type = "v";
                                gender = null;
                            } else {
                                type = definitionType;
                                if (this.fromLanguage.equals(ENGLISH)) {
                                    if (gender.equals("mpl1")) gender = "pl";
                                }
                            }
                            if (type == null) {
                                type = "other";
                                wordType = "other";
                            }

                            wordTypeObject = typeMap.get(type);
                            log.debug(j + ": wordTypeObject = " + wordTypeObject);
                            if (wordTypeObject == null) {
                                //wordTypeObject = new WordType(definitionType, gender);
                                wordTypeObject = new WordType((this.fromLanguage.equals(ENGLISH) ? type : definitionType), gender);
                                definitionTypeBuilder = new StringBuilder();
                                //if (this.fromLanguage.equals(ENGLISH)) wordTypeObject.setFromType(type);
                                log.debug(j + ": typeMap.add('"+type+"', "+wordTypeObject+")");
                                typeMap.put(type, wordTypeObject);
                                log.debug(j + ": typeMap.size() = " + typeMap.size());
                                if (j > 0) { // clone every other instance of the Word object for each list
                            //} else {
                                    definition = (Definition) definition.clone();
                                    definition.setType(definitionType); // reset the definition type
                                    definition.setGender(gender); // reset the gender
                                //definitionList.add(definitionClone);
                                }
                            }
                            log.debug(j + ": wordTypeObject = " + wordTypeObject);
                            if (definitionTypeBuilder.length() > 0) definitionTypeBuilder.append(", ");
                            definitionTypeBuilder.append(definitionType);
                            log.debug(j + ": definitionTypeBuilder = " + definitionTypeBuilder);

                            List<Definition> definitionList = definitionMap.get(wordTypeObject);
                            log.debug(j + ": definitionList = " + definitionList);
                            if (definitionList == null) {
                                definitionList = new ArrayList<Definition>();
                                log.debug(j + ": definitionMap.put(" + wordTypeObject + ", definitionList)");
                                definitionMap.put(wordTypeObject, definitionList);
                            }

                            if (definitionList.contains(definition)) {
                                //String newType = new StringBuilder().append(definition.getType()).append(", ").append(definitionType).toString();
                                //wordTypeObject.setType(newType);
                                /*
                                if (this.fromLanguage.equals(IRISH)) wordTypeObject.addFromType(definitionType);
                                wordTypeObject.addType(definitionType);
                                if (this.toLanguage.equals(IRISH)) {
                                    //definition.setType(definitionType);
                                    definition.setType(new StringBuilder().append(definition.getType()).append(", ").append(definitionType).toString());
                                } else if (this.toLanguage.equals(ENGLISH)) {
                                    definition.setType(wordTypeObject.getType());
                                    //definition.addType(wordTypeObject.getType());
                                    //wordTypeObject.setType(type);
                                } else{
                                    definition.setType(type);
                                    definition.setGender(null);
                                }
                                */
                                if (this.fromLanguage.equals(IRISH)) {
                                    wordTypeObject.setFromType(definitionTypeBuilder.toString());
                                    definition.setType(type);
                                    definition.setGender(null);
                                } else {
                                    definition.setType(definitionTypeBuilder.toString());
                                }

                                //if (this.fromLanguage.equals(IRISH)) wordTypeObject.addType(definitionType);
                                //if (this.fromLanguage.equals(ENGLISH)) wordTypeObject.setFromType(type);
                            } else {
                                log.debug(j + ": definitionList.add(" + definition + ")");
                                if (this.toLanguage.equals(ENGLISH)) {
                                    definition.setGender(null);
                                    definition.setType(type);
                                } else {
                                //    wordTypeObject.setType(type);
                                    definition.setType(definitionType);
                                }
                                //if (this.fromLanguage.equals(ENGLISH)) wordTypeObject.setType(type);
                                //if (this.fromLanguage.equals(ENGLISH)) wordTypeObject.setFromType(type);
                                definitionList.add(definition);
                            }

                            //if (j > 0) { // clone every other instance of the Word object for each list
                                /*
                                if (!definitionList.contains(definitionClone)) {
                                //if (definitionList.contains(definition)) {
                                    definitionClone = (Definition) definition.clone();
                                    definitionClone.setType(definitionType); // reset the definition type
                                    definitionClone.setGender(gender); // reset the gender
                                    definitionList.add(definitionClone);
                                } else {
                                */    
                                //if (definitionList.contains(definition)) {
                                    //definition.setGender(gender); // reset the gender
                                    /*
                                    //WordType wordTypeObjectLookup = typeMap.get(type);
                                    String newType = new StringBuilder().append(definitionClone.getType()).append(", ").append(definitionType).toString();
                                    wordTypeObject.setType(newType);
                                    if (this.toLanguage.equals(IRISH)) {
                                        definitionClone.setType(newType);
                                    } else{
                                        definitionClone.setType(type);
                                        definition.setGender(null);
                                    }
                                    /*
                                    definition.setType(new StringBuilder()
                                        .append(definition.getType())
                                        .append(", ")
                                        .append(definitionType)
                                        .toString()
                                    );
                                    //*/
                                //}
                                //definitionClone = (Definition) definition.clone();
                                //definitionClone.setType(definitionType); // reset the definition type
                                //definitionClone.setGender(gender); // reset the gender
                                //definitionList.add(definitionClone);

                            //} else {
                                /*
                                log.debug("definitionList.add("+definition+")");
                                definition.setType(definitionType); // reset the definition type
                                if (this.toLanguage.equals(ENGLISH)) {
                                    definition.setGender(null);
                                    //definition.setType(type);
                                //} else {
                                    //definition.setType(type);
                                }
                                definitionList.add(definition);
                                */
                            //}

                            /*
                            boolean hasMultipleOfThisType = 
                            boolean alreadyContainsThisType = 
                            if (j > 0) { // clone every other instance of the Word object for each list
                                Definition definitionClone = (Definition) definition.clone();
                                definitionClone.setType(definitionType); // reset the definition type
                                definitionClone.setGender(gender); // reset the gender
                                definitionList.add(definitionClone);
                            } else {
                                log.debug("definitionList.add("+definition+")");
                                definition.setType(definitionType); // reset the definition type
                                definitionList.add(definition);
                            }
                            */
                        }  // for (int j = 0; j < definitionTypes.length; j++)
                    } else {
                        //List<Definition> definitionList = definitionMap.get(type);
                        if (wordType != null && (wordType.equals("vt") || wordType.equals("vi"))) {
                            type = "v";
                            gender = null;
                        } else {
                            type = wordType;
                            if (this.fromLanguage.equals(ENGLISH)) {
                                if (gender != null && gender.equals("mpl1")) gender = "pl";
                            }
                        }
                        if (type == null) {
                            type = "other";
                            wordType = "other";
                        }
                        wordTypeObject = typeMap.get(type);
                        if (wordTypeObject == null) {
                            //wordTypeObject = new WordType(wordType, gender);
                            //if (toLanguage.equals(IRISH)) {
                            if (this.fromLanguage.equals(ENGLISH)) {
                                wordTypeObject = new WordType(type, gender);
                            } else {
                                wordTypeObject = new WordType(wordType, gender);
                            }
                            log.debug("typeMap.add('"+type+"', "+wordTypeObject+")");
                            typeMap.put(type, wordTypeObject);
                            log.debug("typeMap.size() = " + typeMap.size());
                        }
                        log.debug("wordTypeObject = " + wordTypeObject);
                        List<Definition> definitionList = definitionMap.get(wordTypeObject);
                        if (definitionList == null) {
                            definitionList = new ArrayList<Definition>();
                            //log.debug("definitionMap.put("+type+", definitionList)");
                            //definitionMap.put(type, definitionList);
                            log.debug("definitionMap.put("+wordTypeObject+", definitionList)");
                            definitionMap.put(wordTypeObject, definitionList);
                        }
                        log.debug("definitionList.add("+definition+")");

                        //if (toLanguage.equals(IRISH)) {
                        //if (this.fromLanguage.equals(IRISH)) {
                        if (this.toLanguage.equals(ENGLISH)) {
                            definition.setGender(null);
                            definition.setType(type);
                        //} else {
                        //    definition.setType(type);
                        }

                        definitionList.add(definition);
                    }
                } // if (type != null)
                //}
            }  // for (int i = 0; i < definitionList.size(); i++)
            log.debug("definitionMap.size() = " + definitionMap.size());
        }
        return definitionMap;
    }

    public Map<String, List<Definition>> createDefinitionMapBak() {
        log.trace("createDefinitionMap()");
        Map<String, List<Definition>> definitionMap = new LinkedHashMap<String, List<Definition>>();
        if (definitionList != null && definitionList.size() != 0) {
            log.debug("definitionList.size() = " + definitionList.size());

            String N = "n";
            Definition definition = null;
            String type, gender, description;
            java.util.Set<String> typeSet = new java.util.HashSet();
            StringBuilder typeBuilder = new StringBuilder();
            for (int i = 0; i < definitionList.size(); i++) {
                definition = (Definition) definitionList.get(i);
                //log.debug("definition.getType() = " + definition.getType());
                //log.debug("definition.getGender() = " + definition.getGender());
                //log.debug("definition.getDescription() = " + definition.getDescription());
                type = definition.getType();
                gender = definition.getGender();
                description = definition.getDescription();
                boolean hasType = type != null && !type.equals("");
                boolean hasGender = gender != null && !gender.equals("");
                //boolean hasDescription = description != null && !description.equals("");

                if (!hasType && hasGender) {
                    if (genderSet.contains(gender)) {
                        type = N;
                    }
                }

                //if (hasType || hasGender) {
                    if (type != null) {
                        int indexOfComma = type.indexOf(COMMA);
                        //log.debug("indexOfComma = " + indexOfComma);
                        if (indexOfComma != -1) {
                            String[] types = type.split(COMMA);
                            //log.debug("types = " + types);
                            //log.debug("types.length = " + types.length);
                            for (int j = 0; j < types.length; j++) {
                                type = types[j].trim();
                                //if (!typeSet.contains(types[j])) {
                                if (!typeSet.contains(type)) {
                                    //log.debug("typeSet.add("+types[j]+")");
                                    //log.debug("typeSet.add("+type+")");
                                    //typeSet.add(types[j]);
                                    typeSet.add(type);
                                    //log.debug("typeSet.size() = " + typeSet.size());
                                    List<Definition> definitionList = definitionMap.get(type);
                                    if (definitionList == null) {
                                        definitionList = new ArrayList<Definition>();
                                        definitionMap.put(type, definitionList);
                                    }
                                    log.debug("definitionList.add("+definition+")");
                                    definitionList.add(definition);
                                }
                            }
                        } else {
                            if (!typeSet.contains(type)) {
                                //log.debug("typeSet.add("+type+")");
                                typeSet.add(type);
                                //log.debug("typeSet.size() = " + typeSet.size());
                                List<Definition> definitionList = definitionMap.get(type);
                                if (definitionList == null) {
                                    definitionList = new ArrayList<Definition>();
                                    definitionMap.put(type, definitionList);
                                }
                                log.debug("definitionList.add("+definition+")");
                                definitionList.add(definition);
                            }
                        }
                    }
                //}
            }  // for (int i = 0; i < definitionList.size(); i++)
            log.debug("definitionMap.size() = " + definitionMap.size());
            log.debug("typeSet.size() = " + typeSet.size());
        }
        return definitionMap;
    }

    public String toString() {
        return new StringBuilder().append("Word{").append(this.word).append("}").toString();
    }

}
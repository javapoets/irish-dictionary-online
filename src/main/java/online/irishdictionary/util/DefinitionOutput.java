package online.irishdictionary.util;

import java.util.List;
import java.util.HashMap;
import java.util.StringTokenizer;
import online.irishdictionary.model.Definition;
import online.irishdictionary.model.Usage;
import online.irishdictionary.model.Word;
import online.irishdictionary.util.Text;
import online.irishdictionary.util.Validator;

public class DefinitionOutput {

    private static final org.apache.logging.log4j.Logger log = org.apache.logging.log4j.LogManager.getLogger();
    private static final String EMPTY = "";
    private static final String COMMA = ",";
    private static final String ENGLISH = "english";
    private static final String IRISH = "irish";
    private String invalidChars = "_-!@#$%^&*()+[]=\\|?/'\",.<>`~:; ";
    private Word word = null;
    private String fromLanguage = null;
    private String toLanguage = null;
    private String lang = null;
    private String fromLang = null;
    private String toLang = null;
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

    public DefinitionOutput() {}

    public DefinitionOutput(String fromLanguage, String toLanguage) {
        this.fromLanguage = fromLanguage;
        this.toLanguage = toLanguage;
    }

    public DefinitionOutput(Word word, String fromLanguage, String toLanguage, String lang, String fromLang, String toLang) {
        log.trace("(" + word + ", '" + fromLanguage + "', '" + toLanguage +"', '" + lang + "', '" + fromLang + "', '" + toLang +"')");
        this.word = word;
        this.fromLanguage = fromLanguage;
        this.toLanguage = toLanguage;
        this.lang = lang;
        this.fromLang = fromLang;
        this.toLang = toLang;
    }

    //public String createHtml(Word word, String fromLanguage, String toLanguage) {
        //log.trace("createHtml('" + word + "', '" + fromLanguage + "', '" + toLanguage +"')");
    public String createHtml() {
        log.trace("createHtml()");

        online.irishdictionary.util.ResourceBundles resourceBundles = new online.irishdictionary.util.ResourceBundles(lang);

        log.debug("word.getType() = " + word.getType());
        log.debug("word.getDescription() = " + word.getDescription());
        log.debug("word.getGenitiveSingular() = " + word.getGenitiveSingular());
        log.debug("word.getNominativeSingular() = " + word.getNominativeSingular());
        log.debug("word.getGenitivePlural() = " + word.getGenitivePlural());
        log.debug("word.getNominativePlural() = " + word.getNominativePlural());

        String wordType = word.getType();
        log.debug("word.Type() = " + word.getType());
        if (wordType != null) {
            int indexOfComma = wordType.indexOf(COMMA);
            log.debug("indexOfComma = " + indexOfComma);
            if (indexOfComma != -1) {
                String[] wordTypes = wordType.split(COMMA);
                log.debug("wordTypes = " + wordTypes);
                log.debug("wordTypes.length = " + wordTypes.length);
            }
        }

        StringBuilder stringBuilder = new StringBuilder();  // to hold the message body
        List definitionList = word.getDefinitionList();
        List usageList = word.getUsageList();
        stringBuilder.append("<div class=\"definition verb-conjugation\">");

        /*
        stringBuilder
            .append("<div class=\"word-header\">")
            .append(  "<div class=\"language-label\">")
            //.append(    "<span class=\"capitalize\">").append(fromLanguage).append("</span>").append(" word")
            .append(    resourceBundles.getString(fromLanguage + " word"))
            .append(  "</div>")
            .append(  "<div class=\"word\"");
            if (!lang.equals(fromLang)) { stringBuilder.append(" lang=\"").append(fromLang).append("\""); }
        stringBuilder
            .append(  ">")
            .append(word.getWord())
            .append("  </div>");
            
        if (word.getDescription() != null) {
            stringBuilder.append(  "<span class=\"word-description\">").append(word.getDescription()).append("</span>");
        }
        if (word.getWordDescription() != null) {
            stringBuilder.append(  "<span class=\"word-description\">").append(word.getWordDescription()).append("</span>");
        }

        //genitive_singular, nominative_singular, genitive_plural, nominative_plural
        if (word.getGenitiveSingular() != null) {
            stringBuilder.append(  "<span class=\"word-description\">genitive_singular: ").append(word.getGenitiveSingular()).append("</span>");
        }
        if (word.getNominativeSingular() != null) {
            stringBuilder.append(  "<span class=\"word-description\">nominative_singular: ").append(word.getNominativeSingular()).append("</span>");
        }
        if (word.getGenitivePlural() != null) {
            stringBuilder.append(  "<span class=\"word-description\">genitive_plural: ").append(word.getGenitivePlural()).append("</span>");
        }
        if (word.getNominativePlural() != null) {
            stringBuilder.append(  "<span class=\"word-description\">nominative_plural: ").append(word.getNominativePlural()).append("</span>");
        }
        stringBuilder.append("</div>");
        */

        if (definitionList != null && definitionList.size() != 0) {
            log.debug("definitionList.size() = " + definitionList.size());

            //stringBuilder.append("<div>");
            stringBuilder.append("<div class=\"word-header\">");

            /*
            if (hasType || hasGender) {
                stringBuilder.append("<span class=\"type\">");
                if (hasGender) {
                    if (hasType) stringBuilder.append(" ");
                    String genderExpanded = genderMap.get(gender);
                    if (genderExpanded != null) {
                        stringBuilder.append(genderExpanded);
                    } else {    
                        stringBuilder.append(gender);
                    } 
                } else if (hasType) {
                    String partOfSpeech = partsOfSpeech.get(type);
                    if (partOfSpeech != null) {
                        stringBuilder.append(partOfSpeech);
                    } else {    
                        stringBuilder.append(type);
                    } 
                }
                stringBuilder.append("</span>");
            }
            */

            //stringBuilder.append("<ol>");
            String type, gender, description, wordDescription;
            List sortedList = definitionList;
            //Map<String, 
            java.util.Set<String> typeSet = new java.util.HashSet();
            StringBuilder typeBuilder = new StringBuilder();
            int definitionCount = 0;
            for (int i = 0; i < sortedList.size(); i++) {
                Definition definition = (Definition) sortedList.get(i);
                log.debug("definition.getType() = " + definition.getType());
                log.debug("definition.getGender() = " + definition.getGender());
                //log.debug("definition.getDescription() = " + definition.getDescription());
                type = definition.getType();
                gender = definition.getGender();
                description = definition.getDescription();
                //wordDescription = definition.getWordDescription();
                //boolean hasType = !"".equals(type);
                //boolean hasGender = !"".equals(gender);
                //boolean hasDescription = !"".equals(description);
                boolean hasType = type != null && !type.equals("");
                boolean hasGender = gender != null && !gender.equals("");
                boolean hasDescription = description != null && !description.equals("");
                //boolean hasWordDescription = wordDescription != null && !wordDescription.equals("");

                if (hasType || hasGender) {
                    typeBuilder = new StringBuilder();
                    //stringBuilder.append("<span class=\"type\">");
                    //stringBuilder.append("<div class=\"type\">");
                    if (hasGender) {
                        //if (hasType) stringBuilder.append(" ");
                        String genderExpanded = genderMap.get(gender);
                        if (genderExpanded != null) {
                            //stringBuilder.append(genderExpanded);
                            typeBuilder.append(genderExpanded);
                        } else {    
                            //stringBuilder.append(gender);
                            typeBuilder.append(gender);
                        } 
                    } else if (hasType) {
                        String partOfSpeech = partsOfSpeech.get(type);
                        if (partOfSpeech != null) {
                            //stringBuilder.append(partOfSpeech);
                            typeBuilder.append(partOfSpeech);
                        } else {    
                            //stringBuilder.append(type);
                            typeBuilder.append(type);
                        } 
                    }
                    //if (!typeSet.contains(typeBuilder.toString())) {
                    //    typeSet.add(typeBuilder.toString());
                    //    log.debug("typeSet.size() = " + typeSet.size());
                    //}
                    //stringBuilder.append("</span>");
                    //stringBuilder.append(typeBuilder.toString());
                    //stringBuilder.append("</div>");
                }

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

                if ((definition.getDefinition() != null) && !(definition.getDefinition().trim().equals(""))) {
                    //stringBuilder.append("<li>");
                    stringBuilder.append("<li>");
                    //stringBuilder.append("<div style=\"padding-left:17px;\">");
                    //stringBuilder.append("<span class=\"description\" style=\"color:#aaa;margin-left:-33px;\">").append(i + 1).append(". ").append("</span>");
                    stringBuilder.append("<span class=\"description\">").append(i + 1).append(". ").append("</span>");
                    //if((definition.getType() != null) && !definition.getType().equals("")) {
                        //stringBuilder.append("<span class=\"type\">" + definition.getType() + "</span>");
                        /*
                        stringBuilder.append("<i class=type>" + definition.getType() + "</i>");
                        if((definition.getDescription() != null) && !definition.getDescription().equals("")) {
                            stringBuilder.append("<i class=type> " + generateHrefOnWords(definition.getDescription(), "english", "normal", "color1") + "</i>");
                        }
                        */
                    //}
                    stringBuilder.append("&nbsp;<span class=\"definition\"");
                    if (!lang.equals(toLang)) { stringBuilder.append(" lang=\"").append(toLang).append("\""); }
                    stringBuilder.append(">");
                    stringBuilder.append(linkizeWords(definition.getDefinition(), toLanguage, fromLanguage));
                    stringBuilder.append("</span>");
                    //*
                    if (hasDescription) stringBuilder.append("<span class=\"description\">").append(description).append("</span>");
                    //if (hasWordDescription) stringBuilder.append("<span class=\"description\">").append(wordDescription).append("</span>");

                    //if (IRISH.equals(toLanguage)) {
                        if (hasType || hasGender) {
                            stringBuilder.append("<span class=\"type\">");
                            if (hasGender) {
                                if (hasType) stringBuilder.append(" ");
                                String genderExpanded = genderMap.get(gender);
                                if (genderExpanded != null) {
                                    stringBuilder.append(genderExpanded);
                                } else {    
                                    stringBuilder.append(gender);
                                } 
                            } else if (hasType) {
                                String partOfSpeech = partsOfSpeech.get(type);
                                if (partOfSpeech != null) {
                                    stringBuilder.append(partOfSpeech);
                                } else {    
                                    stringBuilder.append(type);
                                } 
                            }
                            stringBuilder.append("</span>");
                        }
                    //}
                    //*/
                    //stringBuilder.append("</div>");
                    stringBuilder.append("</li>");
                }
            }
            stringBuilder.append("</ol>");
            stringBuilder.append("</div>");
        }
        if ((usageList != null) && (usageList.size() > 0)) {

            /*
            stringBuilder.append("<div class=\"row\">");
            stringBuilder.append("<div class=\"cell usage underline\">");
            //stringBuilder.append("<div class=\"word-header\">Example usage:</div>");
            stringBuilder.append("<span class=\"language-label\">");
            stringBuilder.append(resourceBundles.getString("Example Usage"));
            stringBuilder.append("</span>").append("</div>");
            stringBuilder.append("</div>");
            //stringBuilder.append("<ol>");
            //*/

            stringBuilder.append("<div class=\"table\" style=\"padding: 10px 0px;\">");
            //stringBuilder.append("<div class=\"row\">");
            //stringBuilder.append("<div class=\"cell usage-label underline">&nbsp;</div>
            //stringBuilder.append("<div class=\"cell verb-tense-header\">

            stringBuilder.append("<div class=\"row\">");
            stringBuilder.append("<div class=\"cell usage-label underline\">&nbsp;</div>");
            //stringBuilder.append("<div class=\"cell usage underline\">");
            //stringBuilder.append("<div class=\"verb-tense-header\" style=\"display: table-caption;\">");
            stringBuilder.append("<div class=\"cell verb-tense-header\">");
            //stringBuilder.append("<div class=\"word-header\">Example usage:</div>");
            //stringBuilder.append("<span class=\"language-label\">");
            stringBuilder.append(resourceBundles.getString("Example Usage"));
            //stringBuilder.append("</span>")
            stringBuilder.append("</div>");  // cell
            stringBuilder.append("</div>");  //  roq

            //List sortedList = (List) usageList.getSortedList("usageLength");
            List sortedList = usageList;
            int start = word.getStartUsageIndex();
            int end = sortedList.size();
            if (usageList.size() > word.getEndUsageIndex()) {
                end = word.getEndUsageIndex();
            }
            String type, usage, usageTranslated, description, plusSuffix;
            for (int i = start; i < end; i++) {
                Usage usageObject = (Usage)sortedList.get(i);
                usage           = usageObject.getUsage();
                usageTranslated = usageObject.getUsageTranslated();
                type            = usageObject.getType();
                description     = usageObject.getDescription();
                plusSuffix      = usageObject.getPlusSuffix();
                boolean hasUsage = !EMPTY.equals(usage);
                boolean hasUsageTranslated = !EMPTY.equals(usageTranslated);
                boolean hasType = !EMPTY.equals(type);
                boolean hasDescription = !EMPTY.equals(description);
                boolean hasSuffix = !EMPTY.equals(plusSuffix);
                //stringBuilder.append("<li>");
                //stringBuilder.append("<div style=\"padding-left:50px;\">");
                //stringBuilder.append("<div class=\"cell verb-tense-header\"");
                
                stringBuilder.append("<div class=\"row\">");
                stringBuilder.append("<div class=\"cell usage-label\"");
                //if (!lang.equals(fromLang)) { stringBuilder.append(" lang=\"").append(fromLang).append("\""); }
                stringBuilder.append(">");

                //stringBuilder.append("<li>").append(fromLanguage).append(": ");
                //stringBuilder.append("<span class=\"description\" style=\"color:#aaa;margin-left:-33px;\">").append(fromLanguage).append(" ").append("</span>");
                //stringBuilder.append("<span class=\"usage-label "+fromLanguage+"\">").append(resourceBundles.getString(fromLanguage)).append(" ").append("</span>");
                stringBuilder.append(resourceBundles.getString(fromLanguage));
                //stringBuilder.append("<span class=\"description\">").append(fromLanguage).append(": ").append("</span>");
                stringBuilder.append("</div>");

                if (hasUsage) {
                    stringBuilder.append("<div class=\"cell usage\"");
                    //stringBuilder.append("<div class=\"cell verb-tense-header\"");
                    if (!lang.equals(fromLang)) { stringBuilder.append(" lang=\"").append(fromLang).append("\""); }
                    stringBuilder.append(">");
                    stringBuilder.append(linkizeUsage(usage, word.getWord(), fromLanguage, toLanguage));
                    if (hasDescription && ENGLISH.equals(fromLanguage)) stringBuilder.append("<span class=\"description\">").append(description).append("</span>");
                    stringBuilder.append("</div>");
                }
                //stringBuilder.append("<br/>");
                stringBuilder.append("</div>");  // row

                stringBuilder.append("<div class=\"row\">");
                stringBuilder.append("<div");
                //stringBuilder.append(" class=\"cell verb-tense-header\"");
                stringBuilder.append(" class=\"cell usage-label underline\"");
                //if (!lang.equals(toLang)) { stringBuilder.append(" lang=\"").append(toLang).append("\""); }
                stringBuilder.append(">");
                //stringBuilder.append("<span class=\"usage-label "+toLanguage+"\">").append(resourceBundles.getString(toLanguage)).append(" ").append("</span>");
                stringBuilder.append(resourceBundles.getString(toLanguage)).append(" ");
                stringBuilder.append("</div>");  // cell usage-label
                //if (hasUsageTranslated) {
                    //stringBuilder.append("<span class=\"usage-label "+toLanguage+"\">").append(resourceBundles.getString(toLanguage)).append(" ").append("</span>");
                    //stringBuilder.append("<span class=\"translated\"");
                    stringBuilder.append("<div class=\"cell translated underline\"");
                    if (!lang.equals(toLang)) { stringBuilder.append(" lang=\"").append(toLang).append("\""); }
                    stringBuilder.append(">");
                    stringBuilder.append(linkizeWords(usageTranslated, toLanguage, fromLanguage));
                    //if (hasSuffix) stringBuilder.append("<span class=\"description\">").append(plusSuffix).append("</span>");
                    if (hasSuffix && IRISH.equals(toLanguage)) {
                        stringBuilder.append("<span class=\"description\">").append(plusSuffix).append("</span>");
                    }
                    if (hasDescription && IRISH.equals(fromLanguage)) {
                        stringBuilder.append("<span class=\"description\">").append(description).append("</span>");
                    }
                    stringBuilder.append("</div>");  // cell translated
                    stringBuilder.append("</div>");  // row
                //}
                /*
                if(
                    hasType
                    //|| hasDescription
                ) {
                    stringBuilder.append("<span class=\"type\">(");
                    if(hasType) stringBuilder.append(type);
                    stringBuilder.append(")</span>");
                }
                if(hasDescription) {
                    stringBuilder.append("<span class=\"description\">").append(linkize(description, fromLanguage, toLanguage)).append("</span>");
                }
                */
                //if(hasDescription) stringBuilder.append("<span class=\"description\">").append(description).append("</span>");
                //if (hasDescription && IRISH.equals(fromLanguage)) stringBuilder.append("<span class=\"description\">").append(description).append("</span>");
                //stringBuilder.append("</div>");
                //stringBuilder.append("</li>");
            }
            //stringBuilder.append("</ol>");
            //stringBuilder.append("</div>"); // cell
            stringBuilder.append("</div>");  // table
        }
        //stringBuilder.append("</div>"); // row
        stringBuilder.append("</div>"); // definition
        return stringBuilder.toString();
    }

    public String linkizeWords(String words, String fromLanguage, String toLanguage) {
        //log.trace("linkizeWords('" + words + "', '" + fromLanguage + "', '" + toLanguage + "')");
        StringBuilder stringBuilder = new StringBuilder();
        StringTokenizer st = new StringTokenizer(words);
        int tokens = st.countTokens();
        int x = 0;
        while (st.hasMoreTokens()) {
            x++;
            String token = st.nextToken();
            if (Text.containsInvalidChars(token, invalidChars)) {
                StringBuilder invalid = new StringBuilder();
                StringBuilder valid = new StringBuilder();
                for (int i = 0; i < token.length(); i++) {
                    if (Validator.inValidChar(token.charAt(i), invalidChars)) {
                        if (valid.length() >= 1) {
                            String newWord = addHref(valid.toString(), fromLanguage, toLanguage);
                            stringBuilder.append(newWord);
                            valid = new StringBuilder();
                        }
                        invalid.append(token.charAt(i));
                    } else {
                        String newWord = null;
                        if (invalid.length() >= 1) {
                            newWord = invalid.toString();
                            stringBuilder.append(newWord);
                            invalid = new StringBuilder();
                        }
                        if (
                               ((newWord != null) && (newWord.equals("</")))
                            || ((newWord != null) && (newWord.equals("<")))
                        ) {  // temporary fix for when we have '</i>' or <i>
                            invalid.append(token.charAt(i));
                        } else {
                            valid.append(token.charAt(i));
                        }
                    }
                }
                if (valid.length() >= 1) {
                    String newWord = addHref(valid.toString(), fromLanguage, toLanguage);
                    stringBuilder.append(newWord);
                    valid = new StringBuilder();
                }
                if (invalid.length() >= 1) {
                    String newWord = invalid.toString();
                    stringBuilder.append(newWord);
                    invalid = new StringBuilder();
                }
                if (tokens > x) stringBuilder.append(" ");
            } else {
                stringBuilder.append(addHref(token, fromLanguage, toLanguage));
                if (tokens > x) stringBuilder.append(" ");
            }
        }
        return stringBuilder.toString();
    }

    private String addHref(String word, String fromLanguage, String toLanguage) {
        //log.trace("addHref('" + word + "', '" + fromLanguage + "', '" + toLanguage + "')");
        /*
        return new StringBuilder()
            .append("<a href=\"dictionary")
            .append("?language=").append(fromLanguage)
            .append("&toLanguage=").append(toLanguage)
            .append("&word=").append(word)
            .append("\">")
            .append(word)
            .append("</a>")
            .toString();
        */
        return new StringBuilder()
            .append("<a href=\"/").append(fromLanguage)
            .append("/").append(toLanguage)
            .append("/").append(word)
            .append("\">").append(word).append("</a>")
            .toString();
    }

    private String linkizeUsage(String words, String searchWord, String fromLanguage, String toLanguage) {
        //log.trace("linkizeUsage('" + words + "', '" + searchWord + "', '" + fromLanguage + "', '" + toLanguage + "')");
        StringBuilder stringBuilder = new StringBuilder();
        StringTokenizer st = new StringTokenizer(words);
        int tokens = st.countTokens();
        int x = 0;
        while (st.hasMoreTokens()) {
            x++;
            String token = st.nextToken();
            if (Text.containsInvalidChars(token, invalidChars)) {
                StringBuilder invalid = new StringBuilder();
                StringBuilder valid = new StringBuilder();
                for (int i=0; i < token.length(); i++) {
                    if (Validator.inValidChar(token.charAt(i), invalidChars)) {
                        if (valid.length() >= 1) {
                            String newWord = addHrefUsage(valid.toString(), searchWord, fromLanguage, toLanguage);
                            stringBuilder.append(newWord);
                            valid = new StringBuilder();
                        }
                        invalid.append(token.charAt(i));
                    } else {
                        String newWord = null;
                        if (invalid.length() >= 1) {
                            newWord = invalid.toString();
                            stringBuilder.append(newWord);
                            invalid = new StringBuilder();
                        }
                        if (
                               ((newWord != null) && (newWord.equals("</")))
                            || ((newWord != null) && (newWord.equals("<")))
                        ) {  // temporary fix for when we have '</i>' or <i>
                            invalid.append(token.charAt(i));
                        } else {
                            valid.append(token.charAt(i));
                        }
                    }
                }
                if (valid.length() >= 1) {
                    String newWord = addHrefUsage(valid.toString(), searchWord, fromLanguage, toLanguage);
                    stringBuilder.append(newWord);
                    valid = new StringBuilder();
                }
                if (invalid.length() >= 1) {
                    String newWord = invalid.toString();
                    stringBuilder.append(newWord);
                    invalid = new StringBuilder();
                }
                if (tokens > x) stringBuilder.append(" ");
            } else {
                stringBuilder.append(addHrefUsage(token, searchWord, fromLanguage, toLanguage));
                if(tokens > x) stringBuilder.append(" ");
            }
        }
        String returned = stringBuilder.toString();
        return returned;
    }

    private String addHrefUsage(String word, String searchWord, String fromLanguage, String toLanguage) {
        //log.trace("addHrefUsage('" + word + "', '" + searchWord + "', '" + fromLanguage + "', '" + toLanguage + "')");
        /*
        StringBuilder stringBuilder = new StringBuilder()
            .append("<a href=\"dictionary")
            .append("?language=").append(fromLanguage)
            .append("&toLanguage=").append(toLanguage)
            .append("&word=").append(word).append("\"");
        */
        StringBuilder stringBuilder = new StringBuilder()
            .append("<a href=\"/")
            .append(fromLanguage)
            .append("/").append(toLanguage)
            .append("/").append(word).append("\"");
        if (word.toLowerCase().equalsIgnoreCase(searchWord)) {
            stringBuilder.append(" style=\"color:#ff8f00;\"");
        } else {
            /*
            stringBuilder.append("\"");
            stringBuilder.append("class=\"");
            stringBuilder.append(weight);
            stringBuilder.append(color);
            */
            /*
            stringBuilder.append(" style=\"");
            stringBuilder.append("color:").append(color).append(";");
            stringBuilder.append("font-weight:").append(weight).append(";");
            */
        }
        stringBuilder.append(">").append(word).append("</a>");
        return stringBuilder.toString();
    }
}

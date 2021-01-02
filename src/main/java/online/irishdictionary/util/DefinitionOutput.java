package online.irishdictionary.util;

import java.util.List;
import java.util.StringTokenizer;
import online.irishdictionary.model.Definition;
import online.irishdictionary.model.Usage;
import online.irishdictionary.model.Word;
import online.irishdictionary.util.Text;
import online.irishdictionary.util.Validator;

public class DefinitionOutput {

    private static final org.apache.logging.log4j.Logger log = org.apache.logging.log4j.LogManager.getLogger();
    private static final String EMPTY = "";
    private static final String ENGLISH = "english";
    private static final String IRISH = "irish";
    private String invalidChars = "_-!@#$%^&*()+[]=\\|?/'\",.<>`~:; ";
    private String fromLanguage = null;
    private String toLanguage = null;

    public DefinitionOutput() {}

    public DefinitionOutput(String fromLanguage, String toLanguage) {
        this.fromLanguage = fromLanguage;
        this.toLanguage = toLanguage;
    }

    /*
    public String linkize(Word word) {
        //logger.debug("linkize('"+word.getWord()+"')");
        return linkize(word, "irish");
    }

    public String linkize(Word word, String language) {
        //logger.debug("linkize('"+word.getWord()+"', '"+language+"')");
        return linkize(word, language, "english");
    }

    public String linkizeBak(Word word, String fromLanguage, String toLanguage) {
        logger.trace("linkize('"+word.getWord()+"', '"+fromLanguage+"', '"+toLanguage+"')");
        StringBuffer sb = new StringBuffer();  // to hold the message body
        List definitionList = word.getDefinitionList();
        List usageList = word.getUsageList();
        //sb.append("<div class=\"definition red0\" style=\"text-align:left;max-height:400px;overflow-y:auto;\">");
        sb.append("<div class=\"definition\">");
        sb
          //.append("<div style=\"text-align:left;color:#6B6D6B;font-size:20px;font-weight:bold;\">")
          .append("<div class=\"word-header\">")
          .append("<span class=\"language-label\">").append(fromLanguage).append("</span>").append(" word: ")
          .append("<span class=\"word\">").append(word.getWord()).append("</span>")
          //.append(word.getWord())
          .append("</div>");
        if((definitionList != null) && definitionList.size() != 0) {
            //logger.debug("definitionList.size() = "+definitionList.size());
            sb.append("<div>");
            sb.append("<ol>");
            String type, gender, description;
            //List sortedList = (List)definitionList.getSortedList("definitionId");
            List sortedList = definitionList;
            for(int i = 0; i < sortedList.size(); i++) {
                Definition definition = (Definition)sortedList.get(i);
                //logger.debug("definition.getType() = '"+definition.getType()+"'");
                //logger.debug("definition.getGender() = '"+definition.getGender()+"'");
                //logger.debug("definition.getDescription() = '"+definition.getDescription()+"'");
                type = definition.getType();
                gender = definition.getGender();
                description = definition.getDescription();
                //boolean hasType = !"".equals(type);
                //boolean hasGender = !"".equals(gender);
                //boolean hasDescription = !"".equals(description);
                boolean hasType = type != null && !type.equals("");
                boolean hasGender = gender != null && !gender.equals("");
                boolean hasDescription = description != null && !description.equals("");
                if((definition.getDefinition() != null) && !(definition.getDefinition().trim().equals(""))) {
                    //sb.append("<div class=\"table\">");
                    //sb.append("<div class=\"row\">");
                    //sb.append("<div class=\"cell\">");
                    sb.append("<li>");
                    //sb.append(word.getWord());
                    //if((definition.getType() != null) && !definition.getType().equals("")) {
                        //sb.append("<span class=\"type\">" + definition.getType() + "</span>");
                        //sb.append("<i class=type>" + definition.getType() + "</i>");
                        //if((definition.getDescription() != null) && !definition.getDescription().equals("")) {
                        //    sb.append("<i class=type> " + generateHrefOnWords(definition.getDescription(), "english", "normal", "color1") + "</i>");
                        //}
                    //}
                    //sb.append("&nbsp;<span class=\"definition\" style=\"color:#F7941D;\">"+ generateHrefOnWords(definition.getDefinition(), "irish", "normal", "color2")).append("</span>");
                    //sb.append("&nbsp;<span class=\"definition\"\">"+ generateHrefOnWords(definition.getDefinition(), "irish", "normal", "color2")).append("</span>");
                    //sb.append("&nbsp;<span class=\"definition\"\">"+ linkize(definition.getDefinition(), "irish", "definition")).append("</span>");
                    sb.append("&nbsp;<span class=\"definition\"\">").append(linkize(definition.getDefinition(), toLanguage, fromLanguage)).append("</span>");
                    //if((definition.getGender() != null) && !definition.getGender().equals("")) {
                    //    sb.append("&nbsp;" + definition.getGender());
                    //}
                    //if(
                    //    hasType
                    //    || hasGender
                    //) {
                    //    sb.append("<span class=\"type\">(");
                    //    if(hasType) sb.append(type);
                    //    if(hasGender) {
                    //        if(hasType) sb.append(" ");
                    //        sb.append(gender);
                    //    }
                    //    sb.append(")</span>");
                    //}
                    //if(hasDescription) {
                    //    //sb.append("<span class=\"description\"> " + generateHrefOnWords(definition.getDescription(), "english", "normal", "color1") + "</span>");
                    //    //sb.append("<span class=\"description\">" + generateHrefOnWords(definition.getDescription(), "english", "normal", "color1") + "</span>");
                    //    sb.append("<span class=\"description\">"+description+"</span>");
                    //}
                    //sb.append(";");
                    //sb.append("</div></div></div>");
                    sb.append("</li>");
                }
            }
            //sb.append("</div>");
            sb.append("</ol>");
            sb.append("</div>");
        }

        if((usageList != null) && (usageList.size() > 0)) {
            sb.append("<div class=\"usage\">");
            //sb.append("<div style=\"border-bottom:#ccc 1px solid;\">Usage</div>");
            sb.append("<div class=\"word-header\">Usage:</div>");
            sb.append("<div>");
            //sb.append("<div style=\"max-height:200px;overflow-y:auto;\">");
            sb.append("<ol>");
            //List sortedList = (List) usageList.getSortedList("usageLength");
            List sortedList = usageList;
            int start = word.getStartUsageIndex();
            int end = sortedList.size();
            if(usageList.size() > word.getEndUsageIndex()) {
                end = word.getEndUsageIndex();
            }
            String type, usage, usageTranslated, description;
            for(int i = start; i < end; i++) {
                Usage usageObject = (Usage)sortedList.get(i);
                usage = usageObject.getUsage();
                usageTranslated = usageObject.getUsageTranslated();
                type = usageObject.getType();
                description = usageObject.getDescription();
                boolean hasUsage = !"".equals(usage);
                boolean hasUsageTranslated = !"".equals(usageTranslated);
                boolean hasType = !"".equals(type);
                boolean hasDescription = !"".equals(description);
                sb.append("<li>");
                if(hasUsage) {
                    sb.append(linkize(usage, word.getWord(), fromLanguage, toLanguage));
                }
                sb.append(" <span style=\"color:#ff8f00;\">=</span> ");
                if(hasUsageTranslated) {
                    sb.append("<span class=\"translated\">");
                    sb.append(linkize(usageTranslated, toLanguage, fromLanguage));
                    sb.append("</span>");
                }
                if(
                    hasType
                    //|| hasDescription
                ) {
                    sb.append("<span class=\"type\">(");
                    if(hasType) sb.append(type);
                    sb.append(")</span>");
                }
                if(hasDescription) {
                    //sb.append("<span class=\"description\"> " + generateHrefOnWords(definition.getDescription(), "english", "normal", "color1") + "</span>");
                    //sb.append("<span class=\"description\">" + generateHrefOnWords(definition.getDescription(), "english", "normal", "color1") + "</span>");
                    //sb.append("<span class=\"description\">").append(description).append("</span>");
                    //sb.append("<span class=\"description\">").append(linkize(description, "english")).append("</span>");
                    sb.append("<span class=\"description\">").append(linkize(description, fromLanguage, toLanguage)).append("</span>");
                }
                sb.append("</li>");
                //sb.append("</font></td><td nowrap><a href=dictionary?rs=edit&usageId="+usage.getUsageId()+" alt=\"Offer your opinion on this translation.\">beg to differ</a></td><!--td><a href=dictionary&rs=listen&dict=ei&usageId&format=soundFileFormat alt=\"Offer your opinion on this translation.\">edit</a--></td></tr>");
            }
            sb.append("</ol>");
            sb.append("</div>");
            sb.append("</div>");
        }
        sb.append("</div>");
        return sb.toString();
    }
    */

    /*
    public String linkizeIrish(Word word) {
        logger.debug("linkizeIrish('"+word.getWord()+"')");

        StringBuffer sb = new StringBuffer();
        List definitionList = word.getDefinitionList();
        List usageList = word.getUsageList();

        sb.append("<table border=0 cellspacing=1 width=100% RULES=trows class=dictionary>");
        sb.append("<tr><th><table border=0 cellspacing=0 cellpadding=0 width=100% class=word-header><tr><th nowrap>>>");
        sb.append(word.getWord());
        sb.append("<<</th></tr></table></th></tr>");

        if((definitionList != null) && definitionList.size() != 0) {
            sb.append("<tr><th>TRANSLATION:</th></tr>");

            List sortedList = (List)definitionList.getSortedList("definitionId");
            for(int i = 0; i < sortedList.size(); i++) {
                Definition definition = (Definition)sortedList.get(i);

                if((definition.getDefinition() != null) && !(definition.getDefinition().trim().equals(""))) {
                    sb.append("<tr><td>");
                    sb.append("<font class=normalcolor3>");
                    sb.append(word.getWord());
                    sb.append(" =</font> ");
                    if((definition.getType() != null) && !definition.getType().equals("")) {
                        sb.append("<i class=type>" + definition.getType() + "</i>");
                        if((definition.getDescription() != null) && !definition.getDescription().equals("")) {
                            sb.append("<i class=type> " + generateHrefOnWords(definition.getDescription(), "english", "normal", "color2") + "</i>");
                        }
                    }
                    sb.append("&nbsp;"+ generateHrefOnWords(definition.getDefinition(), "english", "normal", "color1"));
                    if((definition.getGender() != null) && !definition.getGender().equals("")) {
                        sb.append("&nbsp;" + definition.getGender());
                    }
                    sb.append("</td></tr>");
                }
            }
            sb.append("<tr><th>&nbsp;</th></tr>");
        }


        if((usageList != null) && (usageList.size() > 0)) {

            sb.append("<tr><th>USAGE:</th></tr>");

            List sortedList = (List) usageList.getSortedList("usageTranslatedLength");

            int start = word.getStartUsageIndex();
            int end = sortedList.size();

            if(usageList.size() > word.getEndUsageIndex()) {
                end = word.getEndUsageIndex();
            }

            for(int i = start; i < end; i++) {
                Usage usage = (Usage)sortedList.get(i);
                sb.append("<tr><td>");
                if(
                    ((usage.getType() != null) && !usage.getType().equals("")) ||
                    ((usage.getDescription() != null) && !usage.getDescription().equals(""))
                  ){
                    sb.append("<i class=type>" + usage.getType() + " " + generateHrefOnWords(usage.getDescription(), "irish", "normal", "color1") + "</i>&nbsp;");
                }
                if((usage.getUsage() != null) && !usage.getUsage().equals("")) {
                    sb.append(getlinkedWords(usage.getUsageTranslated(), word.getWord(), "irish", "normal", "color1"));
                }
                sb.append(" <font class=normalcolor3>=</font> ");
                if((usage.getUsage() != null) && !usage.getUsage().equals("")) {
                    sb.append(generateHrefOnWords(usage.getUsage(), "english", "bold", "color2"));
                }
                sb.append(";");
                sb.append("</td></tr>");
                //sb.append("</font></td><td nowrap><a href=dictionary?rs=edit&usageId="+usage.getUsageId()+" alt=\"Offer your opinion on this translation.\">beg to differ</a></td><!--td><a href=dictionary&rs=listen&dict=ei&usageId&format=soundFileFormat alt=\"Offer your opinion on this translation.\">edit</a></td></tr>");
            }
        }
        if(!word.resultsFound()) {
            sb.append("<tr><td></td><td>No results found!</td></tr>");
        }
        sb.append("</table>");

        return sb.toString();
    }
    */

    /**
     * Replaces the '~' in 'words' with the word
     * returns the String containing the HREF for the 'word'
    private String getlinkedWords(String words, String searchWord, String language, String weight, String color) {
        words = Text.replaceCharactersInString(words, '~', searchWord);
        return linkize(words, searchWord, language);
    }
     */

    /*
    private String linkize(String words, String searchWord, String language, String toLanguage) {
        StringBuffer sb = new StringBuffer();
        StringTokenizer st = new StringTokenizer(words);
        int tokens = st.countTokens();
        int x = 0;
        while (st.hasMoreTokens()) {
            x++;
            String token = st.nextToken();
            if(Text.containsInvalidChars(token, invalidChars)) {
                StringBuffer invalid = new StringBuffer();
                StringBuffer valid = new StringBuffer();
                for(int i=0; i < token.length(); i++){
                    if(Validator.inValidChar(token.charAt(i), invalidChars)){
                        if(valid.length() >= 1) {
                            String newWord = linkize0(valid.toString(), searchWord, language, toLanguage);
                            sb.append(newWord);
                            valid = new StringBuffer();
                        }
                        invalid.append(token.charAt(i));
                    }else{
                        String newWord = null;
                        if(invalid.length() >= 1) {
                            newWord = invalid.toString();
                            sb.append(newWord);
                            invalid = new StringBuffer();
                        }
                        if(
                            ((newWord != null) && (newWord.equals("</"))) ||
                            ((newWord != null) && (newWord.equals("<")))
                          ) {  // temporary fix for when we have '</i>' or <i>
                            invalid.append(token.charAt(i));
                        } else {
                            valid.append(token.charAt(i));
                        }
                    }
                }
                if(valid.length() >= 1) {
                    String newWord = linkize0(valid.toString(), searchWord, language, toLanguage);
                    sb.append(newWord);
                    valid = new StringBuffer();
                }
                if(invalid.length() >= 1) {
                    String newWord = invalid.toString();
                    sb.append(newWord);
                    invalid = new StringBuffer();
                }
                if(tokens > x) sb.append(" ");
            } else {
                sb.append(linkize0(token, searchWord, language, toLanguage));
                if(tokens > x) sb.append(" ");
            }
        }
        String returned = sb.toString();
        return returned;
    }

    private String linkize(String words, String language, String toLanguage) {
        StringBuffer sb = new StringBuffer();
        StringTokenizer st = new StringTokenizer(words);
        int tokens = st.countTokens();
        int x = 0;
        while (st.hasMoreTokens()) {
            x++;
            String token = st.nextToken();
            if(Text.containsInvalidChars(token, invalidChars)) {
                StringBuffer invalid = new StringBuffer();
                StringBuffer valid = new StringBuffer();
                for(int i=0; i < token.length(); i++){
                    if(Validator.inValidChar(token.charAt(i), invalidChars)){
                        if(valid.length() >= 1) {
                            String newWord = linkize0(valid.toString(), language, toLanguage);
                            sb.append(newWord);
                            valid = new StringBuffer();
                        }
                        invalid.append(token.charAt(i));
                    }else{
                        String newWord = null;
                        if(invalid.length() >= 1) {
                            newWord = invalid.toString();
                            sb.append(newWord);
                            invalid = new StringBuffer();
                        }
                        if(
                            ((newWord != null) && (newWord.equals("</"))) ||
                            ((newWord != null) && (newWord.equals("<")))
                          ) {  // temporary fix for when we have '</i>' or <i>
                            invalid.append(token.charAt(i));
                        } else {
                            valid.append(token.charAt(i));
                        }
                    }
                }
                if(valid.length() >= 1) {
                    String newWord = linkize0(valid.toString(), language, toLanguage);
                    sb.append(newWord);
                    valid = new StringBuffer();
                }
                if(invalid.length() >= 1) {
                    String newWord = invalid.toString();
                    sb.append(newWord);
                    invalid = new StringBuffer();
                }
                if(tokens > x) sb.append(" ");
            } else {
                sb.append(linkize0(token, language, toLanguage));
                if(tokens > x) sb.append(" ");
            }
        }
        String returned = sb.toString();
        return returned;
    }

    private String linkize0(String word, String language, String toLanguage) {
        StringBuffer sb = new StringBuffer();
        //sb.append("<a href=\"").append(language).append("\\").append(word).append("\">").append(word).append("</a>");
        //sb.append("<a href=\"dictionary?language=").append(language).append("&word=").append(word).append("\">").append(word).append("</a>");
        sb.append("<a href=\"dictionary?language=").append(language).append("&toLanguage=").append(toLanguage).append("&word=").append(word).append("\">").append(word).append("</a>");
        return sb.toString();
    }

    private String linkize0(String word, String searchWord, String language, String toLanguage) {
        //logger.debug("linkize0('"+word+"', '"+searchWord+"', '"+language+"')");
        StringBuffer sb = new StringBuffer();
        //sb.append("<a href=\"").append(language).append("\\").append(word).append("\"");
        //sb.append("<a href=\"dictionary?language=").append(language).append("&word=").append(word).append("\"");
        //sb.append("<a href=\"dictionary?language=").append(this.fromLanguage).append("&toLanguage=").append(this.toLanguage).append("&word=").append(word).append("\"");
        sb.append("<a href=\"dictionary?language=").append(language).append("&toLanguage=").append(toLanguage).append("&word=").append(word).append("\"");
        if(word.toLowerCase().equalsIgnoreCase(searchWord)) {
            //sb.append("class=\"");
            //sb.append(weight);
            ////sb.append(color);
            //sb.append("color3");
            //sb.append("\">");
            sb.append(" style=\"");
            sb.append("color:#ff8f00;");
            sb.append("\"");
            //sb.append(" style=\"");
            //sb.append("color:").append(color).append(";");
            //sb.append("font-weight:").append(weight).append(";");
        } else {
            //sb.append("\"");
            //sb.append("class=\"");
            //sb.append(weight);
            //sb.append(color);
            //sb.append(" style=\"");
            //sb.append("color:").append(color).append(";");
            //sb.append("font-weight:").append(weight).append(";");
        }
        sb.append(">").append(word).append("</a>");
        return sb.toString();
    }
    */

    public String createHtml(Word word, String fromLanguage, String toLanguage) {
        log.trace("createHtml('"+word+"', '"+fromLanguage+"', '"+toLanguage+"')");
        log.debug("word.getDescription() = " + word.getDescription());
        StringBuilder stringBuilder = new StringBuilder();  // to hold the message body
        List definitionList = word.getDefinitionList();
        List usageList = word.getUsageList();
        stringBuilder.append("<div class=\"definition\">");
        stringBuilder
            .append("<div class=\"word-header\">")
            .append(  "<div class=\"language-label\">")
            .append(    "<span class=\"capitalize\">").append(fromLanguage).append("</span>").append(" word")
            .append(  "</div>")
            .append(  "<div class=\"word\">").append(word.getWord()).append("</div>");
        if (word.getDescription() != null) {
            stringBuilder.append(  "<span class=\"word-description\">").append(word.getDescription()).append("</span>");
        }
        stringBuilder.append("</div>");
        if ((definitionList != null) && definitionList.size() != 0) {
            log.debug("definitionList.size() = " + definitionList.size());
            stringBuilder.append("<div>");
            stringBuilder.append("<ol>");
            String type, gender, description;
            List sortedList = definitionList;
            for(int i = 0; i < sortedList.size(); i++) {
                Definition definition = (Definition) sortedList.get(i);
                log.debug("definition.getType() = " + definition.getType());
                log.debug("definition.getGender() = " + definition.getGender());
                log.debug("definition.getDescription() = " + definition.getDescription());
                type = definition.getType();
                gender = definition.getGender();
                description = definition.getDescription();
                //boolean hasType = !"".equals(type);
                //boolean hasGender = !"".equals(gender);
                //boolean hasDescription = !"".equals(description);
                boolean hasType = type != null && !type.equals("");
                boolean hasGender = gender != null && !gender.equals("");
                boolean hasDescription = description != null && !description.equals("");
                if((definition.getDefinition() != null) && !(definition.getDefinition().trim().equals(""))) {
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
                    stringBuilder
                        .append("&nbsp;<span class=\"definition\">")
                        .append(linkizeWords(definition.getDefinition(), toLanguage, fromLanguage))
                        .append("</span>");
                    /*
                    if(
                        hasType
                        || hasGender
                    ) {
                        stringBuilder.append("<span class=\"type\">(");
                        if(hasType) stringBuilder.append(type);
                        if(hasGender) {
                            if(hasType) stringBuilder.append(" ");
                            stringBuilder.append(gender);
                        }
                        stringBuilder.append(")</span>");
                    }
                    */
                    if (hasDescription) stringBuilder.append("<span class=\"description\">").append(description).append("</span>");
                    //stringBuilder.append("</div>");
                    stringBuilder.append("</li>");
                }
            }
            stringBuilder.append("</ol>");
            stringBuilder.append("</div>");
        }
        if ((usageList != null) && (usageList.size() > 0)) {
            stringBuilder.append("<div class=\"usage\">");
            //stringBuilder.append("<div class=\"word-header\">Example usage:</div>");
            stringBuilder.append("<div class=\"word-header\">")
                .append("<span class=\"language-label\">")
                .append("Example usage")
                .append("</span>")
                .append("</div>");
            stringBuilder.append("<ol>");
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
                stringBuilder.append("<li>");
                //stringBuilder.append("<div style=\"padding-left:50px;\">");
                stringBuilder.append("<div>");
                //stringBuilder.append("<li>").append(fromLanguage).append(": ");
                //stringBuilder.append("<span class=\"description\" style=\"color:#aaa;margin-left:-33px;\">").append(fromLanguage).append(" ").append("</span>");
                stringBuilder.append("<span class=\"usage-label "+fromLanguage+"\">").append(fromLanguage).append(" ").append("</span>");
                //stringBuilder.append("<span class=\"description\">").append(fromLanguage).append(": ").append("</span>");
                if (hasUsage) {
                    stringBuilder.append("<span class=\"usage\">").append(linkizeUsage(usage, word.getWord(), fromLanguage, toLanguage)).append("</span>");
                    if (hasDescription && ENGLISH.equals(fromLanguage)) stringBuilder.append("<span class=\"description\">").append(description).append("</span>");
                }
                stringBuilder.append("<br/>");
                if (hasUsageTranslated) {
                    //stringBuilder.append("<span class=\"description\" style=\"color:#aaa;margin-left:-50px;\">").append(toLanguage).append(" ").append("</span>");
                    //stringBuilder.append("<span class=\"description\" style=\"margin-left:-50px;\">").append(toLanguage).append(" ").append("</span>");
                    stringBuilder.append("<span class=\"usage-label "+toLanguage+"\">").append(toLanguage).append(" ").append("</span>");
                    //stringBuilder.append("<span class=\"description\">").append(toLanguage).append(": ").append("</span>");
                    stringBuilder.append("<span class=\"translated\">");
                    stringBuilder.append(linkizeWords(usageTranslated, toLanguage, fromLanguage));
                    stringBuilder.append("</span>");
                }
                if (hasSuffix) stringBuilder.append("<span class=\"description\">").append(plusSuffix).append("</span>");
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
                if (hasDescription && IRISH.equals(fromLanguage)) stringBuilder.append("<span class=\"description\">").append(description).append("</span>");
                stringBuilder.append("</div>");
                stringBuilder.append("</li>");
            }
            stringBuilder.append("</ol>");
            stringBuilder.append("</div>"); // <div class="usage">
            //stringBuilder.append("</div>");
        }
        stringBuilder.append("</div>");  // <div class="definition">
        return stringBuilder.toString();
    }

    public String linkizeWords(String words, String fromLanguage, String toLanguage) {
        log.trace("linkizeWords('" + words + "', '" + fromLanguage + "', '" + toLanguage + "')");
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
        log.trace("linkizeUsage('" + words + "', '" + searchWord + "', '" + fromLanguage + "', '" + toLanguage + "')");
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

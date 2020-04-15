package online.irishdictionary.taglib;

import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import online.irishdictionary.model.Definition;
import online.irishdictionary.model.Usage;
import online.irishdictionary.model.Word;
import online.irishdictionary.util.Text;
import online.irishdictionary.util.Validator;

/**
 * @author  Dermot Doherty
 * @version 1.0 - 4/18/2011 11:32PM
 */
public class WordTag implements Tag {

    private static final Logger logger = LogManager.getLogger();

    private String invalidChars = "_-!@#$%^&*()+[]=\\|?/'\",.<>`~:; ";
    protected PageContext pageContext;
    protected Tag parent;

    public void setPageContext(PageContext pageContext) {
        this.pageContext = pageContext;
    }
    public void setParent(Tag parent) {
        this.parent = parent;
    }
    public Tag getParent() {
        return parent;
    }
    public int doStartTag() throws JspException {
        //logger.debug("doStartTag()");

        JspWriter out = this.pageContext.getOut();
        Word word = (Word) pageContext.getAttribute("word");
        String fromLanguage = (String) pageContext.getAttribute("fromLanguage");
        String toLanguage = (String) pageContext.getAttribute("toLanguage");

        logger.debug("word.getWord() = " + word.getWord());
        logger.debug("fromLanguage = " + fromLanguage);
        logger.debug("toLanguage = " + toLanguage);

        try {

            if(word != null) {

                /*
                //DefinitionUtil wordUtil = new DefinitionUtil(fromLanguage, toLanguage);
                //logger.debug("doStartTag(): wordUtil.generateWordTextHTML(word) = "+wordUtil.generateWordTextHTML(word));
                //out.print(wordUtil.linkize(word));
                out.print(wordUtil.linkize(word, fromLanguage, toLanguage));
                */
                //DefinitionUtil wordUtil = new DefinitionUtil();
                //out.print(wordUtil.linkize(word, fromLanguage, toLanguage));
                out.print(createHtml(word, fromLanguage, toLanguage));
                
            }

        } catch(java.io.IOException e) {
            System.out.println("IO Error: " + e.getMessage());
            throw new JspTagException("IO Error: " + e.getMessage());
        }
        return (SKIP_BODY);
        //return EVAL_BODY_INCLUDE;
    }

    public int doEndTag() throws JspException {
        return (EVAL_PAGE);
    }

    public void release() {
    }

    /*
     * Accessor methods
     */
    protected String linked;

    public void setLinked(String linked) {
        // always upper case
        this.linked = linked.toUpperCase();
    }

    public String getLinked() {
        return linked;
    }

    public String createHtml(Word word, String fromLanguage, String toLanguage) {
        logger.trace("createHtml('"+word.getWord()+"', '"+fromLanguage+"', '"+toLanguage+"')");

        StringBuffer stringBuilder = new StringBuffer();  // to hold the message body
        List definitionList = word.getDefinitionList();
        List usageList = word.getUsageList();

        stringBuilder.append("<div class=\"definition\">");

        stringBuilder
          .append("<div class=\"word-header\">")
          .append("<span class=\"language-label\">").append(fromLanguage).append("</span>").append(" word: ")
          .append("<span class=\"word\">").append(word.getWord()).append("</span>")
          .append("</div>");

        if((definitionList != null) && definitionList.size() != 0) {

            logger.debug("definitionList.size() = " + definitionList.size());

            stringBuilder.append("<div>");
            stringBuilder.append("<ol>");

            String type, gender, description;
            List sortedList = definitionList;

            for(int i = 0; i < sortedList.size(); i++) {

                Definition definition = (Definition)sortedList.get(i);

                logger.debug("definition.getType() = " + definition.getType());
                logger.debug("definition.getGender() = " + definition.getGender());
                logger.debug("definition.getDescription() = " + definition.getDescription());

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
                    /*
                    stringBuilder.append("<div class=\"table\">");
                    stringBuilder.append("<div class=\"row\">");
                    stringBuilder.append("<div class=\"cell\">");
                    */
                    stringBuilder.append("<li>");
                    //stringBuilder.append(word.getWord());
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
                        .append("&nbsp;<span class=\"definition\"\">")
                        .append(linkize(definition.getDefinition(), toLanguage, fromLanguage))
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

                    /*
                    if(hasDescription) {
                        //stringBuilder.append("<span class=\"description\"> " + generateHrefOnWords(definition.getDescription(), "english", "normal", "color1") + "</span>");
                        //stringBuilder.append("<span class=\"description\">" + generateHrefOnWords(definition.getDescription(), "english", "normal", "color1") + "</span>");
                        stringBuilder.append("<span class=\"description\">"+description+"</span>");
                    }
                    */

                    stringBuilder.append("</li>");
                }
            }
            stringBuilder.append("</ol>");
            stringBuilder.append("</div>");
        }

        if((usageList != null) && (usageList.size() > 0)) {

            stringBuilder.append("<div class=\"usage\">");

            stringBuilder.append("<div class=\"word-header\">Usage:</div>");

            //stringBuilder.append("<div>");
            stringBuilder.append("<ol>");

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


                stringBuilder.append("<li>");

                if(hasUsage) {
                    stringBuilder.append(linkize(usage, word.getWord(), fromLanguage, toLanguage));
                }

                stringBuilder.append(" <span style=\"color:#ff8f00;\">=</span> ");

                if(hasUsageTranslated) {
                    stringBuilder.append("<span class=\"translated\">");
                    stringBuilder.append(linkize(usageTranslated, toLanguage, fromLanguage));
                    stringBuilder.append("</span>");
                }

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

                stringBuilder.append("</li>");
            }
            stringBuilder.append("</ol>");
            stringBuilder.append("</div>");
            stringBuilder.append("</div>");
        }

        stringBuilder.append("</div>");

        return stringBuilder.toString();
    }

    private String linkize(String words, String language, String toLanguage) {
        logger.trace("linkize('" + words + "', '" + language + "', '" + toLanguage + "')");

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
        logger.trace("linkize0('" + word + "', '" + language + "', '" + toLanguage + "')");
        StringBuffer sb = new StringBuffer();
        sb.append("<a href=\"dictionary?language=").append(language).append("&toLanguage=").append(toLanguage).append("&word=").append(word).append("\">").append(word).append("</a>");
        return sb.toString();
    }

    private String linkize(String words, String searchWord, String language, String toLanguage) {
        logger.trace("linkize('" + words + "', '" + searchWord + "', '" + language + "', '" + toLanguage + "')");

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

    private String linkize0(String word, String searchWord, String language, String toLanguage) {
        logger.debug("linkize0('"+word+"', '"+searchWord+"', '"+language+"')");

        StringBuffer sb = new StringBuffer();
        //sb.append("<a href=\"").append(language).append("\\").append(word).append("\"");
        //sb.append("<a href=\"dictionary?language=").append(language).append("&word=").append(word).append("\"");
        //sb.append("<a href=\"dictionary?language=").append(this.fromLanguage).append("&toLanguage=").append(this.toLanguage).append("&word=").append(word).append("\"");
        sb.append("<a href=\"dictionary?language=").append(language).append("&toLanguage=").append(toLanguage).append("&word=").append(word).append("\"");

        if(word.toLowerCase().equalsIgnoreCase(searchWord)) {

            sb.append(" style=\"");
            sb.append("color:#ff8f00;");
            sb.append("\"");

        } else {

            /*
            sb.append("\"");
            sb.append("class=\"");
            sb.append(weight);
            sb.append(color);
            */

            /*
            sb.append(" style=\"");
            sb.append("color:").append(color).append(";");
            sb.append("font-weight:").append(weight).append(";");
            */

        }

        sb.append(">").append(word).append("</a>");

        return sb.toString();
    }

}

package online.irishdictionary.taglib;

import java.util.List;
import java.util.StringTokenizer;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;
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

    private static final org.apache.logging.log4j.Logger log = org.apache.logging.log4j.LogManager.getLogger();
    private static final String EMPTY = "";
    private static final String ENGLISH = "english";
    private static final String IRISH = "irish";
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
        //log.debug("doStartTag()");

        JspWriter jspWriter = this.pageContext.getOut();
        Word word = (Word) pageContext.getAttribute("word");
        String fromLanguage = (String) pageContext.getAttribute("fromLanguage");
        String toLanguage = (String) pageContext.getAttribute("toLanguage");
        log.debug("word.getWord() = " + word.getWord());
        log.debug("fromLanguage = " + fromLanguage);
        log.debug("toLanguage = " + toLanguage);

        try {
            if (word != null) {
                jspWriter.print(createHtmlDefinition(word, fromLanguage, toLanguage));
            }
        } catch (java.io.IOException e) {
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

    public String createHtmlDefinition(Word word, String fromLanguage, String toLanguage) {
        //log.trace("createHtmlDefinition('"+word.getWord()+"', '"+fromLanguage+"', '"+toLanguage+"')");

        StringBuilder stringBuilder = new StringBuilder();  // to hold the message body
        List definitionList = word.getDefinitionList();
        List usageList = word.getUsageList();

        stringBuilder.append("<div class=\"definition\">");

        stringBuilder
          .append("<div class=\"word-header\">")
          .append("<span class=\"language-label\">").append(fromLanguage).append("</span>")
          .append(" word: ")
          .append("<span class=\"word\">").append(word.getWord()).append("</span>")
          .append("</div>");

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
                    stringBuilder.append("<li>");
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
                    stringBuilder.append("</li>");
                }
            }
            stringBuilder.append("</ol>");
            stringBuilder.append("</div>");
        }

        if ((usageList != null) && (usageList.size() > 0)) {
            stringBuilder.append("<div class=\"usage\">");
            stringBuilder.append("<div class=\"word-header\">Example usage:</div>");
            stringBuilder.append("<ol>");
            //List sortedList = (List) usageList.getSortedList("usageLength");
            List sortedList = usageList;
            int start = word.getStartUsageIndex();
            int end = sortedList.size();
            if(usageList.size() > word.getEndUsageIndex()) {
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
                boolean hasUsage = !"".equals(usage);
                boolean hasUsageTranslated = !"".equals(usageTranslated);
                boolean hasType = !"".equals(type);
                boolean hasDescription = !"".equals(description);
                boolean hasSuffix = !EMPTY.equals(plusSuffix);
                stringBuilder.append("<li>");
                if (hasUsage) {
                    stringBuilder.append(linkizeUsage(usage, word.getWord(), fromLanguage, toLanguage));
                    if (hasDescription && ENGLISH.equals(fromLanguage)) stringBuilder.append("<span class=\"description\">").append(description).append("</span>");
                }
                stringBuilder.append("<br/>");
                if (hasUsageTranslated) {
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
                stringBuilder.append("</li>");
            }
            stringBuilder.append("</ol>");
            stringBuilder.append("</div>");
            stringBuilder.append("</div>");
        }
        stringBuilder.append("</div>");  // stringBuilder.append("<div class=\"definition\">");
        return stringBuilder.toString();
    }

    private String linkizeWords(String words, String fromLanguage, String toLanguage) {
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
            .append("<a href=\"/")
            .append(fromLanguage)
            .append("/").append(toLanguage)
            .append("/").append(word)
            .append("\">")
            .append(word)
            .append("</a>")
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
        //log.trace("addHrefUsage('"+word+"', '"+searchWord+"', '" + fromLanguage + "', '" + toLanguage + "')");

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
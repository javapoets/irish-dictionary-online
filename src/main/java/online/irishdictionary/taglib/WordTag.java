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
import online.irishdictionary.util.DefinitionOutput;

/**
 * @author  Dermot Doherty
 * @version 1.0 - 4/18/2011 11:32PM
 */
public class WordTag implements Tag {

    private static final org.apache.logging.log4j.Logger log = org.apache.logging.log4j.LogManager.getLogger();
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
                DefinitionOutput definitionOutput = new DefinitionOutput();
                jspWriter.print(definitionOutput.createHtml(word, fromLanguage, toLanguage));
                //jspWriter.print(createHtmlDefinition(word, fromLanguage, toLanguage));
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

    protected String linked;

    public void setLinked(String linked) {
        // always upper case
        this.linked = linked.toUpperCase();
    }

    public String getLinked() {
        return linked;
    }
}
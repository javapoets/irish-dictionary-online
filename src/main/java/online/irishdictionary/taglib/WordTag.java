package online.irishdictionary.taglib;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import online.irishdictionary.model.Word;
import online.irishdictionary.util.DefinitionUtil;

/**
 * @author  Dermot Doherty
 * @version 1.0 - 4/18/2011 11:32PM
 */
public class WordTag implements Tag {

    private static final Logger logger = LogManager.getLogger();

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
        Word word = (Word)pageContext.getAttribute("word");

        String fromLanguage = (String)pageContext.getAttribute("fromLanguage");
        String toLanguage = (String)pageContext.getAttribute("toLanguage");

        //logger.debug("doStartTag(): word = "+word.getWord());
        //logger.debug("doStartTag(): fromLanguage = "+fromLanguage);
        //logger.debug("doStartTag(): toLanguage = "+toLanguage);

        try {

            if(word != null) {

                //DefinitionUtil wordUtil = new DefinitionUtil(fromLanguage, toLanguage);
                DefinitionUtil wordUtil = new DefinitionUtil();
                //logger.debug("doStartTag(): wordUtil.generateWordTextHTML(word) = "+wordUtil.generateWordTextHTML(word));
                //out.print(wordUtil.linkize(word));
                out.print(wordUtil.linkize(word, fromLanguage, toLanguage));

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
    //
    // Accessor methods
    //
    // Attribute: type
    protected String linked;

    public void setLinked(String linked) {
        // always upper case
        this.linked = linked.toUpperCase();
    }

    public String getLinked() {
        return linked;
    }
}

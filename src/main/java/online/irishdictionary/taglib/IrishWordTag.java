package online.irishdictionary.taglib;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;

import online.irishdictionary.model.Word;
import online.irishdictionary.util.WordUtil;

public class IrishWordTag implements Tag {

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

        JspWriter out = this.pageContext.getOut();
        Word irishWord = (Word)pageContext.getAttribute("irishWord");

        /*
        try {
            if(irishWord != null) {
                WordUtil wordUtil = new WordUtil();
                out.print(wordUtil.generateWordTextHTMLIrish(irishWord));
            }

        } catch(java.io.IOException e) {
            throw new JspTagException("IO Error: " + e.getMessage());
        }
        */
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

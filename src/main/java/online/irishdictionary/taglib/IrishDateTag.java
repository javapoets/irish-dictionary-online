package online.irishdictionary.taglib;

import java.util.Calendar;
import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.JspTagException;
import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.tagext.Tag;
import jakarta.servlet.jsp.PageContext;

public class IrishDateTag implements Tag {

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
        Calendar calendar = Calendar.getInstance();
        try {
            IrishDate irishDate = new IrishDate(calendar);
            out.print(irishDate.getIrishDate());
        } catch(java.io.IOException e) {
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

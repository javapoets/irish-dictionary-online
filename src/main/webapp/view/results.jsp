<%@ include file="/view/header.jsp" %>

<%

    Word word = (Word) request.getAttribute("word");
    logger.debug("word = " + word);

    if(word != null) pageContext.setAttribute("word", word);

    String emailSent = (String)request.getAttribute("emailSent");

    String wordEnglish = null;
    String wordIrish = null;
    String verbEnglish = null;
    String verbIrish = null;

    String verbParam = request.getParameter("verb");
    String wordParam = request.getParameter("word");
    String language = request.getParameter("language");

    logger.debug("verbParam = " + verbParam);
    logger.debug("wordParam = " + wordParam);
    logger.debug("language = " + language);

    if(language != null) {
        if(language.equals("english")) {
            if(wordParam != null) wordEnglish = wordParam;
            if(verbParam != null) verbEnglish = verbParam;
        } else if(language.equals("irish")) {
            if(wordParam != null) wordIrish = wordParam;
            if(verbParam != null) verbIrish = verbParam;
        }
    }

    String fromLanguage = language;
    //String fromLanguage = request.getParameter("fromLanguage");
    //if(fromLanguage == null) fromLanguage = (String)request.getAttribute("fromLanguage");
    //if(fromLanguage == null) fromLanguage = language;
    String toLanguage = request.getParameter("toLanguage");
    if(toLanguage == null) toLanguage = (String)request.getAttribute("toLanguage");
    //System.out.println("results.jsp: fromLanguage = "+fromLanguage);
    //System.out.println("results.jsp: toLanguage = "+toLanguage);
    pageContext.setAttribute("fromLanguage", fromLanguage);
    pageContext.setAttribute("toLanguage", toLanguage);

%>
                      
<%--
<div style="padding-top:108px;padding-bottom:108px;width:728px;text-align:center;margin:auto;">
<div style="padding-top:108px;padding-bottom:108px;max-width:728px;text-align:center;margin:auto;">
  <div style="text-align:center;margin:auto;">
--%>
<div class="container" style=" border: blue 0px solid; height: 100%; text-align: center;  vertical-align: top; margin: auto; margin-top: 0px; padding: 0px; ">

  <div style=" text-align: center; margin: auto; margin-top: 0px; border: green 1px solid; width: 100%; max-width: var(--sitewidth); ">

<%--
    <div style="text-align:left;margin:0px auto 0xp 0px;">
                            
      <div class="table">
        <div class="row">
          <div class="cell" style="vertical-align:top;">
            <a href="<%= contextUrl %>"><img src="<%= imagesUrl %>Irish-Dictionary-Online-Logo.jpg" border="0" title="Irish Dictionary Online"></a>
          </div>
          <div class="cell" style="vertical-align:middle;margin:auto;width:100%;">
            <%@ include file="/view/topForm.jsp" %>
          </div>
        </div>
      </div>
    </div>
--%>
    <div class="header">
      <div>
        <a href="<%= contextUrl %>"><img src="<%= imagesUrl %>Irish-Dictionary-Online-Logo.jpg" border="0" title="Irish Dictionary Online"></a>
      </div>
      <div>
        <%--@ include file="/view/topForm.jsp" --%>
        <%--@ include file="/view/entryForm.jsp" --%>
        <%@ include file="/view/entry-form.jsp" %>
      </div>
    </div>


    <div>
      <% if(word != null) { %>
        <irishdictionary:word />
      <% } %>
    </div>

  </div>
</div>

<%@ include file="/view/footer.jsp" %>

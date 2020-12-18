<%@ include file="/view/header.jsp" %>
<%
    Verb verb = (Verb) request.getAttribute("verb");
    Map verbConjugationMap = verb.getVerbConjugationMap();
    log.debug("verbConjugationMap.size() = " + verbConjugationMap.size());
    System.out.println("verbConjugationMap = " + verbConjugationMap);
    String verbString = (String)request.getAttribute("verbString");
    List<Verb> verbList = (List<Verb>) verb.getVerbList();
    int count = 0;
    if(verbList != null) count = verbList.size();
    String EMPTY = "";
    String SPACE = " ";
    String ENGLISH = "english";
    String IRISH = "irish";
    String wordEnglish = null;
    String wordIrish = null;
    String verbEnglish = null;
    String verbIrish = null;
    String language = request.getParameter("language");
    String verbParam = request.getParameter("verb");
    log.debug("language = " + language);
    log.debug("verbParam = " + verbParam);
    if(language != null) {
        if(language.equals("english")) {
            if(verbParam != null) verbEnglish = verbParam;
        } else if(language.equals("irish")) {
            if(verbParam != null) verbIrish = verbParam;
        }
    }
    String fromLanguage = language;
    //String fromLanguage = request.getParameter("fromLanguage");
    //if(fromLanguage == null) fromLanguage = (String)request.getAttribute("fromLanguage");
    //if(fromLanguage == null) fromLanguage = language;
    String toLanguage = request.getParameter("toLanguage");
    if(toLanguage == null) toLanguage = (String)request.getAttribute("toLanguage");
    log.debug("fromLanguage = " + fromLanguage);
    log.debug("toLanguage = " + toLanguage);
    boolean isEnglish = language.equals("english");
    boolean isIrish = language.equals("irish");
%>
<%!
    String LEFT_PARENTHESIS = "(";
    String RIGHT_PARENTHESIS = ")";
    public String parenthesis(String string) {
        return new StringBuilder().append(LEFT_PARENTHESIS).append(string).append(RIGHT_PARENTHESIS).toString();
    }
%>

<%--
<div style="padding-top:108px;padding-bottom:108px;max-width:728px;text-align:center;margin:auto;">
    <div class="flex-container" style="height: 100%; text-align: center; vertical-align: top; margin: auto; margin-top: 0px; padding: 0px;">
--%>
    <div class="flex-container">
      <div style="text-align: center; margin: auto; margin-top: 0px; width: 100%; max-width: var(--site-width);">
        <div class="header">
          <div style="padding: 13px 42px; width: 200px;">
            <a href="<%= contextUrl %>"><img src="<%= imagesUrl %>Irish-Dictionary-Online-Logo.jpg" border="0" title="Irish Dictionary Online"></a>
          </div>
          <div class="search-block">
            <%@ include file="/view/topForm.jsp" %>
            <%--@ include file="/view/entry-form.jsp" --%>
          </div>
        </div>
        <div style="padding-bottom: 40px;">
          <% if(verb != null) { %>
            <%@ include file="/view/verb/verb-output.jsp" %>
          <% } %>
        </div>
      </div>
    </div>
    <%@ include file="/view/footer.jsp" %>


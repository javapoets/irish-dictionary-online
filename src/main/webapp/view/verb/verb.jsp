<%@ page
    language="java"
    contentType="text/html;charset=UTF-8"
    pageEncoding="UTF-8"
    session="false" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.Set" %>
<%@ page import="online.irishdictionary.model.Word" %>
<%@ page import="online.irishdictionary.model.Verb" %>
<%@ page import="online.irishdictionary.model.VerbConjugation" %>
<%@ page import="online.irishdictionary.util.DefinitionOutput" %>
<%@ include file="/view/log.jsp" %>
<%
    String contextUrl = (String)application.getAttribute("contextUrl");
    String imagesUrl = contextUrl + "view/images/";
    log.debug("contextUrl = " + contextUrl);
    Verb verb = (Verb) request.getAttribute("verb");
    Map verbConjugationMap = null;
    String verbString = null;
    List<Verb> verbList = null;
    int count = 0;
    if (verb != null) {
        verbConjugationMap = verb.getVerbConjugationMap();
        log.debug("verbConjugationMap.size() = " + verbConjugationMap.size());
        verbString = (String)request.getAttribute("verbString");
        verbList = (List<Verb>) verb.getVerbList();
        if(verbList != null) count = verbList.size();
    }
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
    log.debug("language = " + language);
    log.debug("fromLanguage = " + fromLanguage);
    log.debug("toLanguage = " + toLanguage);
    boolean isEnglish = false;
    if (ENGLISH.equals(language)) {
        isEnglish = true;
    }
    boolean isIrish = language.equals("irish");
    log.debug("isEnglish = " + isEnglish);
    DefinitionOutput definitionOutput = new DefinitionOutput();
%>
<%!
    String LEFT_PARENTHESIS = "(", RIGHT_PARENTHESIS = ")";
    public String parenthesis(String string) {
        return new StringBuilder().append(LEFT_PARENTHESIS).append(string).append(RIGHT_PARENTHESIS).toString();
    }
%>
<%@ taglib uri="/WEB-INF/irishdictionary.tld" prefix="irishdictionary" %>
<%@ taglib prefix="javapoets" tagdir="/WEB-INF/tags" %>
<!doctype html>
<html>
  <head>
    <%@ include file="/view/head.jsp" %>
  </head>
  <body>
    <%@ include file="/view/ads-responsive.jsp" %>
    <div class="centering-container">
      <div class="table">
        <%@ include file="/view/row-header.jsp" %>
        <div class="row">
          <div class="cell">
            <div style="padding-bottom: 40px;">
              <% if(verb != null) { %>
                <%@ include file="/view/verb/verb-output.jsp" %>
              <% } else { %>
                <div class="usage description definition">
                  <div class="word-header">
                    <span class="language-label"><%= fromLanguage %> verb</span>
                    <span class="word"><% if (verbParam != null) { %><%= verbParam %><% } %></span>
                    <span class="language-label" style="padding-left: 8px;">not found!</span>
                  </div>
                </div>
              <% } %>
            </div>
          </div>
        </div>
        <%@ include file="/view/row-footer.jsp" %>
      </div>
    </div>
  </body>
</html>
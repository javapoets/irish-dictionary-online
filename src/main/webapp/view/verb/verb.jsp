<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
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
    int verbListSize = 0;
    if (verb != null) {
        verbConjugationMap = verb.getVerbConjugationMap();
        log.debug("verbConjugationMap.size() = " + verbConjugationMap.size());
        verbString = (String)request.getAttribute("verbString");
        verbList = (List<Verb>) verb.getVerbList();
        if(verbList != null) {
            verbListSize = verbList.size();
        }
    }
    String EMPTY = "";
    String SPACE = " ";
    String ENGLISH = "english";
    String IRISH = "irish";
    String wordEnglish = null;
    String wordIrish = null;
    String verbEnglish = null;
    String verbIrish = null;

    //String language = request.getParameter("language");
    String fromLanguage = (String)request.getAttribute("fromLanguage");
    //String verbParam = request.getParameter("verb");
    String verbParam = request.getParameter("verbParam");
    log.debug("fromLanguage = " + fromLanguage);
    log.debug("verbParam = " + verbParam);
    if(fromLanguage != null) {
        if(fromLanguage.equals(ENGLISH)) {
            if(verbParam != null) verbEnglish = verbParam;
        } else if(fromLanguage.equals(IRISH)) {
            if(verbParam != null) verbIrish = verbParam;
        }
    }
    //String fromLanguage = request.getParameter("fromLanguage");
    //if(fromLanguage == null) fromLanguage = (String)request.getAttribute("fromLanguage");
    //if(fromLanguage == null) fromLanguage = language;
    String toLanguage = request.getParameter("toLanguage");
    if(toLanguage == null) toLanguage = (String)request.getAttribute("toLanguage");
    log.debug("fromLanguage = " + fromLanguage);
    log.debug("toLanguage = " + toLanguage);
    boolean isEnglish = false;
    if (ENGLISH.equals(fromLanguage)) {
        isEnglish = true;
    }
    boolean isIrish = fromLanguage.equals("irish");
    log.debug("isEnglish = " + isEnglish);
    log.debug("isIrish = " + isIrish);
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
<%@ include file="/view/lang-resource-bundle.jsp" %>
<!doctype html>
<html lang="<%= lang %>">
  <head>
    <%@ include file="/view/head.jsp" %>
  </head>
  <body>
    <%--@ include file="/view/google-ads-responsive-360x90-728x90.jsp" --%>
    <div class="centering-container">
      <div class="table">
        <%@ include file="/view/row-select-language.jsp" %>
        <%@ include file="/view/row-nav.jsp" %>
        <%@ include file="/view/row-header.jsp" %>
        <div class="row">
          <div class="cell">
            <div style="padding-bottom: 40px;">
              <% if(verb != null) { %>
                <%@ include file="/view/verb/verb-output.jsp" %>
              <% } else { %>
                <div class="usage description definition">
                  <div class="word-header">
                    <%--<span class="language-label"><%= fromLanguage %> verb</span>--%>
                    <%--<span class="language-label"><%= fromLanguage %> verb</span>--%>
                    <span class="language-label">
                        <%= resourceBundles.getString(fromLanguage +" verb") %>
                    </span>
                    <span class="word"><% if (verbParam != null) { %><%= verbParam %><% } %></span>
                    <span class="language-label" style="padding-left: 8px;"><%= resourceBundles.getString("not found") %>!</span>
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
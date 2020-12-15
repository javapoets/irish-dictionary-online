<%--@ include file="/view/header.jsp" --%>
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
<%@ include file="/view/log.jsp" %>
<%
    String contextUrl = (String)application.getAttribute("contextUrl");
    String imagesUrl = contextUrl + "view/images/";
    log.debug("contextUrl = " + contextUrl);
    Word word = (Word) request.getAttribute("word");
    String fromLanguage = (String)request.getAttribute("fromLanguage");
    String toLanguage = (String)request.getAttribute("toLanguage");
    log.debug("word = " + word);
    log.debug("fromLanguage = "+fromLanguage);
    log.debug("toLanguage = "+toLanguage);
    pageContext.setAttribute("fromLanguage", fromLanguage);
    pageContext.setAttribute("toLanguage", toLanguage);
    if(word != null) pageContext.setAttribute("word", word);
    String wordEnglish = null;
    String wordIrish = null;
    //String verbEnglish = null;
    //String verbIrish = null;
    //String verbParam = request.getParameter("verb");
    //String wordParam = request.getParameter("word");
    //String language = request.getParameter("language");
    //log.debug("verbParam = " + verbParam);
    //log.debug("wordParam = " + wordParam);
    //log.debug("language = " + language);
    if(fromLanguage != null) {
        if(fromLanguage.equals("english")) {
            if(word != null) wordEnglish = word.getWord();
            //if(verbParam != null) verbEnglish = verbParam;
        } else if(fromLanguage.equals("irish")) {
            if(word != null) wordIrish = word.getWord();
            //if(verbParam != null) verbIrish = verbParam;
        }
    }
%>
<%@ taglib uri="/WEB-INF/irishdictionary.tld" prefix="irishdictionary" %>
<%@ taglib prefix="javapoets" tagdir="/WEB-INF/tags" %>
<!doctype html>
<html>
  <head>
    <%@ include file="/view/head.jsp" %>
    <style type="text/css">
      body div.entry-form > div
      {
        /*border: blue 1px solid;*/
        padding: 9px;
      }

      @media (min-width: 670px) {
        body div.entry-form > div
        {
          padding: 5px;
          /*border: red 1px solid;*/
        }
        .search-block
        {
          margin-left: 0px;    
        }
      }
    </style>
  </head>
  <body>              
    <div class="flex-container" style="height: 100%; text-align: center; vertical-align: top; margin: auto; margin-top: 0px; padding: 0px;">
      <div style="text-align: center; margin: auto; margin-top: 0px; width: 100%; max-width: var(--site-width);">
        <div class="header">
          <div style="padding: 13px 42px; width: 200px;">
            <a href="<%= contextUrl %>"><img src="<%= imagesUrl %>Irish-Dictionary-Online-Logo.jpg" border="0" title="Irish Dictionary Online"></a>
          </div>
          <div class="search-block">
            <%@ include file="/view/entry-form.jsp" %>
          </div>
        </div>
        <div style="padding-bottom: 40px;">
          <% if(word != null) { %>
            <irishdictionary:word />
          <% } %>
        </div>
      </div>
    </div>
    <%@ include file="/view/footer.jsp" %>

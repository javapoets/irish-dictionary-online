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
    String verbEnglish = null;
    String verbIrish = null;
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
  </head>
  <body>
    <%@ include file="/view/ads-responsive.jsp" %>
    <div class="centering-container">
      <div class="table">
        <%@ include file="/view/row-header.jsp" %>
        <div class="row">
          <div class="cell">
            <div style="padding-bottom: 40px;">
              <% if(word != null) { %>
                <irishdictionary:word />
              <% } %>
            </div>
          </div>
        </div>
        <div class="row">
          <div class="cell">
            <div>
              <%@ include file="/view/footer/footer-copyright.jsp" %>
            </div>
          </div>
        </div>
      </div>
    </div>
  </body>
</html>
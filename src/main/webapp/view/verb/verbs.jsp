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
<%@ include file="/view/log.jsp" %>
<%
    String contextUrl = (String)application.getAttribute("contextUrl");
    String imagesUrl = contextUrl + "view/images/";
    log.debug("contextUrl = " + contextUrl);
    List<Verb> verbList = (List<Verb>)request.getAttribute("verbList");
    log.debug("verbList.size() " + verbList.size());
    String language = (String)request.getAttribute("language");
    String toLanguage = (String)request.getAttribute("toLanguage");
    String wordEnglish = null;
    String wordIrish = null;
    String verbEnglish = null;
    String verbIrish = null;
%>
<!doctype html>
<html>
  <head>
    <%@ include file="/view/head.jsp" %>
  </head>
  <body>
    <%@ include file="/view/google-ads-responsive-360x90-728x90.jsp" %>
    <div class="centering-container">
      <div class="table">
        <%@ include file="/view/row-header.jsp" %>
        <div class="row">
          <div class="cell">
            <div style="padding-bottom: 40px;">
              <div class="verbs-header">
                <span class="language-label"><span class="capitalize"><%= language %></span> verbs</span>
              </div>
              <% if(verbList != null) { %>
                <%@ include file="/view/verb/verbs-output.jsp" %>
              <% } %>
            </div>
          </div>
        </div>
        <%@ include file="/view/row-footer.jsp" %>
      </div>
    </div>
  </body>
</html>
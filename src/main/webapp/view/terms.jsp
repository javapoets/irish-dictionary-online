<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
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
        <%@ include file="/view/row-menu.jsp" %>
        <%@ include file="/view/row-header.jsp" %>
        <div class="row">
          <div class="cell">
            <div style="padding: 0px 40px 40px 40px;">
              <%@ include file="/view/terms-content.jsp" %>
            </div>
          </div>
        </div>
        <%@ include file="/view/row-footer.jsp" %>
      </div>
    </div>
  </body>
</html>
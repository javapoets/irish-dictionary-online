<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
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
    List<Verb> englishVerbList = (List<Verb>)request.getAttribute("englishVerbList");
    log.debug("englishVerbList.size() " + englishVerbList.size());
    List<Verb> irishVerbList = (List<Verb>)request.getAttribute("irishVerbList");
    log.debug("irishVerbList.size() " + irishVerbList.size());
    String language = (String)request.getAttribute("language");
    String toLanguage = (String)request.getAttribute("toLanguage");
    String wordEnglish = null;
    String wordIrish = null;
    String verbEnglish = null;
    String verbIrish = null;
%>
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
        <%@ include file="/view/row-header-verbs.jsp" %>
        <div class="row">
          <div class="cell">
            <div style="display: flex; flex-wrap: wrap; justify-content: space-evenly; ">
              <div style="flex-grow: 1;; padding-left :8px;">
                <%@ include file="/view/verb/verbs-output-english-irish.jsp" %>
              </div>
              <div style="flex-grow: 1; border-left: #ccc 1px solid; padding-left :8px;">
                <%@ include file="/view/verb/verbs-output-irish.jsp" %>
              </div>
            </div>

          </div>
        </div>
        <%@ include file="/view/row-footer.jsp" %>
      </div>
    </div>
  </body>
</html>
<%@ include file="/view/header.jsp" %>
<%
    List wordList = (List) request.getAttribute("wordList");
    List irishWordList = (List) request.getAttribute("irishWordList");
%>
<%@ include file="/view/cookie-popup.jsp" %>
<%--@ include file="/view/google-ads-responsive-360x90-728x90.jsp" --%>
<div class="centering-flex-container">
  <div>
    <div class="table logo">
      <%--@ include file="/view/row-select-language.jsp" --%>
      <%@ include file="/view/row-lang.jsp" %>
      <%@ include file="/view/row-nav.jsp" %>
      <%@ include file="/view/row-logo.jsp" %>
      <div class="row name">
        <div class="cell name">
          <a href="<%= contextUrl %>"><%= resourceBundles.getString("Irish Dictionary") %></a>
        </div>
      </div>
      <div class="row">
        <div class="search-block">
          <%@ include file="/view/entryFormVariables.jsp" %>
          <%@ include file="/view/top-form.jsp" %>
        </div>
        <%@ include file="/view/word-count-statement.jsp" %>
      </div>
      <div class="row">
        <div class="cell">
          <%@ include file="/view/footer/footer-copyright.jsp" %>
        </div>
      </div>
    </div>
  </div>
</div>
<%@ include file="/view/footer.jsp" %>
<%@ include file="/view/header.jsp" %>
<%
    List wordList = (List) request.getAttribute("wordList");
    List irishWordList = (List) request.getAttribute("irishWordList");
%>
<%@ include file="/view/google-ads-responsive-360x90-728x90.jsp" %>
<div class="centering-flex-container">
  <div>
    <div class="table">
      <div class="row logo">
        <div class="cell logo">
        <%--div style="padding: 13px 42px; width: 200px;"--%>
          <a href="<%= contextUrl %>"><img src="<%= imagesUrl %>Irish-Dictionary-Online-Logo.jpg" border="0" title="Irish Dictionary Online"></a>
        </div>
      </div>
      <div class="row">
        <div class="search-block">
          <%@ include file="/view/entryFormVariables.jsp" %>
          <%@ include file="/view/top-form.jsp" %>
        </div>
        <%@ include file="/view/word-count-statement.jsp" %>
      </div>
      <%--
      <%@ include file="/view/entryFormVariables.jsp" %>
      <%@ include file="/view/row-header.jsp" %>
      <div class="row">
        <%@ include file="/view/word-count-statement.jsp" %>
      </div>
      --%>
      <div class="row">
        <div class="cell">
          <%@ include file="/view/footer/footer-copyright.jsp" %>
        </div>
      </div>
    </div>
  </div>
</div>
<%@ include file="/view/footer.jsp" %>
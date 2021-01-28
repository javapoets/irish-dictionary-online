<%@ include file="/view/header.jsp" %>
<%
    List wordList = (List) request.getAttribute("wordList");
    List irishWordList = (List) request.getAttribute("irishWordList");
%>
<%--@ include file="/view/google-ads-responsive-360x90-728x90.jsp" --%>
<div class="centering-flex-container">
  <div>
    <div class="table logo">
      <%@ include file="/view/row-select-language.jsp" %>
      <%@ include file="/view/row-nav.jsp" %>
      <div class="row logo">
        <div class="cell logo">
          <a href="<%= contextUrl %>"><img src="<%= imagesUrl %>Irish-Dictionary-Online-Logo.jpg" border="0" title="Irish Dictionary Online"></a>
        </div>
      </div>
      <div class="row name">
        <div class="cell name">
          <a href="<%= contextUrl %>"><%= resourceBundles.getString("Irish Dictionary") %></a>
        </div>
      </div>
      <div class="row">
        <div class="search-block">
          <%@ include file="/view/entryFormVariables.jsp" %>
          <%@ include file="/view/top-form-dictionary-only.jsp" %>
        </div>
        <%@ include file="/view/dictionary-statement.jsp" %>
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
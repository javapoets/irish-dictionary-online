<%@ include file="/view/header.jsp" %>
<%
    List wordList = (List) request.getAttribute("wordList");
    List irishWordList = (List) request.getAttribute("irishWordList");
%>
<div class="flex-container">
  <div class="logo-offset">
    <div>
      <a href="<%= contextUrl %>"><img src="<%= imagesUrl %>Irish-Dictionary-Online-Logo.jpg" border="0" title="Irish Dictionary Online"></a>
    </div>
  </div>
  <div>
    <div class="search-block">
      <%@ include file="/view/entryFormVariables.jsp" %>
      <%@ include file="/view/entry-form.jsp" %>
      <%@ include file="/view/verb-entry-form.jsp" %>
    </div>
    <%@ include file="/view/word-count-statement.jsp" %>
  </div>
</div>
<%@ include file="/view/footer.jsp" %>
<%@ include file="/view/header.jsp" %>
<%
    List wordList = (List) request.getAttribute("wordList");
    List irishWordList = (List) request.getAttribute("irishWordList");
%>
<div class="flex-container">
  <div>
    <div class="table">
      <div class="row">
        <div>
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
      <div class="row">
        <div class="cell">
          <%@ include file="/view/footer/footer-copyright.jsp" %>
        </div>
      </div>
    </div>
  </div>
</div>
<%@ include file="/view/footer.jsp" %>
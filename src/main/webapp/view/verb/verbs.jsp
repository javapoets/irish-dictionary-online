<%@ include file="/view/header.jsp" %>
<%
    List<Verb> verbList = (List<Verb>)request.getAttribute("verbList");
    log.debug("verbList.size() " + verbList.size());
    String language = (String)request.getAttribute("language");
    String toLanguage = (String)request.getAttribute("toLanguage");
    String wordEnglish = null;
    String wordIrish = null;
    String verbEnglish = null;
    String verbIrish = null;
%>
<div style="padding-top:108px;padding-bottom:108px;max-width:728px;text-align:center;margin:auto;">
  <div style="text-align:center;margin:auto;">
    <div class="header">
      <div>
        <a href="<%= contextUrl %>"><img src="<%= imagesUrl %>Irish-Dictionary-Online-Logo.jpg" border="0" title="Irish Dictionary Online"></a>
      </div>
      <div>
        <%@ include file="/view/topForm.jsp" %>
      </div>
    </div>
<%--        
    <div class="yellow0" style="max-width:728px;">
      <div>
        <div class="definition red0" style="text-align:left;max-height:400px;overflow-y:auto;">
        <div class="definition red">
--%>          
    <div class="yellow0" style="max-width:728px;">
      <div>
          <div class="verbs-container">
            <%
                if (verbList != null) {
                    int x = 1;
                    for(Verb verb: verbList) {
            %>
            <div><span><%= x++ %>. </span><a href="/verb?language=<%= language %>&toLanguage=<%= toLanguage %>&verb=<%= verb.getVerb() %>"><%= verb.getVerb() %></a></div>
            <%
                    }
                }
            %>
          </div>
<%--        
            http://dev.irishdictionary.online:8080/verb?language=english&toLanguage=irish&verb=get
          <ul class="verbs-container">
            <%
                if (verbList != null) {
                    for(Verb verb: verbList) {
            %>
            <li><%= verb.getVerb() %></li>
            <%
                    }
                }
            %>
          </ul>
--%>

      </div>
    </div>
  </div>
</div>

<%@ include file="/view/footer.jsp" %>


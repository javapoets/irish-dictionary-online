<%@ include file="/view/header.jsp" %>
<%
    List<Verb> verbList = (List<Verb>)request.getAttribute("verbList");
    log.debug("verbList.size() " + verbList.size());
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
                    for(Verb verb: verbList) {
            %>
            <div><%= verb.getVerb() %></div>
            <%
                    }
                }
            %>
          </div>
      </div>
    </div>
  </div>
</div>

<%@ include file="/view/footer.jsp" %>


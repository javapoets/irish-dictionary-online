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
    <div class="flex-container" style="height: 100%; text-align: center; vertical-align: top; margin: auto; margin-top: 0px; padding: 0px;">
      <div style="text-align: center; margin: auto; margin-top: 0px; width: 100%; max-width: var(--site-width);">
        <div class="header">
          <div style="padding: 13px 42px; width: 200px;">
            <a href="<%= contextUrl %>"><img src="<%= imagesUrl %>Irish-Dictionary-Online-Logo.jpg" border="0" title="Irish Dictionary Online"></a>
          </div>
          <div class="search-block">
            <%@ include file="/view/topForm.jsp" %>
            <%--@ include file="/view/entry-form.jsp" --%>
          </div>
        </div>
        <div style="padding-bottom: 40px;">
          <!--div class="definition"-->
            <div class="verbs-header">
              <span class="language-label"><span class="capitalize"><%= language %></span> verbs</span>
            </div>
          <!--/div-->

          <% if(verbList != null) { %>
            <%@ include file="/view/verb/verbs-output.jsp" %>
          <% } %>
        </div>
      </div>
    </div>
    <%@ include file="/view/footer.jsp" %>
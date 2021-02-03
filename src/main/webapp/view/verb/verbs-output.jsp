<div class="verbs-header">
  <span class="language-label">
    <%--= resourceBundles.getString("Irish Verbs") --%>
    <%
        String key = new StringBuilder().append(language).append(" ").append("verbs").toString();
    %>
    <%--= resourceBundles.getString("Irish Verbs") --%>
    <%= resourceBundles.getString(key) %>
  </span>
</div>
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
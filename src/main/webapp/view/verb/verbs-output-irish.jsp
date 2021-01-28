<div class="verbs-header">
  <span class="language-label">
    <%= resourceBundles.getString("Irish Verbs") %>
  </span>
</div>
<div class="verbs-container">
  <%
      if (irishVerbList != null) {
          language = "irish";
          toLanguage = "english";
          int x = 1;
          for (Verb verb: irishVerbList) {
  %>
  <div><span><%= x++ %>. </span><a href="/verb?language=<%= language %>&toLanguage=<%= toLanguage %>&verb=<%= verb.getVerb() %>"><%= verb.getVerb() %></a></div>
  <%
          }
      }
  %>
</div>
<div class="verbs-header">
  <span class="language-label">
    <%= resourceBundles.getString("English Verbs") %>
  </span>
</div> 
<div class="verbs-container">
  <%
      if (englishVerbList != null) {
          language = "english";
          toLanguage = "irish";
          int x = 1;
          for(Verb verb: englishVerbList) {
  %>
  <div><span><%= x++ %>. </span><a href="/verb?language=<%= language %>&toLanguage=<%= toLanguage %>&verb=<%= verb.getVerb() %>"><%= verb.getVerb() %></a></div>
  <%
          }
      }
  %>
</div>
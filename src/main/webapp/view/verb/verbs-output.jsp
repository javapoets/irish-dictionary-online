    <div>
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
      </div>
    </div>


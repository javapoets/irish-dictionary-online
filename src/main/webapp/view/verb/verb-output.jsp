<div class="definition verb-conjugation">
  <ol>
    <li>
      <div class="word-line">
        <span class="word"><%= verb.getVerb() %></span>
        <span class="type" style="text-transform: lowercase;"><span class="tag"><%= resourceBundles.getString("verb") %></span></span>
      </div>
      <ol
        <% if (verbListSize == 1) { %> style="list-style-type: none;"<% } %>  
      >
        <%
            Verb verb0 = null;
            String verbString0 = null;
            String description;
            if (verbList != null) {
                for (int i = 0; i < verbListSize; i++) {
                    verb0 = (Verb)verbList.get(i);
                    verbString0 = verb0.getVerb();
                    description = verb0.getDescription();
                    //hasType = type != null && !type.equals(EMPTY);
                    //hasGender = gender != null && !gender.equals(EMPTY);
                    boolean hasDescription = description != null && !description.equals(EMPTY);
        %>
        <li>
          <span class="definition">
            <a href="verb?verb=<%= verbString0 %>&language=<%= toLanguage %>&toLanguage=<%= fromLanguage %>" style="color: inherit;"><%= verbString0 %></a>            
          </span>
          <% if (hasDescription) { %><span class="description"><%= description %></span><% } %>
          <%--span class="type">verb</span--%>
        </li>
        <%
                }
            }
        %>
      </ol>
    </li>
    <% if (verb.getVerbalAdjective() != null && !verb.getVerbalAdjective().equals(EMPTY)) { %>
    <li>
      <div class="word-line">
        <span class="word"><a href="<%= fromLanguage %>/<%= toLanguage %>/<%= verb.getVerbalAdjective() %>"<% if (!lang.equals(fromLang)) { %> lang="<%= fromLang %>"<% } %>><%= verb.getVerbalAdjective() %></a></span>
        <span class="type" style="text-transform: lowercase;"><span class="tag"><%= resourceBundles.getString("Verbal Adjective") %></span></span>
      </div>
      <ol
        <% if (verbListSize == 1) { %> style="list-style-type: none;"<% } %>
      >
        <%
            if (verbList != null) {
                for (int i = 0; i < verbList.size(); i++) {
        %>
        <li>
          <span class="definition"><a href="<%= toLanguage %>/<%= fromLanguage %>/<%= ((Verb)verbList.get(i)).getParticiple() %>"><%= ((Verb)verbList.get(i)).getParticiple() %></a></span>
        </li>
        <%
                }
            }
        %>
      </ol>
    </li>
    <% } %>
    <% if (verb.getVerbalNoun() != null && !verb.getVerbalNoun().equals(EMPTY)) { %>
    <li>
      <div class="word-line">
        <span class="word">ag <a href="<%= fromLanguage %>/<%= toLanguage %>/<%= verb.getVerbalNoun() %>"><%= verb.getVerbalNoun() %></a></span>
        <span class="type" style="text-transform: lowercase;"><span class="tag"><%= resourceBundles.getString("Verbal Noun") %></span></span>
      </div>
      <ol
        <% if (verbListSize == 1) { %> style="list-style-type: none;"<% } %>
      >
        <%
            if (verbList != null) {
                for (int i = 0; i < verbList.size(); i++) {
        %>
        <li>
          <span class="definition">
            <a href="<%= toLanguage %>/<%= fromLanguage %>/<%= ((Verb)verbList.get(i)).getGerund() %>"><%= ((Verb)verbList.get(i)).getGerund() %></a>
          </span>
        </li>
        <%
                }
            }
        %>
      </ol>
    </li>
    <% } %>
    <% if (verb.getParticiple() != null && !verb.getParticiple().equals(EMPTY)) { %>
    <li>
      <div class="word-line">
        <span class="word"><a href="<%= fromLanguage %>/<%= toLanguage %>/<%= verb.getParticiple() %>"><%= verb.getParticiple() %></a></span>
        <span class="type" style="text-transform: lowercase;"><span class="tag"><%= resourceBundles.getString("Verbal Adjective") %></span></span>
      </div>
      <ol
        <% if (verbListSize == 1) { %> style="list-style-type: none;"<% } %>
      >
        <%
            if (verbList != null) {
                for (int i = 0; i < verbList.size(); i++) {
        %>
        <li>
          <span class="definition">
            <a href="<%= toLanguage %>/<%= fromLanguage %>/<%= ((Verb)verbList.get(i)).getVerbalAdjective() %>"><%= ((Verb)verbList.get(i)).getVerbalAdjective() %></a>
          </span>
        </li>
        <%
                }
            }
        %>
      </ol>
    </li>
    <% } %>
    <% if (verb.getGerund() != null && !verb.getGerund().equals(EMPTY)) { %>
    <li>
      <div class="word-line">
        <span class="word"><a href="<%= fromLanguage %>/<%= toLanguage %>/<%= verb.getGerund() %>"><%= verb.getGerund() %></a></span>
        <span class="type" style="text-transform: lowercase;"><span class="tag"><%= resourceBundles.getString("Verbal Noun") %></span></span>
      </div>
      <ol
        <% if (verbListSize == 1) { %> style="list-style-type: none;"<% } %>
      >
        <%
            if (verbList != null) {
                for (int i = 0; i < verbList.size(); i++) {
        %>
        <li>
          <span class="definition">ag <a href="<%= toLanguage %>/<%= fromLanguage %>/<%= ((Verb)verbList.get(i)).getVerbalNoun() %>"><%= ((Verb)verbList.get(i)).getVerbalNoun() %></a></span>
        </li>
        <%
                }
            }
        %>
      </ol>
    </li>
    <% } %>
  </ol>
  <%
      VerbConjugation verbConjugation;
      String tenseId;
      for (int x = 1; x <= 7; x++) {
          tenseId = String.valueOf(x);
          //log.debug("tenseId = " + tenseId);
          verbConjugation = (VerbConjugation) verbConjugationMap.get(tenseId);
  %>
    <%@ include file="/view/verb/verbConjugation.jsp" %>
  <% } %>
</div>
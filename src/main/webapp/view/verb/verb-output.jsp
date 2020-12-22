<div class="definition">
  <div class="word-header">
    <span class="language-label"><span class="capitalize"><%= fromLanguage %></span> verb</span>
    <span class="word"><% if(verb != null) { %><%= verb.getVerb() %><% } %></span>
    <%--
        if (word.getDescription() != null) {
            stringBuilder.append(  "<span class=\"word-description\">").append(word.getDescription()).append("</span>");
        }
    --%>
  </div>
  <div>
    <ol>
      <li>
        <% if (isEnglish) { %>
          <span class="description">(Definition<span class="smaller">/Sainmhíniú</span>)</span>
        <% } else { %>
          <span class="description">(Sainmhíniú<span class="smaller">/Definition</span>)</span>
        <% } %>
        <%-- if (verbList != null) { for (int i = 0; i < verbList.size(); i++) { %><% if (i>0) { %>, <% } %><%= ((Verb)verbList.get(i)).getVerb() %><% } } --%>
        <%
            Verb verb0 = null;
            String verbString0 = null;
            if (verbList != null) {
                int verbListSize = verbList.size();
                for (int i = 0; i < verbListSize; i++) {
                    verb0 = (Verb)verbList.get(i);
                    verbString0 = verb0.getVerb();
        %>
        <a href="verb?verb=<%= verbString0 %>&language=<%= toLanguage %>" style="color: inherit;"><%= verbString0 %></a><% if (i < (verbListSize-1)) { %>,<% } %>
        <%
                }
            }
        %>
      </li>
      <%--
      <% if(verb.getConjugation() > 0) { %>
      <li>
        <% if(isEnglish) { %>
        <span style="font-size:12px;">(Conjugation<span style="font-size:10px;">/Réimniú)</span>)</span>
        <% } else { %>
        <span style="font-size:12px;">(Réimniú</span><span style="font-size:10px;">/Conjugation</span>)</span>
        <% } %>
        <% if(verbList != null) { for(int i = 0; i < verbList.size(); i++) { %><%if(i>0){ %>, <%}%><%= ((((Verb)verbList.get(i)).getConjugation() == 1) ? "first" : "second") %><% } } %>
      </li>
      <% } %>
      --%>
      <% if (verb.getVerbalAdjective() != null && !verb.getVerbalAdjective().equals(EMPTY)) { %>
      <li>
        <% if (isEnglish) { %>
          <span class="description">(Verbal Adjective<span class="smaller">/Aidiacht Briathartha</span>)</span>
        <% } else { %>
          <span class="description">(Aidiacht Briathartha<span class="smaller">/Verbal Adjective</span>)</span>
        <% } %>
        <%--= verb.getVerbalAdjective() --%>
        <a href="<%= fromLanguage %>/<%= toLanguage %>/<%= verb.getVerbalAdjective() %>"><%= verb.getVerbalAdjective() %></a>
        (<% if (verbList != null) { for (int i = 0; i < verbList.size(); i++) { %><% if (i > 0) { %>, <% } %><a href="<%= toLanguage %>/<%= fromLanguage %>/<%= ((Verb)verbList.get(i)).getParticiple() %>"><%= ((Verb)verbList.get(i)).getParticiple() %></a><% } } %>)
      </li>
      <% } %>
      <% if (verb.getVerbalNoun() != null && !verb.getVerbalNoun().equals(EMPTY)) { %>
      <li>
        <% if (isEnglish) { %>
          <span class="description">(Verbal Noun<span class="smaller">/Ainm Briathartha</span>)</span>
        <% } else { %>
          <span class="description">(Ainm Briathartha<span class="smaller">/Verbal Noun</span>)</span>
        <% } %>
        ag <a href="<%= fromLanguage %>/<%= toLanguage %>/<%= verb.getVerbalNoun() %>"><%= verb.getVerbalNoun() %></a>
        (<% if (verbList != null) { for (int i = 0; i < verbList.size(); i++) { %><% if(i > 0) { %>, <% } %><a href="<%= toLanguage %>/<%= fromLanguage %>/<%= ((Verb)verbList.get(i)).getGerund() %>"><%= ((Verb)verbList.get(i)).getGerund() %></a><% } } %>)
      </li>
      <% } %>
      <% if (verb.getParticiple() != null && !verb.getParticiple().equals(EMPTY)) { %>
      <li>
        <% if (isEnglish) { %>
          <span class="description">(Verbal Adjective<span class="smaller">/Aidiacht Briathartha</span>)</span>
        <% } else { %>
          <span class="description">(Aidiacht Briathartha</span><span class="smaller">/Verbal Adjective</span>)</span>
        <% } %>
        <a href="<%= fromLanguage %>/<%= toLanguage %>/<%= verb.getParticiple() %>"><%= verb.getParticiple() %></a>
        (<% if(verbList != null) { for(int i = 0; i < verbList.size(); i++) { %><%if(i>0){ %>, <% } %><a href="<%= toLanguage %>/<%= fromLanguage %>/<%= ((Verb)verbList.get(i)).getVerbalAdjective() %>"><%= ((Verb)verbList.get(i)).getVerbalAdjective() %></a><% } } %>)
      </li>
      <% } %>
      <% if (verb.getGerund() != null && !verb.getGerund().equals(EMPTY)) { %>
      <li>
        <span class="description">(Verbal Noun<span class="smaller">/Ainm Briathartha</span>)</span>
        <a href="<%= fromLanguage %>/<%= toLanguage %>/<%= verb.getGerund() %>"><%= verb.getGerund() %></a>
        (<% if (verbList != null) { for(int i = 0; i < verbList.size(); i++) { %><% if (i>0) { %>, <% } %>ag <a href="<%= toLanguage %>/<%= fromLanguage %>/<%= ((Verb)verbList.get(i)).getVerbalNoun() %>"><%= ((Verb)verbList.get(i)).getVerbalNoun() %></a><% } } %>)
      </li>
      <% } %>
    </ol>
  </div>
  <div class="verb-conjugation">
    <div class="word-header">
      <span class="language-label">Verb conjugation</span>
    </div>
    <%
        VerbConjugation verbConjugation;
        String tenseId;
        for (int x = 1; x <= 7; x++) {
            tenseId = String.valueOf(x);
            log.debug("tenseId = " + tenseId);
            verbConjugation = (VerbConjugation) verbConjugationMap.get(tenseId);
    %>
      <%@ include file="/view/verb/verbConjugation.jsp" %>
    <% } %>
  </div>
</div>
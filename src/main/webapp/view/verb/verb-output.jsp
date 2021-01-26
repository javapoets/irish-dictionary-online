<%--
<div class="usage description definition verb-conjugation">
--%>
<div class="definition verb-conjugation">
  <%--
  <div class="word-header">
    <span class="language-label"><%= resourceBundles.getString(fromLanguage + " verb") %></span>
    <span class="word"<% if (!lang.equals(fromLang)) { %> lang="<%= fromLang %>"<% } %>>
        <% if (verb != null) { %><%= verb.getVerb() %><% } %>
    </span>
    <%
        if (word.getDescription() != null) {
            stringBuilder.append(  "<span class=\"word-description\">").append(word.getDescription()).append("</span>");
        }
    %>
  </div>
  --%>

  <%--
      StringBuilder typeBuilder = new StringBuilder().append(verb.getType());
  --%>
  <ol>
    <li>
      <div class="word-line">
        <span class="word"><%= verb.getVerb() %></span>
        <%--&nbsp<span class="type"><%= typeBuilder.toString() %></span>--%>
        <span class="type">verb</span>
      </div>
      <ol>
        <%
            Verb verb0 = null;
            String verbString0 = null;
            String description;
            if (verbList != null) {
                int verbListSize = verbList.size();
                for (int i = 0; i < verbListSize; i++) {
                    verb0 = (Verb)verbList.get(i);
                    verbString0 = verb0.getVerb();
                    description = verb0.getDescription();
                    //hasType = type != null && !type.equals("");
                    //hasGender = gender != null && !gender.equals("");
                    boolean hasDescription = description != null && !description.equals("");
        %>
        <li>
          <span class="definition">
            <a href="verb?verb=<%= verbString0 %>&language=<%= toLanguage %>&toLanguage=<%= fromLanguage %>" style="color: inherit;"><%= verbString0 %></a>            
          </span>
          <% if (hasDescription) { %><span class="description"><%= description %></span><% } %>
          <span class="type">verb</span>
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
        <span class="type" style="text-transform: lowercase;"><%= resourceBundles.getString("Verbal Adjective") %></span>
      </div>
      <ol>
        <%
            if (verbList != null) {
                for (int i = 0; i < verbList.size(); i++) {
        %>
        <li>
          <span class="definition">
          <a href="<%= toLanguage %>/<%= fromLanguage %>/<%= ((Verb)verbList.get(i)).getParticiple() %>"><%= ((Verb)verbList.get(i)).getParticiple() %></a>
          </span>
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
        <span class="type" style="text-transform: lowercase;"><%= resourceBundles.getString("Verbal Noun") %></span>
      </div>
      <ol>
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
        <span class="type" style="text-transform: lowercase;"><%= resourceBundles.getString("Verbal Adjective") %></span>
      </div>
      <ol>
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
        <span class="type" style="text-transform: lowercase;"><%= resourceBundles.getString("Verbal Noun") %></span>
      </div>
      <ol>
        <%
            if (verbList != null) {
                for (int i = 0; i < verbList.size(); i++) {
        %>
        <li>
          <span class="definition">
            ag <a href="<%= toLanguage %>/<%= fromLanguage %>/<%= ((Verb)verbList.get(i)).getVerbalNoun() %>"><%= ((Verb)verbList.get(i)).getVerbalNoun() %></a>
          </span>
        </li>
        <%
                }
            }
        %>
      </ol>
    </li>
    <% } %>
  </ol>
  <!--div-->
  <div class="table" style="padding: 10px 0px;">
    <%--
    <div class="row">
      <div class="cell usage-label underline"><%= resourceBundles.getString("Definition") %></div>
      <div class="cell translated underline"<% if (!lang.equals(toLang)) { %> lang="<%= toLang %>"<% } %>>
        <%
            Verb verb0 = null;
            String verbString0 = null;
            if (verbList != null) {
                int verbListSize = verbList.size();
                for (int i = 0; i < verbListSize; i++) {
                    verb0 = (Verb)verbList.get(i);
                    verbString0 = verb0.getVerb();
        %>
          <a href="verb?verb=<%= verbString0 %>&language=<%= toLanguage %>&toLanguage=<%= fromLanguage %>" style="color: inherit;"><%= verbString0 %></a><% if (i < (verbListSize-1)) { %>,<% } %>
        <%
                }
            }
        %>
      </div>
    </div>
    --%>
    <%-- if (verb.getVerbalAdjective() != null && !verb.getVerbalAdjective().equals(EMPTY)) { %>
    <div class="row">
      <div class="cell usage-label"><%= resourceBundles.getString("Verbal Adjective") %></div>
      <div class="cell usage">
        <a href="<%= fromLanguage %>/<%= toLanguage %>/<%= verb.getVerbalAdjective() %>"<% if (!lang.equals(fromLang)) { %> lang="<%= fromLang %>"<% } %>><%= verb.getVerbalAdjective() %></a>
      </div>
    </div>
    <div class="row">
      <div class="cell usage-label underline">&nbsp;</div>
      <div class="cell translated underline"<% if (!lang.equals(toLang)) { %> lang="<%= toLang %>"<% } %>>
        <% if (verbList != null) { for (int i = 0; i < verbList.size(); i++) { %><% if (i > 0) { %>, <% } %><a href="<%= toLanguage %>/<%= fromLanguage %>/<%= ((Verb)verbList.get(i)).getParticiple() %>"><%= ((Verb)verbList.get(i)).getParticiple() %></a><% } } %>
      </div>
    </div>
    <% } --%>
    <%-- if (verb.getVerbalNoun() != null && !verb.getVerbalNoun().equals(EMPTY)) { %>
    <div class="row">
      <div class="cell usage-label"><%= resourceBundles.getString("Verbal Noun") %></div>
      <div class="cell usage"<% if (!lang.equals(fromLang)) { %> lang="<%= fromLang %>"<% } %>>
        ag <a href="<%= fromLanguage %>/<%= toLanguage %>/<%= verb.getVerbalNoun() %>"><%= verb.getVerbalNoun() %></a>
      </div>
    </div>
    <div class="row">
      <div class="cell usage-label underline">&nbsp;</div>
      <div class="cell translated underline"<% if (!lang.equals(toLang)) { %> lang="<%= toLang %>"<% } %>>
        <% if (verbList != null) { for (int i = 0; i < verbList.size(); i++) { %><% if(i > 0) { %>, <% } %><a href="<%= toLanguage %>/<%= fromLanguage %>/<%= ((Verb)verbList.get(i)).getGerund() %>"><%= ((Verb)verbList.get(i)).getGerund() %></a><% } } %>
      </div>
    </div>
    <% } --%>
    <%-- if (verb.getParticiple() != null && !verb.getParticiple().equals(EMPTY)) { %>
    <div class="row">
      <div class="cell usage-label"><%= resourceBundles.getString("Verbal Adjective") %></div>
      <div class="cell usage"<% if (!lang.equals(fromLang)) { %> lang="<%= fromLang %>"<% } %>>
        <a href="<%= fromLanguage %>/<%= toLanguage %>/<%= verb.getParticiple() %>"><%= verb.getParticiple() %></a>
      </div>
    </div>
    <div class="row">      
      <div class="cell usage-label underline">&nbsp;</div>
      <div class="cell translated underline"<% if (!lang.equals(toLang)) { %> lang="<%= toLang %>"<% } %>>
        <% if(verbList != null) { for(int i = 0; i < verbList.size(); i++) { %><%if(i>0){ %>, <% } %><a href="<%= toLanguage %>/<%= fromLanguage %>/<%= ((Verb)verbList.get(i)).getVerbalAdjective() %>"><%= ((Verb)verbList.get(i)).getVerbalAdjective() %></a><% } } %>
      </div>
    </div>
    <% } --%>
    <%-- if (verb.getGerund() != null && !verb.getGerund().equals(EMPTY)) { %>
    <div class="row">
      <div class="cell usage-label irish">
        <%= resourceBundles.getString("Verbal Noun") %>
      </div>
      <div class="cell usage"<% if (!lang.equals(fromLang)) { %> lang="<%= fromLang %>"<% } %>>
        <a href="<%= fromLanguage %>/<%= toLanguage %>/<%= verb.getGerund() %>"><%= verb.getGerund() %></a>
      </div>
    </div>
    <div class="row">
      <div class="cell usage-label underline">&nbsp;</div>
      <div class="cell translated underline"<% if (!lang.equals(toLang)) { %> lang="<%= toLang %>"<% } %>>
        <% if (verbList != null) { for(int i = 0; i < verbList.size(); i++) { %><% if (i>0) { %>, <% } %>ag <a href="<%= toLanguage %>/<%= fromLanguage %>/<%= ((Verb)verbList.get(i)).getVerbalNoun() %>"><%= ((Verb)verbList.get(i)).getVerbalNoun() %></a><% } } %>
      </div>
    </div>
    <% } --%>
  </div>
  <!--/div-->
  <div class="verb-conjugation">
    <div class="word-header">
      <span class="language-label"><%= resourceBundles.getString("Verb Conjugation") %></span>
    </div>
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
</div>
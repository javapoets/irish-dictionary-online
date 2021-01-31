<%
    String ENGLISH_PRONOUN_ME = "me";
    String ENGLISH_PRONOUN_YOU = "you";
    //String ENGLISH_PRONOUN_YOU = "you singular";
    String ENGLISH_PRONOUN_HE = "he";
    String ENGLISH_PRONOUN_SHE = "she";
    String ENGLISH_PRONOUN_WE = "we";
    //String ENGLISH_PRONOUN_YOU_PLURAL = "you";
    String ENGLISH_PRONOUN_YOU_PLURAL = "you plural";
    String ENGLISH_PRONOUN_THEY = "they";
    String ENGLISH_AUTONOMOUS = "autonomous";
    String ENGLISH_NEGATIVE = "negative";
    String ENGLISH_QUESTION = "question";
    String IMPERATIVE = "imperative";
%>
  <div class="table">
    <div class="row">
      <div class="cell verb-tense-header">
        <% if (verbConjugation.getTenseEnglish() != null) { %>
        <div>
          <%= resourceBundles.getString(verbConjugation.getTenseEnglish()) %>
        </div>
        <% } %>
      </div>
    </div>
  </div>
  <ol style="list-style-type: none;">
    <li>
      <div class="word-line">
        <% if (verbConjugation.getMe() != null) { %>
          <span class="word"<% if (!lang.equals(fromLang)) { %> lang="<%= fromLang %>"<% } %>>
            <%= definitionOutput.linkizeWords(verbConjugation.getMe(), fromLanguage, toLanguage) %>
          </span>
          <span class="type">
            <span class="tag tag-pronoun"><%= resourceBundles.getString(ENGLISH_PRONOUN_ME)  %></span>
            <span class="tag tag-language"><%= resourceBundles.getString(fromLanguage)  %></span>
            <span class="tag tag-tense"><%= resourceBundles.getString(verbConjugation.getTenseEnglish()) %></span>
          </span>
        <% } %>
      </div>
      <ol
        <% if (verbListSize == 1) { %> style="list-style-type: none;"<% } %>
      >
      <%
        String me = null;
        for (int i = 0; i < verbList.size(); i++) {
            Verb verbI = (Verb) verbList.get(i);
            Map verbConjugationMapI = (Map)verbI.getVerbConjugationMap();
            VerbConjugation verbConjugationI = (VerbConjugation)verbConjugationMapI.get(tenseId);
            me = verbConjugationI.getMe();
            //log.debug("me = " + me);
            if (me != null) {
      %>            
        <li><span class="definition"><%= definitionOutput.linkizeWords(me, toLanguage, fromLanguage) %></span></li>
      <%  
            }
        }
      %>
      </ol>
    </li>
    <li>
      <div class="word-line">
        <% if (verbConjugation.getYouSingular() != null) { %>
        <span class="word"<% if (!lang.equals(fromLang)) { %> lang="<%= fromLang %>"<% } %>>
          <%= definitionOutput.linkizeWords(verbConjugation.getYouSingular(), fromLanguage, toLanguage) %>
        </span>
        <span class="type">
          <small class="tag"><%= resourceBundles.getString(ENGLISH_PRONOUN_YOU)  %></small>
          <%--small class="tag"><%= resourceBundles.getString(verbConjugation.getTenseEnglish()) %></small--%>
          <%--small class="tag"><%= resourceBundles.getString(fromLanguage)  %></small--%>
        </span>
        <% } %>
      </div>
      <ol
        <% if (!lang.equals(toLang)) { %> lang="<%= toLang %>"<% } %>
        <% if (verbListSize == 1) { %> style="list-style-type: none;"<% } %>
      >
      <%
        String youSingular = null;
        for (int i = 0; i < verbList.size(); i++) {
            Verb verbI = (Verb)verbList.get(i);
            Map verbConjugationMapI = (Map)verbI.getVerbConjugationMap();
            VerbConjugation verbConjugationI = (VerbConjugation)verbConjugationMapI.get(tenseId);
            youSingular = verbConjugationI.getYouSingular();
            //log.debug("youSingular = " + youSingular);
            if (youSingular != null) {
      %>
        <li><span class="definition"><%= definitionOutput.linkizeWords(youSingular, toLanguage, fromLanguage) %></span></li>
      <%
            }
        }

      %>
      </ol>
    </li>
    <li>
      <div class="word-line">
        <% if (verbConjugation.getHe() != null) { %>
        <span class="word"<% if (!lang.equals(fromLang)) { %> lang="<%= fromLang %>"<% } %>>
          <%= definitionOutput.linkizeWords(verbConjugation.getHe(), fromLanguage, toLanguage) %>
        </span>
        <span class="type">
          <span class="tag"><%= resourceBundles.getString(ENGLISH_PRONOUN_HE)  %></span>
          <%--span class="tag"><%= resourceBundles.getString(verbConjugation.getTenseEnglish()) %></span>
          <span class="tag"><%= resourceBundles.getString(fromLanguage)  %></span--%>
        </span>
        <% } %>
      </div>
      <ol
        <% if (!lang.equals(toLang)) { %> lang="<%= toLang %>"<% } %>
        <% if (verbListSize == 1) { %> style="list-style-type: none;"<% } %>
      >
      <%
        String he = null;
        for (int i = 0; i < verbList.size(); i++) {
            Verb verbI = (Verb)verbList.get(i);
            Map verbConjugationMapI = (Map)verbI.getVerbConjugationMap();
            VerbConjugation verbConjugationI = (VerbConjugation)verbConjugationMapI.get(tenseId);
            he = verbConjugationI.getHe();
            //log.debug("he = " + he);
            if (he != null) {
      %>
        <li><span class="definition"><%= definitionOutput.linkizeWords(he, toLanguage, fromLanguage) %></span></li>
      <%
            }
        }
      %>
      </ol>
    </li>
    <li>
      <div class="word-line">
        <% if (verbConjugation.getShe() != null) { %>
        <span class="word"<% if (!lang.equals(fromLang)) { %> lang="<%= fromLang %>"<% } %>>
          <%= definitionOutput.linkizeWords(verbConjugation.getShe(), fromLanguage, toLanguage) %>
        </span>
        <span class="type">
          <span class="tag"><%= resourceBundles.getString(ENGLISH_PRONOUN_SHE)  %></span>
          <%--span class="tag"><%= resourceBundles.getString(verbConjugation.getTenseEnglish()) %></span>
          <span class="tag"><%= resourceBundles.getString(fromLanguage)  %></span--%>
        </span>
        <% } %>
      </div>
      <ol
        <% if (!lang.equals(toLang)) { %> lang="<%= toLang %>"<% } %>
        <% if (verbListSize == 1) { %> style="list-style-type: none;"<% } %>
      >
      <%
        String she = null;
        for (int i = 0; i < verbList.size(); i++) {
            Verb verbI = (Verb)verbList.get(i);
            Map verbConjugationMapI = (Map)verbI.getVerbConjugationMap();
            VerbConjugation verbConjugationI = (VerbConjugation)verbConjugationMapI.get(tenseId);
            she = verbConjugationI.getShe();
            //log.debug("she = " + she);
            if (she != null) {
      %>
        <li><span class="definition"><%= definitionOutput.linkizeWords(she, toLanguage, fromLanguage) %></span></li>
      <%
            }
        }
      %>
      </ol>
    </li>
    <li>
      <div class="word-line">
        <% if (verbConjugation.getWe() != null) { %>
        <span class="word"<% if (!lang.equals(fromLang)) { %> lang="<%= fromLang %>"<% } %>>
          <%= definitionOutput.linkizeWords(verbConjugation.getWe(), fromLanguage, toLanguage) %>
          <% if (verbConjugation.getWeAlternative() != null) { %>
            <small> or </small><span class="definition"><%= definitionOutput.linkizeWords(verbConjugation.getWeAlternative(), fromLanguage, toLanguage) %></span>
          <% } %>
        </span>
        <span class="type">
          <span class="tag"><%= resourceBundles.getString(ENGLISH_PRONOUN_WE)  %></span>
          <%--span class="tag"><%= resourceBundles.getString(verbConjugation.getTenseEnglish()) %></span>
          <span class="tag"><%= resourceBundles.getString(fromLanguage)  %></span--%>
        </span>
        <% } %>
      </div>
      <ol
        <% if (!lang.equals(toLang)) { %> lang="<%= toLang %>"<% } %>
        <% if (verbListSize == 1) { %> style="list-style-type: none;"<% } %>
      >
      <%
        String we = null;
        String weAlternative = null;
        for (int i = 0; i < verbList.size(); i++) {
            Verb verbI = (Verb)verbList.get(i);
            Map verbConjugationMapI = (Map)verbI.getVerbConjugationMap();
            VerbConjugation verbConjugationI = (VerbConjugation)verbConjugationMapI.get(tenseId);
            we = verbConjugationI.getWe();
            weAlternative = verbConjugationI.getWeAlternative();
            //log.debug("we = " + we);
            if (we != null) {
      %>
        <li>
          <span class="definition"><%= definitionOutput.linkizeWords(we, toLanguage, fromLanguage) %></span>
          <% if (weAlternative != null) { %>
            <small> or </small><span class="definition"><%= definitionOutput.linkizeWords(weAlternative, toLanguage, fromLanguage) %></span>
          <% } %>
        </li>
      <%
            }
        }
      %>
      </ol>
    </li>
    <li>
      <div class="word-line">
        <% if (verbConjugation.getYouPlural() != null) { %>
        <span class="word"<% if (!lang.equals(fromLang)) { %> lang="<%= fromLang %>"<% } %>>
          <%= definitionOutput.linkizeWords(verbConjugation.getYouPlural(), fromLanguage, toLanguage) %>
        </span>
        <span class="type">
          <span class="tag"><%= resourceBundles.getString(ENGLISH_PRONOUN_YOU_PLURAL)  %></span>
          <%--span class="tag"><%= resourceBundles.getString(verbConjugation.getTenseEnglish()) %></span>
          <span class="tag"><%= resourceBundles.getString(fromLanguage)  %></span--%>
        </span>
        <% } %>
      </div>
      <ol
        <% if (!lang.equals(toLang)) { %> lang="<%= toLang %>"<% } %>
        <% if (verbListSize == 1) { %> style="list-style-type: none;"<% } %>
      >
      <%
        String youPlural = null;
        for (int i = 0; i < verbList.size(); i++) {
            Verb verbI = (Verb)verbList.get(i);
            Map verbConjugationMapI = (Map)verbI.getVerbConjugationMap();
            VerbConjugation verbConjugationI = (VerbConjugation)verbConjugationMapI.get(tenseId);
            youPlural = verbConjugationI.getYouPlural();
            //log.debug("youPlural = " + youPlural);
            if (youPlural != null) {
      %>
        <li><span class="definition"><%= definitionOutput.linkizeWords(youPlural, toLanguage, fromLanguage) %></span></li>
      <%
            }
        }
      %>
      </ol>
    </li>
    <li>
      <div class="word-line">
        <% if (verbConjugation.getThey() != null) { %>
        <span class="word">
          <%= definitionOutput.linkizeWords(verbConjugation.getThey(), fromLanguage, toLanguage) %>
          <% if (verbConjugation.getTheyAlternative() != null) { %>
            <small> or </small><span class="definition"><%= definitionOutput.linkizeWords(verbConjugation.getTheyAlternative(), fromLanguage, toLanguage) %></span>
          <% } %>
        </span>
        <span class="type">
          <span class="tag"><%= resourceBundles.getString(ENGLISH_PRONOUN_THEY)  %></span>
          <%--span class="tag"><%= resourceBundles.getString(verbConjugation.getTenseEnglish()) %></span>
          <span class="tag"><%= resourceBundles.getString(fromLanguage)  %></span--%>
        </span>
        <% } %>
      </div>
      <ol
        <% if (!lang.equals(toLang)) { %> lang="<%= toLang %>"<% } %>
        <% if (verbListSize == 1) { %> style="list-style-type: none;"<% } %>
      >
      <%
        String they = null;
        String theyAlternative = null;
        for (int i = 0; i < verbList.size(); i++) {
            Verb verbI = (Verb)verbList.get(i);
            Map verbConjugationMapI = (Map)verbI.getVerbConjugationMap();
            VerbConjugation verbConjugationI = (VerbConjugation)verbConjugationMapI.get(tenseId);
            they = verbConjugationI.getThey();
            theyAlternative = verbConjugationI.getTheyAlternative();
            //log.debug("they = " + they);
            //log.debug("theyAlternative = " + theyAlternative);
            if (they != null) {
      %>
        <li>
          <span class="definition"><%= definitionOutput.linkizeWords(they, toLanguage, fromLanguage) %></span>
          <%-- if (theyAlternative != null) { --%>
          <% if (theyAlternative != null &&!theyAlternative.equals(they)) { %>
            <small> or </small>
            <span class="definition"> <%= definitionOutput.linkizeWords(theyAlternative, toLanguage, fromLanguage) %></span>
          <% } %>
        </li>
      <%
            }
        }
      %>
      </ol>
    </li>
    <li>
      <div class="word-line">
        <% if (verbConjugation.getAutonomous() != null) { %>
        <span class="word"<% if (!lang.equals(fromLang)) { %> lang="<%= fromLang %>"<% } %>>
          <%= definitionOutput.linkizeWords(verbConjugation.getAutonomous(), fromLanguage, toLanguage) %>
        </span>
        <span class="type">
          <span class="tag"><%= resourceBundles.getString(ENGLISH_AUTONOMOUS)  %></span>
          <span class="tag"><%= resourceBundles.getString(verbConjugation.getTenseEnglish()) %></span>
          <%--span class="tag"><%= resourceBundles.getString(fromLanguage)  %></span--%>
        </span>
        <% } %>
      </div>
      <ol
        <% if (!lang.equals(toLang)) { %> lang="<%= toLang %>"<% } %>
        <% if (verbListSize == 1) { %> style="list-style-type: none;"<% } %>
      >
      <%
        String autonomous = null;
        for (int i = 0; i < verbList.size(); i++) {
            Verb verbI = (Verb)verbList.get(i);
            Map verbConjugationMapI = (Map)verbI.getVerbConjugationMap();
            VerbConjugation verbConjugationI = (VerbConjugation)verbConjugationMapI.get(tenseId);
            autonomous = verbConjugationI.getAutonomous();
            //log.debug("autonomous = " + autonomous);
            if (
              autonomous != null
              && !autonomous.equals(EMPTY)
            ) {
      %>
        <li><span class="definition"><%= definitionOutput.linkizeWords(autonomous, toLanguage, fromLanguage) %></span></li>
      <%
            }
        }

      %>
      </ol>
    </li>
    <li>
      <div class="word-line">
        <% if (verbConjugation.getNegative() != null) { %>
        <span class="word"<% if (!lang.equals(fromLang)) { %> lang="<%= fromLang %>"<% } %>>
          <%= definitionOutput.linkizeWords(verbConjugation.getNegative(), fromLanguage, toLanguage) %>
        </span>
        <span class="type">
          <span class="tag"><%= resourceBundles.getString(ENGLISH_NEGATIVE)  %></span>
          <span class="tag"><%= resourceBundles.getString(verbConjugation.getTenseEnglish()) %></span>
          <% if (!verbConjugation.getTenseEnglish().equals(IMPERATIVE)) { %>
          <span class="tag"><%= resourceBundles.getString(ENGLISH_PRONOUN_HE)  %></span>
          <% } %>
        </span>
        <% } %>
      </div>
      <ol
        <% if (!lang.equals(toLang)) { %> lang="<%= toLang %>"<% } %>
        <% if (verbListSize == 1) { %> style="list-style-type: none;"<% } %>
      >
      <%
        String negative = null;
        for (int i = 0; i < verbList.size(); i++) {
            Verb verbI = (Verb)verbList.get(i);
            Map verbConjugationMapI = (Map)verbI.getVerbConjugationMap();
            VerbConjugation verbConjugationI = (VerbConjugation)verbConjugationMapI.get(tenseId);
            negative = verbConjugationI.getNegative();
            if (
              negative != null
              && !negative.equals(EMPTY)
            ) {
      %>
        <li><span class="definition"><%= definitionOutput.linkizeWords(negative, toLanguage, fromLanguage) %></span></li>
      <%
            }
        }

      %>
      </ol>
    </li>
    <%
      if (!EMPTY.equals(verbConjugation.getQuestion())) {
    %>
    <li>
      <div class="word-line">
        <% if (verbConjugation.getQuestion() != null) { %>
        <span class="word"<% if (!lang.equals(fromLang)) { %> lang="<%= fromLang %>"<% } %>>
          <%= definitionOutput.linkizeWords(verbConjugation.getQuestion(), fromLanguage, toLanguage) %>
        </span>
        <span class="type">
          <span class="tag"><%= resourceBundles.getString(ENGLISH_QUESTION)  %></span>
          <span class="tag"><%= resourceBundles.getString(verbConjugation.getTenseEnglish()) %></span>
          <% if (!verbConjugation.getTenseEnglish().equals(IMPERATIVE)) { %>
          <span class="tag"><%= resourceBundles.getString(ENGLISH_PRONOUN_HE)  %></span>
          <% } %>
        </span>
        <% } %>
      </div>
      <ol
        <% if (!lang.equals(toLang)) { %> lang="<%= toLang %>"<% } %>
        <% if (verbListSize == 1) { %> style="list-style-type: none;"<% } %>
      >
      <%
        String question = null;
        for (int i = 0; i < verbList.size(); i++) {
            Verb verbI = (Verb)verbList.get(i);
            Map verbConjugationMapI = (Map)verbI.getVerbConjugationMap();
            VerbConjugation verbConjugationI = (VerbConjugation)verbConjugationMapI.get(tenseId);
            question = verbConjugationI.getQuestion();
            if (
              question != null
              && !question.equals(EMPTY)
            ) {
      %>
        <li><span class="definition"><%= definitionOutput.linkizeWords(question, toLanguage, fromLanguage) %></span></li>
      <%
            }
        }
      %>
      </ol>
    </li>
    <% } %>
  </ol>
<%--/div--%>
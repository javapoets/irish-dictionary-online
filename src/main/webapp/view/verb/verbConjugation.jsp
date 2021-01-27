<%
    String ENGLISH_PRONOUN_ME = "me";
    String ENGLISH_PRONOUN_YOU = "you";
    String ENGLISH_PRONOUN_HE = "he";
    String ENGLISH_PRONOUN_SHE = "she";
    String ENGLISH_PRONOUN_WE = "we";
    String ENGLISH_PRONOUN_YOU_PLURAL = "you";
    String ENGLISH_PRONOUN_THEY = "they";
    String ENGLISH_AUTONOMOUS = "autonomous";
    String ENGLISH_NEGATIVE = "negative";
    String ENGLISH_QUESTION = "question";
%>
  <div class="table">
    <div class="row">
      <div class="cell verb-tense-header">
        <div><%= resourceBundles.getString(verbConjugation.getTenseEnglish()) %></div>
      </div>
    </div>
  </div>
  <ol style="list-style-type: none;">
    <li>
      <div class="word-line">
        <span class="word"<% if (!lang.equals(fromLang)) { %> lang="<%= fromLang %>"<% } %>>
          <%= definitionOutput.linkizeWords(verbConjugation.getMe(), fromLanguage, toLanguage) %>
        </span>
        <span class="type">
          <%= resourceBundles.getString(ENGLISH_PRONOUN_ME)  %>
          <%= resourceBundles.getString(fromLanguage)  %>
        </span>
      </div>
      <ol>
      <%
        String me = null;
        for (int i = 0; i < verbList.size(); i++) {
            Verb verbI = (Verb)verbList.get(i);
            Map verbConjugationMapI = (Map)verbI.getVerbConjugationMap();
            VerbConjugation verbConjugationI = (VerbConjugation)verbConjugationMapI.get(tenseId);
            me = verbConjugationI.getMe();
            log.debug("me = " + me);
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
        <span class="word"<% if (!lang.equals(fromLang)) { %> lang="<%= fromLang %>"<% } %>><%= definitionOutput.linkizeWords(verbConjugation.getYouSingular(), fromLanguage, toLanguage) %></span>
        <span class="type">
          <%= resourceBundles.getString(ENGLISH_PRONOUN_YOU)  %>
          <%--= resourceBundles.getString(fromLanguage)  --%>
          <%--= isEnglish ? resourceBundles.getString(IRISH) : resourceBundles.getString(ENGLISH) --%> 
          <%= resourceBundles.getString(verbConjugation.getTenseEnglish()) %>
          <%= resourceBundles.getString(fromLanguage)  %>
        </span>
      </div>
      <ol<% if (!lang.equals(toLang)) { %> lang="<%= toLang %>"<% } %>>
      <%
        String youSingular = null;
        for (int i = 0; i < verbList.size(); i++) {
            Verb verbI = (Verb)verbList.get(i);
            Map verbConjugationMapI = (Map)verbI.getVerbConjugationMap();
            VerbConjugation verbConjugationI = (VerbConjugation)verbConjugationMapI.get(tenseId);
            youSingular = verbConjugationI.getYouSingular();
            log.debug("youSingular = " + youSingular);
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
        <span class="word"<% if (!lang.equals(fromLang)) { %> lang="<%= fromLang %>"<% } %>><%= definitionOutput.linkizeWords(verbConjugation.getHe(), fromLanguage, toLanguage) %></span>
        <span class="type">
          <%= resourceBundles.getString(ENGLISH_PRONOUN_HE)  %>
          <%= resourceBundles.getString(verbConjugation.getTenseEnglish()) %>
          <%--= resourceBundles.getString(toLanguage)  %>
          <%= resourceBundles.getString(fromLanguage)  --%>
          <%= resourceBundles.getString(fromLanguage)  %>
          <%--= isEnglish ? resourceBundles.getString(IRISH): resourceBundles.getString(ENGLISH) --%>  
        </span>
      </div>
      <ol<% if (!lang.equals(toLang)) { %> lang="<%= toLang %>"<% } %>>
      <%
        String he = null;
        for (int i = 0; i < verbList.size(); i++) {
            Verb verbI = (Verb)verbList.get(i);
            Map verbConjugationMapI = (Map)verbI.getVerbConjugationMap();
            VerbConjugation verbConjugationI = (VerbConjugation)verbConjugationMapI.get(tenseId);
            he = verbConjugationI.getHe();
            log.debug("he = " + he);
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
        <span class="word"<% if (!lang.equals(fromLang)) { %> lang="<%= fromLang %>"<% } %>><%= definitionOutput.linkizeWords(verbConjugation.getShe(), fromLanguage, toLanguage) %></span>
        <span class="type">
          <%= resourceBundles.getString(ENGLISH_PRONOUN_SHE)  %>
          <%= resourceBundles.getString(verbConjugation.getTenseEnglish()) %>
          <%= resourceBundles.getString(fromLanguage)  %>
        </span>
      </div>
      <ol<% if (!lang.equals(toLang)) { %> lang="<%= toLang %>"<% } %>>
      <%
        String she = null;
        for (int i = 0; i < verbList.size(); i++) {
            Verb verbI = (Verb)verbList.get(i);
            Map verbConjugationMapI = (Map)verbI.getVerbConjugationMap();
            VerbConjugation verbConjugationI = (VerbConjugation)verbConjugationMapI.get(tenseId);
            she = verbConjugationI.getShe();
            log.debug("she = " + she);
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
        <span class="word"<% if (!lang.equals(fromLang)) { %> lang="<%= fromLang %>"<% } %>><%= definitionOutput.linkizeWords(verbConjugation.getWe(), fromLanguage, toLanguage) %></span>
        <span class="type">
          <%= resourceBundles.getString(ENGLISH_PRONOUN_WE)  %>
          <%= resourceBundles.getString(verbConjugation.getTenseEnglish()) %>
          <%= resourceBundles.getString(fromLanguage)  %>
        </span>
      </div>
      <ol<% if (!lang.equals(toLang)) { %> lang="<%= toLang %>"<% } %>>
      <%
        String we = null;
        for (int i = 0; i < verbList.size(); i++) {
            Verb verbI = (Verb)verbList.get(i);
            Map verbConjugationMapI = (Map)verbI.getVerbConjugationMap();
            VerbConjugation verbConjugationI = (VerbConjugation)verbConjugationMapI.get(tenseId);
            we = verbConjugationI.getWe();
            log.debug("we = " + we);
            if (we != null) {
      %>
        <li><span class="definition"><%= definitionOutput.linkizeWords(we, toLanguage, fromLanguage) %></span></li>
      <%
            }
        }
      %>
      </ol>
    </li>
    <li>
      <div class="word-line">
        <span class="word"<% if (!lang.equals(fromLang)) { %> lang="<%= fromLang %>"<% } %>><%= definitionOutput.linkizeWords(verbConjugation.getYouPlural(), fromLanguage, toLanguage) %></span>
        <span class="type">
          <%= resourceBundles.getString(ENGLISH_PRONOUN_YOU_PLURAL)  %>
          <%= resourceBundles.getString(verbConjugation.getTenseEnglish()) %>
          <%= resourceBundles.getString(fromLanguage)  %>
        </span>
      </div>
      <ol<% if (!lang.equals(toLang)) { %> lang="<%= toLang %>"<% } %>>
      <%
        String youPlural = null;
        for (int i = 0; i < verbList.size(); i++) {
            Verb verbI = (Verb)verbList.get(i);
            Map verbConjugationMapI = (Map)verbI.getVerbConjugationMap();
            VerbConjugation verbConjugationI = (VerbConjugation)verbConjugationMapI.get(tenseId);
            youPlural = verbConjugationI.getYouPlural();
            log.debug("youPlural = " + youPlural);
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
        <%--
        <span class="word"<% if (!lang.equals(fromLang)) { %> lang="<%= fromLang %>"<% } %>><%= definitionOutput.linkizeWords(verbConjugation.getThey(), fromLanguage, toLanguage) %></span>
        --%>
        <span class="word">
          <%
            log.debug("verbConjugation = " + verbConjugation);
            log.debug("verbConjugation.getThey() = " + verbConjugation.getThey());
          %>
          <%= definitionOutput.linkizeWords(verbConjugation.getThey(), fromLanguage, toLanguage) %>
        </span>
        <span class="type">
          <%= resourceBundles.getString(ENGLISH_PRONOUN_THEY)  %>
          <%= resourceBundles.getString(verbConjugation.getTenseEnglish()) %>
          <%= resourceBundles.getString(fromLanguage)  %>
        </span>
      </div>
      <ol<% if (!lang.equals(toLang)) { %> lang="<%= toLang %>"<% } %>>
      <%
        String they = null;
        for (int i = 0; i < verbList.size(); i++) {
            Verb verbI = (Verb)verbList.get(i);
            Map verbConjugationMapI = (Map)verbI.getVerbConjugationMap();
            VerbConjugation verbConjugationI = (VerbConjugation)verbConjugationMapI.get(tenseId);
            they = verbConjugationI.getThey();
            log.debug("they = " + they);
            if (they != null) {
      %>
        <li><span class="definition"><%= definitionOutput.linkizeWords(they, toLanguage, fromLanguage) %></span></li>
      <%
            }
        }
      %>
      </ol>
    </li>
    <li>
      <div class="word-line">
        <span class="word"<% if (!lang.equals(fromLang)) { %> lang="<%= fromLang %>"<% } %>><%= definitionOutput.linkizeWords(verbConjugation.getAutonomous(), fromLanguage, toLanguage) %></span>
        <span class="type">
          <%= resourceBundles.getString(ENGLISH_AUTONOMOUS)  %>
          <%= resourceBundles.getString(verbConjugation.getTenseEnglish()) %>
          <%= resourceBundles.getString(fromLanguage)  %>
        </span>
      </div>
      <ol<% if (!lang.equals(toLang)) { %> lang="<%= toLang %>"<% } %>>
      <%
        String autonomous = null;
        for (int i = 0; i < verbList.size(); i++) {
            Verb verbI = (Verb)verbList.get(i);
            Map verbConjugationMapI = (Map)verbI.getVerbConjugationMap();
            VerbConjugation verbConjugationI = (VerbConjugation)verbConjugationMapI.get(tenseId);
            autonomous = verbConjugationI.getAutonomous();
            log.debug("autonomous = " + autonomous);
            if (
              autonomous != null
              && !autonomous.equals("")
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
        <span class="word"<% if (!lang.equals(fromLang)) { %> lang="<%= fromLang %>"<% } %>>
          <%= definitionOutput.linkizeWords(verbConjugation.getNegative(), fromLanguage, toLanguage) %>
        </span>
        <span class="type">
          <%= resourceBundles.getString(ENGLISH_NEGATIVE)  %>
          <%= resourceBundles.getString(verbConjugation.getTenseEnglish()) %>
          <%= resourceBundles.getString(fromLanguage)  %>
        </span>
      </div>
      <ol<% if (!lang.equals(toLang)) { %> lang="<%= toLang %>"<% } %>>
      <%
        String negative = null;
        for (int i = 0; i < verbList.size(); i++) {
            Verb verbI = (Verb)verbList.get(i);
            Map verbConjugationMapI = (Map)verbI.getVerbConjugationMap();
            VerbConjugation verbConjugationI = (VerbConjugation)verbConjugationMapI.get(tenseId);
            negative = verbConjugationI.getNegative();
            if (
              negative != null
              && !negative.equals("")
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
        <span class="word"<% if (!lang.equals(fromLang)) { %> lang="<%= fromLang %>"<% } %>>
          <%= definitionOutput.linkizeWords(verbConjugation.getQuestion(), fromLanguage, toLanguage) %>
        </span>
        <span class="type">
          <%= resourceBundles.getString(ENGLISH_QUESTION)  %>
          <%= resourceBundles.getString(verbConjugation.getTenseEnglish()) %>
          <%= resourceBundles.getString(fromLanguage)  %>
        </span>
      </div>
      <ol<% if (!lang.equals(toLang)) { %> lang="<%= toLang %>"<% } %>>
      <%
        String question = null;
        for (int i = 0; i < verbList.size(); i++) {
            Verb verbI = (Verb)verbList.get(i);
            Map verbConjugationMapI = (Map)verbI.getVerbConjugationMap();
            VerbConjugation verbConjugationI = (VerbConjugation)verbConjugationMapI.get(tenseId);
            question = verbConjugationI.getQuestion();
            if (
              question != null
              && !question.equals("")
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
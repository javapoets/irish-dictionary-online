<%--    
    I/Mé
    You/Tú (singular/uatha)
    He/Sé
    She/Sí
    We/Muid
    You/Sibh (plural/iolra)
    They/Siad
    Autonomous/Saorbhriathar
    Negative/Diúltach
    Question/Ceisteach
--%>
<%
    String ENGLISH_PRONOUN_ME = "I";
    String IRISH_PRONOUN_ME = "Mé";
    String ENGLISH_PRONOUN_YOU = "You";
    String IRISH_PRONOUN_YOU = "Tú";
    String ENGLISH_PRONOUN_HE = "He";
    String IRISH_PRONOUN_HE = "Sé";
    String ENGLISH_PRONOUN_SHE = "She";
    String IRISH_PRONOUN_SHE = "Sí";
    String ENGLISH_PRONOUN_WE = "We";
    String IRISH_PRONOUN_WE = "Muid";
    String ENGLISH_PRONOUN_YOU_PLURAL = "You";
    String IRISH_PRONOUN_YOU_PLURAL = "Sibh";
    String ENGLISH_PRONOUN_THEY = "They";
    String IRISH_PRONOUN_THEY = "Siad";
    String ENGLISH_AUTONOMOUS = "Autonomous";
    String IRISH_AUTONOMOUS = "Saorbhriathar";
    String ENGLISH_NEGATIVE = "Negative";
    String IRISH_NEGATIVE = "Diúltach";
    String ENGLISH_QUESTION = "Question";
    String IRISH_QUESTION = "Ceisteach";
%>
<div class="table">
  <div class="row">
    <div class="cell usage-label underline">&nbsp;</div>
    <div class="cell verb-tense-header">
      <% if (isEnglish) { %>
        <%--= verbConjugation.getTenseEnglish() %> - <%= verbConjugation.getTenseIrish() --%>
        <div><%= verbConjugation.getTenseEnglish() %> -</div> <div> <%= verbConjugation.getTenseIrish() %></div>
      <% } else { %>
        <div><%= verbConjugation.getTenseIrish() %> -</div> <div> <%= verbConjugation.getTenseEnglish() %></div>
      <% } %>
    </div>
  </div>
  <div class="row">
    <div class="cell usage-label">
      <%= isEnglish ?
            new StringBuilder().append(ENGLISH).append(SPACE).append(parenthesis(ENGLISH_PRONOUN_ME))
          : new StringBuilder().append(IRISH).append(SPACE).append(parenthesis(IRISH_PRONOUN_ME)) %>
    </div>
    <%--div class="cell usage"><%= verbConjugation.getMe() %></div--%>
    <%--div class="cell usage"><%= definitionOutput.linkizeWords(verbConjugation.getMe(), isEnglish ? toLanguage : fromLanguage, isEnglish ? fromLanguage : toLanguage) %></div--%>
    <%--div class="cell usage"><%= definitionOutput.linkizeWords(verbConjugation.getMe(), isEnglish ? fromLanguage : toLanguage, isEnglish ? toLanguage : fromLanguage) %></div--%>
    <div class="cell usage"><%= definitionOutput.linkizeWords(verbConjugation.getMe(), fromLanguage, toLanguage) %></div>
  </div>
  <div class="row">
    <div class="cell usage-label underline">
      <%= isEnglish ?
            new StringBuilder().append(IRISH).append(SPACE).append(parenthesis(IRISH_PRONOUN_ME))
          : new StringBuilder().append(ENGLISH).append(SPACE).append(parenthesis(ENGLISH_PRONOUN_ME)) %>
    </div>
    <div class="cell translated underline">
      <%
        StringBuilder stringBuilder = new StringBuilder();
        String me = null;
        for (int i = 0; i < verbList.size(); i++) {
            Verb verbI = (Verb)verbList.get(i);
            Map verbConjugationMapI = (Map)verbI.getVerbConjugationMap();
            VerbConjugation verbConjugationI = (VerbConjugation)verbConjugationMapI.get(tenseId);
            me = verbConjugationI.getMe();
            if (me != null) {
                if (i > 0) stringBuilder.append(", ");
                stringBuilder.append(me);
            }
        }
        if (stringBuilder.length() > 0) {
      %>
        <%--= definitionOutput.linkizeWords(stringBuilder.toString(), isEnglish ? fromLanguage : toLanguage, isEnglish ? toLanguage : fromLanguage) --%>
        <%= definitionOutput.linkizeWords(stringBuilder.toString(), toLanguage, fromLanguage) %>
      <% } else { %>
        &nbsp;
      <% } %>
    </div>
  </div>
  <div class="row">
    <div class="cell usage-label english">
      <%= isEnglish ?
            new StringBuilder().append(ENGLISH).append(SPACE).append(parenthesis(ENGLISH_PRONOUN_YOU))
          : new StringBuilder().append(IRISH).append(SPACE).append(parenthesis(IRISH_PRONOUN_YOU)) %>
    </div>
    <div class="cell usage"><%= definitionOutput.linkizeWords(verbConjugation.getYouSingular(), fromLanguage, toLanguage) %></div>
  </div>
  <div class="row">
    <div class="cell usage-label underline">
      <%= isEnglish ?
            new StringBuilder().append(IRISH).append(SPACE).append(parenthesis(IRISH_PRONOUN_YOU))
          : new StringBuilder().append(ENGLISH).append(SPACE).append(parenthesis(ENGLISH_PRONOUN_YOU)) %>
    </div>
    <div class="cell translated underline">
      <%
        stringBuilder = new StringBuilder();
        String youSingular = null;
        for (int i = 0; i < verbList.size(); i++) {
            Verb verbI = (Verb)verbList.get(i);
            Map verbConjugationMapI = (Map)verbI.getVerbConjugationMap();
            VerbConjugation verbConjugationI = (VerbConjugation)verbConjugationMapI.get(tenseId);
            youSingular = verbConjugationI.getYouSingular();
            if (youSingular != null) {
                if (i > 0) stringBuilder.append(", ");
                stringBuilder.append(youSingular);
            }
        }
        if (stringBuilder.length() > 0) {
      %>
        <%= definitionOutput.linkizeWords(stringBuilder.toString(), toLanguage, fromLanguage) %>
      <% } else { %>
        &nbsp;
      <% } %>
    </div>
  </div>
  <div class="row">
    <div class="cell usage-label english">
      <%= isEnglish ?
            new StringBuilder().append(ENGLISH).append(SPACE).append(parenthesis(ENGLISH_PRONOUN_HE))
          : new StringBuilder().append(IRISH).append(SPACE).append(parenthesis(IRISH_PRONOUN_HE)) %>
    </div>
    <div class="cell usage"><%= definitionOutput.linkizeWords(verbConjugation.getHe(), fromLanguage, toLanguage) %></div>
  </div>
  <div class="row">
    <div class="cell usage-label underline">
      <%= isEnglish ?
            new StringBuilder().append(IRISH).append(SPACE).append(parenthesis(IRISH_PRONOUN_HE))
          : new StringBuilder().append(ENGLISH).append(SPACE).append(parenthesis(ENGLISH_PRONOUN_HE)) %>
    </div>
    <div class="cell translated underline">
      <%
        stringBuilder = new StringBuilder();
        String he = null;
        for (int i = 0; i < verbList.size(); i++) {
            Verb verbI = (Verb)verbList.get(i);
            Map verbConjugationMapI = (Map)verbI.getVerbConjugationMap();
            VerbConjugation verbConjugationI = (VerbConjugation)verbConjugationMapI.get(tenseId);
            he = verbConjugationI.getHe();
            if (he != null) {
                if (i > 0) stringBuilder.append(", ");
                stringBuilder.append(he);
            }
        }
        if (stringBuilder.length() > 0) {
      %>
        <%= definitionOutput.linkizeWords(stringBuilder.toString(), toLanguage, fromLanguage) %>
      <% } else { %>
        &nbsp;
      <% } %>
    </div>
  </div>
  <div class="row">
    <div class="cell usage-label english">
      <%= isEnglish ?
            new StringBuilder().append(ENGLISH).append(SPACE).append(parenthesis(ENGLISH_PRONOUN_SHE))
          : new StringBuilder().append(IRISH).append(SPACE).append(parenthesis(IRISH_PRONOUN_SHE)) %>
    </div>
    <div class="cell usage"><%= definitionOutput.linkizeWords(verbConjugation.getShe(), fromLanguage, toLanguage) %></div>
  </div>
  <div class="row">
    <div class="cell usage-label underline">
      <%= isEnglish ?
            new StringBuilder().append(IRISH).append(SPACE).append(parenthesis(IRISH_PRONOUN_SHE))
          : new StringBuilder().append(ENGLISH).append(SPACE).append(parenthesis(ENGLISH_PRONOUN_SHE)) %>
    </div>
    <div class="cell translated underline">
      <%
        stringBuilder = new StringBuilder();
        String she = null;
        for (int i = 0; i < verbList.size(); i++) {
            Verb verbI = (Verb)verbList.get(i);
            Map verbConjugationMapI = (Map)verbI.getVerbConjugationMap();
            VerbConjugation verbConjugationI = (VerbConjugation)verbConjugationMapI.get(tenseId);
            she = verbConjugationI.getShe();
            if (she != null) {
                if (i > 0) stringBuilder.append(", ");
                stringBuilder.append(she);
            }
        }
        if (stringBuilder.length() > 0) {
      %>
        <%= definitionOutput.linkizeWords(stringBuilder.toString(), toLanguage, fromLanguage) %>
      <% } else { %>
        &nbsp;
      <% } %>
    </div>
  </div>
  <div class="row">
    <div class="cell usage-label english">
      <%= isEnglish ?
            new StringBuilder().append(ENGLISH).append(SPACE).append(parenthesis(ENGLISH_PRONOUN_WE))
          : new StringBuilder().append(IRISH).append(SPACE).append(parenthesis(IRISH_PRONOUN_WE)) %>
    </div>
    <div class="cell usage"><%= definitionOutput.linkizeWords(verbConjugation.getWe(), fromLanguage, toLanguage) %></div>
  </div>
  <div class="row">
    <div class="cell usage-label underline">
      <%= isEnglish ?
            new StringBuilder().append(IRISH).append(SPACE).append(parenthesis(IRISH_PRONOUN_WE))
          : new StringBuilder().append(ENGLISH).append(SPACE).append(parenthesis(ENGLISH_PRONOUN_WE)) %>
    </div>
    <div class="cell translated underline">
      <%
        stringBuilder = new StringBuilder();
        String we = null;
        for (int i = 0; i < verbList.size(); i++) {
            Verb verbI = (Verb)verbList.get(i);
            Map verbConjugationMapI = (Map)verbI.getVerbConjugationMap();
            VerbConjugation verbConjugationI = (VerbConjugation)verbConjugationMapI.get(tenseId);
            we = verbConjugationI.getWe();
            if (we != null) {
                if (i > 0) stringBuilder.append(", ");
                stringBuilder.append(we);
            }
        }
        if (stringBuilder.length() > 0) {
      %>
        <%= definitionOutput.linkizeWords(stringBuilder.toString(), toLanguage, fromLanguage) %>
      <% } else { %>
        &nbsp;
      <% } %>
    </div>
  </div>
  <div class="row">
    <div class="cell usage-label english">
      <%= isEnglish ?
            new StringBuilder().append(ENGLISH).append(SPACE).append(parenthesis(ENGLISH_PRONOUN_YOU_PLURAL))
          : new StringBuilder().append(IRISH).append(SPACE).append(parenthesis(IRISH_PRONOUN_YOU_PLURAL)) %>
    </div>
    <div class="cell usage"><%= definitionOutput.linkizeWords(verbConjugation.getYouPlural(), fromLanguage, toLanguage) %></div>
  </div>
  <div class="row">
    <div class="cell usage-label underline">
      <%= isEnglish ?
            new StringBuilder().append(IRISH).append(SPACE).append(parenthesis(IRISH_PRONOUN_YOU_PLURAL))
          : new StringBuilder().append(ENGLISH).append(SPACE).append(parenthesis(ENGLISH_PRONOUN_YOU_PLURAL)) %>
    </div>
    <div class="cell translated underline">
      <%
        stringBuilder = new StringBuilder();
        String youPlural = null;
        for (int i = 0; i < verbList.size(); i++) {
            Verb verbI = (Verb)verbList.get(i);
            Map verbConjugationMapI = (Map)verbI.getVerbConjugationMap();
            VerbConjugation verbConjugationI = (VerbConjugation)verbConjugationMapI.get(tenseId);
            youPlural = verbConjugationI.getYouPlural();
            if (youPlural != null) {
                if (i > 0) stringBuilder.append(", ");
                stringBuilder.append(youPlural);
            }
        }
        if (stringBuilder.length() > 0) {
      %>
        <%= definitionOutput.linkizeWords(stringBuilder.toString(), toLanguage, fromLanguage) %>
      <% } else { %>
        &nbsp;
      <% } %>
    </div>
  </div>
  <div class="row">
    <div class="cell usage-label english">
      <%= isEnglish ?
            new StringBuilder().append(ENGLISH).append(SPACE).append(parenthesis(ENGLISH_PRONOUN_THEY))
          : new StringBuilder().append(IRISH).append(SPACE).append(parenthesis(IRISH_PRONOUN_THEY)) %>
    </div>
    <div class="cell usage"><%= definitionOutput.linkizeWords(verbConjugation.getThey(), fromLanguage, toLanguage) %></div>
  </div>
  <div class="row">
    <div class="cell usage-label underline">
      <%= isEnglish ?
            new StringBuilder().append(IRISH).append(SPACE).append(parenthesis(IRISH_PRONOUN_THEY))
          : new StringBuilder().append(ENGLISH).append(SPACE).append(parenthesis(ENGLISH_PRONOUN_THEY)) %>
    </div>
    <div class="cell translated underline">
      <%
        stringBuilder = new StringBuilder();
        String they = null;
        for (int i = 0; i < verbList.size(); i++) {
            Verb verbI = (Verb)verbList.get(i);
            Map verbConjugationMapI = (Map)verbI.getVerbConjugationMap();
            VerbConjugation verbConjugationI = (VerbConjugation)verbConjugationMapI.get(tenseId);
            they = verbConjugationI.getThey();
            if (they != null) {
                if (i > 0) stringBuilder.append(", ");
                stringBuilder.append(they);
            }
        }
        if (stringBuilder.length() > 0) {
      %>
        <%= definitionOutput.linkizeWords(stringBuilder.toString(), toLanguage, fromLanguage) %>
      <% } else { %>
        &nbsp;
      <% } %>
    </div>
  </div>
  <div class="row">
    <div class="cell usage-label english">
      <%= isEnglish ?
            new StringBuilder().append(ENGLISH).append(SPACE).append(parenthesis(ENGLISH_AUTONOMOUS))
          : new StringBuilder().append(IRISH).append(SPACE).append(parenthesis(IRISH_AUTONOMOUS)) %>
    </div>
    <div class="cell usage"><%= definitionOutput.linkizeWords(verbConjugation.getAutonomous(), fromLanguage, toLanguage) %></div>
  </div>
  <div class="row">
    <div class="cell usage-label underline">
      <%= isEnglish ?
            new StringBuilder().append(IRISH).append(SPACE).append(parenthesis(IRISH_AUTONOMOUS))
          : new StringBuilder().append(ENGLISH).append(SPACE).append(parenthesis(ENGLISH_AUTONOMOUS)) %>
    </div>
    <div class="cell translated underline">
      <%
        stringBuilder = new StringBuilder();
        String autonomous = null;
        for (int i = 0; i < verbList.size(); i++) {
            Verb verbI = (Verb)verbList.get(i);
            Map verbConjugationMapI = (Map)verbI.getVerbConjugationMap();
            VerbConjugation verbConjugationI = (VerbConjugation)verbConjugationMapI.get(tenseId);
            autonomous = verbConjugationI.getAutonomous();
            if (
              autonomous != null
              && !autonomous.equals("")
            ) {
                if (i > 0) stringBuilder.append(", ");
                stringBuilder.append(autonomous);
            }
        }
        if (stringBuilder.length() > 0) {
      %>
        <%= definitionOutput.linkizeWords(stringBuilder.toString(), toLanguage, fromLanguage) %>
      <% } else { %>
        &nbsp;
      <% } %>
    </div>
  </div>
  <div class="row">
    <div class="cell usage-label english">
      <%= isEnglish ?
            new StringBuilder().append(ENGLISH).append(SPACE).append(parenthesis(ENGLISH_NEGATIVE))
          : new StringBuilder().append(IRISH).append(SPACE).append(parenthesis(IRISH_NEGATIVE)) %>
    </div>
    <div class="cell usage"><%= definitionOutput.linkizeWords(verbConjugation.getNegative(), fromLanguage, toLanguage) %></div>
  </div>
  <div class="row">
    <div class="cell usage-label underline">
      <%= isEnglish ?
            new StringBuilder().append(IRISH).append(SPACE).append(parenthesis(IRISH_NEGATIVE))
          : new StringBuilder().append(ENGLISH).append(SPACE).append(parenthesis(ENGLISH_NEGATIVE)) %>
    </div>
    <div class="cell translated underline">
      <%
        stringBuilder = new StringBuilder();
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
                if(i > 0) stringBuilder.append(", ");
                stringBuilder.append(negative);
            }
        }
        if (stringBuilder.length() > 0) {
      %>
        <%= definitionOutput.linkizeWords(stringBuilder.toString(), toLanguage, fromLanguage) %>
      <% } else { %>
        &nbsp;
      <% } %>
    </div>
  </div>
  <%
      if (!EMPTY.equals(verbConjugation.getQuestion())) {
  %>
  <div class="row">
    <div class="cell usage-label english">
      <%= isEnglish ?
          new StringBuilder().append(ENGLISH).append(SPACE).append(parenthesis(ENGLISH_QUESTION))
        : new StringBuilder().append(IRISH).append(SPACE).append(parenthesis(IRISH_QUESTION)) %>
    </div>
    <div class="cell usage"><%= definitionOutput.linkizeWords(verbConjugation.getQuestion(), fromLanguage, toLanguage) %></div>
  </div>
  <div class="row">
    <div class="cell usage-label">
      <%= isEnglish ?
            new StringBuilder().append(IRISH).append(SPACE).append(parenthesis(IRISH_QUESTION))
          : new StringBuilder().append(ENGLISH).append(SPACE).append(parenthesis(ENGLISH_QUESTION)) %>
    </div>
    <div class="cell translated">
      <%
        stringBuilder = new StringBuilder();
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
                if (i > 0) stringBuilder.append(", ");
                stringBuilder.append(question);
            }
        }
        if (stringBuilder.length() > 0) {
      %>
        <%= definitionOutput.linkizeWords(stringBuilder.toString(), toLanguage, fromLanguage) %>
      <% } else { %>
        &nbsp;
      <% } %>
    </div>
  </div>
  <% } %>
</div>
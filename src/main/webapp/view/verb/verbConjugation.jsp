<% if (isEnglish) { %>
  <div class="verb-tense-header">
    <%= verbConjugation.getTenseEnglish() %> - <%= verbConjugation.getTenseIrish() %>
  </div>
<% } else { %>
  <div style="list-style:none;text-align:left;font-family:arial;border-bottom:#ccc 1px solid;">
    <%= verbConjugation.getTenseIrish() %> - <%= verbConjugation.getTenseEnglish() %>
  </div>
<% } %>
<%--    
<ol style="list-style:none;text-align:left;font-family:arial;">
  <li>
    I/mé
    You/tú (singular/uatha)
    He/sé
    She/sí
    We/muid
    You/sibh (plural/iolra)
    They/siad
--%>    
<div class="table">
  <div class="row">
    <div class="cell usage-label"><%= isEnglish ? ENGLISH : IRISH %> (I/Mé) </div>
    <div class="cell usage"><%= verbConjugation.getMe() %></div>
  </div>
  <div class="row">
    <div class="cell usage-label underline"><%= isEnglish ? IRISH : ENGLISH %> (I/Mé) </div>
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
      <%= stringBuilder.toString() %>
      <%
        }
      %>
    </div>
  </div>
  <div class="row">
    <div class="cell usage-label english"><%= isEnglish ? ENGLISH : IRISH %> (You/Tú) </div>
    <div class="cell usage"><%= verbConjugation.getYouSingular() %></div>
  </div>
  <div class="row">
    <div class="cell usage-label underline"><%= isEnglish ? IRISH : ENGLISH %> (You/Tú) </div>
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
      <%= stringBuilder.toString() %>
    </div>
    <%
        }
    %>
  </div>
  <div class="row">
    <div class="cell usage-label english"><%= isEnglish ? ENGLISH : IRISH %> (He/Sé) </div>
    <div class="cell usage"><%= verbConjugation.getHe() %></div>
  </div>
  <div class="row">
    <div class="cell usage-label underline"><%= isEnglish ? IRISH : ENGLISH %> (He/Sé) </div>
    <div class="cell translated underline">
      <%
        stringBuilder = new StringBuilder();
        String he = null;
        for(int i = 0; i < verbList.size(); i++) {
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
      <%= stringBuilder.toString() %>
      <% } %>
    </div>
  </div>
  <div class="row">
    <div class="cell usage-label english"><%= isEnglish ? ENGLISH : IRISH %> (She/Sí) </div>
    <div class="usage"><%= verbConjugation.getShe() %></div>
  </div>
  <div class="row">
    <div class="cell usage-label underline"><%= isEnglish ? IRISH : ENGLISH %> (She/Sí) </div>
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
      <%= stringBuilder.toString() %>
      <% } %>
    </div>
  </div>
  <div class="row">
    <div class="cell usage-label english"><%= isEnglish ? ENGLISH : IRISH %> (We/Muid) </div>
    <div class="cell usage"><%= verbConjugation.getWe() %></div>
  </div>
  <div class="row">
    <div class="cell usage-label underline"><%= isEnglish ? IRISH : ENGLISH %> (We/Muid) </div>
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
      <%= stringBuilder.toString() %>
    </div>
    <% } %>
  </div>
  <div class="row">
    <div class="cell usage-label english"><%= isEnglish ? ENGLISH : IRISH %> (You/Sibh) </div>
    <div class="cell usage"><%= verbConjugation.getYouPlural() %></div>
  </div>
  <div class="row">
    <div class="cell usage-label underline"><%= isEnglish ? IRISH : ENGLISH %> (You/Sibh) </div>
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
      <%= stringBuilder.toString() %>
      <% } %>
    </div>
  </div>
  <div class="row">
    <div class="cell usage-label english"><%= isEnglish ? ENGLISH : IRISH %> (They/Siad) </div>
    <div class="cell usage"><%= verbConjugation.getThey() %></div>
  </div>
  <div class="row">
    <div class="cell usage-label underline"><%= isEnglish ? IRISH : ENGLISH %> (They/Siad) </div>
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
                if(i > 0) stringBuilder.append(", ");
                stringBuilder.append(they);
            }
        }
        if (stringBuilder.length() > 0) {
      %>
      <%= stringBuilder.toString() %>
      <% } %>
    </div>
  </div>
  <div class="row">
    <div class="cell usage-label english"><%= isEnglish ? ENGLISH : IRISH %> (Autonomous) </div>
    <div class="cell usage"><%= verbConjugation.getAutonomous() %></div>
  </div>
  <div class="row">
    <div class="cell usage-label underline"><%= isEnglish ? IRISH : ENGLISH %> (Saorbhriathar)</div>
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
                if(i > 0) stringBuilder.append(", ");
                stringBuilder.append(autonomous);
            }
        }
        if (stringBuilder.length() > 0) {
      %>
      <%= stringBuilder.toString() %>
      <% } %>
    </div>
  </div>
  <div class="row">
    <div class="cell usage-label english"><%= isEnglish ? ENGLISH : IRISH %> (Negative/<span style="font-size:10px;">Diúltach</span>) </div>
    <div class="cell usage"><%= verbConjugation.getNegative() %></div>
  </div>
  <div class="row">
    <div class="cell usage-label underline"><%= isEnglish ? IRISH : ENGLISH %> (Negative/<span style="font-size:10px;">Diúltach</span>) </div>
    <div class="cell translated underline">
      <%
        stringBuilder = new StringBuilder();
        String negative = null;
        for (int i = 0; i < verbList.size(); i++) {
            Verb verbI = (Verb)verbList.get(i);
            Map verbConjugationMapI = (Map)verbI.getVerbConjugationMap();
            VerbConjugation verbConjugationI = (VerbConjugation)verbConjugationMapI.get(tenseId);
            negative = verbConjugationI.getNegative();
            if(
              negative != null
              && !negative.equals("")
            ) {
                if(i > 0) stringBuilder.append(", ");
                stringBuilder.append(negative);
            }
        }
        if (stringBuilder.length() > 0) {
      %>
      <%= stringBuilder.toString() %>
      <% } %>
    </div>
  </div>
  <div class="row">
    <div class="cell usage-label english"><%= isEnglish ? ENGLISH : IRISH %> (Question/<span style="font-size:10px;">Ceisteach</span>) </div>
    <div class="cell usage"><%= verbConjugation.getQuestion() %></div>
  </div>
  <div class="row">
    <div class="cell usage-label underline"><%= isEnglish ? IRISH : ENGLISH %> (Question/<span style="font-size:10px;">Ceisteach</span>) </div>
    <div class="cell translated underline">
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
                if(i > 0) stringBuilder.append(", ");
                stringBuilder.append(question);
            }
        }
        if(stringBuilder.length() > 0) {
      %>
      <%= stringBuilder.toString() %>
      <% } %>
    </div>
  </div>
</div>
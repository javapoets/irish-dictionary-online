<% if (isEnglish) { %>
  <div style="list-style:none;text-align:left;font-family:arial;border-bottom:#ccc 1px solid;">
    <%= verbConjugation.getTenseEnglish() %> - <%= verbConjugation.getTenseIrish() %>
  </div>
<% } else { %>
  <div style="list-style:none;text-align:left;font-family:arial;border-bottom:#ccc 1px solid;">
    <%= verbConjugation.getTenseIrish() %> - <%= verbConjugation.getTenseEnglish() %>
  </div>
<% } %>
<ol style="list-style:none;text-align:left;font-family:arial;">
  <li>
<%--    
    I/mé
    You/tú (singular/uatha)
    He/sé
    She/sí
    We/muid
    You/sibh (plural/iolra)
    They/siad
--%>    
    <div>
      <span class="usage-label english"><%= isEnglish ? ENGLISH : IRISH %> (I/Mé) </span>
      <span class="usage"><%= verbConjugation.getMe() %></span>
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
      <br/>
      <span class="usage-label irish"><%= isEnglish ? IRISH : ENGLISH %> (I/Mé) </span>
      <span class="translated">
      <%= stringBuilder.toString() %>
      </span>
    <%
        }
    %>
    </div>
  </li>
  <li>
    <div>
      <span class="usage-label english">english (You/Tú) </span>
      <span class="usage"><%= verbConjugation.getYouSingular() %></span>
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
      <br/>
      <span class="usage-label irish">irish (You/Tú) </span>
      <span class="translated">
      <%= stringBuilder.toString() %>
      </span>
    <%
        }
    %>
  </li>
  <li>
    <div>
      <span class="usage-label english">english (He/Sé) </span>
      <span class="usage"><%= verbConjugation.getHe() %></span>
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
      <br/>
      <span class="usage-label irish">irish (He/Sé) </span>
      <span class="translated">
      <%= stringBuilder.toString() %>
      </span>
    <%
        }
    %>
    </div>
  </li>
  <li>
    <div>
      <span class="usage-label english">english (She/Sí) </span>
      <span class="usage"><%= verbConjugation.getShe() %></span>
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
      <br/>
      <span class="usage-label irish">irish (She/Sí) </span>
      <span class="translated">
      <%= stringBuilder.toString() %>
      </span>
    <%
        }
    %>
    </div>
  </li>
  <li>
    <div>
      <span class="usage-label english">english (We/Muid) </span>
      <span class="usage"><%= verbConjugation.getWe() %></span>
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
      <br/>
      <span class="usage-label irish">irish (We/Muid) </span>
      <span class="translated">
      <%= stringBuilder.toString() %>
      </span>
    <%
        }
    %>
    </div>
  </li>
  <li>
    <div>
      <span class="usage-label english">english (You/Sibh) </span>
      <span class="usage"><%= verbConjugation.getYouPlural() %></span>
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
      <br/>
      <span class="usage-label irish">irish (You/Sibh) </span>
      <span class="translated">
      <%= stringBuilder.toString() %>
      </span>
    <%
        }
    %>
    </div>
  </li>
  <li>
    <div>
      <span class="usage-label english">english (They/Siad) </span>
      <span class="usage"><%= verbConjugation.getThey() %></span>
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
      <br/>
      <span class="usage-label irish">irish (They/Siad) </span>
      <span class="translated">
      <%= stringBuilder.toString() %>
      </span>
    <%
        }
    %>
    </div>
  </li>
  <li>
    <div>
      <span class="usage-label english">english (Autonomous/Saorbhriathar) </span>
      <span class="usage"><%= verbConjugation.getAutonomous() %></span>
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
      <br/>
      <span class="usage-label irish">irish (Autonomous/Saorbhriathar)</span>
      <span class="translated">
      <%= stringBuilder.toString() %>
      </span>
    <%
        }
    %>
    </div>
  </li>
  <li>
    <div>
      <span class="usage-label english">english (Negative/<span style="font-size:10px;">Diúltach</span>) </span>
      <span class="usage"><%= verbConjugation.getNegative() %></span>
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
      <br/>
      <span class="usage-label irish">irish (Negative/<span style="font-size:10px;">Diúltach</span>) </span>
      <span class="translated">
        <%= stringBuilder.toString() %>
      </span>
    <%
        }
    %>
    </div>
  </li>
  <li>
    <div>
      <span class="usage-label english">english (Question/<span style="font-size:10px;">Ceisteach</span>) </span>
      <span class="usage"><%= verbConjugation.getQuestion() %></span>
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
      <br/>
      <span class="usage-label irish">irish (Question/<span style="font-size:10px;">Ceisteach</span>) </span>
      <span class="translated">
      <%= stringBuilder.toString() %>
      </span>
    <%
        }
    %>
    </div>
  </li>
</ol>
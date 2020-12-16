<% if (isEnglish) { %>
  <div style="list-style:none;text-align:left;font-family:arial;border-bottom:#ccc 1px solid;">
    <%= verbConjugation.getTenseEnglish() %> - <%= verbConjugation.getTenseIrish() %>
  </div>
<% } else { %>
  <div style="list-style:none;text-align:left;font-family:arial;border-bottom:#ccc 1px solid;">
    <%= verbConjugation.getTenseIrish() %> - <%= verbConjugation.getTenseEnglish() %>
  </div>
<% } %>
<ul style="list-style:none;text-align:left;font-family:arial;">
  <li>
    <%= verbConjugation.getMe() %>
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
      <span style="color: #ff8f00;">=</span>
      <%= stringBuilder.toString() %>
    <%
        }
    %>
  </li>
  <li>
    <%= verbConjugation.getYouSingular() %>
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
      <span style="color: #ff8f00;">=</span>
      <%= stringBuilder.toString() %>
    <%
        }
    %>
  </li>
  <li>
    <%= verbConjugation.getHe() %>
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
      <span style="color: #ff8f00;">=</span>
      <%= stringBuilder.toString() %>
    <%
        }
    %>
  </li>
  <li>
    <%= verbConjugation.getShe() %>
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
      <span style="color: #ff8f00;">=</span>
      <%= stringBuilder.toString() %>
    <%
        }
    %>
  </li>
  <li>
    <%= verbConjugation.getWe() %>
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
      <span style="color: #ff8f00;">=</span>
      <%= stringBuilder.toString() %>
    <%
        }
    %>
  </li>
  <li>
    <%= verbConjugation.getYouPlural() %>
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
      <span style="color:#ff8f00;">=</span>
      <%= stringBuilder.toString() %>
    <%
        }
    %>
  </li>
  <li>
    <%= verbConjugation.getThey() %>
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
      <span style="color:#ff8f00;">=</span>
      <%= stringBuilder.toString() %>
    <%
        }
    %>
  </li>
  <li>
    <span style="font-size:12px">(Autonomous)</span>
    <%= verbConjugation.getAutonomous() %>
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
      <span style="color:#ff8f00;">=</span>
      <%= stringBuilder.toString() %>
    <%
        }
    %>
  </li>
  <li>
    <span style="font-size:12px">(Negative</span><span style="font-size:10px;">/Diúltach)</span>
    <%= verbConjugation.getNegative() %>
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
      <span style="color: #ff8f00;">=</span>
      <%= stringBuilder.toString() %>
    <%
        }
    %>
  </li>
  <li>
    <span style="font-size:12px">(Question</span><span style="font-size:10px;">/Ceisteach)</span>
    <%= verbConjugation.getQuestion() %>
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
    <span style="color: #ff8f00;">=</span>
    <%= stringBuilder.toString() %>
    <%
        }
    %>
  </li>
</ul>
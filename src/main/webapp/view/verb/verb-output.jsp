<div class="usage description definition">
<%--  
  <div class="word-header">
    <span class="language-label">Example usage</span>
  </div>
  <ol>
    <li>
      <div>
            <span class="usage-label irish">irish </span>
            <span class="usage"><a href="/irish/english/éadaí">éadaí</a> <a href="/irish/english/agus">agus</a> <a href="/irish/english/comhghabhálais">comhghabhálais</a> <a href="/irish/english/éadaí">éadaí</a> <a href="/irish/english/lena">lena</a> <a href="/irish/english/n">n</a>-<a href="/irish/english/áirítear" style="color:#ff8f00;">áirítear</a> <a href="/irish/english/lámhainní">lámhainní</a> <a href="/irish/english/agus">agus</a> <a href="/irish/english/miotáin">miotáin</a></span>
            <br><span class="usage-label english">english </span>
            <span class="translated"><a href="/english/irish/articles">articles</a> <a href="/english/irish/of">of</a> <a href="/english/irish/apparel">apparel</a> <a href="/english/irish/and">and</a> <a href="/english/irish/clothing">clothing</a> <a href="/english/irish/accessories">accessories</a>, <a href="/english/irish/including">including</a> <a href="/english/irish/gloves">gloves</a> <a href="/english/irish/and">and</a> <a href="/english/irish/mittens">mittens</a></span></div></li><li><div><span class="usage-label irish">irish </span><span class="usage"><a href="/irish/english/píoráideacht">píoráideacht</a>, <a href="/irish/english/lena">lena</a> <a href="/irish/english/n">n</a>-<a href="/irish/english/áiritear">áiritear</a> <a href="/irish/english/cion">cion</a> <a href="/irish/english/ag">ag</a> <a href="/irish/english/cúlpháirtí">cúlpháirtí</a> <a href="/irish/english/roimh">roimh</a> <a href="/irish/english/an">an</a> <a href="/irish/english/ngníomh">ngníomh</a> <a href="/irish/english/nó">nó</a> <a href="/irish/english/ina">ina</a> <a href="/irish/english/dhiaidh">dhiaidh</a></span><br><span class="usage-label english">english </span><span class="translated"><a href="/english/irish/piracy">piracy</a>, <a href="/english/irish/including">including</a> <a href="/english/irish/an">an</a> <a href="/english/irish/offence">offence</a> <a href="/english/irish/by">by</a> <a href="/english/irish/an">an</a> <a href="/english/irish/accessory">accessory</a> <a href="/english/irish/before">before</a> <a href="/english/irish/or">or</a> <a href="/english/irish/after">after</a> <a href="/english/irish/the">the</a> <a href="/english/irish/fact">fact</a></span>
        </div>
    </li>

<div class="definition">
    <span class="language-label"><span class="capitalize"><%= fromLanguage %></span> verb</span>
--%>  
  <div class="word-header">
    <span class="language-label"><%= fromLanguage %> verb</span>
    <span class="word"><% if(verb != null) { %><%= verb.getVerb() %><% } %></span>
    <%--
        if (word.getDescription() != null) {
            stringBuilder.append(  "<span class=\"word-description\">").append(word.getDescription()).append("</span>");
        }
    --%>
  </div>
  <!--div-->
    <ol>
      <li>
        <div>
        <% if (isEnglish) { %>
          <span class="description usage-label irish">(Definition<span class="smaller">/Sainmhíniú</span>)</span>
        <% } else { %>
          <span class="usage-label irish">(Sainmhíniú<span class="smaller">/Definition</span>)</span>
        <% } %>
        <span class="usage">
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
        </span>
        </div>
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
        <div>
        <%-- if (isEnglish) { --%>
          <span class="usage-label irish">(Verbal Adjective)</span>
          <span class="usage">
              <a href="<%= fromLanguage %>/<%= toLanguage %>/<%= verb.getVerbalAdjective() %>"><%= verb.getVerbalAdjective() %></a>
          </span>
        <%-- } else { --%>
          <br/><span class="usage-label irish">(Aidiacht Briathartha)</span>
          <span class="translated">
            <% if (verbList != null) { for (int i = 0; i < verbList.size(); i++) { %><% if (i > 0) { %>, <% } %><a href="<%= toLanguage %>/<%= fromLanguage %>/<%= ((Verb)verbList.get(i)).getParticiple() %>"><%= ((Verb)verbList.get(i)).getParticiple() %></a><% } } %>
          </span>
        <%-- } --%>
        <%--= verb.getVerbalAdjective() --%>
        <%--
        <span class="usage">
        <a href="<%= fromLanguage %>/<%= toLanguage %>/<%= verb.getVerbalAdjective() %>"><%= verb.getVerbalAdjective() %></a>
        (<% if (verbList != null) { for (int i = 0; i < verbList.size(); i++) { %><% if (i > 0) { %>, <% } %><a href="<%= toLanguage %>/<%= fromLanguage %>/<%= ((Verb)verbList.get(i)).getParticiple() %>"><%= ((Verb)verbList.get(i)).getParticiple() %></a><% } } %>)
        --%>
        </div>
      </li>
      <% } %>
      <% if (verb.getVerbalNoun() != null && !verb.getVerbalNoun().equals(EMPTY)) { %>
      <li>
        <div>
        <%-- if (isEnglish) { --%>
          <span class="usage-label irish">
            (Verbal Noun)
          </span>
          <span class="usage">
            ag <a href="<%= fromLanguage %>/<%= toLanguage %>/<%= verb.getVerbalNoun() %>"><%= verb.getVerbalNoun() %></a>
          </span>
        <%-- } else { --%>
        <%-- } --%>
          <br/>
          <span class="usage-label irish">
            (Ainm Briathartha)
          </span>
          <span class="translated">
            <% if (verbList != null) { for (int i = 0; i < verbList.size(); i++) { %><% if(i > 0) { %>, <% } %><a href="<%= toLanguage %>/<%= fromLanguage %>/<%= ((Verb)verbList.get(i)).getGerund() %>"><%= ((Verb)verbList.get(i)).getGerund() %></a><% } } %>
          </span>
        </div>
      </li>
      <% } %>
      <% if (verb.getParticiple() != null && !verb.getParticiple().equals(EMPTY)) { %>
      <li>
        <div>
        <%-- if (isEnglish) { --%>
          <span class="usage-label irish">
            (Verbal Adjective)
          </span>
          <span class="usage">
            <a href="<%= fromLanguage %>/<%= toLanguage %>/<%= verb.getParticiple() %>"><%= verb.getParticiple() %></a>
          </span>
          <br/>
        <%-- } else { --%>
          <span class="usage-label irish">(Aidiacht Briathartha)</span>
        <%-- } --%>
          <span class="translated">
            <% if(verbList != null) { for(int i = 0; i < verbList.size(); i++) { %><%if(i>0){ %>, <% } %><a href="<%= toLanguage %>/<%= fromLanguage %>/<%= ((Verb)verbList.get(i)).getVerbalAdjective() %>"><%= ((Verb)verbList.get(i)).getVerbalAdjective() %></a><% } } %>
          </span>
        </div>
      </li>
      <% } %>
      <% if (verb.getGerund() != null && !verb.getGerund().equals(EMPTY)) { %>
      <li>
        <div>
        <span class="usage-label irish">(Verbal Noun)</span>
          <span class="usage">
        <a href="<%= fromLanguage %>/<%= toLanguage %>/<%= verb.getGerund() %>"><%= verb.getGerund() %></a>
          </span>
          <br/>
        <span class="usage-label irish">(Ainm Briathartha)</span>
          <span class="translated">
            <% if (verbList != null) { for(int i = 0; i < verbList.size(); i++) { %><% if (i>0) { %>, <% } %>ag <a href="<%= toLanguage %>/<%= fromLanguage %>/<%= ((Verb)verbList.get(i)).getVerbalNoun() %>"><%= ((Verb)verbList.get(i)).getVerbalNoun() %></a><% } } %>
          </span>
        </div>
      </li>
      <% } %>
    </ol>
  <!--/div-->
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
<div>
  <div>
    <div class="definition red0" style="text-align:left;max-height:400px;overflow-y:auto;">
<%--
      <div class="header blue" style="text-align:left;color:#6B6D6B;font-size:20px;font-weight:bold;padding:8px;">
--%>
      <div>
        <% if(isEnglish) { %>English verb: <% } %>
        <% if(isIrish) { %>Irish verb: <% } %>
        <% if(verb != null) { %><%= verb.getVerb() %><% } %>
        =
<%--
        <%= ((Verb)verbList.get(i)).getVerb() %><% } } %>
--%>
<%
        Verb v0 = null;
        String verb0 = null;
        if (verbList != null) {
            int verbListSize = verbList.size();
            for (int i = 0; i < verbListSize; i++) {
                v0 = (Verb)verbList.get(i);
                verb0 = v0.getVerb();
%>
<%--
        <%if(i>0){ %>,<%}%><a href="verb?verb=<%= verb0 %>&language=<%= toLanguage %>"><%= verb0 %></a>
--%>
        <a href="verb?verb=<%= verb0 %>&language=<%= toLanguage %>"><%= verb0 %></a><%if(i<(verbListSize-1)){ %>,<%}%>
<%
            }
        }
%>
      </div>
      <div>
        <ol>
          <li>
            <% if (isEnglish) { %>
            <span style="font-size:12px;">(Definition<span style="font-size:10px;">/Sainmhíniú</span>)</span>
            <% } else { %>
            <span style="font-size:12px;">(Sainmhíniú<span style="font-size:10px;">/Definition</span>)</span>
            <% } %>
            <% if (verbList != null) { for (int i = 0; i < verbList.size(); i++) { %><% if (i>0) { %>, <% } %><%= ((Verb)verbList.get(i)).getVerb() %><% } } %>
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
          <% if (verb.getVerbalAdjective() != null && !verb.getVerbalAdjective().equals("")) { %>
          <li>
            <% if (isEnglish) { %>
            <span style="font-size:12px;">(Verbal Adjective<span style="font-size:10px;">/Aidiacht Briathartha</span>)</span>
            <% } else { %>
            <span style="font-size:12px;">(Aidiacht Briathartha<span style="font-size:10px;">/Verbal Adjective</span>)</span>
            <% } %>
            <%= verb.getVerbalAdjective() %>
            (<% if (verbList != null) { for (int i = 0; i < verbList.size(); i++) { %><% if (i>0) { %>, <% } %><%= ((Verb)verbList.get(i)).getParticiple() %><% } } %>)
          </li>
          <% } %>
          <% if (verb.getVerbalNoun() != null && !verb.getVerbalNoun().equals("")) { %>
          <li>
            <% if (isEnglish) { %>
            <span style="font-size:12px;">(Verbal Noun<span style="font-size:10px;">/Ainm Briathartha</span>)</span>
            <% } else { %>
            <span style="font-size:12px;">(Ainm Briathartha<span style="font-size:10px;">/Verbal Noun</span>)</span>
            <% } %>
            ag <%= verb.getVerbalNoun() %>
            (<% if (verbList != null) { for(int i = 0; i < verbList.size(); i++) { %><% if(i > 0) { %>, <% } %><%= ((Verb)verbList.get(i)).getGerund() %><% } } %>)
          </li>
          <% } %>
          <% if (verb.getParticiple() != null && !verb.getParticiple().equals("")) { %>
          <li>
            <% if (isEnglish) { %>
            <span style="font-size:12px;">(Verbal Adjective<span style="font-size:10px;">/Aidiacht Briathartha</span>)</span>
            <% } else { %>
            <span style="font-size:12px;">(Aidiacht Briathartha</span><span style="font-size:10px;">/Verbal Adjective</span>)</span>
            <% } %>
            <%= verb.getParticiple() %>
            (<% if(verbList != null) { for(int i = 0; i < verbList.size(); i++) { %><%if(i>0){ %>, <%}%><%= ((Verb)verbList.get(i)).getVerbalAdjective() %><% } } %>)
          </li>
          <% } %>
          <% if (verb.getGerund() != null && !verb.getGerund().equals("")) { %>
          <li>
            <span style="font-size:12px;">(Verbal Noun<span style="font-size:10px;">/Ainm Briathartha   </span>)</span>
            <%= verb.getGerund() %>
            (<% if (verbList != null) { for(int i = 0; i < verbList.size(); i++) { %><% if (i>0) { %>, <% } %><%= "ag " + ((Verb)verbList.get(i)).getVerbalNoun() %><% } } %>)
          </li>
          <% } %>
        </ol>
      </div>
    </div>
  </div>
  <div>
    <%
      VerbConjugation verbConjugation;
      String tenseId;
      for(int x = 1; x <= 7; x++) {
          tenseId = String.valueOf(x);
          System.out.println("tenseId = " + tenseId);
          verbConjugation = (VerbConjugation) verbConjugationMap.get(tenseId);
    %>
      <div>
        <%@ include file="/view/verb/verbConjugation.jsp" %>
      </div>
    <%
      }
    %>
  </div>
</div>


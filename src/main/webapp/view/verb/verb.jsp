<%@ include file="/view/header.jsp" %>
<%
    Verb verb = (Verb) request.getAttribute("verb");
    Map verbConjugationMap = verb.getVerbConjugationMap();
    log.debug("verbConjugationMap.size() = " + verbConjugationMap.size());
    System.out.println("verbConjugationMap = " + verbConjugationMap);
    String verbString = (String)request.getAttribute("verbString");
    List<Verb> verbList = (List<Verb>) verb.getVerbList();
    int count = 0;
    if(verbList != null) count = verbList.size();
    String wordEnglish = null;
    String wordIrish = null;
    String verbEnglish = null;
    String verbIrish = null;
    String language = request.getParameter("language");
    String verbParam = request.getParameter("verb");
    log.debug("language = " + language);
    log.debug("verbParam = " + verbParam);
    if(language != null) {
        if(language.equals("english")) {
            if(verbParam != null) verbEnglish = verbParam;
        } else if(language.equals("irish")) {
            if(verbParam != null) verbIrish = verbParam;
        }
    }
    String fromLanguage = language;
    //String fromLanguage = request.getParameter("fromLanguage");
    //if(fromLanguage == null) fromLanguage = (String)request.getAttribute("fromLanguage");
    //if(fromLanguage == null) fromLanguage = language;
    String toLanguage = request.getParameter("toLanguage");
    if(toLanguage == null) toLanguage = (String)request.getAttribute("toLanguage");
    log.debug("fromLanguage = " + fromLanguage);
    log.debug("toLanguage = " + toLanguage);
    boolean isEnglish = language.equals("english");
    boolean isIrish = language.equals("irish");
%>

<%--
<div class="red0" style="padding-top:108px;padding-bottom:108px;width:728px;text-align:center;margin:auto;">
  <div class="blue0" style="text-align:center;margin:auto;">

    <div class="yellow0" style="text-align:left;margin:0px auto 0xp 0px;">

      <div class="table">
        <div class="row">
          <div class="cell" style="vertical-align:top;">
            <a href="<%= contextUrl %>"><img src="view/images/Irish-Dictionary-Online-Logo.jpg" border="0" title="Irish Dictionary Online"></a>
          </div>
          <div class="cell red0" style="vertical-align:middle;margin:auto;width:100%;">
            <%@ include file="/view/topForm.jsp" %>
          </div>
        </div>
      </div>
    </div>
--%>
<div style="padding-top:108px;padding-bottom:108px;max-width:728px;text-align:center;margin:auto;">
  <div style="text-align:center;margin:auto;">
<%--
    <div style="text-align:left;margin:0px auto 0xp 0px;">
                            
      <div class="table">
        <div class="row">
          <div class="cell" style="vertical-align:top;">
            <a href="<%= contextUrl %>"><img src="<%= imagesUrl %>Irish-Dictionary-Online-Logo.jpg" border="0" title="Irish Dictionary Online"></a>
          </div>
          <div class="cell" style="vertical-align:middle;margin:auto;width:100%;">
            <%@ include file="/view/topForm.jsp" %>
          </div>
        </div>
      </div>
    </div>
--%>
    <div class="header">
      <div>
        <a href="<%= contextUrl %>"><img src="<%= imagesUrl %>Irish-Dictionary-Online-Logo.jpg" border="0" title="Irish Dictionary Online"></a>
      </div>
      <div>
        <%@ include file="/view/topForm.jsp" %>
      </div>
    </div>
    <div class="yellow0" style="max-width:728px;">
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
                <span style="font-size:12px;">(Verb Gerund)</span>
                <%= verb.getGerund() %>
                (<% if (verbList != null) { for(int i = 0; i < verbList.size(); i++) { %><% if (i>0) { %>, <% } %><%= "ag " + ((Verb)verbList.get(i)).getVerbalNoun() %><% } } %>)
              </li>
              <% } %>
            </ol>
          </div>
        </div>
      </div>
      <div>
      <%--
          Set s = verbConjugationMap.keySet();
          Iterator iterator = s.iterator();
          String tenseId;
          VerbConjugation verbConjugation;
          int marker = 0;
          while(iterator.hasNext()) {
              tenseId = (String)iterator.next();
              verbConjugation = (VerbConjugation)verbConjugationMap.get(tenseId);
              marker++;
      %>
        <div>
          <%@ include file="/view/verb/verbConjugation.jsp" %>
        </div>
      <%
          }
      --%>
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
  </div>
</div>
<%@ include file="/view/footer.jsp" %>


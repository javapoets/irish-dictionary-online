
<% if(isEnglish) { %>
<div style="list-style:none;text-align:left;font-family:arial;border-bottom:#ccc 1px solid;"><%= verbConjugation.getTenseEnglish() %> - <%= verbConjugation.getTenseIrish() %></div>
<% } else { %>
<div style="list-style:none;text-align:left;font-family:arial;border-bottom:#ccc 1px solid;"><%= verbConjugation.getTenseIrish() %> - <%= verbConjugation.getTenseEnglish() %></div>
<% } %>


<ul style="list-style:none;text-align:left;font-family:arial;">

 <li>
  <%= verbConjugation.getMe() %>
<%--
<%= ((VerbConjugation)((Map)((Verb)verbList.getItem(i)).getVerbConjugationMap()).get(tenseId)).getMe() %>; <% } %>
--%>
<%
    StringBuilder sb = new StringBuilder();
    String me = null;
    for(int i = 0; i < verbList.size(); i++) {
        Verb v = (Verb)verbList.getItem(i);
        Map vCM = (Map)v.getVerbConjugationMap();
        ie.irishdictionary.model.VerbConjugation vC = (ie.irishdictionary.model.VerbConjugation)vCM.get(tenseId);
        me = vC.getMe();
        if(me != null) {
            if(i > 0)sb.append(", ");
            sb.append(me);
        }
    }
    if(sb.length() > 0) {
%>
  <span style="color:#ff8f00;">=</span>
  <%= sb.toString() %>
<%
    }
%>
 </li>

 <li>
  <%= verbConjugation.getYouSing() %>
<%--
<%= ((VerbConjugation)((Map)((Verb)verbList.getItem(i)).getVerbConjugationMap()).get(tenseId)).getYouSing() %>, <% } %>
--%>
<%
    sb = new StringBuilder();
    String youSing = null;
    for(int i = 0; i < verbList.size(); i++) {
        Verb v = (Verb)verbList.getItem(i);
        Map vCM = (Map)v.getVerbConjugationMap();
        ie.irishdictionary.model.VerbConjugation vC = (ie.irishdictionary.model.VerbConjugation)vCM.get(tenseId);
        youSing = vC.getYouSing();
        if(youSing != null) {
            if(i > 0)sb.append(", ");
            sb.append(youSing);
        }
    }
    if(sb.length() > 0) {
%>
  <span style="color:#ff8f00;">=</span>
  <%= sb.toString() %>
<%
    }
%>
 </li>

 <li>
  <%= verbConjugation.getHe() %>
<%
    sb = new StringBuilder();
    String he = null;
    for(int i = 0; i < verbList.size(); i++) {
        Verb v = (Verb)verbList.getItem(i);
        Map vCM = (Map)v.getVerbConjugationMap();
        ie.irishdictionary.model.VerbConjugation vC = (ie.irishdictionary.model.VerbConjugation)vCM.get(tenseId);
        he = vC.getHe();
        if(he != null) {
            if(i > 0)sb.append(", ");
            sb.append(he);
        }
    }
    if(sb.length() > 0) {
%>
  <span style="color:#ff8f00;">=</span>
  <%= sb.toString() %>
<%
    }
%>
 </li>

 <li>
  <%= verbConjugation.getShe() %>
<%
    sb = new StringBuilder();
    String she = null;
    for(int i = 0; i < verbList.size(); i++) {
        Verb v = (Verb)verbList.getItem(i);
        Map vCM = (Map)v.getVerbConjugationMap();
        ie.irishdictionary.model.VerbConjugation vC = (ie.irishdictionary.model.VerbConjugation)vCM.get(tenseId);
        she = vC.getShe();
        if(she != null) {
            if(i > 0)sb.append(", ");
            sb.append(she);
        }
    }
    if(sb.length() > 0) {
%>
  <span style="color:#ff8f00;">=</span>
  <%= sb.toString() %>
<%
    }
%>
 </li>

 <li>
  <%= verbConjugation.getWe() %>
<%
    sb = new StringBuilder();
    String we = null;
    for(int i = 0; i < verbList.size(); i++) {
        Verb v = (Verb)verbList.getItem(i);
        Map vCM = (Map)v.getVerbConjugationMap();
        ie.irishdictionary.model.VerbConjugation vC = (ie.irishdictionary.model.VerbConjugation)vCM.get(tenseId);
        we = vC.getWe();
        if(we != null) {
            if(i > 0)sb.append(", ");
            sb.append(we);
        }
    }
    if(sb.length() > 0) {
%>
  <span style="color:#ff8f00;">=</span>
  <%= sb.toString() %>
<%
    }
%>
 </li>

 <li>
  <%= verbConjugation.getYouPlur() %>
<%
    sb = new StringBuilder();
    String youPlur = null;
    for(int i = 0; i < verbList.size(); i++) {
        Verb v = (Verb)verbList.getItem(i);
        Map vCM = (Map)v.getVerbConjugationMap();
        ie.irishdictionary.model.VerbConjugation vC = (ie.irishdictionary.model.VerbConjugation)vCM.get(tenseId);
        youPlur = vC.getYouPlur();
        if(youPlur != null) {
            if(i > 0)sb.append(", ");
            sb.append(youPlur);
        }
    }
    if(sb.length() > 0) {
%>
  <span style="color:#ff8f00;">=</span>
  <%= sb.toString() %>
<%
    }
%>
 </li>

 <li>
  <%= verbConjugation.getThey() %>
<%
    sb = new StringBuilder();
    String they = null;
    for(int i = 0; i < verbList.size(); i++) {
        Verb v = (Verb)verbList.getItem(i);
        Map vCM = (Map)v.getVerbConjugationMap();
        ie.irishdictionary.model.VerbConjugation vC = (ie.irishdictionary.model.VerbConjugation)vCM.get(tenseId);
        they = vC.getThey();
        if(they != null) {
            if(i > 0)sb.append(", ");
            sb.append(they);
        }
    }
    if(sb.length() > 0) {
%>
  <span style="color:#ff8f00;">=</span>
  <%= sb.toString() %>
<%
    }
%>
 </li>

 <li>
  <span style="font-size:12px">(Autonomous)</span>
  <%= verbConjugation.getAut() %>
<%--
  <% for(int i = 0; i < verbList.size(); i++) { %><%= ((VerbConjugation)((Map)((Verb)verbList.getItem(i)).getVerbConjugationMap()).get(tenseId)).getAut() %>; <% } %>
--%>
<%
    sb = new StringBuilder();
    String aut = null;
    for(int i = 0; i < verbList.size(); i++) {
        Verb v = (Verb)verbList.getItem(i);
        Map vCM = (Map)v.getVerbConjugationMap();
        ie.irishdictionary.model.VerbConjugation vC = (ie.irishdictionary.model.VerbConjugation)vCM.get(tenseId);
        aut = vC.getAut();
        if(
          aut != null
          && !aut.equals("")
        ) {
            if(i > 0) sb.append(", ");
            sb.append(aut);
        }
    }
    if(sb.length() > 0) {
%>
  <span style="color:#ff8f00;">=</span>
  <%= sb.toString() %>
<%
    }
%>
 </li>

 <li>
<%--
  <span style="font-size:12px">Negative</span><span style="font-size:10px;padding-left:3px;">(Diúltach)</span>
--%>
  <span style="font-size:12px">(Negative</span><span style="font-size:10px;">/Diúltach)</span>
  <%= verbConjugation.getNeg() %>
<%--
  <% for(int i = 0; i < verbList.size(); i++) { %><%= ((VerbConjugation)((Map)((Verb)verbList.getItem(i)).getVerbConjugationMap()).get(tenseId)).getNeg() %>; <% } %>
--%>
<%
    sb = new StringBuilder();
    String neg = null;
    for(int i = 0; i < verbList.size(); i++) {
        Verb v = (Verb)verbList.getItem(i);
        Map vCM = (Map)v.getVerbConjugationMap();
        ie.irishdictionary.model.VerbConjugation vC = (ie.irishdictionary.model.VerbConjugation)vCM.get(tenseId);
        neg = vC.getNeg();
        if(
          neg != null
          && !neg.equals("")
        ) {
            if(i > 0) sb.append(", ");
            sb.append(neg);
        }
    }
    if(sb.length() > 0) {
%>
  <span style="color:#ff8f00;">=</span>
  <%= sb.toString() %>
<%
    }
%>
 </li>

 <li>
  <span style="font-size:12px">(Question</span><span style="font-size:10px;">/Ceisteach)</span>
  <%= verbConjugation.getQuestion() %>
<%--
  <% for(int i = 0; i < verbList.size(); i++) { %><%= ((VerbConjugation)((Map)((Verb)verbList.getItem(i)).getVerbConjugationMap()).get(tenseId)).getQuestion() %>; <% } %>
--%>
<%
    sb = new StringBuilder();
    String question = null;
    for(int i = 0; i < verbList.size(); i++) {
        Verb v = (Verb)verbList.getItem(i);
        Map vCM = (Map)v.getVerbConjugationMap();
        ie.irishdictionary.model.VerbConjugation vC = (ie.irishdictionary.model.VerbConjugation)vCM.get(tenseId);
        question = vC.getQuestion();
        if(
          question != null
          && !question.equals("")
        ) {
            if(i > 0) sb.append(", ");
            sb.append(question);
        }
    }
    if(sb.length() > 0) {
%>
  <span style="color:#ff8f00;">=</span>
  <%= sb.toString() %>
<%
    }
%>
 </li>

</ul>

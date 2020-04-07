<%@ include file="/view/header.jsp" %>

<%
    List wordList = (List) request.getAttribute("wordList");
    List irishWordList = (List) request.getAttribute("irishWordList");
    Word word = (Word) request.getAttribute("word");
    Word irishWord = (Word) request.getAttribute("irishWord");

    //System.out.println("home.jsp: word = "+word);
    //System.out.println("home.jsp: irishWord = "+irishWord);

    if(word != null) {
      pageContext.setAttribute("word", word);
    } else {
      pageContext.setAttribute("irishWord", irishWord);
    }

    String emailSent = (String) request.getAttribute("emailSent");
%>

<%--
<div style="padding-top:108px;padding-bottom:108px;width:728px;text-align:center;margin:auto;">
<div style="padding-top:108px;padding-bottom:108px;max-width:728px;text-align:center;margin:auto;">
<div style="padding-top:108px;padding-bottom:108px;text-align:center;margin:auto;">
--%>  
<div style="padding-top:108px;padding-bottom:108px;max-width:728px;text-align:center;margin:auto;">
  <div style="text-align:center;margin:auto;">

    <div style="text-align:left;margin:0px auto 0xp 0px;">

      <div class="table" style="width:100%;">
        <div class="row">

          <div class="cell">
            <a href="<%= contextUrl %>"><img src="<%= imagesUrl %>Irish-Dictionary-Online-Logo.jpg" border="0" title="Irish Dictionary Online"></a>
          </div>

        </div>
      </div>

    </div>

    <div style="text-align:center;margin:auto;padding-top:20px">
      <%@ include file="/view/entryFormVariables.jsp" %>
      <%@ include file="/view/entryForm.jsp" %>
    </div>

    <% if((word != null) || (irishWord != null)) { %>
    <div style="width:728px;">
      <% if(word != null) { %>
        <irishdictionary:word />
      <% } else { %>
        <irishdictionary:irishword />
      <% } %>
    </div>
    <% } %>

  </div>
</div>

<%@ include file="/view/footer.jsp" %>

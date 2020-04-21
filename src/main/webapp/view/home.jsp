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

<div class="container">

  <div class="logo-offset">
    <div>
      <a href="<%= contextUrl %>"><img src="<%= imagesUrl %>Irish-Dictionary-Online-Logo.jpg" border="0" title="Irish Dictionary Online"></a>
    </div>
  </div>

  <div>
    <div class="search-block">
      <%@ include file="/view/entryFormVariables.jsp" %>
      <%--@ include file="/view/entryForm.jsp" --%>
      <%@ include file="/view/entry-form.jsp" %>
    </div>
    <%@ include file="/view/word-count-statement.jsp" %>
  </div>

</div>

<%@ include file="/view/footer.jsp" %>
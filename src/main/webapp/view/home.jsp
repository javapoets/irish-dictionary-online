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

<div class="container" style=" border: blue 0px solid; height: 100%; text-align: center;  vertical-align: middle; margin: 0px; padding: 0px;">

  <div class="logo-offset">
    <div>
      <a href="<%= contextUrl %>"><img src="<%= imagesUrl %>Irish-Dictionary-Online-Logo.jpg" border="0" title="Irish Dictionary Online"></a>
    </div>
  </div>

  <div style="
    display: inline-block;
    text-align: center;
    vertical-align: middle;
    /*border: red 1px solid;*/
    margin: auto;">
    <%@ include file="/view/entryFormVariables.jsp" %>
    <%@ include file="/view/entryForm.jsp" %>
  </div>

</div>

<%@ include file="/view/footer.jsp" %>
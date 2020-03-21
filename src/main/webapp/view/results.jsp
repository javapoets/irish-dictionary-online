<%@ include file="/view/header.jsp" %>

<%

    //SortableList wordList = (SortableList)request.getAttribute("wordList");
    //List wordList = (List) request.getAttribute("wordList");
    //SortableList irishWordList = (SortableList)request.getAttribute("irishWordList");
    //List irishWordList = (List) request.getAttribute("irishWordList");

    Word word = (Word) request.getAttribute("word");
    Word irishWord = (Word) request.getAttribute("irishWord");

    //System.out.println("results.jsp: word = "+word);
    //System.out.println("results.jsp: irishWord = "+irishWord);

    if(word != null) {
      pageContext.setAttribute("word", word);
    } else {
      pageContext.setAttribute("irishWord", irishWord);
    }
    String emailSent = (String)request.getAttribute("emailSent");

    String wordEnglish = null;
    String wordIrish = null;
    String verbEnglish = null;
    String verbIrish = null;

    String verbParam = request.getParameter("verb");
    String wordParam = request.getParameter("word");
    String language = request.getParameter("language");

    //System.out.println("results.jsp: verbParam = "+verbParam);
    //System.out.println("results.jsp: wordParam = "+wordParam);
    //System.out.println("results.jsp: language = "+language);

    if(language != null) {
        if(language.equals("english")) {
            if(wordParam != null) wordEnglish = wordParam;
            if(verbParam != null) verbEnglish = verbParam;
        } else if(language.equals("irish")) {
            if(wordParam != null) wordIrish = wordParam;
            if(verbParam != null) verbIrish = verbParam;
        }
    }

    String fromLanguage = language;
    //String fromLanguage = request.getParameter("fromLanguage");
    //if(fromLanguage == null) fromLanguage = (String)request.getAttribute("fromLanguage");
    //if(fromLanguage == null) fromLanguage = language;
    String toLanguage = request.getParameter("toLanguage");
    if(toLanguage == null) toLanguage = (String)request.getAttribute("toLanguage");
    //System.out.println("results.jsp: fromLanguage = "+fromLanguage);
    //System.out.println("results.jsp: toLanguage = "+toLanguage);
    pageContext.setAttribute("fromLanguage", fromLanguage);
    pageContext.setAttribute("toLanguage", toLanguage);
%>
                      
<div style="padding-top:108px;padding-bottom:108px;width:728px;text-align:center;margin:auto;">
  <div style="text-align:center;margin:auto;">

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

    <div style="width:728px;">
    <% if((word != null) || (irishWord != null)) { %>
      <% if(word != null) { %>
        <irishdictionary:word />
      <% } else { %>
<%--
        <irishdictionary:irishword />
        <irishdictionary:word />
--%>
        <irishdictionary:word />
      <% } %>
    <% } %>
    </div>

  </div>
</div>

<%@ include file="/view/footer.jsp" %>

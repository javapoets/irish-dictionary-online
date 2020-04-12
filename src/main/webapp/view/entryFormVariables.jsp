<%

    String wordEnglish = "";
    String wordIrish = "";
    String verbEnglish = "";
    String verbIrish = "";
    String verb = request.getParameter("verb");
    String wordParam = request.getParameter("word");
    String language = request.getParameter("language");
    if((language != null) && language.equals("english")) {
        if(wordParam != null) {
            wordEnglish = wordParam;
        }
        if(verb != null) {
            verbEnglish = verb;
        }
    }
    if((language != null) && language.equals("irish")) {
        if(wordParam != null) {
            wordIrish = wordParam;
        }
        if(verb != null) {
            verbIrish = verb;
        }
    }

%>
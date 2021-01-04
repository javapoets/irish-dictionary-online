<%
    String lang = null;
    lang = (String)request.getAttribute("lang");
    //log.debug("lang = " + lang);
    if (lang == null) {
        log.debug("session = " + session);
        if (session != null) {
            lang = (String)session.getAttribute("lang");
        }
        if (lang == null) { // The default application lang if none is set
            log.debug("application = " + application);
            lang = (String)application.getAttribute("lang");
            //log.debug("lang = " + lang);
            if(lang == null) lang = "en";
            //if(lang == null) lang = java.util.Locale.getDefault().getLanguage();
        }
    }
    log.debug("lang = " + lang);
    String fromLang = (String)request.getAttribute("fromLang");
    String toLang = (String)request.getAttribute("toLang");
    log.debug("fromLang = " + fromLang);
    log.debug("toLang = " + toLang);
    final online.irishdictionary.util.ResourceBundles resourceBundles = new online.irishdictionary.util.ResourceBundles(lang);
%>

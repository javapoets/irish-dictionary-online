<%
    String lang = null;
    String fromLang = null;
    String toLang = null;
    lang = (String)request.getAttribute("lang");
    fromLang = (String)request.getAttribute("fromLang");
    toLang = (String)request.getAttribute("toLang");
    log.debug("lang = " + lang);
    log.debug("fromLang = " + fromLang);
    log.debug("toLang = " + toLang);
    if (lang == null) {
        log.debug("session = " + session);
        if (session != null) {
            lang = (String)session.getAttribute("lang");
            fromLang = (String)session.getAttribute("fromLang");
            toLang = (String)session.getAttribute("toLang");
            log.debug("lang = " + lang);
            log.debug("fromLang = " + fromLang);
            log.debug("toLang = " + toLang);
        }
        if (lang == null) {
            log.debug("application = " + application);
            lang = (String)application.getAttribute("lang");
            fromLang = (String)application.getAttribute("fromLang");
            toLang = (String)application.getAttribute("toLang");
            log.debug("lang = " + lang);
            log.debug("fromLang = " + fromLang);
            log.debug("toLang = " + toLang);
            if(lang == null) lang = "en";
            //if(lang == null) lang = java.util.Locale.getDefault().getLanguage();
        }
    }
    log.debug("lang = " + lang);
    log.debug("fromLang = " + fromLang);
    log.debug("toLang = " + toLang);
    final online.irishdictionary.util.ResourceBundles resourceBundles = new online.irishdictionary.util.ResourceBundles(lang);
%>

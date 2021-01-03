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
        if (session != null) {
            lang = (String)session.getAttribute("lang");
            fromLang = (String)session.getAttribute("fromLang");
            toLang = (String)session.getAttribute("toLang");
            log.debug("lang = " + lang);
            log.debug("fromLang = " + fromLang);
            log.debug("toLang = " + toLang);
        }
        if (lang == null) {
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
<%

    //String contextUrl = online.irishdictionary.servlet.InitServlet.init.getProperty("contextUrl");
    //String contextUrl = online.irishdictionary.servlet.InitServlet.init.getProperty("contextUrl");
    String contextUrl = (String) application.getAttribute("contextUrl");
    String imagesUrl = contextUrl + "view/images/";
    String sortParameter = null;
    String fieldName, fieldValue = "";
    String cssClass = "main";
    String rs = (String)request.getParameter("rs");
    if(rs == null) rs = "home";

    /*
    CurrencyBean currencyBean = (CurrencyBean)application.getAttribute("currencyBean");
    User userCompany = (User)application.getAttribute("userCompany");
    User userSession = (User)session.getAttribute("user");
    User user = (User)session.getAttribute("user");
    Map groupMap          =         (Map)       application.getAttribute("groupMap");
    //// new for price groups
    //Map priceGroupMap = (Map)session.getAttribute("priceGroupMap");

    ErrorBean errorBean = (ErrorBean)request.getAttribute("errorBean");
    WebPage webPagePage = (WebPage)request.getAttribute("webPagePage");
    FormError formError = null;

    String previousRequestURI = (String)request.getAttribute("previousRequestURI");
    String servletPath = request.getServletPath();
    String servletName = servletPath.substring(1);
    String queryString = request.getQueryString();
    String contextPath = request.getContextPath();
    String pathInfo = request.getPathInfo();
    String requestURI = request.getRequestURI();
    String prevReqURI;
    if((prevReqURI = (String)request.getAttribute("prevReqURI")) == null){
        if((prevReqURI = request.getParameter("prevReqURI")) == null){
            prevReqURI = "";
        }
    }
    String thisRequestURI = servletName;
    if(queryString != null) {
      thisRequestURI = thisRequestURI + "?" + queryString;
      //thisRequestURI = java.net.URLEncoder.encode(thisRequestURI, "UTF-8");
    }

    int fontSize = 11;
    try {
      fontSize = Integer.parseInt((String)session.getAttribute("fontSize"));
    } catch(Exception e){}
    session.setAttribute("fontSize", String.valueOf(fontSize));  // set the default font size of our site to 11
    //String siteWidth = "100%";
    String siteWidth = UtilBundle.init.getProperty("site.width.main")+"px";
    String siteHeight = UtilBundle.init.getProperty("site.height.main")+"px";

    String httpProtocol = "http";
    if (!request.isSecure()) {
        httpProtocol = "https";
    }

    String viewNameAdmin = UtilBundle.init.getProperty("main.view.name");
    Map viewSettingMap = (Map)ViewSettingUtil.getViewSettingsMap(viewNameAdmin);
    MenuBean menuBean = null;
    MenuItem menuItem = null;
    MenuContainer menuContainer = null;
    boolean displayFade = false;
    */

%>

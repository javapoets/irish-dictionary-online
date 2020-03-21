package online.irishdictionary.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import online.irishdictionary.model.Word;
import online.irishdictionary.database.DictionaryDatabaseManager;
import online.irishdictionary.servlet.InitServlet;

public class DictionaryServlet extends InitServlet {

    private static final Logger logger = LogManager.getLogger();

    private final String JSP_HOME = DIR_VIEW + "home.jsp";
    private final String JSP_RESULTS = DIR_VIEW + "results.jsp";

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.debug("doGet(request, response)");

        //include(request, response, JSP_HOME);
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.debug("doPost(request, response)");

        //*
        java.util.Enumeration parameterNames = (java.util.Enumeration)request.getParameterNames();
        while(parameterNames.hasMoreElements()) {
            String parameterName = (String)parameterNames.nextElement();
            logger.debug(parameterName+" = "+request.getParameter(parameterName));
            //logger.debug("parameterName = "+parameterName);
        }
        //*/

        //String wordParam = request.getParameter("word");
        String wordParam = null;
        try {
            wordParam = request.getParameter("word");
        } catch(Exception e) {
            e.printStackTrace();
        }


        String language = request.getParameter("language");
        String languageIdParam = request.getParameter("languageId");
        String fromLanguage = request.getParameter("fromLanguage");
        String toLanguage = request.getParameter("toLanguage");

        String remoteAddr = request.getRemoteAddr();
        //logger.debug("remoteAddr = "+remoteAddr);

        String locale = (request.getLocale()).toString();
        //logger.debug("locale = "+locale);

        StringBuilder sb = new StringBuilder();
        sb.append(locale);
        sb.append("/");
        sb.append(remoteAddr);
        sb.append(": ");
        sb.append(language);
        sb.append("/");
        sb.append(wordParam);

        logger.info(sb.toString());

        if(wordParam == null) {
            //response.sendRedirect(java.net.URLDecoder.decode(request.getContextPath()+"/dictionary", "UTF-8"));
            response.sendRedirect("home");
            return;
        }

        if(
            language == null
            || language.equals("null")
        ) {
            language = "irish";
            sb = new StringBuilder();
            sb.append(locale);
            sb.append("/");
            sb.append(remoteAddr);
            sb.append(": ");
            sb.append(language);
            sb.append("/");
            sb.append(wordParam);
            logger.info(sb.toString());
        }

        //logger.debug("word = "+wordParam);
        //logger.debug("language = "+language);
        //logger.debug("languageIdParam = "+languageIdParam);
        //logger.debug("fromLanguage = "+fromLanguage);
        //logger.debug("toLanguage = "+toLanguage);
        if(fromLanguage == null) {
            fromLanguage = language;
            request.setAttribute("fromLanguage", fromLanguage);
        }

        if(toLanguage == null) {
            if(fromLanguage != null) {
                toLanguage = fromLanguage.equals("english") ? "irish" : "english";
                request.setAttribute("toLanguage", toLanguage);
            }
        }

        int languageId = -1;
        if(languageIdParam != null) {
            try {
                languageId = Integer.parseInt(languageIdParam);
            } catch(Exception e) {
                logger.error(e);
            }
        } else {
            if(fromLanguage != null && fromLanguage.equals("english")) {
                languageId = 1;
            } else {
                languageId = 2;
            }
        }
        //logger.debug("languageId = "+languageIdParam);


        //request.setAttribute("fromLanguage", fromLanguage);
        //request.setAttribute("toLanguage", toLanguage);

        if(!"".equals(wordParam)) {

            Word word = new Word(wordParam.trim());

            /*
            //user.setWord(word);
            if(language.equals("english")) {
                try {
                    DictionaryManager.selectEnglishWord(word);
                    request.setAttribute("word", word);
                } catch(Exception e) {
                    logger.error(e);
                }
            } else if(language.equals("irish")) {
                try {
                    DictionaryManager.selectIrishWord(word);
                    //request.setAttribute("irishWord", word);
                    request.setAttribute("word", word);
                } catch(Exception e) {
                    logger.error(e);
                }
            }
            */

            try {

                //DictionaryManager.selectWord(word);
                DictionaryDatabaseManager.selectWord(word, languageId, getConnectionPool());
                request.setAttribute("word", word);

            } catch(Exception e) {
                logger.error(e);
                StringWriter stringWriter = new StringWriter();
                PrintWriter printWriter = new PrintWriter(stringWriter);
                e.printStackTrace(printWriter);
                logger.error(stringWriter.toString());
            }

            //displayResults(request, response);
            include(request, response, JSP_RESULTS);

        } else {

            /*
            // Word select failed.  Redisplay the search Page
            // try looking up in the Irish dictionary
            String thisReqURI = request.getParameter("thisReqURI");
            if(thisReqURI == null || thisReqURI.equals("")){
                thisReqURI = request.getContextPath()+"/dictionary";
            }
            response.sendRedirect(java.net.URLDecoder.decode(thisReqURI, "UTF-8"));
            //request.getRequestDispatcher("dictionary").forward(request, response);
            */

            /*
            //include(request, response, JSP_HOME);
            String requestURI = new StringBuilder().append(request.getContextPath()).append("/home").append("?").append(locale).toString();
            logger.debug("requestURI = "+requestURI);
            response.sendRedirect(java.net.URLDecoder.decode(requestURI, "UTF-8"));
            //request.getRequestDispatcher("dictionary").forward(request, response);
            */

            include(request, response, JSP_HOME);
        }

    }


    public void displayResults(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //HttpSession session = request.getSession(false);
        //User user = (User)session.getAttribute("user");
        request.setAttribute("pageType", "dictionary");
        include(request, response, JSP_RESULTS);
    }

    /*
    public void doService(HttpServletRequest request, HttpServletResponse response) throws java.sql.SQLException, IOException, ServletException, Exception {

        Enumeration parameterNames = (Enumeration)request.getParameterNames();
        while(parameterNames.hasMoreElements()) {
            String parameterName = (String)parameterNames.nextElement();
            if(parameterName.equals("word")) {
                word(request, response);
                return;
            }
        }

        String requestState;
        if(
            ((requestState = ((String)request.getParameter("rs"))) == null) ||
            (requestState.equals("tell"))
          )
        {
            requestState = "displayOpeningPage";
        }
        System.out.println(DictionaryControl.class+"requestState = "+requestState);

        if(requestState.equals("displayOpeningPage")) {
            displayOpeningPage(request, response);
        } else if(requestState.equals("displayDictSearch")){
            displayDictSearch(request, response);
        } else if(requestState.equals("processEmailWord")){
            processEmailWord(request, response);
        } else if(requestState.equals("displayWavFileForWord")){
            displayWavFileForWord(request, response);
        } else if(requestState.equals("dl")){
            displayLetter(request, response);
        } else if(requestState.equals("contact")){
            contact(request, response);
        } else if(requestState.equals("dictionary")){
            dictionary(request, response);
        } else if(requestState.equals("feedback")){
            feedback(request, response);
        } else if(requestState.equals("processContact")){
            processContact(request, response);
        } else if(requestState.equals("processFeedback")){
            processFeedback(request, response);
        } else if(requestState.equals("signup")){
            redirectToSignup(request, response);
        } else if(requestState.equals("privacy")){
            displayPrivacy(request, response);
        } else if(requestState.equals("terms")){
            displayTerms(request, response);
        } else if(requestState.equals("edit")){
            edit(request, response);
        }

    }
    */

    /**
    * Displays the home page
    public void displayOpeningPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = SessionListener.getSession(request);
        User user = user = (User)session.getAttribute("user");
        displayJSP(request, response, JSP_HOME);
    }
    */

    /**
    * Displays the home page
    public void displayDictSearch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = SessionListener.getSession(request);
        User user = null;
        if((session.getAttribute("user")) == null) {  // if the user is null create one and put it into the session
            user = new User();
        } else {
            user = (User)session.getAttribute("user");
        }
        request.setAttribute("pageType", "home");
        displayJSP(request, response, "home.jsp");
    }
    */

    /*
    public void word(HttpServletRequest request, HttpServletResponse response) throws java.sql.SQLException, IOException, ServletException, Exception {

        HttpSession session = SessionListener.getSession(request);
        ErrorBean errorBean = new ErrorBean();
        User user = user = (User)session.getAttribute("user");

        String word = request.getParameter("word");
        String language = request.getParameter("language");
        if(language == null) {
            language = request.getParameter("dict"); // backward compatibility
        }
        System.out.println(DictionaryControl.class+".word() word = "+word);
        System.out.println(DictionaryControl.class+".word() language = "+language);
        String letter;


        if((word!= null) && !(word.trim().equals(""))) {

            user.setWord(word);
            if(language.equals("english")) {
                WordBean wordBean = new WordBean(word.trim());
                DictionaryManager.selectEnglishWord(wordBean);
                request.setAttribute("wordBean", wordBean);
                System.out.println("request.setAttribute(\"wordBean\", wordBean);");
                displayDictResults(request, response);
            } else if(language.equals("irish")) {
                WordBean wordBean = new WordBean(word.trim());
                DictionaryManager.selectIrishWord(wordBean);
                request.setAttribute("irishWordBean", wordBean);
                System.out.println("request.setAttribute(\"irishWordBean\", wordBean);");
                displayDictResults(request, response);
            }
        } else {

            // Word select failed.  Redisplay the search Page
            // try looking up in the Irish dictionary
            String thisReqURI = request.getParameter("thisReqURI");
            if(thisReqURI == null || thisReqURI.equals("")){
                thisReqURI = request.getContextPath()+"/dictionary";
            }
            response.sendRedirect(java.net.URLDecoder.decode(thisReqURI, "UTF-8"));
            //request.getRequestDispatcher("dictionary").forward(request, response);
        }

    }
    */


    /**
     * Displays the results page
    public void displayDictResults(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = SessionListener.getSession(request);
        User user = (User)session.getAttribute("user");
        request.setAttribute("pageType", "dictionary");
        displayJSP(request, response, JSP_RESULTS);
    }
    */

    /*
    public void processEmailWord(HttpServletRequest request, HttpServletResponse response) throws java.sql.SQLException, IOException, ServletException, Exception {

        HttpSession session = request.getSession(false);
        String word = request.getParameter("word");
        String emailAddress = request.getParameter("emailAddress");
        ErrorBean errorBean = new ErrorBean();

        if  ((word!= null) && !(word.trim().equals(""))) {

            WordBean wordBean = new WordBean();
            wordBean.setWord(word);

            DictionaryManager.selectEnglishWord(wordBean);

                session.setAttribute("wordBean", wordBean);
                //try {
                //    com.javapoets.util.mailer.WordMailer.sendMessage(emailAddress, wordBean);
                //    request.setAttribute("emailSent", "true");
                //}catch(javax.mail.MessagingException me){
                //    request.setAttribute("emailSent", "false");
                //}
                displayDictResults(request, response);

        }else{

            // Word select failed.  Redisplay the search Page
            errorBean.addError(new FormError(
                                FormValidator.getMessages().getProperty("englishirish.search.form.nomatch") ,
                                FormError.SEVERITY_REPOST_DATA));
            request.setAttribute("errorBean", errorBean);
            displayDictSearch(request, response);

        }
    }
    */

    /*
    public void displayLetter(HttpServletRequest request, HttpServletResponse response) throws java.sql.SQLException, IOException, ServletException, Exception {

        String letter = request.getParameter("l");
        String language = request.getParameter("language");
        ErrorBean errorBean = new ErrorBean();
        HttpSession session = SessionListener.getSession(request);

        User user = user = (User)session.getAttribute("user");

        if  ((letter != null) && !(letter.trim().equals(""))) {
            if(language.equals("ei")) {
                Set letterWordSet = new TreeSet();
                DictionaryManager.selectWordByLetter(letterWordSet, letter);
                    request.setAttribute("letterWordSet", letterWordSet);
                    request.setAttribute("pageType", "dictionary");
                    displayJSP(request, response, "letterList.jsp");

            } else if(language.equals("ie")) {
                Set letterWordSet = new TreeSet();
                DictionaryManager.selectWordByLetter(letterWordSet, letter);
                    request.setAttribute("letterWordSet", letterWordSet);
                    request.setAttribute("pageType", "dictionary");
                    displayJSP(request, response, "letterListIrish.jsp");
            }
        }else{

            // Word select failed.  Redisplay the search Page
            errorBean.addError(new FormError(
                                FormValidator.getMessages().getProperty("englishirish.search.form.nomatch") ,
                                FormError.SEVERITY_REPOST_DATA));
            request.setAttribute("errorBean", errorBean);
            displayDictSearch(request, response);

        }
    }
     */

    /*
     * Displays the contact page
    public void contact(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("pageType", "contact");
        displayJSP(request, response, "contact.jsp");
    }
    */

    /**
     * Displays the feedback page
    public void feedback(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("pageType", "feedback");
        displayJSP(request, response, "feedback.jsp");
    }
    */

    /**
     * Displays the dictionary page
    public void dictionary(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        displayJSP(request, response, "/view/home.jsp");
    }
    */

    /*
    public void processContact(HttpServletRequest request, HttpServletResponse response) throws java.sql.SQLException, IOException, ServletException, Exception {

        ContactBean contactBean = new ContactBean();
        ServletUtil.beanIntrospect(contactBean, request);
        contactBean.setDateCreated(new Date());
        ErrorBean errorBean = new ErrorBean();

        if  ((contactBean.getQuery() != null) && !(contactBean.getQuery().equals(""))) {

            try {
                ContactManager.insertContact(contactBean);
                com.javapoets.util.mailer.ContactMailer.send(contactBean);
                request.setAttribute("pageType", "contact");
                displayJSP(request, response, "contactConfirm.jsp");
            } catch(Exception e){
                e.printStackTrace();
                contact(request, response);
            }

        }else{

            // Word select failed.  Redisplay the search Page
            errorBean.setMainErrorMessage("The query field is requestuired!");
            request.setAttribute("errorBean", errorBean);
            contact(request, response);

        }

    }
    */

    /*
    public void processFeedback(HttpServletRequest request, HttpServletResponse response) throws java.sql.SQLException, IOException, ServletException, Exception {

        ContactBean contactBean = new ContactBean();
        ServletUtil.beanIntrospect(contactBean, request);
        contactBean.setDateCreated(new Date());
        ErrorBean errorBean = new ErrorBean();

        if  ((contactBean.getQuery() != null) && !(contactBean.getQuery().equals(""))) {

            try {
                ContactManager.insertFeedback(contactBean);
                //com.javapoets.util.Mailer.sendFeedback(contactBean);
                com.javapoets.util.mailer.FeedbackMailer.send(contactBean);
                request.setAttribute("pageType", "feedback");
                displayJSP(request, response, "feedbackConfirm.jsp");
            } catch(Exception e){
                e.printStackTrace();
                feedback(request, response);
            }

        }else{

            // Word select failed.  Redisplay the search Page
            errorBean.setMainErrorMessage("The 'comments, feedback or suggestions field' is requestuired!");
            request.setAttribute("errorBean", errorBean);
            feedback(request, response);

        }

    }

    public void displayPrivacy(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            displayJSP(request, response, "privacy.jsp");
    }
    public void displayTerms(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            displayJSP(request, response, "tandc.jsp");
    }
    public void edit(HttpServletRequest request, HttpServletResponse response) throws java.sql.SQLException, IOException, ServletException, Exception {

        HttpSession session = SessionListener.getSession(request);
        ErrorBean errorBean = new ErrorBean();
        User user = user = (User)session.getAttribute("user");

        String language = request.getParameter("language");
        String word = request.getParameter("word");
        String usageId = request.getParameter("usageId");

        UsageBean usageBean = new UsageBean(usageId);
        DictionaryManager.selectUsageByUsageId(usageBean);
        request.setAttribute("usageBean", usageBean);
        displayJSP(request, response, "editUsage.jsp");
    }

    public void processEdit(HttpServletRequest request, HttpServletResponse response) throws Exception {

        HttpSession session = SessionListener.getSession(request);
        UsageBean usageBean = new UsageBean();
        ServletUtil.beanIntrospect(usageBean, request);

        DictionaryManager.insertUsage(usageBean);
        request.setAttribute("usageBean", usageBean);
        displayJSP(request, response, "usage.jsp");
    }
    */

}

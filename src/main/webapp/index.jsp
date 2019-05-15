<%

    String locale = (request.getLocale()).toString();
    //logger.debug("locale = "+locale);

    //request.getRequestDispatcher("home").forward(request, response);
    //request.getRequestDispatcher("home?"+locale).forward(request, response);
    String requestURI = new StringBuilder().append(request.getContextPath()).append("/home").append("?").append(locale).toString();
    //logger.debug("requestURI = "+requestURI);
    response.sendRedirect(java.net.URLDecoder.decode(requestURI, "UTF-8"));
%>

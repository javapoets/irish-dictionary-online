<%@ tag import="java.util.Date" import="java.text.DateFormat"%>
<%
  DateFormat dateFormat =
    DateFormat.getDateInstance(DateFormat.LONG);
  Date now = new Date(System.currentTimeMillis());
  out.println(dateFormat.format(now));
%>
<%--
Using this tag...
Add the following to your JSP page
                                  Today is <javapoets:date/>
--%>


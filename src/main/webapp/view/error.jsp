<%@ page isErrorPage="true" %>
<!-- header.jsp -->
<%@ include file="/view/imports.jsp" %>
<%@ include file="/view/variables.jsp" %>
<%@ page contentType="text/html;charset=ISO-8859-1" %>
<html>
  <head>
    <link rel=stylesheet href=admin?rs=css type=text/css>
  </head>
  <body leftmargin="0" topmargin=6 marginwidth=0 marginheight=0>
    <table border=0 cellspacing=0 cellpadding=0 align="center">
      <tr>
        <td valign=top align=center>
          <table border=0 cellspacing=8 cellpadding=2 width=100%>
            <tr>
              <td valign=top align=left>
                <%
                  Exception applicationException = (Exception)request.getAttribute("exception");
                  String subject = null;
                  if(exception != null) {
                    subject = exception.getMessage();
                  }
                  if(applicationException != null) {
                    subject = applicationException.getMessage();
                  }
                %>
                <table class=admin cellspacing=1 cellpadding=0 border=0 width=100%>
                  <tr>
                    <td>
                      <table class=admin border=0 cellpadding=0 cellspacing=0 width=100%>
                        <tr>
                          <th>!!! Application error !!!</th>
                          <th style="text-align: right" nowrap>
                            <input type=button class=button onclick="parent.top.self.location='javascript:history.go(-1)'" value="back">
                            <input type=submit class=button value=send>
                          </th>
                        </tr>
                      </table>
                    </th>
                  </tr>
                  <tr>
                    <td colspan=2>
                      <table cellspacing=8 cellpadding=0 border=0 width=100%>
                        <tr>
                          <td valign=top align>
                            <table class=admin cellspacing=1 cellpadding=0 border=0 width=100%>
                              <tr><th>Error info...</th></tr>
                              <tr>
                                <td>
                                  <form action=mail method=post>
                                  <input type=hidden name=rs value=sendErrorMail>
                                  <input type=hidden name=subject value="<%= subject %>">
                                  <input type=hidden name=to value="support@irishdictionary.ie">
                                  <textarea name=body cols=100 rows=20 class=100>
                                  <%
                                    /*
                                    * We need to create a <code>PrintWriter<code> object using the implicit <code>out</code> object
                                    * to print the stack trace as the implicit <code>javax.servlet.jsp.JspWriter out</code> object
                                    * cannot call the <code>java.lang.Throwable.printStackTrace(PrintWriter s)</code> method.
                                    */
                                    java.io.PrintWriter newOut = new java.io.PrintWriter(out);
                                    if(exception != null) {
                                  %>
                                  !!! JSP error !!!
                                  Error info...
                                  <%
                                    exception.printStackTrace(newOut);
                                    }
                                  %>
                                  <%
                                    if(applicationException != null) {
                                  %>
                                  !!! Application error !!!
                                  Error info...
                                  <%
                                      applicationException.printStackTrace(newOut);
                                    }
                                  %>
                                  </textarea><br>
                                  Help fix this problem?<br>Click send to email this error to development.
                                  <input type=submit class=button value=send>
                                  </form>
                                </td>
                              </tr>
                            </table>
                          </td>
                        </tr>
                      </table>
                    </td>
                  </tr>
                </table>
              </td>
            </tr>
          </table>
        </td>
      </tr>
    </table>
  </body>
</html>

<jsp:doBody var="referer" scope="session"/>
<%--
Using this tag...
Add the following to your JSP page
                                  Your referer header: ${header.referer}
                                  <br/>
                                  <tags:referer>
                                    ${header.referer}
                                  </tags:referer>
                                  <a href="viewReferer.jsp">View</a>
                                  the referer as a Session attribute.
--%>

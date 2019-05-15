<%@ include file="/view/imports.jsp" %>
<%@ include file="/view/variables.jsp" %>

<%-- Include the required tag libraries --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ tag import="java.util.Date" import="java.text.DateFormat" %>
<%@ tag import="javax.xml.parsers.*" %>
<%@ tag import="org.w3c.dom.*" %>
<%@ tag import="org.xml.sax.*" %>
<%@ tag import="org.w3c.dom.traversal.*" %>
<%@ tag import="org.apache.xpath.XPathAPI" %>

<%-- Define the Map for dynamic attributes --%>
<%@ tag dynamic-attributes="menuItems"%>

<%-- Define the variables --%>
<%@ variable name-given="destination" %>
<%@ variable name-given="menuItemName" %>

<%-- Define the attributes --%>
<%@ attribute name="id"%>
<%@ attribute name="href"%>
<%@ attribute name="metalinks"%>
<%@ attribute name="onmouseover"%>
<%@ attribute name="cssclass"%>

<%
                menuBean = MenuUtil.getMenuBean("top");
                if(menuBean != null) {
                    menuItemBeanList = (SortableBeanList)menuBean.getMenuItemBeanList();
                    if((menuItemBeanList != null) && (menuItemBeanList.size() > 0)) {
                        List sortedMenuItemBeanList = (List)menuItemBeanList.getSortedList("priority");
                        for(int j = 0; j < sortedMenuItemBeanList.size(); j++) {
                            menuItemBean = (MenuItemBean)sortedMenuItemBeanList.get(j);
                            if(menuItemBean.getDisplay()) {
                                out.println("<a href="+ menuItemBean.getDestination() +" class=top>"+ menuItemBean.getText() +"</a>");
                                if(j < (sortedMenuItemBeanList.size() - 1)) {
                                        out.println(" |");
                                }
                            }
                        }
                    }
                }
  DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.LONG);
  Date now = new Date(System.currentTimeMillis());
  jspContext.setAttribute("destination", menuItemBean.getDestination());
  out.println(dateFormat.format(now));
%>


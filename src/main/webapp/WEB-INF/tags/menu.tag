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
        String cssclass = "top";
        String onmouseover = "false";
        String metalinks = "view/embeddedLinks.xml";
        String id = null;
        menuBean = MenuUtil.getMenuBean("top");
        if(menuBean != null) {
            menuItemBeanList = (SortableBeanList)menuBean.getMenuItemBeanList();
            if((menuItemBeanList != null) && (menuItemBeanList.size() > 0)) {
                List sortedMenuItemBeanList = (List)menuItemBeanList.getSortedList("priority");
                for(int j = 0; j < sortedMenuItemBeanList.size(); j++) {
                    menuItemBean = (MenuItemBean)sortedMenuItemBeanList.get(j);
                    if(menuItemBean.getDisplay()) {
/*
                        out.println("<a href="+ menuItemBean.getDestination() +" class=top>"+ menuItemBean.getText() +"</a>");
                        if(j < (sortedMenuItemBeanList.size() - 1)) {
                                out.println(" |");
                        }
*/
                        //id = menuItemBean.getMenuItemId();
                        id = menuItemBean.getText();
                        // insert the main hypertext
                        out.println("<nobr><a href=\""+menuItemBean.getDestination()+"\" class=\""+cssclass+"\">"+menuItemBean.getText()+"</a>");

                        String ua = ((HttpServletRequest)pageContext.getRequest()).getHeader("User-Agent").toLowerCase();
                        if (ua.indexOf("msie")>0) {
                                // Begin composing dynamic HTML code for Internet Explorer
                                if (onmouseover!=null && onmouseover.toLowerCase().equals("true")) {
                                    out.println("<a href=\"\" onmouseover=\"DynamicPane_"+id+".style.visibility = (DynamicPane_"+id+".style.visibility=='visible' ? 'hidden' : 'visible'); return false;\" onmouseout=\"if (window.event.clientX<=DynamicPane_"+id+".offsetLeft || window.event.clientY<=DynamicPane_"+id+".offsetTop) { DynamicPane_"+id+".style.visibility = 'hidden'; }\" onclick=\"return false;\" class=\""+cssclass+"\">");
                                    //out.println("<a href=\"\" onmouseover=\"document.getElementById('DynamicPane_"+id+"').style.visibility = (document.getElementById('DynamicPane_"+id+"').style.visibility=='visible' ? 'hidden' : 'visible'); return false;\" onmouseout=\"if (window.event.clientX<=document.getElementById('DynamicPane_"+id+"').offsetLeft || window.event.clientY<=DynamicPane_"+id+".offsetTop) { DynamicPane_"+id+".style.visibility = 'hidden'; }\" onclick=\"return false;\" class=\""+cssclass+"\">");
                                    out.println("<img src=\"view/images/dropdown_icon.gif\" alt=\"\" border=\"0\"/>");
                                    out.println("</a></nobr>");
                                } else {
                                    //out.println("<a href=\"\" onclick=\"DynamicPane_"+id+".style.visibility = (DynamicPane_"+id+".style.visibility=='visible' ? 'hidden' : 'visible'); return false;\" onmouseout=\"if (window.event.clientX<=DynamicPane_"+id+".offsetLeft || window.event.clientY<=DynamicPane_"+id+".offsetTop) { DynamicPane_"+id+".style.visibility = 'hidden'; }\" class=\""+cssclass+"\">");
                                    out.println("<a href=\"\" onclick=\"DynamicPane_"+id+".style.visibility = (DynamicPane_"+id+".style.visibility=='visible' ? 'hidden' : 'visible'); return false;\" onmouseout=\"if (window.event.clientX<=DynamicPane_"+id+".offsetLeft || window.event.clientY<=DynamicPane_"+id+".offsetTop) { DynamicPane_"+id+".style.visibility = 'hidden'; }\" class=\""+cssclass+"\">");
                                    out.println("<img src=\"view/images/dropdown_icon.gif\" alt=\"Click to expand\" title=\"Click to expand\" border=\"0\"/>");
                                    out.println("</a></nobr>");
                                }
                        } else if (ua.indexOf("netscape6")>0 || ua.indexOf("netscape/7")>0) {
                                // Begin composing dynamic HTML code for Netscape 6.0+ browsers
                                if (onmouseover!=null && onmouseover.toLowerCase().equals("true")) {
                                    out.println("<a href=\"\" onmouseover=\"document.getElementById('DynamicPane_"+id+"').style.left=event.pageX+5;document.getElementById('DynamicPane_"+id+"').style.top=event.pageY-8; document.getElementById('DynamicPane_"+id+"').style.visibility = (document.getElementById('DynamicPane_"+id+"').style.visibility=='visible' ? 'hidden' : 'visible'); return false;\" onmouseout=\"if (event.pageX<=document.getElementById('DynamicPane_"+id+"').style.left || event.pageY<=document.getElementById('DynamicPane_"+id+"').style.top) { document.getElementById('DynamicPane_"+id+"').style.visibility = 'hidden'; }\" onclick=\"return false;\" class=\""+cssclass+"\">");
                                    out.println("<img src=\"view/images/dropdown_icon.gif\" alt=\"\" border=\"0\"/>");
                                    out.println("</a></nobr>");
                                } else {
                                    out.println("<a href=\"\" onclick=\"document.getElementById('DynamicPane_"+id+"').style.left=event.pageX+5;document.getElementById('DynamicPane_"+id+"').style.top=event.pageY-8; document.getElementById('DynamicPane_"+id+"').style.visibility = (document.getElementById('DynamicPane_"+id+"').style.visibility=='visible' ? 'hidden' : 'visible'); return false;\" onmouseout=\"if (window.event.clientX<=document.getElementById('DynamicPane_"+id+"').offsetLeft || window.event.clientY<=document.getElementById('DynamicPane_"+id+"').offsetTop) { document.getElementById('DynamicPane_"+id+"').style.visibility = 'hidden'; }\" class=\""+cssclass+"\">");
                                    out.println("<img src=\"view/images/dropdown_icon.gif\" alt=\"Click to expand\" title=\"Click to expand\" border=\"0\"/>");
                                    out.println("</a></nobr>");
                                }
                        } else {
                                // ignore all other browsers
                                out.println("</nobr>");
                        }

                        // Create dynamic <span> element for displaying embedded hyperlinks
                        out.println("<span id=\"DynamicPane_"+id+"\" style=\"position:absolute;visibility:hidden;background-color:#ffffff;padding:2px;border-style:solid;border-color:#000000;border-width:1px;margin-top:5px;\" onmouseover=\"this.style.visibility='visible';\" onmouseout=\"this.style.visibility='hidden';\">");

                        // Load XML document containing additional hyperlinks.
                        // Use this document to generate the embedded hyperlinks.
                        // Look for a <Section> element with name attribute = id.
                        Document xmlDoc = XMLUtil.loadXml(pageContext.getServletContext().getRealPath(metalinks));
                        NodeIterator iterator = XPathAPI.selectNodeIterator(xmlDoc, "/Hrefs/Section[@name='"+id+"']/Href");
                        Node node;
                        while ((node=iterator.nextNode())!=null)
                        {
                            out.println("<a href=\""+node.getAttributes().getNamedItem("url").getNodeValue()+"\" style=\"text-decoration:none;\" class=\""+cssclass+"\">");
                            out.println("<font color=\"#000000\" style=\"font-family:verdana,arial,helvetica,sans-serif; font-size:10px; font-weight:normal;\" onmouseover=\"this.color='#cc0000';\" onmouseout=\"this.color='#000000';\">");
                            out.println(node.getAttributes().getNamedItem("text").getNodeValue());
                            out.println("</font></a><br>");
                        }
                        out.println("</span>");

                            }
                        }
                    }
                }

%>


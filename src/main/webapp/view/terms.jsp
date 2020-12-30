<%@ page
    language="java"
    contentType="text/html;charset=UTF-8"
    pageEncoding="UTF-8"
    session="false" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.Set" %>
<%@ page import="online.irishdictionary.model.Word" %>
<%@ page import="online.irishdictionary.model.Verb" %>
<%@ page import="online.irishdictionary.model.VerbConjugation" %>
<%@ include file="/view/log.jsp" %>
<%
    String contextUrl = (String)application.getAttribute("contextUrl");
    String imagesUrl = contextUrl + "view/images/";
    log.debug("contextUrl = " + contextUrl);
    String wordEnglish = null;
    String wordIrish = null;
    String verbEnglish = null;
    String verbIrish = null;    
%>
<!doctype html>
<html>
  <head>
    <%@ include file="/view/head.jsp" %>
  </head>
  <body>
    <div class="centering-container">
      <div class="table">
        <div class="row">
          <div class="cell">
            <div class="flex-header">
              <!--div style="padding: 13px 42px; width: 200px;"-->
              <div>
                <a href="<%= contextUrl %>"><img src="<%= imagesUrl %>Irish-Dictionary-Online-Logo.jpg" border="0" title="Irish Dictionary Online"></a>
              </div>
              <div class="search-block">
                <%@ include file="/view/top-form.jsp" %>
              </div>
            </div>
          </div>
        </div>
        <div class="row">
          <div class="cell">
            <div style="padding-bottom: 40px;">

<p>
Terms of Service
</p>
<p>
Please read the following terms of service carefully. By using this website you are signifying that you are in agreement with our terms of service. Irish dictionary online reserves the right to modify, change or update these terms at any time. We ask that you refrain from using this website if you do not agree with the terms and conditions outlined below.
</p>
<p> 
Disclaimer
Irish dictionary online provides this website with no warranties of any kind, expressed or implied by statute, common usage or otherwise. Use of this website is at your own risk, at all times. In particular, Irish dictionary online disclaims any implied warranties of merchantability, fitness for purpose, or non-infringement. Irish dictionary online reserves the right to withdraw or modify any aspects of this website at its absolute discretion. Irish dictionary online does not warrant your use of this website will be always available and uninterrupted, error free or that it will meet your requirements, and Irish dictionary online deny liability for any loss or damage so caused.
</p>
<p>
Privacy
Irish dictionary online's Privacy Policy forms part of these Terms of Service.
Right of Refusal
Irish Dictionary shall have the right to prevent a person using this website if:

    The person abuses or wrongfully uses this website.
    The customer fails to pay the relevant subscription fee when required to do so. 
</p>

            </div>
          </div>
        </div>
        <div class="row">
          <div class="cell">
            <div>
              <%@ include file="/view/footer/footer-copyright.jsp" %>
            </div>
          </div>
        </div>
      </div>
    </div>
<%--    
--%>
<%@ include file="/view/footer.jsp" %>

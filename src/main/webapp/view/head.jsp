<%
	StringBuilder contentLanguageBuilder = new StringBuilder();
	contentLanguageBuilder.append(lang);
	if (fromLang != null && !fromLang.equals(lang)) contentLanguageBuilder.append(", ").append(fromLang);
	if (toLang != null && !toLang.equals(lang)) contentLanguageBuilder.append(", ").append(toLang);
%>
    <meta charset="utf-8" />
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
    <meta http-equiv="Content-Language" content="<%= contentLanguageBuilder.toString() %>" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <%--meta name="viewport" content="width=device-width, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no" /--%>
    <meta name="description" content="A premium online Irish Gaelic dictionary providing quick word searches, definitions and usage." />
    <meta name="keywords" content="irish dictionary, irish dictionary online, gaelic dictionary, irish, gaelic, translate irish, dictionary irish, dictionary, ireland dictionary, irish words, irish translation, translation, ireland, foclóir gaeilge" />
    <base href="<%= contextUrl %>" />
    <link rel="shortcut icon" href="<%= contextUrl %>favicon.ico" sizes="16x16 24x24 32x32 48x48 64x64" type="image/x-icon" />
    <title>Irish Dictionary Online, Irish Gaelic dictionary, Irish Dictionary, Gaelic Dictionary, Foclóir Gaeilge, Translate Irish, Irish language dictionary</title>
    <link rel="stylesheet" type="text/css" href="<%= contextUrl %>css" />
    <%--link rel="stylesheet" type="text/css" href="<%= contextUrl %>css?<%= new java.util.Date().getTime() %>"--%>
    <%--
    <script async src="https://pagead2.googlesyndication.com/pagead/js/adsbygoogle.js"></script>
    <script data-ad-client="ca-pub-5611094585811186" async src="https://pagead2.googlesyndication.com/pagead/js/adsbygoogle.js"></script>
    <script async src="http://pagead2.googlesyndication.com/pagead/js/adsbygoogle.js"></script>
    --%>
    <%--@ include file="google-analytics-async.html" --%>
    <%-- if (!lang.equals("ga")) { %>
    <script data-ad-client="ca-pub-5611094585811186" async src="//pagead2.googlesyndication.com/pagead/js/adsbygoogle.js"></script>
    <% } --%>
    <% if (!lang.equals("ga")) { %>
      <script data-ad-client="ca-pub-5611094585811186" async src="https://pagead2.googlesyndication.com/pagead/js/adsbygoogle.js"></script>
    <% } %>
    <script type="text/javascript">
      <%@ include file="/view/inline-javascript.jsp" %>
    </script>
    <style>
      @import url('https://fonts.googleapis.com/css2?family=Averia+Serif+Libre:wght@700&display=swap');
    </style> 
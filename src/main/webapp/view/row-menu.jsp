<%
    String lang = null;
    lang = (String)request.getAttribute("lang");
    log.debug("lang = " + lang);
    if (lang == null) {
        if (session != null) lang = (String)session.getAttribute("lang");
        log.debug("lang = " + lang);
        if (lang == null) {
            lang = (String)application.getAttribute("lang");
            log.debug("lang = " + lang);
            if(lang == null) lang = "en";
            //if(lang == null) lang = java.util.Locale.getDefault().getLanguage();
        }
    }
    log.debug("lang = " + lang);
    final online.irishdictionary.util.ResourceBundles resourceBundles = new online.irishdictionary.util.ResourceBundles(lang);
%>
<%--= resourceBundles.getString("English word(s)") --%>
<div class="row menu">
  <div class="cell menu">
    <div style="display: inline-block;">
      <% if ("ga".equals(lang)) { %>
        Tá an suíomh gréasáin seo i <strong>nGaeilge</strong>.
      <% } else if ("es".equals(lang)) { %>
        Esto sitio web es en <strong>Español</strong>.
      <% } else if ("en".equals(lang)) { %>
        The principal language of this website is <strong>English</strong>.
      <% } %>
    </div>
    <div style="display: inline-block;">
      <%= resourceBundles.getString("Change it to") %>:
      <select onchange="selectLanguage(this)">
        <option><%= resourceBundles.getString("Select") %></option>
        <% if ("es".equals(lang) || "en".equals(lang)) { %>
        <option value="ga" <% if (lang != null && lang.equals("ga")) { %>selected<% } %>><%= resourceBundles.getString("Irish") %></option>
        <% } %>
        <% if ("en".equals(lang) || "ga".equals(lang)) { %>
        <option value="es" <% if ("es".equals(lang)) { %>selected<% } %>><%= resourceBundles.getString("Spanish") %></option>
        <% } %>
        <% if ("es".equals(lang) || "ga".equals(lang)) { %>
        <option value="en" <% if ("en".equals(lang)) { %>selected<% } %>><%= resourceBundles.getString("English") %></option>
        <% } %>
      </select>
    </div>
  </div>
</div>

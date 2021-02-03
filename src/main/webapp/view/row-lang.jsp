<div class="row menu">
  <div class="cell menu">
    <div>
      <% if ("ga".equals(lang)) { %>
        Tá an suíomh seo i <strong>nGaeilge</strong>.
      <% } else if ("es".equals(lang)) { %>
        Esté sitio está en <strong>Español</strong>.
      <% } else if ("en".equals(lang)) { %>
        The principal language of this website is <strong>English</strong>.
      <% } %>
    </div>
    <div>
      <%--= resourceBundles.getString("Change it to") --%>
      <%= resourceBundles.getString("It is also available in") %>
      <select onchange="selectLanguage(this)">
        <option><%= resourceBundles.getString("Select") %></option>
        <% if ("es".equals(lang) || "en".equals(lang)) { %>
        <option value="ga" <% if (lang != null && lang.equals("ga")) { %>selected<% } %>><%= resourceBundles.getString("Irish") %>/Gaelige<%-- Irish / Gaelige --%></option>
        <% } %>
        <% if ("en".equals(lang) || "ga".equals(lang)) { %>
        <option value="es" <% if ("es".equals(lang)) { %>selected<% } %>><%= resourceBundles.getString("Spanish") %>/Español<%-- Spanish / Español --%></option>
        <% } %>
        <% if ("es".equals(lang) || "ga".equals(lang)) { %>
        <option value="en" <% if ("en".equals(lang)) { %>selected<% } %>><%= resourceBundles.getString("English") %>/English</option>
        <% } %>
      </select>
    </div>
  </div>
</div>

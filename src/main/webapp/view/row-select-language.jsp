<%@ page pageEncoding="UTF-8"%>
<div class="row menu">
  <div class="cell menu">
    <div style="display: inline-block;">
      <%= resourceBundles.getString("This website is in") %>
    </div>
    <div style="display: inline-block;">
      <select onchange="selectLanguage(this)">
        <option><%= resourceBundles.getString("Select_Language") %></option>
        <% if ("es".equals(lang) || "en".equals(lang)) { %>
        <option value="ga" <%-- if (lang != null && lang.equals("ga")) { %>selected<% } --%>><%= resourceBundles.getString("Irish") %>/Gaelige<%-- Irish / Gaelige --%></option>
        <% } %>
        <% if ("en".equals(lang) || "ga".equals(lang)) { %>
        <option value="es" <%-- if ("es".equals(lang)) { %>selected<% } --%>><%= resourceBundles.getString("Spanish") %>/Español<%-- Spanish / Español --%></option>
        <% } %>
        <% if ("es".equals(lang) || "ga".equals(lang)) { %>
        <option value="en" <%-- if ("en".equals(lang)) { %>selected<% } --%>><%= resourceBundles.getString("English") %>/English</option>
        <% } %>
      </select>
    </div>
  </div>
</div>

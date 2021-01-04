<div class="table copyright">
  <div class="row">
    <div class="cell copyright">
      <%--  
      <a href="<%= contextUrl %>">Copyright &copy; <%= new java.text.SimpleDateFormat("yyyy").format(new java.util.Date()) %> Irish Dictionary Online</a>
      --%>
      <%= resourceBundles.getString("Copyright") %> &copy; 2003-<%= new java.text.SimpleDateFormat("yyyy").format(new java.util.Date()) %>
      <%--= resourceBundles.getString("Irish Dictionary Online") --%>
      Irish Dictionary Online
    </div>
  </div>
  <div class="row terms">
    <div class="cell terms">
      [<a href="<%= contextUrl %>terms"><%= resourceBundles.getString("Terms of Service") %></a>]
      <%--[<a href="<%= contextUrl %>privacy">Privacy</a>]--%>
	  </div>
  </div>
</div>

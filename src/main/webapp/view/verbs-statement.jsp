<div class="table" style="
    width: 100%;
    color: var(--dark-green);
<%--
    font-family: Roboto, Arial Narrow, Arial, Verdana, Georgia, Garamond, Impact;
    letter-spacing: -1px;
--%>
    font-family: Arial;
    font-size: 14px;
    text-transform: uppercase;
    line-height: 21px;
">
  <%
      int englishVerbsCount = (Integer)application.getAttribute("englishVerbsCount");
      int irishVerbsCount = (Integer)application.getAttribute("irishVerbsCount");
  %>
  <div class="row">
    <div class="cell">
      <a href="verbs/english" style="color:inherit"><%= englishVerbsCount %> <%= resourceBundles.getString("English verbs") %></a>
      <%= resourceBundles.getString("and") %>
      <a href="verbs/irish" style="color:inherit"><%= irishVerbsCount %> <%= resourceBundles.getString("Irish verbs") %></a>
      <span style="white-space: nowrap;"><%= resourceBundles.getString("conjugated and translated") %></span>
    </div>
  </div>
</div>
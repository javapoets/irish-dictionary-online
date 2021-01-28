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
"
>
  <div class="row">
    <div class="cell" style="padding: 10px;">
      <%= resourceBundles.getString("Over 50,000 words translated and put to use") %>
    </div>
  </div>
  <%--
      Over 50,000 words translated and put to use
      1,400 English verbs and 768 Irish verbs conjugated and translated.
  --%>
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
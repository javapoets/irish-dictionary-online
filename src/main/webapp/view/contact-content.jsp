<%--
<h1><%= resourceBundles.getString("Contact Irish Dictionary Online") %></h1>
--%>
<div class="contact-content">
  <div>
    <form method="post" action="<%= contextUrl %>contact">
      <div class="input">
        <input type="text" name="name" tabindex="1" placeholder="<%= resourceBundles.getString("Your name") %>..." />
      </div>
      <div class="input">
        <input type="email" name="email" tabindex="2" placeholder="<%= resourceBundles.getString("Your email") %>..." />
      </div>
      <div class="input">
        <textarea cols="40" rows="6" name="message" tabindex="3" placeholder="<%= resourceBundles.getString("Your message") %>..."></textarea>
      </div>
      <div style="margin: 10px;">
        <%--button type="submit" tabindex="4" formmethod="post">Send</button--%>
        <input type="submit" tabindex="4" value="<%= resourceBundles.getString("Send") %>" />
      </div>
    </form>
  </div>
</div>

<h1><%= resourceBundles.getString("Contact Irish Dictionary Online") %></h1>
<div class="contact-content">
  <div>
    <form action="contact" method="post">
      <div class="input">
        <input type="text" name="name" tabindex="1" placeholder="Your name...">
      </div>
      <div class="input">
        <input type="email" name="email" tabindex="2" placeholder="Your email...">
      </div>
      <div class="input">
        <textarea cols="40" rows="6" name="message" tabindex="3" placeholder="Your message..."></textarea>
      </div>
      <div style="margin: 10px;">
        <button type="submit" tabindex="4">Send</button>
      </div>
    </form>
  </div>
</div>

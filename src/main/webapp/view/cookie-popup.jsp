<%
    String acceptCookies = null;
    log.debug("session = " + session);
    if (session != null) {
        acceptCookies = (String)session.getAttribute("acceptCookies");
    }
    log.debug("acceptCookies = " + acceptCookies);
    if (
      acceptCookies == null
      || (acceptCookies != null && !acceptCookies.equals("true"))
    ) {
%>
<div id="cookie-popup" style="position: fixed; bottom: 0; height: 100px; width: 100%;">
  <div style="text-align: center; margin: auto auto 0px auto; width: 100%; vertical-align: bottom; padding-top:10px;">
    <div style="vertical-align: bottom;">
      <div style="display: inline-table; height: 90px; box-shadow:0px -3px 8px rgba(0,0,0,0.33); max-width: var(--site-width); vertical-align: middle; margin: auto;">
        <div class="table" style="height: 100%; margin: auto; vertical-align: middle; background-color: rgba(255,255,255,0.9)">
          <div class="cell" style="font-size: .9em; text-align: left; padding: 5px 0px 5px 20px; margin: auto auto auto 0px; vertical-align: middle; ">
          This website uses cookies to enhance your experience.
          By continuing to use this site you consent to the use of cookies as described by our <a href="privacy#cookies">Cookie Policy</a>
          To find out more read our <a href="privacy">Privacy Policy</a>.
          </div>
          <div class="cell" style="text-align: right; padding: 20px; margin: auto; vertical-align: middle; ">
            <button style="font-size: 1.2em; border-radius: 25px;" onclick="clickAcceptCookies()">Got it!</button>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
<% } %>

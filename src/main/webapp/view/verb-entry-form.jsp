<div class="entry-form">
  <div>

    <form action="verb" method="post" name="verb" style="margin:0px;" onsubmit="searchEnglishVerb(this);return false;">
      <input type="hidden" name="rs" value="search" />
      <input type="hidden" name="languageId" value="1" />
      <input type="hidden" name="language" value="english" />
      <input type="hidden" name="fromLanguage" value="english" />
      <input type="hidden" name="toLanguage" value="irish" />

      <div class="input">
        <div class="table">
          <div class="row">
            <div class="cell">
                <input
                  type="text"
                  name="verb"
                  id="irishVerb"
                  class="text"
                  <% if (verbEnglish != null) { %>value="<%= verbEnglish %>"<% } %>
                  maxlength="200"
                  placeholder="English verb(s)"
                  style="width: 100%;" />
            </div>
            <div class="cell" style="margin-right: 0px; text-align: right; width: 60px;">
              <input type="button" value="go" class="orangebutton3" onclick="searchEnglishVerb(this.form)" />
            </div>
          </div>
        </div>
      </div>
    </form>

  </div>
  <div>

    <form action="verb" method="post" name="irishVerb" style="margin:0px;" onsubmit="searchIrishVerb(this);return false;">
      <input type="hidden" name="rs" value="search" />
      <input type="hidden" name="languageId" value="2" />
      <input type="hidden" name="language" value="irish" />
      <input type="hidden" name="fromLanguage" value="irish" />
      <input type="hidden" name="toLanguage" value="english" />

      <div class="input">
        <div class="table">
          <div class="row">
            <div class="cell">
                <input
                  type="text"
                  name="verb"
                  id="irishVerb"
                  class="text"
                  <% if(verbIrish != null) { %>value="<%= verbIrish %>"<% } %>
                  maxlength="200"
                  placeholder="Irish verb(s)"
                  style="width: 100%;" />
            </div>
            <div class="cell" style="margin-right: 0px; text-align: right; width: 60px;">
              <input type="button" value="go" class="orangebutton3" onclick="searchIrishVerb(this.form)" />
            </div>
          </div>
        </div>
      </div>
    </form>
  </div>
</div>
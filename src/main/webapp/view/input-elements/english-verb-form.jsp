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
          <input type="text" name="verb" id="englishVerb" class="text" maxlength="200" placeholder="<%= resourceBundles.getString("English verb") %>"<% if (verbEnglish != null) { %> value="<%= verbEnglish %>"<% } %> />
        </div>
        <div class="cell" style="margin-right: 0px; text-align: right; width: 60px;">
          <input type="button" value="go" class="orangebutton3" onclick="searchEnglishVerb(this.form)" />
        </div>
      </div>
    </div>
  </div>
</form>
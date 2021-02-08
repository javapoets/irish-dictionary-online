<form action="dictionary" method="post" name="word" onsubmit="searchEnglishWord(this); return false;">
  <input type="hidden" name="languageId" value="1" />
  <input type="hidden" name="language" value="english" />
  <input type="hidden" name="fromLanguage" value="english" />
  <input type="hidden" name="toLanguage" value="irish" />
  <div class="input">
    <div class="table">
      <div class="row">
        <div class="cell">
          <input type="text" name="word" id="englishWord" class="text" maxlength="200" placeholder="<%= resourceBundles.getString("English word(s)") %>"<% if (wordEnglish != null) { %> value="<%= wordEnglish %>"<% } %> />
        </div>
        <div class="cell" style="margin-right: 0px; text-align: right; width: 60px;">
          <input type="button" value="go" class="orangebutton3" onclick="searchEnglishWord(this.form)" />
        </div>
      </div>
    </div>
  </div>
</form>

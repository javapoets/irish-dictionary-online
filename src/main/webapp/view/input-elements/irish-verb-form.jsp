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
          <input type="text" name="verb" id="irishVerb" class="text" placeholder="<%= resourceBundles.getString("Irish verb") %>" maxlength="200"<% if(verbIrish != null) { %> value="<%= verbIrish %>"<% } %> />
        </div>
        <div class="cell" style="margin-right: 0px; text-align: right; width: 60px;">
          <input type="button" value="go" class="orangebutton3" onclick="searchIrishVerb(this.form)" />
        </div>
      </div>
    </div>
  </div>
</form>
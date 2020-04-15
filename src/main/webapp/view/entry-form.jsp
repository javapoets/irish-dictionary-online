<div class="entry-form" style="text-align:center;margin:auto;">

  <div>

    <form action="dictionary" method="post" name="word" style="margin:0px;" onsubmit="searchEnglishWord(this);return false;">

      <input type="hidden" name="languageId" value="1" />
      <input type="hidden" name="language" value="english" />
      <input type="hidden" name="fromLanguage" value="english" />
      <input type="hidden" name="toLanguage" value="irish" />

      <div class="table blue" style="width: 100%;">
        <div class="row">
          <div class="cell" style="outline: red 1px solid;">
            <div class="input" style="outline: blue 1px solid; display: table; width: 100%;">
              <input type="text" name="word" id="irishWord" class="text" value="<%= wordEnglish %>" maxlength="200" placeholder="English word(s)" style="border: blue 1px solid; width: 100%;" />
            </div>
          </div>
          <div class="cell yellow">
            <input type="button" value="go" class="orangebutton3" onclick="searchEnglishWord(this.form)" />
          </div>
        </div>
      </div>

    </form>

  </div>

  <div>

    <form action="dictionary" method="post" name="irishWord" style="margin:0px;" onsubmit="searchIrishWord(this);return false;">
      
      <input type="hidden" name="languageId" value="2" />
      <input type="hidden" name="language" value="irish" />
      <input type="hidden" name="fromLanguage" value="irish" />
      <input type="hidden" name="toLanguage" value="english" />

      <div class="table blue" style="width: 100%;">
        <div class="row">
          <div class="cell" style="outline: red 1px solid;">
            <div class="input" style="outline: blue 1px solid; display: table; width: 100%;">
              <input type="text" name="word" id="irishWord" class="text" value="<%= wordIrish %>" maxlength="200" placeholder="Irish word(s)" style="border: blue 1px solid; width: 100%;" />
            </div>
          </div>
          <div class="cell yellow">
            <input type="button" value="go" class="orangebutton3" onclick="searchIrishWord(this.form)" />
          </div>
        </div>
      </div>

    </form>

  </div>

</div>
    <form action="dictionary" method="post" name="irishWord" onsubmit="searchIrishWord(this);return false;">
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
                  name="word"
                  id="irishWord"
                  class="text"
                  <% if(wordIrish != null) { %>value="<%= wordIrish %>"<% } %>
                  maxlength="200"
                  placeholder="Irish word(s)"
                  style="width: 100%;" />
            </div>
            <div class="cell" style="margin-right: 0px; text-align: right; width: 60px;">
              <input type="button" value="go" class="orangebutton3" onclick="searchIrishWord(this.form)" />
            </div>
          </div>
        </div>
      </div>
    </form>

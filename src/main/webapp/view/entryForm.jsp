

<%--
<div class="table" style="text-align: center; margin: auto;">
  <div class="row">
    <div class="cell" style="padding: 20px 20px 10px 20px">

      <div class="table" style="width: 100%">
        <div class="row">
          <div class="cell" style="padding-right: 33px">

            <form action="dictionary" method="post" name="word" style="margin:0px;" onsubmit="searchEnglishWord(this);return false;">

              <input type="hidden" name="languageId" value="1" />
              <input type="hidden" name="language" value="english" />
              <input type="hidden" name="fromLanguage" value="english" />
              <input type="hidden" name="toLanguage" value="irish" />

              <div style="text-align: left;">

                <div style="padding-left: 15px;">English word(s)</div>
                <div class="table">
                  <div class="row">
                    <div class="cell">
                      <div class="input"><input type="text" name="word" class="text" value="<%= wordEnglish %>" maxlength="200" /></div>
                    </div>
                    <div class="cell yellow0" style="vertical-align:middle;margin:auto;padding-left:3px;">
                      <input type="button" value="go" class="orangebutton3" onclick="searchEnglishWord(this.form)" />
                    </div>
                  </div>
                </div>
                <script language="javascript">
                  document.word.word.focus();
                  document.word.word.select();
                </script>
              </div>

            </form>

          </div>
--%>          

<div style="padding-top:108px;padding-bottom:108px;text-align:center;margin:auto;">

  <div class="entry-form" style="text-align:center;margin:auto;">

    <!--div-->

<%--
      <div style="padding-right: 33px">

        <form action="dictionary" method="post" name="word" style="margin:0px;" onsubmit="searchEnglishWord(this);return false;">

          <input type="hidden" name="languageId" value="1" />
          <input type="hidden" name="language" value="english" />
          <input type="hidden" name="fromLanguage" value="english" />
          <input type="hidden" name="toLanguage" value="irish" />

          <div style="text-align: left;">

            <div class="table">
              <div class="row">
                <div class="cell">
                  <div class="input"><input type="text" name="word" class="text" value="<%= wordEnglish %>" maxlength="200" placeholder="English word(s)" /></div>
                </div>
                <div class="cell yellow0" style="vertical-align:middle;margin:auto;padding-left:3px;">
                  <input type="button" value="go" class="orangebutton3" onclick="searchEnglishWord(this.form)" />
                </div>
              </div>
            </div>
            <script language="javascript">
              document.word.word.focus();
              document.word.word.select();
            </script>
          </div>

        </form>

      </div>
--%>
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
<%--      
                <div class="cell yellow0" style="border: red 1px solid; vertical-align: middle; margin: auto; padding-left: 3px;">
--%>      
                <div class="cell yellow">
                  <input type="button" value="go" class="orangebutton3" onclick="searchIrishWord(this.form)" />
                </div>
              </div>
            </div>

<%--      
            <div class="light small bold" style="margin:0px;padding-left:10px;">
              Add a Fada:&nbsp;
              <span onclick="val=$('irishWord').value;$('irishWord').value=val+'á'" class="small link">[á]</span>
              <span onclick="val=$('irishWord').value;$('irishWord').value=val+'é'" class="small link">[é]</span>
              <span onclick="val=$('irishWord').value;$('irishWord').value=val+'í'" class="small link">[í]</span>
              <span onclick="val=$('irishWord').value;$('irishWord').value=val+'ó'" class="small link">[ó]</span>
              <span onclick="val=$('irishWord').value;$('irishWord').value=val+'ú'" class="small link">[ú]</span>
            </div>
--%>      

        </form>

      </div>
<%--      
    </div>

  </div>

  <div class="row">
    <div class="cell">
--%>      
      <div class="table" style="width:100%">
        <div class="row">
          <div class="cell light" style="font-size:12px;">
            Over 50,000 words translated and put to use!
          </div>
        </div>
        <div class="row">
          <div class="cell light red0" style="font-size:12px;">
            1,400 English verbs and 768 Irish verbs conjugated and translated!
          </div>
        </div>
      </div>

    <!--/div-->

  </div>

</div>

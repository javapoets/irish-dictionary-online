<%--
<div class="table blue" style="text-align:center;margin:auto;vertical-align:top;width:100%;height:100%;">
--%>
<div class="table blue0" style="text-align:right;margin:0px 0px 0px auto;vertical-align:middle;">
  <div class="row">
    <div class="cell red0">

      <div class="table blue0" style="width:100%">
        <div class="row">
          <div class="cell" style="padding:3px;">

            <form action="dictionary" method="post" name="word" style="margin:0px;text-align:right;" onsubmit="searchEnglishWord(this);return false;">
            <input type="hidden" name="languageId" value="1">
            <input type="hidden" name="language" value="english">
            <input type="hidden" name="fromLanguage" value="english">
            <input type="hidden" name="toLanguage" value="irish">
            <div style="text-align:right;">

              <div class="table blue0">
                <div class="row">
                  <div class="cell">

<%--
                    <div class="input"><input type="text" name="word" class="text" value="<%= wordEnglish %>" maxlength="200"></div>
                    <div class="input">
                      <input type="text" name="word" class="text" value="<%= wordEnglish %>" maxlength="200" onfocus="if(this.value=='English word(s)'){this.value='';this.style.color='#eee';}" onblur="if(this.value==''){this.value='English word(s)';this.style.color='#fff';}">
                    </div>
--%>
                    <div class="input">
<%--
                      <input type="text" name="word" class="text" value="<%= wordEnglish %>" maxlength="200">
                      <input type="text" name="word" class="text" value="<%= (wordEnglish != null ? wordEnglish : "English word(s)") %>" maxlength="200" onfocus="if(this.value=='English word(s)'){this.value='';this.style.color='#eee';}" onblur="if(this.value==''){this.value='English word(s)';this.style.color='#fff';}">
                      <input type="text" name="word" class="text" value="<%= (wordEnglish != null ? wordEnglish : "English word(s)") %>" maxlength="200" onfocus="if(this.value=='English word(s)'){this.value='';this.className='focus';}" onblur="if(this.value==''){this.value='English word(s)';this.className='blur';}">
--%>
                      <% if(wordEnglish != null) { %>
                      <input type="text" name="word" class="text" value="<%= wordEnglish %>" maxlength="200" onfocus="if(this.value=='English word(s)'){this.value='';this.className='focus';}" onblur="if(this.value==''){this.value='English word(s)';this.className='blur';}">
                      <script language="JavaScript">
                        document.word.word.focus();
                        document.word.word.select();
                      </script>
                      <% } else { %>
                      <input type="text" name="word" class="blur" value="English word(s)" maxlength="200" onfocus="if(this.value=='English word(s)'){this.value='';this.className='focus';}" onblur="if(this.value==''){this.value='English word(s)';this.className='blur';}">
                      <% } %>
                    </div>

                  </div>
                  <div class="cell yellow0" style="vertical-align:middle;margin:auto;padding-left:3px;">
<%--
                    <input type="submit" value="Go" class="orangebutton3">
--%>
                    <input type="button" value="go" class="orangebutton3" onclick="searchEnglishWord(this.form)" />
                  </div>
                </div>
              </div>
<%--
              <script language="JavaScript">
                document.word.word.focus();
                document.word.word.select();
              </script>
--%>
            </div>
            </form>

          </div>
          <div class="cell" style="padding:3px;">

            <form action="dictionary" method="post" name="irishWord" style="margin:0px;" onsubmit="searchIrishWord(this);return false;">
            <input type="hidden" name="languageId" value="2">
            <input type="hidden" name="language" value="irish">
            <input type="hidden" name="fromLanguage" value="irish">
            <input type="hidden" name="toLanguage" value="english">
            <div style="text-align:left;">
              <div class="table blue0">
                <div class="row">
                  <div class="cell">
                    <div class="input">
<%--
                      <input type="text" name="word" class="text" value="<%= wordIrish %>" maxlength="200">
                      <input type="text" name="word" class="text" value="<%= (wordIrish != null ? wordIrish : "Irish word(s)") %>" maxlength="200" onfocus="if(this.value=='Irish word(s)'){this.value='';this.className='focus';}" onblur="if(this.value==''){this.value='Irish word(s)';this.className='blur';}">
--%>
                      <% if(wordIrish != null) { %>
                      <input type="text" name="word" id="irishWord" class="text" value="<%= (wordIrish != null ? wordIrish : "Irish word(s)") %>" maxlength="200" onfocus="if(this.value=='Irish word(s)'){this.value='';this.className='focus';}" onblur="if(this.value==''){this.value='Irish word(s)';this.className='blur';}">
                      <% } else { %>
                      <input type="text" name="word" id="irishWord" class="blur" value="Irish word(s)" maxlength="200" onfocus="if(this.value=='Irish word(s)'){this.value='';this.className='focus';}" onblur="if(this.value==''){this.value='Irish word(s)';this.className='blur';}">
                      <% } %>
                    </div>
                  </div>
                  <div class="cell yellow0" style="vertical-align:middle;margin:auto;padding-left:3px;">
<%--
                    <input type="submit" value="Go" class="orangebutton3">
--%>
                    <input type="button" value="go" class="orangebutton3" onclick="searchIrishWord(this.form)" />
                  </div>
                </div>
              </div>
<%--
--%>
              <div class="light small bold red0" style="margin:0px;padding-left:10px;">
                Add a Fada:&nbsp;
                <span onclick="val=$('irishWord').value;$('irishWord').value=val+'á'" class="small link">[á]</span>
                <span onclick="val=$('irishWord').value;$('irishWord').value=val+'é'" class="small link">[é]</span>
                <span onclick="val=$('irishWord').value;$('irishWord').value=val+'í'" class="small link">[í]</span>
                <span onclick="val=$('irishWord').value;$('irishWord').value=val+'ó'" class="small link">[ó]</span>
                <span onclick="val=$('irishWord').value;$('irishWord').value=val+'ú'" class="small link">[ú]</span>
              </div>

            </div>
            </form>

          </div>
        </div>

      </div>
    </div>
  </div>

  <div class="row">
    <div class="cell red0">
      <div class="table blue0" style="width:100%">
        <div class="row">
          <div class="cell" style="padding:3px;">

            <form action="verb" method="post" name="verb" style="margin:0px;" onsubmit="searchEnglishVerb(this);return false;">
            <input type="hidden" name="rs" value="search">
            <input type="hidden" name="languageId" value="1">
            <input type="hidden" name="language" value="english">
            <input type="hidden" name="fromLanguage" value="english">
            <input type="hidden" name="toLanguage" value="irish">
            <div style="text-align:left;">
              <div class="table blue0">
                <div class="row">
                  <div class="cell">
                    <div class="input">
<%--
                      <input type="text" name="verb" class="text" value="<%= verbEnglish %>" maxlength="200">
                      <input type="text" name="verb" class="text" value="<%= (verbEnglish != null ? verbEnglish : "English verb") %>" maxlength="200" onfocus="if(this.value=='English verb'){this.value='';this.className='focus';}" onblur="if(this.value==''){this.value='English verb';this.className='blur';}">
--%>
                      <% if(verbEnglish != null) { %>
                      <input type="text" name="verb" class="text" value="<%= verbEnglish %>" maxlength="200" onfocus="if(this.value=='English verb'){this.value='';this.className='focus';}" onblur="if(this.value==''){this.value='English verb';this.className='blur';}">
                      <% } else { %>
                      <input type="text" name="verb" class="blur" value="English verb" maxlength="200" onfocus="if(this.value=='English verb'){this.value='';this.className='focus';}" onblur="if(this.value==''){this.value='English verb';this.className='blur';}">
                      <% } %>
                    </div>
                  </div>
                  <div class="cell yellow0" style="vertical-align:middle;margin:auto;padding-left:3px;">
<%--
                    <input type="submit" value="Go" class="orangebutton3">
--%>
                    <input type="button" value="go" class="orangebutton3" onclick="searchEnglishVerb(this.form)" />
                  </div>
                </div>
              </div>
            </div>
            </form>

          </div>
          <div class="cell" style="padding:3px;">

            <form action="verb" method="post" name="irishVerb" style="margin:0px;" onsubmit="searchIrishVerb(this);return false;">
            <input type="hidden" name="rs" value="search">
            <input type="hidden" name="languageId" value="2">
            <input type="hidden" name="language" value="irish">
            <input type="hidden" name="fromLanguage" value="irish">
            <input type="hidden" name="toLanguage" value="english">
            <div style="text-align:left;">
              <div class="table blue0">
                <div class="row">
                  <div class="cell">
                    <div class="input">
<%--
                      <input type="text" name="verb" class="text" value="<%= verbIrish %>" maxlength="200">
                      <input type="text" name="verb" class="text" value="<%= (verbIrish != null ? verbIrish : "Irish verb") %>" maxlength="200" onfocus="if(this.value=='Irish verb'){this.value='';this.className='focus';}" onblur="if(this.value==''){this.value='Irish verb';this.className='blur';}">
--%>
                      <% if(verbIrish != null) { %>
                      <input type="text" name="verb" id="irishVerb" class="text" value="<%= verbIrish %>" maxlength="200" onfocus="if(this.value=='Irish verb'){this.value='';this.className='focus';}" onblur="if(this.value==''){this.value='Irish verb';this.className='blur';}">
                      <% } else { %>
                      <input type="text" name="verb" id="irishVerb" class="blur" value="Irish verb" maxlength="200" onfocus="if(this.value=='Irish verb'){this.value='';this.className='focus';}" onblur="if(this.value==''){this.value='Irish verb';this.className='blur';}">
                      <% } %>
                    </div>
                  </div>
                  <div class="cell yellow0" style="vertical-align:middle;margin:auto;padding-left:3px;">
<%--
                    <input type="submit" value="Go" class="orangebutton3">
--%>
                    <input type="button" value="go" class="orangebutton3" onclick="searchIrishVerb(this.form)" />
                  </div>
                </div>
              </div>
              <div class="light small bold red0" style="margin:0px;padding-left:10px;">
                Add a Fada:&nbsp;
                <span onclick="val=$('irishVerb').value;$('irishVerb').value=val+'á'" class="small link">[á]</span>
                <span onclick="val=$('irishVerb').value;$('irishVerb').value=val+'é'" class="small link">[é]</span>
                <span onclick="val=$('irishVerb').value;$('irishVerb').value=val+'í'" class="small link">[í]</span>
                <span onclick="val=$('irishVerb').value;$('irishVerb').value=val+'ó'" class="small link">[ó]</span>
                <span onclick="val=$('irishVerb').value;$('irishVerb').value=val+'ú'" class="small link">[ú]</span>
              </div>

            </div>
            </form>

          </div>
        </div>

      </div>
    </div>
  </div>

</div>

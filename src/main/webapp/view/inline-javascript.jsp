function searchEnglishWord(form){
    console.trace('searchEnglishWord('+form+')');
    var wordElement = form.elements['word'];
    console.debug('wordElement = '+wordElement);
    console.debug('wordElement.value = '+wordElement.value);
    var url=[
      '<%= contextUrl %>'
      ,'dictionary'
      ,'?language=english'
      ,'&toLanguage=irish'
      ,'&word=',wordElement.value
    ].join('');
    console.debug(url);
    window.location=url;
}

function searchIrishWord(form){
    console.trace('searchIrishWord('+form+')');
    var wordElement = form.elements['word'];
    console.debug('wordElement = '+wordElement);
    console.debug('wordElement.value = '+wordElement.value);
    var url=[
      '<%= contextUrl %>'
      ,'dictionary'
      ,'?language=irish'
      ,'&toLanguage=english'
      ,'&word=',wordElement.value
    ].join('');
    console.debug(url);
    window.location=url;
}

function searchEnglishVerb(form){
    console.trace('searchEnglishVerb('+form+')');
    var verbElement=form.elements['verb'];
    console.debug('verbElement = '+verbElement);
    console.debug('verbElement.value = '+verbElement.value);
    var url=[
      '<%= contextUrl %>'
      ,'verb'
      ,'?language=english'
      ,'&toLanguage=irish'
      ,'&verb=',verbElement.value
    ].join('');
    console.debug(url);
    window.location=url;
}

function searchIrishVerb(form){
    console.trace('searchIrishVerb('+form+')');
    var verbElement=form.elements['verb'];
    console.debug('verbElement = '+verbElement);
    console.debug('verbElement.value = '+verbElement.value);
    var url=[
      '<%= contextUrl %>'
      ,'verb'
      ,'?language=irish'
      ,'&toLanguage=english'
      ,'&verb=',verbElement.value
    ].join('');
    console.trace(url);
    window.location=url;
}

<%--
window.startAds = function() {
    console.log('window.startAds()');
    console.log('window.adsbygoogle = ' + window.adsbygoogle);
    (adsbygoogle = window.adsbygoogle || []).push({});
}
console.log('window = ' + window);
console.log('document = ' + document);
window.onload = function() {
    console.log('window.onload()');
    //window.startAds();
    window.setTimeout(window.startAds, 1000);
}
--%>

function selectLanguage(selectElement) {
    console.log('selectLanguage('+selectElement+')');
    console.log('selectElement.selectedIndex = ' + selectElement.selectedIndex);
    console.log('selectElement.options[selectElement.selectedIndex].value = ' + selectElement.options[selectElement.selectedIndex].value);
    var value = selectElement.options[selectElement.selectedIndex].value;
    let LANG = "lang";
    let LANG_EQUALS = "lang=";
    console.log('value = ' + value);
    let windowLocation = window.location.href;
    console.log('windowLocation = ' + windowLocation);
    console.log('typeof windowLocation = ' + typeof windowLocation);
    //let containsLang = windowLocation.includes(LANG_EQUALS);
    let containsLang = windowLocation.indexOf(LANG_EQUALS) != -1;
    console.log('containsLang = ' + containsLang);
    if (containsLang) {
        var href = new URL(windowLocation);
        href.searchParams.set(LANG, value);
        console.log(href.toString());
        window.location = href.toString();
    } else {
        window.location = windowLocation + (windowLocation.includes('?') ? '&' : '?') + LANG_EQUALS + value;
    }
}

function clickAcceptCookies() {
    console.log('clickAcceptCookies()');

    let xhr = new XMLHttpRequest();
    xhr.onload = function() {
      if (xhr.status != 200) { // analyze HTTP status of the response
        alert(`Error ${xhr.status}: ${xhr.statusText}`); // e.g. 404: Not Found
      } else { // show the result
        alert(`Done, got ${xhr.response.length} bytes`); // response is the server response
      }
    };
    //xhr.open(method, URL, [async, user, password])
    xhr.open('GET', '/cookie?accept=true')
    xhr.send()
    var cookiePopupElement = document.getElementById('cookie-popup');
    cookiePopupElement.style.display = 'none';
}
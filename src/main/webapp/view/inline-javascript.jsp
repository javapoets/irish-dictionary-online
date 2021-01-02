function searchEnglishWord(form){
  console.trace('searchEnglishWord('+form+')');
  var wordElement = form.elements['word'];
  console.debug('wordElement = '+wordElement);
  console.debug('wordElement.value = '+wordElement.value);
  var url=[
    '<%= contextUrl %>'
    ,'dictionary'
    ,'?language=english'
    //,'&fromLanguage=english'
    ,'&toLanguage=irish'
    //,'?languageId=',1
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
    //,'&fromLanguage=irish'
    ,'&toLanguage=english'
    //,'?languageId=',2
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
    //,'&fromLanguage=english'
    ,'&toLanguage=irish'
    //,'?languageId=',1
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
    //,'&fromLanguage=irish'
    ,'&toLanguage=english'
    //,'?languageId=',2
    ,'&verb=',verbElement.value
  ].join('');
  console.trace(url);
  window.location=url;
}

window.startAds = function() {
    console.log('window.startAds()');
    console.log('window.adsbygoogle = ' + window.adsbygoogle);
    console.log('window.adsbygoogle.push = ' + window.adsbygoogle.push);
    (adsbygoogle = window.adsbygoogle || []).push({});
}

console.log('window = ' + window);
console.log('document = ' + document);
window.onload = function() {
  console.log('window.onload()');
  //window.startAds();
  window.setTimeout(window.startAds, 1000);
}

function selectLanguage(selectElement) {
  console.log('selectLanguage('+selectElement+')');
  console.log('selectElement.selectedIndex = ' + selectElement.selectedIndex);
  console.log('selectElement.options[selectElement.selectedIndex].value = ' + selectElement.options[selectElement.selectedIndex].value);
  var value = selectElement.options[selectElement.selectedIndex].value;
  console.log('value = ' + value);
  window.location = '<%= contextUrl %>home?' + value;
}
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
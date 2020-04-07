<%@ include file="/view/imports.jsp" %>
<%@ include file="/view/variables.jsp" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/irishdictionary.tld" prefix="irishdictionary" %>
<%--@ taglib uri="<%= contextUrl %>/irishdictionary.tld" prefix="irishdictionary" --%>
<%--@ taglib prefix="spring" uri="/WEB-INF/spring.tld" --%>
<%@ taglib prefix="javapoets" tagdir="/WEB-INF/tags" %>

<!doctype html>

<html>
<head>

<title>Irish dictionary online, Irish gaelic dictionary, Irish Dictionary, Gaelic dictionary, translate Irish, Irish language dictionary.</title>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
<meta name="description" content="A premium online Irish Gaelic dictionary providing quick word searches, definitions and usage." />
<meta name="keywords" content="irish dictionary, irish dictionary online, gaelic dictionary, irish, gaelic, translate Irish, dictionary irish, dictionary, ireland dictionary, irish words, irish translation, translation, ireland" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="css" />

<script type="text/javascript">function $(x){return document.getElementById(x)}</script>

<script async src="http://pagead2.googlesyndication.com/pagead/js/adsbygoogle.js"></script>

<%--@ include file="google-analytics-async.html" --%>

<script type="text/javascript">

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

</script>

</head>
<body>

<%--
<div style="position:fixed;top:0;height:100px;border:0px solid;width:100%;">
  <div style="text-align:center;margin:auto auto 0px auto;width:100%;border:0px solid;vertical-align:bottom;">
    <div style="border:0px solid;vertical-align:bottom;">

      <div style="display:inline-table;border:0px solid;box-shadow:0px 3px 13px rgba(0,0,0,0.33);-moz-box-shadow:0px 3px 13px rgba(0,0,0,0.33);-webkit-box-shadow:0px 3px 13px rgba(0,0,0,0.33);">
        <%@ include file="/view/google-adsense.html" %>
      </div>

    </div>
  </div>
</div>


<div style="position:fixed;bottom:0;height:100px;border:0px solid;width:100%;">
  <div style="text-align:center;margin:auto auto 0px auto;width:100%;border:0px solid;vertical-align:bottom;padding-top:10px;">
    <div style="border:0px solid;vertical-align:bottom;">

      <div style="display:inline-table;border:0px solid;box-shadow:0px -3px 8px rgba(0,0,0,0.33);-moz-box-shadow:0px -3px 8px rgba(0,0,0,0.33);-webkit-box-shadow:0px -3px 8px rgba(0,0,0,0.33);">
        <%@ include file="/view/google-adsense.html" %>
      </div>

    </div>
  </div>
</div>
--%>

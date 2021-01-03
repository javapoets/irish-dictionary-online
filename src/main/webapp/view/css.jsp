/*
*
{
  border: red 1px solid;
}
*/

:root {
  --orange: #FF8F00;
  --gray: #8B9290;
  --medium-gray: #C0C5C4;
  --light-gray: #EDF0EE;
  --dark-green: #0E4F24;
  --medium-green: #4B8029;
  --dark-text: #322;
  --medium-text: #6B6D6B;
  /*
  --site-width: 1140px;
  --site-width: 1000px;
  --search-block-width: 400px;
  */
  --site-width: 900px;
  --max-search-block-width: 550px;
}

html
,body
{
  height:100%;
  background-color: #fff;
  margin: 0px;
  font-family: Arial;
}

.orange
{ 
  color: var(--orange);
}

div.table
{
  display: table;
  width: 100%;
  /*
  height: 100%;
  border: blue 1px solid;
  */
}

div.row
{
  display: table-row;
}

div.cell
{
  display: table-cell;
  /*
  border: red 1px solid;
  */
}

div.row.menu
{
  text-align: center;
}

div.row.menu
div.cell.menu
{
  /*
  padding-left: 13px;
  border: blue 1px solid;
  padding-top: 100px;
  padding: 10px 0px;;
  */
  padding: 10px 0px;
}

div.row.menu
div.cell.menu
> div
{
  /*
  padding-top: 8px;
  padding-bottom: 8px;
  */
  padding: 5px 0px;;
}

div.row.logo
{
  text-align: left;
}

div.row.logo
div.cell.logo
{
  padding-left: 13px;
  text-align: left;
  margin-left: 0px;
}

/*
body > div
{
  border: red 1px solid;
  max-width: var(--site-width);
  margin: auto;
  vertical-align: middle;
}
*/

/*
body > div > div.table > div.row > div.cell
{
  border: red 1px solid;
}
*/

.centering-container
{
  /*
  text-align: center;
  vertical-align: middle;
  margin: 0px;
  padding: 0px;
  height: 100%;
  border: red 1px solid;
  */
  max-width: var(--site-width);
  margin: auto;
  padding-top: 100px;
}

.centering-flex-container
{
  display: flex;
  align-items: center;
  justify-content: center;
  /*
  border: red 1px solid;
  */
  text-align: center;
  vertical-align: middle;
  margin: 0px;
  padding: 0px;
  height: 100%;
}

body div.flex-header
{
  margin: auto;
  display: flex;
  flex-direction: row;
  flex-wrap: wrap;
  flex-basis: 550px;
  /*
  align-items: stretch;
  align-items: flex-end;
  align-items: flex-start
  justify-content: space-between;
  justify-content: space-around;
  justify-content: center;
  justify-content: space-evenly;
  */
  align-items: center;
  justify-content: flex-start;
  /*
  border: green 1px solid;
  padding-top: 20px;
  */
  padding-bottom: 20px;
}

/*
body div.header > div
{
  align-items: center;
}
*/

body div.entry-form
{
  /*
  max-width: 428px;
  border: red 1px solid;
  */
  width: 100%;
  text-align: center;
  margin: auto;
}

body div.entry-form > div
{
  padding-top: 8px;
  padding-bottom: 8px;
}

body div.entry-form > div
,body div.entry-form > div.row > div.cell
{
  /*
  border: blue 1px solid;
  */
  padding: 5px;
}

.search-block
{
  display: inline-block;
  text-align: center;
  vertical-align: middle;
  /*
  margin: auto;
  margin-left: 0px;    
  border: blue 1px solid;
  */
  max-width: var(--max-search-block-width);
  width: 100%;
}

.logo-offset
{
  position: absolute;
  display: inline-block;
  top: 50%;
  left: 50%;
  margin: auto;
  margin-top: -250px;
  margin-left: -180px;
}

div.bottombox {
  width:100%;
  position:fixed;
  bottom:0;
  background:#fff;
<%--
  border-top-left-radius:3px;border-top-right-radius:3px;
  -moz-border-radius-topleft:3px;-moz-border-radius-topright:3px;
  box-shadow:0px -3px 5px rgba(0,0,0,0.33);
  -moz-box-shadow:0px -3px 5px rgba(0,0,0,0.33);
  -webkit-box-shadow:0px -3px 5px rgba(0,0,0,0.33);
--%>
  height:100px;
  z-index:1000;
}

div.bottomfooter {
  width:1000px;
  text-align:center;margin:0 auto 0 auto;
  overflow:visible;
}

input.orangebutton1 {
  color:#fff;
  cursor:pointer;
  border:0;
  font-size:13px;
  font-weight:bold;
  background: var(--orange);
<%--
  padding:1px 8px 2px 8px;
--%>
  border-radius:8px;-moz-border-radius:8px;-webkit-border-radius:8px;
  box-shadow:inset 0px -5px 10px 0px rgba(0,0,0,0.13),0 0 3px #999;
  -moz-box-shadow:inset 0px -5px 10px 0px rgba(0,0,0,0.13),0 0 3px #999;
  -webkit-box-shadow:inset 0px -5px 10px 0px rgba(0,0,0,0.13),0 0 3px #999;
}

input.orangebutton2 {
  color:#fff;
  cursor:pointer;
  border:0;
  font-size:18px;
  font-weight:bold;
  background:  var(--orange);
  border-radius:15px;-moz-border-radius:15px;-webkit-border-radius:15px;
  padding:3px 18px;
<%--
  box-shadow:inset 0px -15px 15px 0px rgba(0,0,0,0.2);
  -webkit-box-shadow:0 0 3px #999;
--%>
  box-shadow:inset 0px -10px 20px 0px rgba(0,0,0,0.13),0 0 3px #999;
  -moz-box-shadow:inset 0px -10px 20px 0px rgba(0,0,0,0.13),0 0 3px #999;
  -webkit-box-shadow:inset 0px -10px 20px 0px rgba(0,0,0,0.13),0 0 3px #999;
}

input.orangebutton3
{
  color:#fff;
  cursor:pointer;
  border:0;
  font-size:18px;
  font-weight:bold;
  background: var(--orange);
  border-radius:15px;
  /*
  padding:5px 15px;
  */
  padding:5px 15px;
  margin: 0px;

  text-transform: uppercase;
  /*
  box-shadow:inset 0px -10px 20px 0px rgba(0,0,0,0.13),0 0 3px #999;
  -moz-box-shadow:inset 0px -10px 20px 0px rgba(0,0,0,0.13),0 0 3px #999;
  -webkit-box-shadow:inset 0px -10px 20px 0px rgba(0,0,0,0.13),0 0 3px #999;
  */
}

span.small {
  font-size:10px;
}

span.link {
  text-decoration:none;
}

span.link:hover {
  text-decoration:underline;
  cursor:pointer;
}

.nowrap
{
  white-space:nowrap;
}

a.ad {
  text-decoration:none;
}

div.ad {
  border:#2C5A26 1px solid;
  border-radius:8px;-moz-border-radius:8px;-webkit-border-radius:8px;
  text-align:center;
  padding:3px 8px 3px 8px;
  font-family:arial;
<%--
  box-shadow:0 0 3px #999;
  -moz-box-shadow:0 0 3px #999;
  -webkit-box-shadow:0 0 3px #999;
--%>
}

div.ad:hover {
  background-color:#B4CD8F;
  box-shadow:0 0 3px #999;
  -moz-box-shadow:0 0 3px #999;
  -webkit-box-shadow:0 0 3px #999;
}

div.ad-top {
  display:inline-table;
  white-space:nowrap;
<%--
  font-size:13px;
  font-weight:bold;
--%>
  color:#6B6D6B;
  color:#295921;
}

div.ad-bottom {
  color:#FF8F00;
  font-weight:normal;
<%--
  font-size:12px;
--%>
  font-size:13px;
}

div.input {
  background-color: #B4CD8F;
  border: #2C5A26 2px solid;
  border-radius: 25px;
  padding: 0px;
  margin: 0px;
  padding: 5px;
  /*
  display:inline-table;
  border: 0px;
  outline: #2C5A26 2px solid;
  margin-left:5px;
  margin-right:5px;
  padding:5px;
  box-shadow:inset 0px -10px 20px 0px rgba(0,0,0,0.13),0 0 3px #999;
  */
}

div.input div.table div.cell
{
  padding-left: 5px;
}

input.text {
<%--
  background-color:#B4CD8F;
--%>
  background-color:transparent;
  border:0px;
  outline:none;
  font-size:18px;
}

input.blur {
  color:#72945c;
  background-color:transparent;
  border:0px;
  outline:none;
  font-size:15px;
}

input.focus {
  color:#000;
  background-color:transparent;
  border:0px;
  outline:none;
  font-size:15px;
}
div.light {
  color:#B4CD8F;
  font-family:Arial;
}
div.small {
  font-size:10px;
}
div.bold {
  font-weight:bold;
}

div.definition
{
  /*
  padding-top: 20px;
  color: #6B6D6B;
  color: var(--darktext);
  */
  font-family: Arial;
}

div.definition .language-label
{
  /*
  font-weight: bold;
  line-height: 30px;
  margin-bottom: 0px;
  padding-bottom: 5px;
  margin-bottom: 5px;
  color: var(--lighttext);
  color: #aaa;
  vertical-align: bottom;
  vertical-align: bottom;
  border: red 1px solid;
  */
  display: inline-block;
  color: #999;
  line-height: 28px;
  text-transform: capitalize;
}

div.definition .language-label .capitalize
{
  text-transform: capitalize;
}

div.definition div.word-header
, div.usage div.word-header
{
  text-align: left;
  /*
  font-size: 20px;
  color: #6B6D6B;
  padding-left: 20px;
  padding-bottom: 20px;
  font-weight: bold;
  padding-top: 0px;
  padding-left: 0px;
  margin: auto;
  vertical-align: middle;
  */
  padding-bottom: 0px;
  vertical-align: bottom;
  margin: 0px;
  font-size: 18px;
}

div.definition div.word-header .word
{
  /*
  line-height: 30px;
  vertical-align: middle;
  border: red 1px solid;
  line-height: 20px;
  */
  display: inline-block;
  padding: 0px;
  padding-left: 10px;
  font-size: 33px;
  vertical-align: bottom;
  font-weight: normal;
  text-align: left;
  color: var(--darktext);
}

div.definition div.word-header .word-description
{
  color: #aaa;
  padding-left: 10px;
}

div.definition > div
{
  /*
  color: #6B6D6B;
  font-weight: bold;
  border: green 1x solid;
  text-align: left;
  */
  font-size: 19px;
  padding: 10px 20px 10px 40px;
}

div.definition div ol {
  /*
  color: #6B6D6B;
  font-size: 20px;
  font-weight: bold;
  border: black 1px solid;
  margin: 0px;
  padding-right: 20px;
  padding: 10px 20px 10px 20px;
  padding: 10px 20px 10px 40px;
  padding: 0px;
  padding-right: 20px;
  */
  text-align: left;
  margin-left: 0px;
  margin-top: 0px;
  margin-bottom: 0px;
}

div.definition li {
  list-style:none;
  /*
  padding-left: 30px;
  */
}

/*
div.definition div:first-child
{
  text-align:left;
  font-size:20px;
  border: red 1px solid;
  color:#6B6D6B;
  font-weight:bold;
  padding:8px;
}
*/

div.definition div:first-child a
{
  text-decoration:none;
  /*
  color:#6B6D6B;
  */
}

div.definition div:first-child a:hover
{
  text-decoration:underline;
}

div.definition span.definition
{
  line-height: 25px;
  font-size: 19px;
}

div.definition span.definition a {
  /*
  color:#f7941d;
  color:#6B6D6B;
  */
  color: var(--darktext);
  text-decoration:none;
}

div.definition span.definition a:hover {
  /*
  color:#f7941d;
  color:#6B6D6B;
  */
  text-decoration:underline;
}

div.definition span.description a {
  /*
  color:#f7941d;
  color:#6B6D6B;
  */
  font-size:11px;
  text-decoration:none;
}

div.definition span.type {
  /*
  color:#f7941d;
  color:#6B6D6B;
  */
  font-size:11px;
  text-decoration:underline;
  padding-left:5px;
}

div.definition li span.type {
  color:#6B6D6B;
  font-size:12px;
  text-decoration:none;
  padding-left:5px;
}

div.definition span.description
{
  /*
  color:#f7941d;
  color:#6B6D6B;
  color: var(--darktext);
  color: var(--mediumtext);
  */
  color: #999;
  font-size:12px;
  padding-left:5px;
}
div.definition span.description .smaller
{
  font-size: 11px;
}

div.definition li span.description a
{
  /*
  color:#f7941d;
  color:#6B6D6B;
  font-size:11px;
  */
  text-decoration:none;
}

div.definition li span.description a:hover
{
  /*
  color:#f7941d;
  color:#6B6D6B;
  font-size:11px;
  */
  text-decoration:underline;
}

div.usage
{
  padding: 0px;
  text-align: left;
}

/*
div.usage ol
{
  padding: 0px;
  padding-left: 60px;
}
*/

div.usage li
{
<%--
  border-bottom:#ccc 1px dotted;
  border-bottom:#ccc 1px solid;
  border:#ddd 1px solid;
  border-width:0px 0px 1px 1px;
  margin-top:3px;
  border-bottom:#ddd 1px solid;
  padding-left: 50px;
  padding-left: 5px;
  padding: 7px 0px;
--%>
  border-bottom: #ccc 1px solid;
  list-style:none;
  padding-top: 7px;
  padding-bottom: 7px;
  padding-left: 50px;
}

<%--
div.usage li > div
{
  border-bottom: #ccc 1px solid;
}
--%>

<%--
--%>
div.usage li span.usage
{
  /*
  border-bottom: blue 1px solid;
  */
  padding-left: 5px;
  line-height: 25px;
  font-size: 19px;
}

div.usage li > div .usage-label
{
  /*
  margin-left: -33px;
  padding-left: 5px;
  padding-right: 5px;
  */
  color: #999;
  font-size: 13px;
}
 
/* 
*/
div.usage li > div .usage-label.english
{
  margin-left:-60px;
  margin-left: -50px;
  text-transform: capitalize;
}

div.usage li > div .usage-label.irish
{
  margin-left:-43px;
  margin-left: -33px;
  text-transform: capitalize;
}

div.usage li span.translated
{
  color: #2C5A26;
  font-style: italic;
  /*
  border-bottom: blue 1px solid;
  */
  width: 100%;
  padding-left: 5px;
  line-height: 25px;
  font-size: 19px;
}

div.usage li span.translated a {
  color:#2C5A26;
  font-weight:bold;
  font-weight:normal;
}

div.usage li a {
<%--
  color:#f7941d;
  color:#6B6D6B;
  font-size:13px;
--%>
  color: var(--darktext);
  text-decoration:none;
}

div.usage li a:hover {
  /*
  color:#f7941d;
  color:#6B6D6B;
  */
  text-decoration:underline;
}

ul {
  padding: 0;
  margin: 0;
  list-style-type: none;
  display: flex;
  flex-direction: column;
  flex-wrap: wrap;
  flex-flow: wrap column;
  /* Limit height to whatever you need
  height: 100vh;
  max-height: 500px;
  height: 100vh;
  */
}

ul li
{
  text-align: left;
}

<%--
  Verb
--%>
div.verb-conjugation div.table
{
  padding-bottom: 25px;
  /*
  */
  font-size: 19px;
}

div.verb-conjugation div.verb-tense-header
{
  /*
  list-style: none;
  font-family:arial;
  line-height: 33px;
  */
  text-align: left;
  border-bottom: #ccc 1px solid;
  color: #888;
  padding-left: 10px;
  font-size: 1.33em;
}

div.verb-conjugation div.verb-tense-header > div
{
  display: inline-block;
}

.verb-conjugation .usage-label
{
  color: #999;
  font-size: 12px;
  width: 1%;
  /*
  border: red 1px solid;
  */
  white-space: nowrap;
  text-align: right;
  text-transform: capitalize;
}

.uppercase
{
  text-transform: uppercase;
}

.verb-conjugation .usage
{
  line-height: 25px;
  /*
  border: blue 1px solid;
  */
  padding-left: 10px;
  text-align: left;
}

.verb-conjugation .usage-label.underline
,.verb-conjugation .translated.underline
{
  border-bottom: #ccc 1px solid;
}

.verb-conjugation .translated
{
  color: #2C5A26;
  font-style: italic;
  padding-left: 10px;
  line-height: 25px;
  text-align: left;
}

/*
.verb-conjugation .row:nth-child(2) .cell
  background: red;
*/
.verb-conjugation .row:nth-child(odd) .cell
{
  padding-bottom: 7px;
}

/*
.verb-conjugation div.row .cell:nth-child(2)
{
  background: green;
}
*/

.verb-conjugation .row:nth-child(even) .cell
{
  padding-top: 7px;
}

/*
.verb-conjugation .row:last-child .cell
{
  padding-top: 7px;
}
*/

<%--
  Verbs
--%>
.verbs-container
{
  column-gap: 2em;
  /*
  column-rule: 1px solid #eee;
  column-count: 2;
  column-width: 20em;
  */
  column-width: 120px;
}

.verbs-container > div
{
  text-align: left;
  font-size: 19px;
  white-space: nowrap;
  line-height: 22px;
}

.verbs-container > div > span
{
  color: #ccc;
  font-size: 12px;
}

.verbs-container > div a
, .definition a
{
  text-decoration: none;
  color: inherit;
}

.verbs-container > div a:hover
, .definition a:hover
{
  text-decoration: underline;
}

div.verbs-header
{
  /*
  list-style: none;
  font-family:arial;
  line-height: 33px;
  */
  text-align: left;
  border-bottom: #ccc 1px solid;
  color: #888;
  padding-left: 10px;
  font-size: 22px;
  line-height: 30px;
  text-transform: capitalize;
  margin-bottom: 8px;
}

div.table.copyright
{
  /*
  padding-top: 33px;
  border: green 1px solid;
  */
  padding: 33px 0px;
  margin: auto;
  text-align: center;
}

.copyright {
  /*
  font-family: Verdana, Arial, Helvetica, sans-serif;
  border: blue 1px solid;
  */
  font-size: 14px;
  color: var(--darktext);
  text-decoration: none;
  padding: 4px 0px;
}

div.table.copyright
div.cell.copyright
a
{
  /*
  color: var(--darktext);
  font-size: 15px;
  */
  color: var(--dark-green);
  text-decoration: none;
}

div.table.copyright
div.row.terms
div.cell.terms
{
  /*
  color: var(--darktext);
  */
  font-size: 15px;
}

div.table.copyright
div.row.terms
a
{
  /*
  color: var(--darktext);
  */
  font-size: 14px;
  color: var(--dark-green);
  text-decoration: none;
}

div.table.copyright
div.cell.copyright
a:hover
{
  text-decoration: underline;
}

<%@ include file="/view/css-media-queries.jsp" %>

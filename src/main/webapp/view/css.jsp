<%--
*
{
  /*
  margin: 0;
  padding: 0;
  box-sizing: border-box;
  */
  border: black 1px solid;
}

ol
{
  border: red 1px solid;
}
--%>

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
  --site-width: 911px;
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

div.row.logo div.cell.logo
{
  padding-left: 13px;
  text-align: left;
  margin-left: 0px;
  margin: 0px;
  vertical-align: bottom;
  /*
  background-color: red;
  */
  padding-top: 10px;
}

div.about
div.row.logo
div.cell.logo
{
  padding-left: 0px;
  text-align: center;
  margin: auto;
}

div.row.logo div.cell.logo a
{
  margin: 0px;
  vertical-align: bottom;
  /*
  border: red 1px solid;
  */
}

div.row.logo div.cell.logo a img
{
  margin: 0px;
  vertical-align: bottom;
  /*
  border: blue 1px solid;
  */
}

div.table.logo
div.row.name
div.cell.name
{
  padding: 8px;
  text-align: center;
  margin: auto;
  font-size: 28px;
  font-weight: bold;
  /*
  text-transform: uppercase;
  font-family: Times, serif;
  */
  text-decoration:none;
  font-family: 'Averia Serif Libre', cursive;
}

div.table.logo
div.row.name
div.cell.name
a
{
  text-decoration: none;
  color: var(--dark-green);
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
  padding-top: 100px;
  border: red 1px solid;
  */
  max-width: var(--site-width);
  margin: auto;
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
  justify-content: space-evenly;
  justify-content: flex-start;
  */
  justify-content: center;
  align-items: center;
  /*
  border: green 1px solid;
  padding-top: 20px;
  padding-bottom: 20px;
  */
  padding: 10px;
}

body div.flex-header > div:first-child
{
  /*
  width: 200px;
  padding: 0px 42px;
  vertical-align: bottom;
  text-align: left;
  margin-left: 0px;
  */
}

body div.flex-header > div:first-child a
{
  /*
  border: red 1px solid;
  margin: 0px;
  text-align: left;
  margin-left: 0px;
  */
  vertical-align: bottom;
}

<%--
body div.flex-header > div:first-child a img
{
  border: blue 1px solid;
  margin: 0px;
  vertical-align: bottom;
  /*
  text-align: left;
  margin-left: 0px;
  */
}
--%>


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

div.input
{
  background-color: #B4CD8F;
  border: #2C5A26 2px solid;
  border-radius: 25px;
  padding: 0px;
  margin: 0px;
  padding: 5px;
}

<%--
.flex-header
  .search-block
    div.input
{
  padding: 3px;
  /*
  border: red 2px solid;
  */
}
--%>

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

<%--
div.input
{
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
--%>

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
  width: 100%;
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
  border: red 2px solid;
  font-size: 1.0em;
  */
  font-family: Arial;
}

<%--
div.definition > div
{
  /*
  color: #6B6D6B;
  font-weight: bold;
  text-align: left;
  padding: 10px 20px 10px 40px;
  */
  border: green 1px solid;
  font-size: 19px;
}
--%>

div.definition div.word-header
{
  /*
  border: blue 2px solid;
  */
}

<%--
div.definition div.word-header .word
{
  /*
  line-height: 30px;
  vertical-align: middle;
  border: red 1px solid;
  line-height: 20px;
  padding: 0px;
  padding-left: 10px;
  */
  padding: 8px;
  display: inline-block;
  font-size: 33px;
  vertical-align: bottom;
  font-weight: normal;
  text-align: left;
  color: var(--darktext);
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
  font-size: 18px;
  */
  padding-bottom: 0px;
  vertical-align: bottom;
  margin: 0px;
}
--%>

div.definition ol div.word-line
{
  /*
  border: orange 2px solid;
  */
  color: var(--darktext);
}

<%--
/*
  background: #ff9999;
  padding: 20px;
}
div.definition > ol
*/
div.definition > ol
{
  margin-bottom: 0px;
  margin-top: 10px;
--%>
div.definition > ol
{
  /*
  border: green 1px solid;
  margin-top: 0px;
  margin-bottom: 10px;
  */
}

div.definition > ol ol
{
  <%--
  padding-top: 8px;
  padding-left: 20px;
  padding-bottom: 20px;
  padding-top: 0px;
  margin-top: 0px;
  padding-top: 6px;
  margin-top: 6px;
  padding-bottom: 0px;
  margin-bottom 0px;
  --%>
  margin-top: 6px;
  margin-bottom: 10px;
}

div.definition > ol > li
{
  color: #999;
  /*
  font-size: 0.77em;
  font-size: 1.0em;
  font-size: 0.9em;
  font-size: 1.0em;
  list-style-type: none;
  */
  margin-top: 10px;
  margin-bottom: 10px;
}

div.definition.verb-conjugation > ol > li
{
  list-style-type: none;
}

<%--
--%>
div.definition ol ol li:before
{
  font-size: 0.77em;
  border: black 1px solid;
}

<%--
div.definition ol div.word-line .numbering
, div.definition ol li:before
--%>
div.definition ol li span
{
  /*
  border: black 2px solid;
  color:#6B6D6B;
  color: var(--darktext);
  color:red;
  font-size: 1.5em;
  */
  color: #333;
}

div.definition ol div.word-line .word
{
  /*
  border: red 1px solid;
  */
  font-size: 1.23em;
  line-height: 30px;
}

div.definition ol ol li .word
{
  border: black 2px solid;
  /*
  font-size: 1.0em;
  */
  font-size: 1.23em;
}


div.definition div.word-header div.word-line .type
{
  /*
  color:#f7941d;
  color:#6B6D6B;
  font-size: 15px;
  text-decoration: underline;
  padding-left: 5px;
  border: black 2px solid;
  */
  text-decoration:none;
  padding-left:5px;
  color: var(--dark-green);
  font-style: italic;
  font-size: 1.0em;
}

div.definition div.word-header ol {
  /*
  color: #6B6D6B;
  font-size: 20px;
  font-weight: bold;
  margin: 0px;
  padding-right: 20px;
  padding: 10px 20px 10px 20px;
  padding: 10px 20px 10px 40px;
  padding: 0px;
  padding-right: 20px;
  margin-top: 0px;
  margin-bottom: 0px;
  text-align: left;
  margin-left: 0px;
  border: black 1px solid;
  */
}

/*
div.definition .language-label
*/
.language-label
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
  border: red 1px solid;
  text-transform: capitalize;
  */
  font-size: 1.33em;
  display: inline-block;
  color: #999;
  line-height: 28px;
  padding: 8px;
}

div.definition .language-label .capitalize
{
  text-transform: capitalize;
}

div.definition div.word-header .word-description
{
  color: #aaa;
  padding-left: 10px;
}

<%--
div.definition li {
  list-style:none;
  /*
  padding-left: 30px;
  */
}
--%>

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

div.definition > ol > li > span.definition
{
<%--
  line-height: 25px;
  font-size: 19px;
  line-height: 25px;
  padding: 5px;
  margin: 5px;
  font-size: 0.9em;
--%>
  line-height: 24px;
  padding-left: 5px;
}

div.definition > ol ol > li
{
  /*
  border: green 1px solid;
  */
  line-height: 24px;
  font-size: 0.8em;
}

<%--
  font-size: 0.9em;
--%>
div.definition > ol ol > li span.definition
{
  /*
  border: red 1px solid;
  */
  font-size: 1.33em;
  vertical-align: bottom;
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

div.definition li span.type {
  color:#6B6D6B;
  /*
  font-size:12px;
  border: blue 1px solid;
  */
  text-decoration: none;
  padding-left: 5px;
  color: var(--dark-green);
  font-style: italic;
  font-size: .9em;
  line-height: 24px;
}

/*
div.verb-conjugation li span.type {
  border: green 1px solid;
  border: 0px;
}
*/

div.definition span.description
{
  /*
  color:#f7941d;
  color:#6B6D6B;
  color: var(--darktext);
  color: var(--mediumtext);
  color: #999;
  font-size:15px;
  */
  color:#6B6D6B;
  font-size: 0.9em;
  padding-left:5px;
}

<%--
div.definition span.description .smaller
{
  font-size: 11px;
}
--%>

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
  font-size: 19px;
  */
  padding-left: 5px;
  line-height: 25px;
}

div.usage li > div .usage-label
{
  /*
  margin-left: -33px;
  padding-left: 5px;
  padding-right: 5px;
  */
  border: blue 1px solid;
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
  font-size: 19px;
  line-height: 25px;
  */
  width: 100%;
  padding-left: 5px;
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

<%--
ol {
    counter-reset: item;
    padding-left: 10px;
}
--%>

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

<%--
div.verb-conjugation div.table
{
  /*
  padding-bottom: 25px;
  */
  font-size: 19px;
}
--%>

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
  padding: 8px;
  padding-left: 10px;
  font-size: 1.22em;
  text-transform: capitalize;
}

div.verb-conjugation div.verb-tense-header > div
{
  display: inline-block;
}

<%--
.verb-conjugation .usage-label
--%>
.usage-container .usage-label
{
  color: #999;
  font-size: 12px;
  width: 1%;
  /*
  border: red 1px solid;
  */
  padding-right: 5px;
  white-space: nowrap;
  text-align: right;
  text-transform: capitalize;
}

.uppercase
{
  text-transform: uppercase;
}

<%--
.verb-conjugation .usage
--%>
.usage-container .usage
{
  line-height: 25px;
  /*
  border: blue 1px solid;
  padding-left: 10px;
  */
  text-align: left;
  padding-left: 5px;
}

<%--
.verb-conjugation .usage-label.underline
,.verb-conjugation .translated.underline
--%>
<%--
.usage-container .usage-label.underline
--%>
.usage-container .translated.underline
{
  border-bottom: #ccc 1px solid;
}

<%--
.verb-conjugation .translated
--%>
.usage-container .translated
{
  color: #2C5A26;
  font-style: italic;
  line-height: 25px;
  text-align: left;
  /*
  padding-left: 10px;
  */
  padding-left: 5px;
}

<%--
.verb-conjugation .row:nth-child(2) .cell
  background: red;
.verb-conjugation div.row .cell:nth-child(2)
{
  background: green;
}
.verb-conjugation .row:nth-child(odd) .cell
--%>
.usage-container .row:nth-child(even) .cell
{
  padding-bottom: 7px;
}


<%--
.verb-conjugation .row:nth-child(even) .cell
--%>
.usage-container .row:nth-child(odd) .cell
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
  /*
  font-size: 19px;
  */
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
  border-bottom: #ccc 1px solid;
  text-transform: capitalize;
  padding-left: 10px;
  color: #888;
  */
  text-align: left;
  font-size: 22px;
  line-height: 30px;
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

div.row.nav div.cell.nav
{
  padding: 8px;
  margin: auto;
  text-align: center;
  /*
  border: red 1px solid;
  */
}

div.row.nav div.cell.nav nav
{
  margin: auto;
  text-align: center;
  /*
  border: red 1px solid;
  */
}

nav a
, button
{
  background-color: #B4CD8F;
  background-color: var(--orange);
  background-color: #fff;
  border: #2C5A26 1px solid;
  border-radius: 15px;
  padding: 0px;
  margin: 0px;
  margin-left: 3px;
  margin-right: 3px;
  text-decoration: none;
  color: #2C5A26;
  padding: 5px 10px;
  white-space: nowrap;
  /*
  display:inline-table;
  border: 0px;
  outline: #2C5A26 2px solid;
  margin-left:5px;
  margin-right:5px;
  padding:5px;
  box-shadow:inset 0px -10px 20px 0px rgba(0,0,0,0.13),0 0 3px #999;
  */
  box-shadow:inset 0px -10px 20px 0px rgba(0,0,0,0.13),0 0 3px #999;
}

<%--
.tag-language
{
  /*
  background-color: green;
  background-color: lightgreen;
  color: #fff;
  border: var(--darkgreen) 1px solid;
  #B4CD8F
  font-family: verdana;
  font-size: .9em;
  */
  background-color: #B4CD8F;
  color: var(--dark-green);
  color: #fff;
  border-radius: 10px;
  padding: 1px 5px;
  line-height: 20px;
  font-weight: 600;
}
--%>

div.definition ol li span.type .tag
,.usage-container .usage-label .tag
{
  color: #fff;
  /*
  font-size: .9em;
  background-color: rgb(240, 240, 240);
  background-color: rgb(222, 222, 222);
  background-color: rgba(108, 108, 108, 0.33);
  background-color: #B4CD8F;
  background-color: #ccc;
  border: var(--dark-green) 1px solid;
  font-weight: bold;
  border: 0px;
  border-radius: 11px;
  border-radius: 12px/50%;
  padding: 2px 7px;
  */
  padding: 2px 8px;
  border-radius: 12px;
  color: #aaa;
  border: #B4CD8F 1px solid;
  line-height: 20px;
}

<%--
div.definition ol li span .tag-pronoun
{
  /*
  border: var(--dark-green) 1px solid;
  */
  background-color: #B4CD8F;
  color: #fff;
  border-radius: 10px;
  padding: 1px 5px;
  font-weight: bold;
}

div.definition ol li span .tag-tense
{
  /*
  border: var(--dark-green) 1px solid;
  */
  background-color: #B4CD8F;
  color: #fff;
  border-radius: 10px;
  padding: 1px 5px;
  font-weight: 600;
}

div.definition ol li span .tag-language
{
  color: #fff;
}
--%>

<%--  
div.contact-content
{
  border: red 1px solid;
}
--%>

div.contact-content > div
{
  background-color: #F5F5F5;
  padding: 33px;
  margin: 33px;
  border-radius: 3px;
  border: #e2e2e2 1px solid;
  <%--  
  border: blue 1px solid;
  --%>
}

<%--
div.contact-content > div > form
{
  font-size: 16px;
}
--%>

div.contact-content > div > form > div.input
{
  font-size: 16px;
  border: #d5d5d5 1px solid;
  border-radius: 0px;
  margin: 10px;
  padding: 5px 5px;
  background-color: #fff;
}

div.contact-content > div > form > div.input input
{
  width: 100%;
  padding: 0px;
  margin: 0px;
  border: 0px;
  font-size: 16px;
}

div.contact-content > div > form > div.input textarea
{
  width: 100%;
  padding: 0px;
  margin: 0px;
  border: 0px;
  font-size: 16px;
  resize: none;
  font-family: arial;
}

input:focus, textarea:focus, select:focus{
    outline: none;
}

<%--
div.contact-content > div > form button
--%>
div.contact-content > div > form input[type=submit]
{
  border: #d5d5d5 1px solid;
  background-color: #e2e2e2;
  color: #2d2d2d;
  padding: 5px 25px;
  font-weight: bold;
  font-size: 18px;
  font-family: arial;
}

<%@ include file="/view/css-media-queries.jsp" %>

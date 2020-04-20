:root {
  --orange: #FF8F00;
  --gray: #8B9290;
  --mediumgray: #C0C5C4;
  --lightgray: #EDF0EE;
  --darkgreen: #0E4F24;
  --mediumgreen: #4B8029;
  --darktext: #322;
  --mediumtext: #6B6D6B;
  --sitewidth: 900px;
}

.orange
{ 
  color: var(--orange);
}

div.table
{
  display: table;
  width: 100%;
}

div.row
{
  display: table-row;
}

div.cell
{
  display: table-cell;
}

html
,body
{
  height:100%;
  background-color: #fff;
  margin: 0px;
}

.container {
  display: flex;
  align-items: center;
  justify-content: center;
}

body div.header
{

  /*
  position: fixed;
  width: 100%;
  top: 0px;
  z-index: 5;
  */

  /*
  padding: 1px 0px;
  padding: 8px 0px 3px;
  padding: 1px 0px;
  padding: 5px 0px;
  */
  padding-top: 20px;
  padding-bottom: 20px;

  /*
  text-align: center;
  */
  margin: auto;

  /*
  box-shadow: 0px 11px 8px -10px #ccc;
  box-shadow: 0px 3px 3px 0px rgba(0, 0, 0, .13);
  */

  display: flex;
  flex-direction: row;
  flex-wrap: wrap;
  flex-basis: 450px;

  /*
  align-items: stretch;
  align-items: flex-end;
  align-items: flex-start
  */
  align-items: center;

  /*
  justify-content: space-between;
  justify-content: space-around;
  justify-content: center;
  max-width: var(--sitewidth);  
  justify-content: space-evenly;
  */
  justify-content: flex-start;
}

/*
body div.header > div
{
  align-items: center;
}
*/

body div.entry-form
{
  max-width: 428px;
  text-align: center;
  margin: auto;
}

/*
*/
body div.entry-form > div
{
  /*border: red 1px solid;*/
  padding: 10px;
}

@media (max-width: 670px) {

  body div.header
  {
    /*
    justify-content: flex-start;
    */
    justify-content: center;
  }

  body div.entry-form > div
  {
    padding-left: 5px;
    padding-right: 5px;
  }

}

@media (min-width: 670px) {
  body div.entry-form > div
  {
    /*
    padding: 8px;
    border: red 1px solid;
    */
  }
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

@media (max-width: 500px) {
  .logo-offset
  {
    margin-left: -95px;
  }
  .entry-form
  {
    padding-left: 20px;
    padding-right: 20px;
  }
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
  display:inline-table;
  border: #2C5A26 2px solid;
  border-radius: 20px;
  padding: 0px;
  margin: 0px;
  padding:5px;
  /*
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
  color: #6B6D6B;
  color: var(--darktext);
  font-family: Arial;
  /*
  padding-top: 20px;
  */
}

div.definition .language-label
{
  text-transform: capitalize;
  font-weight: bold;
}

div.definition div.word-header
{
  text-align: left;
  font-size: 20px;
  /*
  color: #6B6D6B;
  */
  font-weight: bold;
  padding-left: 20px;
  padding-top: 0px;
  padding-bottom: 20px;
}

div.definition div.word-header .word
{
  text-align: left;
  color: var(--darktext);
  font-size: 22px;
  /*
  */
  font-weight: normal;
}

div.definition > div
{
  text-align: left;
  font-size: 20px;
  /*
  color: #6B6D6B;
  font-weight: bold;
  border: green 1x solid;
  */
}

div.definition div ol {
  /*
  text-align: left;
  color: #6B6D6B;
  font-size: 20px;
  font-weight: bold;
  border: black 1px solid;
  */
  /*
  padding: 0px;
  margin: 0px;
  padding-right: 20px;
  padding: 10px 20px 10px 20px;
  margin-bottom: 0px;
  */
  margin-top: 0px;
  /*
  padding: 10px 20px 10px 40px;
  */
  padding-right: 20px;
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

div.definition li {
  list-style:none;
}

div.definition li span.type {
  color:#f7941d;
  color:#6B6D6B;
  font-size:11px;
  text-decoration:none;
  padding-left:5px;
}

div.definition li span.description
{
  /*
  color:#f7941d;
  color:#6B6D6B;
  color: var(--darktext);
  */
  color: var(--mediumtext);

  font-size:15px;
  padding-left:5px;
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
  padding:0px;
}

div.usage li span.translated
{
  color:#2C5A26;
  font-style: italic;
}

div.usage li span.translated a {
  color:#2C5A26;
  font-weight:bold;
  font-weight:normal;
}

div.usage li
{
  list-style:none;
<%--
  border-bottom:#ccc 1px dotted;
  border-bottom:#ccc 1px solid;
  border:#ddd 1px solid;
  border-width:0px 0px 1px 1px;
  margin-top:3px;
  border-bottom:#ddd 1px solid;
--%>
  border-bottom: #ccc 1px solid;
  padding: 5px 0px;
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

body {
  margin:0px;
  background-color:#fff;
}
div.grey { background-color:grey; }
div.red { border:red 1px solid; }
div.blue { border:blue 1px solid; }
div.yellow { border:yellow 1px solid; }
div.table {display:table}
div.row {display:table-row}
div.cell {display:table-cell}
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
  background:#FF8F00;
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
  background:#FF8F00;
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
input.orangebutton3 {
  color:#fff;
  cursor:pointer;
  border:0;
  font-size:15px;
  font-weight:bold;
  background:#FF8F00;
  border-radius:15px;-moz-border-radius:15px;-webkit-border-radius:15px;
  padding:3px 15px;
  box-shadow:inset 0px -10px 20px 0px rgba(0,0,0,0.13),0 0 3px #999;
  -moz-box-shadow:inset 0px -10px 20px 0px rgba(0,0,0,0.13),0 0 3px #999;
  -webkit-box-shadow:inset 0px -10px 20px 0px rgba(0,0,0,0.13),0 0 3px #999;
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
  background-color:#B4CD8F;
  display:inline-table;
  border:#2C5A26 1px solid;
  border-radius:15px;-moz-border-radius:15px;-webkit-border-radius:15px;
  padding:3px;
  box-shadow:inset 0px -10px 20px 0px rgba(0,0,0,0.13),0 0 3px #999;
}
input.text {
<%--
  background-color:#B4CD8F;
--%>
  background-color:transparent;
  border:0px;
  outline:none;
  font-size:15px;
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

div.definition {
  color:#6B6D6B;
  font-family:Arial;
}
div.definition div.header {
  text-align:left;
  color:#6B6D6B;
  font-size:20px;
  font-weight:bold;
  padding:8px;
}
div.definition div.header a {
  text-decoration:none;
  color:#6B6D6B;
}
div.definition div.header a:hover {
  text-decoration:underline;
}
div.definition span.definition a {
  color:#f7941d;
  color:#6B6D6B;
  text-decoration:none;
}
div.definition span.definition a:hover {
  color:#f7941d;
  color:#6B6D6B;
  text-decoration:underline;
}
div.definition span.description a {
  color:#f7941d;
  color:#6B6D6B;
  font-size:11px;
  text-decoration:none;
}
div.definition span.type {
  color:#f7941d;
  color:#6B6D6B;
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
div.definition li span.description {
  color:#f7941d;
  color:#6B6D6B;
  font-size:11px;
  text-decoration:none;
  padding-left:5px;
}
div.definition li span.description a {
  color:#f7941d;
  color:#6B6D6B;
  font-size:11px;
  text-decoration:none;
}
div.definition li span.description a:hover {
  color:#f7941d;
  color:#6B6D6B;
  font-size:11px;
  text-decoration:underline;
}
div.usage {
  padding:0px;
}

div.usage li span.translated {
  color:#2C5A26;
}
div.usage li span.translated a {
  color:#2C5A26;
  font-weight:bold;
  font-weight:normal;
}
div.usage li {
  list-style:none;
<%--
  border-bottom:#ccc 1px dotted;
  border-bottom:#ccc 1px solid;
  border:#ddd 1px solid;
  border-width:0px 0px 1px 1px;
  margin-top:3px;
  border-bottom:#ddd 1px solid;
--%>
  border-bottom:#eee 1px solid;
  padding:3px;
}
div.usage li a:hover {
  list-style:none;
  color:#f7941d;
  color:#6B6D6B;
  text-decoration:underline;
}
div.usage li a {
  color:#f7941d;
  color:#6B6D6B;
<%--
  font-size:13px;
--%>
  text-decoration:none;
}

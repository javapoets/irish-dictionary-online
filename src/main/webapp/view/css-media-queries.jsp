<%--
@media (min-width: 670px)
{
  body div.entry-form > div
  {
    /*
    padding: 8px;
    border: green 1px solid;
    border: red 1px solid;
    */
  }
  /*
  .search-block
  {
    border: green 1px solid;
    width: 366px;
    width: var(--search-block-width);
  }
  */
}

@media (min-width: var(--search-block-width))
@media (min-width: 366px)
{
  .search-block
  {
    border: green 2px solid;
    width: 100%;
  }
}
--%>

@media (max-width: 500px)
{
  .logo-offset
  {
    margin-left: -95px;
  }
  /*
  .entry-form
  {
    padding-left: 20px;
    padding-right: 20px;
  }
  */
}

/*
#adsbygoogle-728x90 {
  display: inline-table;
  display: none;
  border: red 1px solid;
}

#adsbygoogle-360x90 {
  display: none;
}
*/

<%--
@media (min-width: 670px) {
--%>
@media (max-width: 575.98px) {

  #adsbygoogle-728x90 {
    display: none;
  }

  #adsbygoogle-360x90 {
    display: inline-table;
  }

  div.row.logo
  div.cell.logo
  {
    padding-left: 0px;
    text-align: center;
    margin: auto;
  }

  body div.entry-form > div
  {
    padding: 5px;
    /*
    border: red 1px solid;
    border: red 1px solid;
    */
  }

  div.contact-content > div
  {
    margin: 0px;
  }

  /*
  #adsbygoogle-728x90 {
    display: none;
    display: inline-table;
    border: red 1px solid;
  }
  #adsbygoogle-360x90 {
    display: inline-table;
    display: none;
    border: red 1px solid;
  }
  */

  div.input
  {
    /*
    background-color: red;
    */
    border: #2C5A26 2px solid;
    border-radius: 25px;
    padding: 0px;
    margin: 0px;
    padding: 4px;
  }

  /*
  .search-block
  {
    margin-left: 0px;    
  }
  div.verb-conjugation div.verb-tense-header
  {
    padding-left: 10px;
    font-size: 1.1em;
  }
  */
}

<%--
@media (max-width: 670px)
{
--%>
@media (min-width: 576px) {

  #adsbygoogle-728x90 {
    display: inline-table;
  }
  
  #adsbygoogle-360x90 {
    display: none;
  }

  body div.flex-header
  {
    /*
    justify-content: flex-start;
    */
    justify-content: center;
    justify-content: flex-start;
  }

  body div.flex-header > div:first-child
  {
    padding-right: 33px;
  }

  /*
  #adsbygoogle-728x90 {
    display: none;
  }

  #adsbygoogle-360x90 {
    display: inline-table;
    border: blue 1px solid;
  }
  */

  body div.row.logo
  {
    text-align: center;
  }
  div.row.logo
  div.cell.logo
  {
    padding-left: 0px;
  }
  body div.entry-form > div
  {
    padding-left: 5px;
    padding-right: 5px;
  }

  <%--
  div.verb-conjugation div.verb-tense-header
  {
    padding-left: 10px;
    font-size: 1.1em;
  }
  --%>

  <%--
  div.input
  {
    /*
    background-color: green;
    */
    border: #2C5A26 1px solid;
    border-radius: 25px;
    padding: 0px;
    margin: 0px;
    padding: 3px;
  }
  --%>

}
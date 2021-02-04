<h1><%= resourceBundles.getString("About Irish Dictionary Online") %></h1>
  <%--
  Data entry for teh Irish Thesaurus has been complete
  after the dot-com business went bust
  The project was inspired when I was looking for the word for wine. After returning from California where I had fallen in love with Napa Valley, I wanted to make wine from the wild berries of Ireland which I had done with my father many years previous.
  Since it was winter time and there were no berries on the trees I decided to create a label for the wine bottles and give it a name... the Irish word for wine, which I could not remember what it was even though I had been fluent in Irish after spending many summers in the Gaeltacts of Donegal.
  So that evening I bought the domain englishirishdictionary.com, emailed all the lists I found online, told them I was building a searchable database of irish terms, and if they would permit me to add their words to the database
  I spend the next 2 years typing words I found on the Internet into the database along with usage examples of thse words. Shortly after completing the dictionary I realized that understanding the tenses of the verbs was a big part of any language.
  <%= resourceBundles.getString("After completing the dictionary itself, I decided to conjugate all the Irish verbs in the dictionary into their various tenses and translate those to their English counterparts.") %>
  --%>
  <%--= resourceBundles.getString("The Irish Dictionary Online is a projecct by Diarmuid O'Dochartaigh as Dun na nGall.") --%>
<p>
  <%= resourceBundles.getString("Irish Dictionary Online is a project by") %>
  <a href="https://www.linkedin.com/in/dermotdoherty/">Diarmuid O'Dochartaigh</a>
  <%= resourceBundles.getString("from Carndonagh, Co. Donegal.") %>
</p>
<p style="font-style: italic;">
  <%= resourceBundles.getString("\"It started in 2001 when I was online looking for the Irish word for wine for a wine bottle label design I was working on and realized that there was no searchable database of Irish terms on the Internet at that time.") %>
  <%--= resourceBundles.getString("I went online and after an hour of looking around was surprised that there was no searchable database of Irish terms on the Internet at that time.") --%>
  <%= resourceBundles.getString("I did eventually find the word for wine 'fion' but spent the next 2 years researching and assembling a database of Irish words and their English translations along with real world use examples of those words.\"") %>
</p>
<p>
  <%= resourceBundles.getString("After the dictionary was completed and put online in 2003, 750 Irish verbs were conjugated into their various tenses and translated into English.") %>
</p>
<p>
  <%= resourceBundles.getString("In 2020 work was done to make the site usable on mobile phones, several new words and verbs were added and some typos fixed.") %>
  <%= resourceBundles.getString("The milestone of 800 Irish verbs was reached on January 25th 2021 and the output screens for both verbs and word definitions were updated and restyled for better readability.") %>
</p>
<h2><%= resourceBundles.getString("Upcoming Developments") %></h2>
<p>
  <ul>
    <li>
      <strong>Irish Thesaurus</strong>
      <br/><%= resourceBundles.getString("Work is underway to add an Irish Theaurus to this service based on the work of Seamus. The data entry has been completed and the next step is to add the ability to reference the thesaurus.") %>
    </li>
    <li style="padding-top: 10px;">
      <strong>Merging word and verb definitions</strong>
      <br/><%= resourceBundles.getString("Some words that currently appear solely within the verb output screen will appear on the word definition screen.") %>
    </li>
    <li style="padding-top: 10px;">
      <strong>Browse the dictionary</strong>
      <br/><%= resourceBundles.getString("The ability to browse the dictionary by letter of the aplhabet.") %>
    </li>
  </ul>
</p>
<h2><%= resourceBundles.getString("Open Source") %></h2>
<p>
  <%= resourceBundles.getString("The source code for this website and service in now open source and available on") %>
  <a href="https://github.com/javapoets/irish-dictionary-online">GitHub</a>.
</p>
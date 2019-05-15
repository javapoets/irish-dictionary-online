package online.irishdictionary.taglib;

import java.util.*;
import java.awt.*;

/**
 * 9ú Márta
 * 10ú; 17ú; 24ú Feabhra; 3ú; 10ú Márta
County Semi-Final 24ú Márta
County Final 31ú Márta
 * 9ú Meán Fómhair
 *
 * An Naoiu Aois Deag
 * chead Bhliain
 *
 * Cuirfear tús le sraith nua de imeachtaí an chlub Ghaeilge Sult ar an Déardaoin 28ú Meán Fómhair ag 9.00i.n. Beidh an chlub ar siúl gach dara Déardaoin as sin go dtí an 7ú Nollaig, agus arís ón 18ú Eanáir - 24ú Bealtaine 2001! Mar is gnáth, beidh sé ar siúl sa Castle Inn, Lord Edward Street, díreach trasna ó Árd Eaglais Chríost.

If you would like a chance to practice your Irish, or just enjoy some music and fun, Sult begins again on Thursday 28th September at 9.00pm, and will take place every second Thursday until 7th December. It will commence again after Christmas, and will run from 18th January - 24th May 2001 ! It takes place upstairs in the Castle Inn, Lord Edward Street, opposite Christ Church.


  Dates 2001
18ú Eanáir - 18th January
1ú Feabhra - 1st February
15ú Feabhra - 15th February
1ú Márta - 1st March
15ú Márta - 15th March
29ú Márta - 29th March
12ú Aibreán - 12th April
26ú Aibreán - 26th April
10ú Bealtaine - 10th May
24ú Bealtaine - 24th May

 */
public class IrishDate {

    private Calendar calendar = null;

    public IrishDate(Calendar calendar) {
        this.calendar = calendar;
    }
    
    public String getIrishDate() {

        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        String[] monthIrish = {"Eanáir", "Feabhra", "Márta", "Aibreán", "Bealtaine", "Meitheamh", "Iúil", "Lúnasa", "Meán Fómhair", "Deireadh Fómhair", "Samhain", "Nollaig"};
        String[] monthEnglish = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

        StringBuffer dateText = new StringBuffer();  // to hold the message body
        dateText.append("<i>");
        dateText.append(day);
        dateText.append("ú ");
        dateText.append(monthIrish[month]);
        dateText.append(" ");
        dateText.append(year);
        dateText.append("</i>");
        // dateText.append("<br>");
        // dateText.append("<i>" + day + "th " + monthEnglish[month] +  " " + year + "</i>");
        return dateText.toString();

    }

}

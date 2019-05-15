package online.irishdictionary.taglib;

import java.util.*;
import java.awt.*;

/**
 * 9� M�rta
 * 10�; 17�; 24� Feabhra; 3�; 10� M�rta
County Semi-Final 24� M�rta
County Final 31� M�rta
 * 9� Me�n F�mhair
 *
 * An Naoiu Aois Deag
 * chead Bhliain
 *
 * Cuirfear t�s le sraith nua de imeachta� an chlub Ghaeilge Sult ar an D�ardaoin 28� Me�n F�mhair ag 9.00i.n. Beidh an chlub ar si�l gach dara D�ardaoin as sin go dt� an 7� Nollaig, agus ar�s �n 18� Ean�ir - 24� Bealtaine 2001! Mar is gn�th, beidh s� ar si�l sa Castle Inn, Lord Edward Street, d�reach trasna � �rd Eaglais Chr�ost.

If you would like a chance to practice your Irish, or just enjoy some music and fun, Sult begins again on Thursday 28th September at 9.00pm, and will take place every second Thursday until 7th December. It will commence again after Christmas, and will run from 18th January - 24th May 2001 ! It takes place upstairs in the Castle Inn, Lord Edward Street, opposite Christ Church.


  Dates 2001
18� Ean�ir - 18th January
1� Feabhra - 1st February
15� Feabhra - 15th February
1� M�rta - 1st March
15� M�rta - 15th March
29� M�rta - 29th March
12� Aibre�n - 12th April
26� Aibre�n - 26th April
10� Bealtaine - 10th May
24� Bealtaine - 24th May

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
        String[] monthIrish = {"Ean�ir", "Feabhra", "M�rta", "Aibre�n", "Bealtaine", "Meitheamh", "I�il", "L�nasa", "Me�n F�mhair", "Deireadh F�mhair", "Samhain", "Nollaig"};
        String[] monthEnglish = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

        StringBuffer dateText = new StringBuffer();  // to hold the message body
        dateText.append("<i>");
        dateText.append(day);
        dateText.append("� ");
        dateText.append(monthIrish[month]);
        dateText.append(" ");
        dateText.append(year);
        dateText.append("</i>");
        // dateText.append("<br>");
        // dateText.append("<i>" + day + "th " + monthEnglish[month] +  " " + year + "</i>");
        return dateText.toString();

    }

}

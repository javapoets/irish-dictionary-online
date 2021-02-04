package online.irishdictionary.taglib;

import java.util.Calendar;

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

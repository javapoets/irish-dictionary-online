package online.irishdictionary.util;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Validator {

    public static Calendar entered = new GregorianCalendar();
    public static Calendar today = new GregorianCalendar();
    public static Calendar old = null;

    /**
     * This method compares a character agains a list of characters in a <i>list</i> string
     *
     *<b>Note:</b> during comparison both strings are converted to lowercase
     *
     * @param chr character to be evaluated
     * @param invalidChars string of valid characters (ie: "abc")
     * @return boolean true if the character is invalid or boolean false otherwise
     */
    public static boolean inValidChar(char chr, String invalidChars) {
        chr = Character.toLowerCase(chr);
        invalidChars = invalidChars.toLowerCase();

        if(invalidChars.indexOf(chr) > -1) return true;
        return false;
    }

    /**
     * This method compares a character agains a list of characters in a <i>list</i> string
     *
     *<b>Note:</b> during comparison both strings are converted to lowercase
     *
     * @param chr character to be evaluated
     * @param list String list of valid characters (ie: "abc")
     * @return boolean true if the character is valid or boolean false otherwise
     */
    public static boolean validChar(char chr, String list) {
        chr = Character.toLowerCase(chr);
        list = list.toLowerCase();

        if(list.indexOf(chr) > -1) return true;
        return false;
    }

}

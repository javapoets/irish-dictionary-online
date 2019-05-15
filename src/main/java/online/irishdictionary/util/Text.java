package online.irishdictionary.util;

import java.util.*;
import java.io.*;

import java.math.BigInteger;
import java.util.regex.Pattern;

public class Text {

    private static final String className   = Text.class.getName();

    private static final String SPACE               = " ";
    private static final String EMPTY               = "";
    private static final String COMMA               = ",";

    public static final int SECOND = 1000;
    public static final int MINUTE = SECOND * 60;
    public static final int HOUR = MINUTE * 60;
    public static final long DAY = HOUR * 24;
    public static final long WEEK = DAY * 7;

    /**
    *
    * Returns a new string resulting from replacing all occurrences of <code>charToReplace</code>
    * in this string with <code>replaceStr</code>.
    *
    * If the character <code>charToReplace</code> does not occur in this String object, then
    * a reference to this String object is returned.
    *
    * @param string the string containing string to be replaced
    * @param charToReplace the old character
    * @param replaceStr the new string
    *
    * @return a string derived from this string by replacing every occurrence of
    * <code>charToReplace</code> with <code>replaceStr</code>.
    */
    public static String replaceCharactersInString(String string, char charToReplace, String replaceStr) {

        if(string.indexOf(charToReplace) != -1) {
            if(string == null || replaceStr == null) return null;
                StringBuilder sb = new StringBuilder();
                for(int i = 0; i < string.length(); i++){
                    if(string.charAt(i) == charToReplace){
                    sb.append(replaceStr);
                } else {
                    sb.append(string.charAt(i));
                }
            }
            return sb.toString();
        }
        return string;
    }

    public static String replaceCharactersInString(String string, String invalidChars, String replaceStr) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < string.length(); i++) {
            if(Validator.validChar(string.charAt(i), invalidChars)){
                sb.append(replaceStr);
                //System.out.println("sb.append("+replaceStr+");");
            } else {
                sb.append(string.charAt(i));
                //System.out.println("sb.append("+string.charAt(i)+");");
            }
            //System.out.println("sb.toString() "+sb.toString());
        }
        return sb.toString();
    }

    /**
     * This method compares every character in <i>string</i> agains a list of characters in a <i>invalidChars</i> string
     * using <i>Validator.validChar</i> method and returns a boolean depending on whether the String contains invalid characters.
     *
     * <b>Note:</b> during comparison both strings are converted to lowercase
     *
     * @see com.javapoets.util.common.Validator
     *
     * @param string string of characters to be validated
     * @param invalidChars list of invalid characters (ie: "abc")
     * @return String with invalid characters stripped out
     */
    public static boolean containsInvalidChars(String string, String invalidChars){
        for(int i=0;i<string.length();i++){
            if(!Validator.validChar(string.charAt(i), invalidChars)){
                return true;
            }
        }
        return false;
    }

    /**
    *
    * Returns a digits-only string composed of digits in the <code>string</code>
    *
    * @param string the string to be processed
    *
    * @return String consisting of only digits found in the <code>string</code>,
    * null if none were found
    */
    public static String getDigitsFromString(String string) {
        if(string == null) return null;
        StringBuilder sb = new StringBuilder();
        int digit = -1;
        for(int i = 0; i < string.length(); i++){
            digit = Character.digit(string.charAt(i), 10);
            if(digit > -1 && digit < 10){
                sb.append(digit);
            }
        }
        if(sb.length() > 0) {
            return sb.toString();
        } else {
            return null;
        }
    }

}

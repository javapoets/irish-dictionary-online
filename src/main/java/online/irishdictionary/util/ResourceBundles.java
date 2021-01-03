package online.irishdictionary.util;

public class ResourceBundles {

    private static final org.apache.logging.log4j.Logger log = org.apache.logging.log4j.LogManager.getLogger();
    String lang = null;
    java.util.ResourceBundle resourceBundle = null;

    public ResourceBundles(String lang) {
        log.debug("('" + lang +"')");
        this.lang = lang;
        //this.resourceBundle = java.util.ResourceBundle.getBundle("irishdictionary", new java.util.Locale(lang));
        this.resourceBundle = java.util.ResourceBundle.getBundle("irishdictionary", new java.util.Locale(lang), new Utf8Control());
    }

    public String getString(String x) {
        log.debug("getString('" + x +"')");
        String s = null;
        try {
            s = this.resourceBundle.getString(x);
            //if(s != null) return s;
            return s;
        } catch(java.util.MissingResourceException e) {
            log.warn(".getString('"+x+"'): MISSING");
        }
        return x;
    }
}

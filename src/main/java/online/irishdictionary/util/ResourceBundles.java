package online.irishdictionary.util;

import java.util.ResourceBundle;

public class ResourceBundles {

    private static final org.apache.logging.log4j.Logger log = org.apache.logging.log4j.LogManager.getLogger();
    String lang = null;
    ResourceBundle resourceBundle = null;
    //private HashMap<String, ResourceBundle> resourceBundleMap;

    public ResourceBundles() {
        log.debug("()");
        //resourceBundleMap = new HashMap<String, ResourceBundle>();
    }

    public ResourceBundles(String lang) {
        log.debug("('" + lang +"')");
        this.lang = lang;
        //this.resourceBundle = java.util.ResourceBundle.getBundle("irishdictionary", new java.util.Locale(lang));
        this.resourceBundle = ResourceBundle.getBundle("irishdictionary", new java.util.Locale(lang), new Utf8Control());
    }

    public String getString(String x) {
        //log.trace("getString('" + x +"')");
        String s = null;
        try {
            s = this.resourceBundle.getString(x);
            //if(s != null) return s;
            return s;
        } catch(java.util.MissingResourceException e) {
            log.warn("getString('" + x + "'): Missing!");
        }
        return x;
    }

    /*
    public void setLang(String lang) {
        log.trace("setLang('"+lang+"')");
        this.lang = lang;
        this.resourceBundle = ResourceBundle.getBundle("irishdictionary", new java.util.Locale(lang), new Utf8Control());
        this.resourceBundleMap.put(lang, rb);
    }
    */
}

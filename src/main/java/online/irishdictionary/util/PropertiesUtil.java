package online.irishdictionary.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class PropertiesUtil {

    private static final String className = PropertiesUtil.class.getName();
    private static final Logger logger = LogManager.getLogger();

    public static String getProperty(String fileName, String propertyKey) {

        File file = new File(fileName);
        String propertyValue = null;
        Properties properties = new Properties();

        try {
            properties.load(new FileInputStream(file));
            propertyValue = properties.getProperty(propertyKey);
        } catch(FileNotFoundException e) {
            System.out.println(className+".getProperties(fileName, propertyKey): Cannot find property file: " + file.getAbsolutePath());
        } catch(IOException ioe) {
            System.out.println(className+".getProperties(fileName, propertyKey): Property '" + propertyKey + "' not found in " + fileName + " file.");
        }
        return propertyValue;
    }

    public static String getProperty(Properties properties, String propertyKey) {

        String propertyValue = null;

        try {
            propertyValue = properties.getProperty(propertyKey);
        } catch(Exception ioe) {
            System.out.println("Property '" + propertyKey + "' not found.");
        }
        return propertyValue;
    }

    public static Properties getProperties(String fileName) {
        return getProperties(new File(fileName));
    }

    public static Properties getProperties(File file) {
        try {
            return getProperties(new FileInputStream(file));
        } catch(FileNotFoundException e) {
            logger.debug("FileNotFoundException: getProperties(file): Cannot find property file: " + file.getAbsolutePath());
        }
        return null;
    }

    public static Properties getProperties(InputStream is) {

        Properties properties = new Properties();
        try { properties.load(is); } catch(IOException ioe) { return null; }
        return properties;

    }

    public static Set getKeySet(String fileName) throws IOException {
        File file = new File(fileName);
        return getKeySet(file);
    }

    public static Set getKeySet(File file) throws IOException {
        Properties p = new Properties();
        p.load(new FileInputStream(file));
        if(p != null) {
            return p.keySet();
        }
        return null;
    }

    public static Set getKeys(String fileName) {

        Properties properties = getProperties(fileName);
        return properties.keySet();

    }

    public static void savePropertiesToFile(String fileName, Properties properties) {
        try{
            File file = new File(fileName);
            FileOutputStream fos = new FileOutputStream(file);
            properties.store(fos, fileName);
            fos.close();
        } catch(IOException e) {
            System.err.println("unable to write to: "+fileName);
        }
    }

    public static void savePropertiesToFile(File file, Properties properties) throws IOException {

        FileOutputStream fos = new FileOutputStream(file);
        properties.store(fos, file.getName());
        fos.close();

    }

    public static void addFilePropertiesToProperties(Properties p, String fileName) {

        p.putAll(getProperties(fileName));
        /*
        try{
            File file = new File(fileName);
            FileInputStream fis = new FileInputStream(file);
            p.load(fis);
            fis.close();
        }catch(FileNotFoundException e){
            System.err.println("file "+fileName+" not found");
        }catch(IOException e){
            System.err.println("unable to read from: "+fileName);
        }
         */
    }

    /*
    public static void print(Properties p) {

        Iterator i = p.interator();
        while(i.hasNext()) {
     */

}


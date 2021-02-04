package online.irishdictionary.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

public class PropertiesUtil {

    private static final org.apache.logging.log4j.Logger log = org.apache.logging.log4j.LogManager.getLogger();

    public static String getProperty(String filePath, String propertyKey) {
        File file = new File(filePath);
        String propertyValue = null;
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(file));
            propertyValue = properties.getProperty(propertyKey);
        } catch (FileNotFoundException e) {
            log.debug("Cannot find property file: " + file.getAbsolutePath());
        } catch (IOException ioe) {
            log.debug("Property: " + propertyKey + " not found in: " + filePath);
        }
        return propertyValue;
    }

    public static String getProperty(Properties properties, String propertyKey) {
        String propertyValue = null;
        try {
            propertyValue = properties.getProperty(propertyKey);
        } catch (Exception e) {
            log.debug("Property: " + propertyKey + " not found.");
        }
        return propertyValue;
    }

    public static Properties getProperties(String filePath) {
        return getProperties(new File(filePath));
    }

    public static Properties getProperties(File file) {
        try {
            return getProperties(new FileInputStream(file));
        } catch (FileNotFoundException e) {
            log.debug("FileNotFoundException: getProperties(file): Cannot find property file: " + file.getAbsolutePath());
        }
        return null;
    }

    public static Properties getProperties(InputStream inputStream) {
        Properties properties = new Properties();
        try { properties.load(inputStream); } catch (IOException e) { return null; }
        return properties;
    }

    public static Set getKeySet(String filePath) throws IOException {
        File file = new File(filePath);
        return getKeySet(file);
    }

    public static Set getKeySet(File file) throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream(file));
        if (properties != null) {
            return properties.keySet();
        }
        return null;
    }

    public static Set getKeys(String fileName) {
        Properties properties = getProperties(fileName);
        return properties.keySet();

    }

    public static void savePropertiesToFile(String fileName, Properties properties) {
        try {
            File file = new File(fileName);
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            properties.store(fileOutputStream, fileName);
            fileOutputStream.close();
        } catch (IOException e) {
            System.err.println("unable to write to: " + fileName);
        }
    }

    public static void savePropertiesToFile(File file, Properties properties) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        properties.store(fileOutputStream, file.getName());
        fileOutputStream.close();
    }

    public static void addFilePropertiesToProperties(Properties properties, String filePath) {
        properties.putAll(getProperties(filePath));
    }
}


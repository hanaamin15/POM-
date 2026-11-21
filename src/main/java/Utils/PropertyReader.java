package Utils;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.util.Collection;
import java.util.Properties;

public class PropertyReader {

    //Load properties function to load all data from .properties file into system properties

    public static Properties loadProperties() {
        Properties properties;
        try {
            properties = new Properties();
            Collection<File> propertyFiles;
            propertyFiles = FileUtils.listFiles(new File("src/main/resources"), new String[]{"properties"}, true);
            propertyFiles.forEach(file -> {
                try {
                    properties.load(FileUtils.openInputStream(file));
                } catch (Exception e) {
                    System.out.println("Error loading properties file");
                }
            });
            properties.putAll(System.getProperties());
            System.getProperties().putAll(properties);

        } catch (Exception e) {
            System.out.println("Error loading properties file");
            return null;
        }
        return properties;
    }

    public static String getProperty(String key) {
        return System.getProperty(key);
    }
}
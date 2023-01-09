package com.lab4EE.Config;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    String propToReturn;
    String propFileName = "DBParams.properties";
    public String getPropValues(String property) {
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName)) {
            Properties prop = new Properties();
            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }
            propToReturn = prop.getProperty(property);
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
        return propToReturn;
    }
}
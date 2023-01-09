package com.example.lab3ee;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private final Properties properties = new Properties();

    ConfigReader() throws IOException {
            String filePath = "cookieAge.properties";
            try (InputStream out = getClass().getClassLoader().getResourceAsStream(filePath)) {
                properties.load(out);
            }

    }

    public String getProperty(String propertyName){
        return properties.getProperty(propertyName);
    }
}
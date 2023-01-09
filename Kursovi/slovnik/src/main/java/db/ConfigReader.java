package db;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private final Properties properties = new Properties();

    public ConfigReader() {
        String filePath = "db.properties";
        try (InputStream out = getClass().getClassLoader().getResourceAsStream(filePath)) {
            properties.load(out);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String getProperty(String propertyName){
        return properties.getProperty(propertyName);
    }
}

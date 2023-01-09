package Model.Config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {

    private final Properties properties = new Properties();

    public PropertiesReader() {
        String filePath = "db.prop";
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(filePath)) {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String getProperty(String propertyName){
        return properties.getProperty(propertyName);
    }
}

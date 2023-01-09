package Config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Reader {

    private final Properties properties = new Properties();

    public Reader() {
        String filePath = "DBParams.properties";
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

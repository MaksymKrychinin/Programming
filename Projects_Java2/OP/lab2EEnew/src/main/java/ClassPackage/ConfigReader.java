package ClassPackage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    int propToReturn;
    InputStream inputStream;

    public int getPropValues(String property) throws IOException {

        try {
            Properties prop = new Properties();
            String propFileName = "cookieAge.properties";
            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }
            propToReturn = Integer.parseInt(prop.getProperty(property));

        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            inputStream.close();
        }
        return propToReturn;
    }
}
package Properties;

import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
    private static Properties properties;

    public static Properties getProperties() {
        return properties;
    }
    public void setProperties(String name) {
        properties = new Properties();
        try {
            properties.load(PropertyReader.class.getClassLoader().getResourceAsStream(name + ".properties"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


package conn;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class MyProperties {

    private MyProperties() {
    }

    static Properties prop = new Properties();

    static {
        try (InputStream input = MyProperties.class.getClassLoader().getResourceAsStream("database.properties")) {
            prop.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String get(String key) {
        return prop.getProperty(key);
    }
}

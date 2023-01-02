package testMethods;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ArgumentsMvn {

    public void prop() throws IOException {
        System.out.println("Inside the Test");
        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("my.properties");
        Properties properties = new Properties();
        properties.load(inputStream);
        String device = properties.getProperty("app.device");
        String version = properties.getProperty("app.version");
        System.out.println(device+version);
    }
}

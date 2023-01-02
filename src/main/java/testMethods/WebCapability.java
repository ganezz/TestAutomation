package testMethods;

import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import static Sync.waitMethods.implicit;


public class WebCapability {
    public static Properties prop;
    public static WebDriver driver;

    public static void propInit() throws IOException {
        FileReader fr = new FileReader("src/webData.properties");
        prop = new Properties();
        prop.load(fr);
    }
    public static void cap() throws IOException {
        propInit();
        String browser = prop.getProperty("browser");
        if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", prop.getProperty("chromePath") );
            driver = new ChromeDriver();
            implicit();
        } else if (browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.firefox.driver", prop.getProperty("firefoxPath"));
            driver = new FirefoxDriver();
        } else {
            System.out.println("Browser Not Found");
        }

    }
    public static int count=0;
    @Given("Print the statement count of the Scenarios")
    public void print_the_statement_count_of_the_scenarios() {
        System.out.println("Number of Scenarios"+count++);
    }

}

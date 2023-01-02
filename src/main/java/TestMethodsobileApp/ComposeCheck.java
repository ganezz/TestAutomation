package TestMethodsobileApp;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;

import java.net.MalformedURLException;

import static Utilities.Android.explicit;

public class ComposeCheck {
    public static AndroidDriver driver;

    public static void main(String[] args) throws MalformedURLException {
        Capabilities.appConfig("nav");
        driver = Capabilities.Capability();
      //  driver.rotate(ScreenOrientation.LANDSCAPE);
        By mobile =  By.xpath("//android.view.View[@content-desc='Contact Details']/android.widget.EditText[1]");
        By email =  By.xpath("//android.view.View[@content-desc='Contact Details']/android.widget.EditText[2]");
        By login =  By.xpath("//android.view.View[@content-desc='Contact Details']/android.view.View[2]");
        By error = By.xpath("//android.view.View[@content-desc='Enter 10th Digit MObile Number']");
        By otp =  By.xpath("//android.widget.EditText");
        explicit(mobile,5);

        System.out.println("Element is there");
       driver.findElement(mobile).sendKeys("8465465465");
       driver.findElement(email).sendKeys("email@234.com");
       driver.findElement(login).click();
     //  System.out.println(driver.findElement(error).getText());
       driver.findElement(otp).sendKeys("1234");
    }

}

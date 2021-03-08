package TestMethods;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class Capabilities {
    public static String appPackage;
    public static String appActivity;
    public static AndroidDriver<AndroidElement> Capability() throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability(MobileCapabilityType.DEVICE_NAME,"emulator-5554");
        dc.setCapability("platformName","android");
        dc.setCapability("appPackage",appPackage);
        dc.setCapability("appActivity",appActivity);
        AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),dc);
        return driver;
    }
    public static void appConfig(String appName){
        if(appName.equals("yahoo")){
            appPackage="com.yahoo.mobile.client.android.mail";
            appActivity = ".activity.MainActivity";
        }
        else if (appName.contains("APIdemo")){
            appPackage="com.example.android.apis";
            appActivity = ".ApiDemos";
        }
        else{

        }
    }
}

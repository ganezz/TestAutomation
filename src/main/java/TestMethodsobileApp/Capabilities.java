package TestMethodsobileApp;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

import static Utilities.Android.implicit;

public class Capabilities {
    public static String appPackage;
    public static String appActivity;
    public static AndroidDriver<AndroidElement> driver;
    public static AndroidDriver<AndroidElement> Capability() throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();
        String emulator = "emulator-5554";
        String deviceName = "32079B120408";
        dc.setCapability(MobileCapabilityType.DEVICE_NAME,deviceName);
        dc.setCapability("platformName","android");
        dc.setCapability("appPackage",appPackage);
        dc.setCapability("appActivity",appActivity);
        driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),dc);
        return driver;
    }
    public static void appConfig(String appName){
        if(appName.equals("yahoo")){
            appPackage="com.yahoo.mobile.client.android.mail";
            appActivity = ".activity.MainActivity";
        }
        else if (appName.contains("APIdemo")){
            appPackage="io.appium.android.apis";
            appActivity = ".ApiDemos";
        }
        else if (appName.contains("nav")){
            appActivity=".MainActivity";
            appPackage= "com.iexceed.navigationpoc";
        }
    }
}

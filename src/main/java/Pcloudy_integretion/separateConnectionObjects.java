package Pcloudy_integretion;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class separateConnectionObjects {
    public static AppiumDriver driver1;
    //Extra for separate Execution
    public static void  setIOSCapabilities() throws MalformedURLException, InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("pCloudy_Username", "sriganesh.d@i-exceed.com");
        capabilities.setCapability("pCloudy_ApiKey", "bkx8w6zydrxh6kj7xxw5t4kr");
        capabilities.setCapability("pCloudy_DurationInMinutes", 10);
        capabilities.setCapability("newCommandTimeout", 600);
        capabilities.setCapability("launchTimeout", 90000);

        capabilities.setCapability("pCloudy_DeviceFullName", "APPLE_iPhoneXSMax_iOS_14.2.0_bbec2");
        capabilities.setCapability("platformVersion", "14.2.0");

        capabilities.setCapability("platformName", "ios");
        capabilities.setCapability("acceptAlerts", true);
        capabilities.setCapability("automationName", "XCUITest");
        capabilities.setCapability("noReset",true);
        capabilities.setCapability("bundleId", "com.apple.Preferences");
        capabilities.setCapability("pCloudy_WildNet", "true");
        capabilities.setCapability("pCloudy_EnableVideo", "true");
        capabilities.setCapability("pCloudy_EnablePerformanceData", "true");
        capabilities.setCapability("pCloudy_EnableDeviceLogs", "true");
        capabilities.setCapability("uiautomator2ServerLaunchTimeout", 120000);
        capabilities.setCapability("uiautomator2ServerInstallTimeout", 90000);
        driver1 = new IOSDriver<WebElement>(new URL("https://device.pcloudy.com/appiumcloud/wd/hub"), capabilities);
        //this.launchRetail("com.ixceed.RetailOnboarding.Dev","https://a3.files.diawi.com/app-file/9MjJ7DKopb3U8naNAgSD.ipa",driver1);
    }
    public void launchRetail(String bundleId,String app, WebDriver driver) throws InterruptedException {
        IOSDriver drive = ((IOSDriver<WebElement>) driver);
        drive.terminateApp("com.apple.Preferences");
        try {
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("bundleId", bundleId);
            drive.executeScript("mobile: removeApp", params);
            System.out.println("Uninstalling app");
        }catch (Exception e){

        }
        System.out.println("Installing");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("app", app);
        drive.executeScript("mobile: installApp", params);

        trustDevice(drive);

        Map<String, Object> retail= new HashMap<String, Object>();
        retail.put("bundleId",bundleId);
        drive.executeScript("mobile: launchApp", retail);
        System.out.println("lauch Retailapp");
    }

    public  void reStartApp(WebDriver driver,String bundleId,String app) throws InterruptedException {
        IOSDriver drive = ((IOSDriver<WebElement>) driver);
        System.out.println("terminate app");
        // dryRun=true,

        drive.terminateApp(bundleId);
        System.out.println("Relauch App");
//        drive.resetApp();

      //  trustDevice(drive);

        Map<String, Object> retail= new HashMap<String, Object>();
        retail.put("bundleId",bundleId);
        drive.executeScript("mobile: launchApp", retail);
    }

    public  void reInstallApp(WebDriver driver, String bundleId, String app) throws InterruptedException {
        IOSDriver drive = ((IOSDriver<WebElement>) driver);
        System.out.println("terminate app");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("bundleId", bundleId);
        drive.executeScript("mobile: removeApp", params);

        System.out.println("Relauch App");
        //drive.resetApp();
        Map<String, Object> param = new HashMap<String, Object>();
        params.put("app", app);
        drive.executeScript("mobile: installApp", params);

        trustDevice(drive);

        Map<String, Object> retail= new HashMap<String, Object>();
        retail.put("bundleId",bundleId);
        drive.executeScript("mobile: launchApp", retail);
    }
    public  void reStartAppAndroid(WebDriver driver,String androidPackage,String androidActivity) throws InterruptedException {
        AndroidDriver drive = ((AndroidDriver<WebElement>) driver);
        System.out.println("terminate app");
       // drive.terminateApp(androidPackage);
        Thread.sleep(5000);
        System.out.println("Relauch App");
        drive.resetApp();
        System.out.println("Relauch App");
        //drive.startActivity(new Activity(androidPackage, androidActivity));
    }
    public void installAndroid(WebDriver driver,String appLink,String androidPackage,String androidActivity){
        AndroidDriver drive = ((AndroidDriver<WebElement>) driver);
        System.out.println("Installing App");
        drive.installApp(appLink);
        drive.startActivity(new Activity(androidPackage, androidActivity));
    }

    public static void trustDevice(IOSDriver drive) throws InterruptedException {
        System.out.println("activate Settings app");
        drive.activateApp("com.apple.Preferences");
        drive.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS) ;
        scrollandClick(drive,"General");
        Thread.sleep(2000);
        try {
            scrollandClick(drive, "Device Management");
        }catch (Exception e){
            scrollandClick(drive, "Profiles & Device Management");
        }
        drive.findElement(By.xpath("//XCUIElementTypeCell[@name='i-exceed technology solutions private limited']")).click();
        try {
            drive.findElement(By.xpath("//XCUIElementTypeStaticText[@name='Trust “i-exceed technology solutions private limited”']")).click();
            drive.findElement(By.xpath("//XCUIElementTypeButton[@name='Trust']")).click();
        }catch (Exception e){

        }
        Thread.sleep(3000);
        System.out.println("terminate settings");
        drive.terminateApp("com.apple.Preferences");
    }
    public static void scrollandClick(IOSDriver drive, String name){
        RemoteWebElement element = (RemoteWebElement)drive.findElement(By.xpath("//*[@name='"+name+"']"));
        String elementID = element.getId();
        HashMap<String, String> scrollObject = new HashMap<String, String>();
        scrollObject.put("element", elementID);
        scrollObject.put("toVisible", "not an empty string");
        drive.executeScript("mobile:scroll", scrollObject);
        element.click();
    }

    public  static  void setAndroidCapabilities() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("pCloudy_Username", "sriganesh.d@i-exceed.com");
        capabilities.setCapability("pCloudy_ApiKey", "bkx8w6zydrxh6kj7xxw5t4kr");
        capabilities.setCapability("pCloudy_DurationInMinutes", 10);
        capabilities.setCapability("newCommandTimeout", 600);
        capabilities.setCapability("launchTimeout", 90000);
      //  capabilities.setCapability("pCloudy_DeviceFullName", "ASUS_ZenfoneGo_Android_5.1.1_22de2");
        capabilities.setCapability("pCloudy_DeviceManufacturer", "XIAOMI");
        capabilities.setCapability("platformVersion", "11.0.0");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("automationName", "uiautomator1");
        capabilities.setCapability("pCloudy_ApplicationName", "pCloudy_Appium_Demo.apk");
        capabilities.setCapability("appPackage", "com.pcloudy.appiumdemo");
        capabilities.setCapability("appActivity", "com.ba.mobile.LaunchActivity");
        capabilities.setCapability("pCloudy_WildNet", "false");
        capabilities.setCapability("pCloudy_EnableVideo", "false");
        capabilities.setCapability("pCloudy_EnablePerformanceData", "true");
        capabilities.setCapability("pCloudy_EnableDeviceLogs", "true");
        driver1 = new AndroidDriver<WebElement>(new URL("https://device.pcloudy.com/appiumcloud/wd/hub"), capabilities);
        driver1.closeApp();
        String packageName = "com.pcloudy.appiumdemo";
        driver1.terminateApp(packageName);
        driver1.activateApp(packageName);

    }



    public  void setIosCapabilities() throws MalformedURLException, InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("pCloudy_Username", "sriganesh.d@i-exceed.com");
        capabilities.setCapability("pCloudy_ApiKey", "bkx8w6zydrxh6kj7xxw5t4kr");
        capabilities.setCapability("pCloudy_DurationInMinutes", 10);
        capabilities.setCapability("newCommandTimeout", 600);
        capabilities.setCapability("launchTimeout", 90000);
        capabilities.setCapability("pCloudy_DeviceFullName", "APPLE_iPhoneXS_iOS_14.1.0_21d51");
        capabilities.setCapability("platformVersion", "14.1.0");
        capabilities.setCapability("platformName", "ios");
        capabilities.setCapability("acceptAlerts", true);
        capabilities.setCapability("automationName", "XCUITest");
        capabilities.setCapability("pCloudy_ApplicationName", "AssistedApplicationModuleSampleApp_Resigned1632922649.ipa");
        capabilities.setCapability("bundleId", "com.ixceed.AssistedApplicationModuleSampleApp");
        capabilities.setCapability("pCloudy_WildNet", "false");
        capabilities.setCapability("pCloudy_EnableVideo", "false");
        capabilities.setCapability("pCloudy_EnablePerformanceData", "true");
        capabilities.setCapability("pCloudy_EnableDeviceLogs", "true");
        IOSDriver<WebElement> driver = new IOSDriver<WebElement>(new URL("https://us.pcloudy.com/appiumcloud/wd/hub"), capabilities);
    }


    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        setIOSCapabilities();
    }




}

package Pcloudy_integretion;

import Pcloudy_integretion.separateConnectionObjects;
import com.iexceed.uiframework.appium.CreateSession;
import com.iexceed.uiframework.utilites.ProjectConfigurator;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ConnectionObjects {
    CreateSession createSession;
    public static AppiumDriver driver;
    public static Properties config;

    public static ProjectConfigurator projectConfigurator;
    public static separateConnectionObjects connection = new separateConnectionObjects();

    public void startAppium(String platform) throws Exception {
        createSession = new CreateSession();
        createSession.createDriver(platform,ConnectionObjects.class.getDeclaredMethod("startAppium", String.class));
    }

    public void setRemoteDeviceCapabilities(String platform, String version, String deviceName, String automationName, String applicationName, String androidActivity, String androidPackage, String bundleID, String maxDuration) throws MalformedURLException, InterruptedException {
        if(driver == null) {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("pCloudy_Username", "sriganesh.d@i-exceed.com");
            capabilities.setCapability("pCloudy_ApiKey", "bkx8w6zydrxh6kj7xxw5t4kr");
            capabilities.setCapability("pCloudy_DurationInMinutes", maxDuration);
            capabilities.setCapability("newCommandTimeout", 600);
            capabilities.setCapability("launchTimeout", 90000);
            capabilities.setCapability("pCloudy_DeviceFullName", deviceName);
            capabilities.setCapability("platformVersion", version);
            capabilities.setCapability("platformName", platform);
            capabilities.setCapability("acceptAlerts", true);
            capabilities.setCapability("automationName", automationName);
            capabilities.setCapability("pCloudy_WildNet", "false");
            capabilities.setCapability("pCloudy_EnableVideo", "true");
            capabilities.setCapability("pCloudy_EnablePerformanceData", "true");
            capabilities.setCapability("pCloudy_EnableDeviceLogs", "true");
            try {
                if (platform.equalsIgnoreCase("ios")) {
                    capabilities.setCapability("bundleId", "com.apple.Preferences");
                    driver = new IOSDriver<WebElement>(new URL("https://device.pcloudy.com/appiumcloud/wd/hub"), capabilities);
                    System.out.println("Driver connected");
                    connection.launchRetail(bundleID, applicationName, driver);
                } else {
                    capabilities.setCapability("pCloudy_ApplicationName", applicationName);
                    capabilities.setCapability("appPackage", androidPackage);
                    capabilities.setCapability("appActivity", androidActivity);
                    driver = new AndroidDriver<WebElement>(new URL("https://device.pcloudy.com/appiumcloud/wd/hub"), capabilities);
                    System.out.println("Android Driver connected");
                    // connection.installAndroid(driver,applicationName,androidPackage,androidActivity);
                }
            } catch (Exception e) {
                System.out.println("Devices not avaialale : " + e);
            }
        }else {
            if (platform.equalsIgnoreCase("ios")) {
                //connection.reStartApp(driver, bundleID);
                System.out.println("Restarting new App");
            }else {
                connection.reStartAppAndroid(driver,androidPackage,androidActivity);
                System.out.println("Restarting new App");
            }
        }
    }

    public void setRealDeviceCapabilities(String platform, String deviceName, String automationName, String applicationName, String androidActivity, String androidPackage, String deviceURL,String noReset) throws Exception {
        if (driver == null) {
            setCapability(platform, deviceName, automationName, applicationName, androidActivity, androidPackage, deviceURL, noReset);
        }else {
            connection.reStartAppAndroid(driver,androidPackage,androidActivity);
            System.out.println("Restarting new App");
        }
    }
    public void setCapability(String platform, String deviceName, String automationName, String applicationName, String androidActivity, String androidPackage, String deviceURL,String noReset) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", deviceName);
        capabilities.setCapability("platformName", platform);
        capabilities.setCapability("appPackage", androidPackage);
        capabilities.setCapability("appActivity", androidActivity);
        capabilities.setCapability("app",applicationName);
        capabilities.setCapability("noReset", Boolean.parseBoolean(noReset));
        capabilities.setCapability("automationName", automationName);
        driver = new AndroidDriver(new URL(deviceURL), capabilities);
    }

    public void relaunchRemoteApp(String platform, String version, String deviceName, String automationName, String applicationName, String androidActivity, String androidPackage, String bundleID, String maxDuration) throws InterruptedException {
        if (platform.equalsIgnoreCase("ios")) {
          //  connection.reStartApp(driver,bundleID);
        } else {
            driver.closeApp();
            driver.resetApp();

        }
    }

    public void relaunchAppReal(String platform, String deviceName, String automationName, String applicationName, String androidActivity, String androidPackage, String deviceURL, String noReset) {
        AndroidDriver drive = ((AndroidDriver<WebElement>) driver);
        System.out.println("terminate app");
        driver.terminateApp(androidPackage);
        System.out.println("Relauch App");
        drive.startActivity(new Activity(androidPackage, androidActivity));
    }
}

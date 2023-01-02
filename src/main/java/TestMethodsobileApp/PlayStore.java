package TestMethodsobileApp;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.MobileCapabilityType;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class PlayStore {

    public AndroidDriver<AndroidElement> driver;

    public static void main(String[] args) throws IOException {
        PlayStore sp = new PlayStore();
        sp.connectPcloudy();
        //sp.realDevice();
        //sp.playStore();
    }

    private void connectPcloudy() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("pCloudy_Username", "divya.bharathi@i-exceed.com");
        capabilities.setCapability("pCloudy_ApiKey", "tk6cbfnnny9vhm55nhqmgzv3");
        capabilities.setCapability("pCloudy_DurationInMinutes", 10);
        capabilities.setCapability("newCommandTimeout", 600);
        capabilities.setCapability("launchTimeout", 90000);
        capabilities.setCapability("pCloudy_DeviceManufacturer", "GOOGLE");
        capabilities.setCapability("platformVersion", "11.0.0");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("automationName", "uiautomator1");
        capabilities.setCapability("appPackage","com.android.vending");
        capabilities.setCapability("appActivity","com.google.android.finsky.activities.MainActivity");
        capabilities.setCapability("noReset",true);
        capabilities.setCapability("pCloudy_WildNet", "false");
        capabilities.setCapability("pCloudy_EnableVideo", "false");
        capabilities.setCapability("pCloudy_EnablePerformanceData", "false");
        capabilities.setCapability("pCloudy_EnableDeviceLogs", "true");
        driver = new AndroidDriver<AndroidElement>(new URL("https://device.pcloudy.com/appiumcloud/wd/hub"), capabilities);
    }

    private void realDevice() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities(); //32079B120409 emulator-5554
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"android");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"32079B120409");
        capabilities.setCapability("appPackage","com.android.vending");
        capabilities.setCapability("appActivity","com.google.android.finsky.activities.MainActivity");
        capabilities.setCapability("noReset",true);
        driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
    }


    private void playStore() throws IOException {
        try {
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            WebElement search = driver.findElementByXPath("//*[@text='Search for apps & games']");
            search.click();
            search.sendKeys("Yahoo");
            driver.pressKey(new KeyEvent(AndroidKey.ENTER));
            driver.findElementByXPath("//*[@text='Install']").click();
        }catch (Exception e){
                File srcFile=driver.getScreenshotAs(OutputType.FILE);
                String filename= UUID.randomUUID().toString();
                File targetFile=new File("Screenshot/"+filename +".jpg");
                FileUtils.copyFile(srcFile,targetFile);
                System.out.println(e);
        }
        System.out.println("Success");
        driver.close();
    }
}

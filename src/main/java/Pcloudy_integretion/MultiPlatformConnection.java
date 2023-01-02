package uiframework.DomainObjects;

import com.iexceed.uiframework.appium.PcloudyConnection;
import com.iexceed.uiframework.core.TestBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import static com.iexceed.uiframework.appium.PcloudyConnection.appiumDriver;

public class MultiPlatformConnection extends TestBase {

    protected static Properties mobileProps = new Properties();
    private static Logger LOGGER = LogManager.getLogger(MultiPlatformConnection.class);

    PcloudyConnection mobileConnection;
    TestBase testBase;

    By targetCompanyName = By.xpath("//XCUIElementTypeCell[@name='i-exceed technology solutions private limited']");
    By trustCompanyName = By.xpath("//XCUIElementTypeStaticText[@name='Trust ?i-exceed technology solutions private limited?']");
    By trustBtn = By.xpath("//XCUIElementTypeButton[@name='Trust']");

    public MultiPlatformConnection() {
        FileInputStream ip;
        try {
            ip = new FileInputStream(new File("src/main/resources/mobileConnection.properties"));
            mobileProps.load(ip);
            LOGGER.info("Mobile Properties Loaded");

        } catch (Exception e) {
            LOGGER.error("Check Mobile Proper");
        }
        testBase = new TestBase();
        mobileConnection = new PcloudyConnection();
    }

    public void platformConnection(String platform,String application) throws Exception {
        if (platform.equalsIgnoreCase("android") || platform.equalsIgnoreCase("ios")){
            if (application.equalsIgnoreCase("bank")){
                DynamicDeviceAllocation(platform.toLowerCase(),mobileProps.getProperty("bank_androidApplicationName"), mobileProps.getProperty("bank_androidActivity"), mobileProps.getProperty("bank_androidPackage"),mobileProps.getProperty("bank_iosApplicationName"),mobileProps.getProperty("bank_bundleID"));
            }else if (application.equalsIgnoreCase("customer")){
                DynamicDeviceAllocation(platform.toLowerCase(),mobileProps.getProperty("customer_androidApplicationName"), mobileProps.getProperty("customer_androidActivity"), mobileProps.getProperty("customer_androidPackage"),mobileProps.getProperty("customer_iosApplicationName"),mobileProps.getProperty("customer_bundleID"));
            }else {
                Assert.fail("Please provide valid testNG parameter");
            }
        }else if (platform.equalsIgnoreCase("web")){
            if (application.equalsIgnoreCase("bank")){
                browserInitialization(props.getProperty("bank_url"));
            }else if (application.equalsIgnoreCase("customer")){
                browserInitialization(props.getProperty("corporateUrl"));
            }else {
                Assert.fail("Please provide valid testNG parameter");
            }
        }else {
            Assert.fail("Please provide valid testNG parameter");
        }
    }

    private void browserInitialization(String url) throws Exception {
        TestBase.initialization(props.getProperty("browser"));
        TestBase.getDriver().get(url);
        TestBase.getDriver().manage().window().maximize();
        TestBase.getDriver().manage().deleteAllCookies();
        TestBase.getDriver().navigate().refresh();
        LOGGER.info("Browser Started");
    }

    private void DynamicDeviceAllocation(String platform,String androidApplicationName,String activityName, String packageName,String iosApplicationName,String bundleName) throws Exception {
        if (mobileProps.getProperty("real_device").equalsIgnoreCase("true")){
            mobileConnection.setRealDeviceCapabilities(platform,mobileProps.getProperty("android_realDeviceName"), "appium","",activityName,packageName, mobileProps.getProperty("appium_url"), mobileProps.getProperty("noReset"), mobileProps.getProperty("orientation"));
        }else {
            for (int i = 1; i <= Integer.parseInt(mobileProps.getProperty("no_devices")); i++) {
                String deviceName,applicationName,automatorName;
                if (platform.equalsIgnoreCase("ios")){
                    deviceName = mobileProps.getProperty("ios_device"+i);
                    applicationName = iosApplicationName;
                    automatorName = mobileProps.getProperty("ios_automatorName");
                }else {
                    deviceName = mobileProps.getProperty("android_device"+i);
                    applicationName = androidApplicationName;
                    automatorName = mobileProps.getProperty("android_automatorName");
                }
                System.out.println(deviceName);
                mobileConnection.setRemoteDeviceCapabilities(mobileProps.getProperty("pcloudyUsername"), mobileProps.getProperty("pcloudyApikey"),platform,"",deviceName,automatorName, applicationName,activityName,packageName,bundleName,
                        mobileProps.getProperty("maxDuration"), mobileProps.getProperty("deviceURL"), mobileProps.getProperty("orientation"),Boolean.valueOf(mobileProps.getProperty("isTrustedDevice")),targetCompanyName,trustCompanyName ,trustBtn);
            }
        }
        if (appiumDriver == null){
            Assert.fail("Devices are failed to connect");
        }else {
            TestBase.setDriver(appiumDriver);
        }
    }

    public static void main(String[] args) throws Exception {
        MultiPlatformConnection multiPlatformConnection = new MultiPlatformConnection();
        multiPlatformConnection.platformConnection("web","bank");
    }

}

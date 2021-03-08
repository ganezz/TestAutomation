package TestMethods;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.net.MalformedURLException;

public class App
{
    public static AndroidDriver<AndroidElement> driver;
    @Given("I launch {string} APP")
    public void i_launch_app(String appName) throws MalformedURLException {
        Capabilities.appConfig(appName);
        driver = Capabilities.Capability();
    }
    @When("I tap the Compose button")
    public void i_tap_the_compose_button() throws InterruptedException {
        MobileElement el1 = (MobileElement) driver.findElementById("com.yahoo.mobile.client.android.mail:id/yahoo_sign_in_link");
        el1.click();
        Thread.sleep(15000);
        MobileElement el2 = (MobileElement) driver.findElementByAccessibilityId("Compose message");
        el2.click();
        Thread.sleep(5000);
    }
    @Then("Compose page will open")
    public void compose_page_will_open() {
        MobileElement el1 = (MobileElement) driver.findElementById("com.android.permissioncontroller:id/permission_allow_button");
        el1.click();
        System.out.println("ON compose page");
    }
    @When("Tap the To and give value as {string}")
    public void tap_the_to_and_give_value_as(String to) throws InterruptedException {
        Thread.sleep(1000);
        MobileElement el2 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[1]/android.view.View[2]/android.widget.EditText");
        //el2.click();
        el2.sendKeys(to);
    }
    @When("Tap the Subject and give value as {string}")
    public void tap_the_subject_and_give_value_as(String sub) {
        MobileElement el3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[3]/android.widget.EditText");
        el3.click();
        el3.sendKeys(sub);
    }
    @When("Tap the Body Section and give value as {string}")
    public void tap_the_body_section_and_give_value_as(String body) {
        MobileElement el5 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.webkit.WebView/android.webkit.WebView/android.widget.EditText");
       el5.click();
       driver.hideKeyboard();
        el5.sendKeys("\n"+body);
    }
    @When("Tap the send button")
    public void tap_the_send_button() {
        MobileElement el6 = (MobileElement) driver.findElementById("com.yahoo.mobile.client.android.mail:id/send");
        el6.click();
    }


}

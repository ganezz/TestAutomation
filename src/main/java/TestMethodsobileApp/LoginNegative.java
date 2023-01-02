package TestMethodsobileApp;

import io.appium.java_client.MobileElement;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

import static TestMethodsobileApp.App.driver;
import static Utilities.Android.explicit;
import static Utilities.Android.implicit;
import static org.apache.batik.anim.timing.Trace.exit;

public class LoginNegative {

    @When("I tab the Already user login")
    public void i_tab_the_already_user_login() throws InterruptedException {
        explicit((By.id("com.yahoo.mobile.client.android.mail:id/yahoo_sign_in_link")), 10);
        MobileElement el1 = (MobileElement) driver.findElementById("com.yahoo.mobile.client.android.mail:id/yahoo_sign_in_link");
        el1.click();

    }

    @Then("Login page will open")
    public void login_page_will_open() {
        explicit(By.xpath("//android.view.View[contains(@text,'Sign in')]"),10);
        MobileElement el2 = (MobileElement) driver.findElementByXPath( "//android.view.View[contains(@text,'Sign in')]");
        Assert.assertTrue(el2.getText().contains("Sign in"));
        System.out.println(el2.getText());
    }

    @Then("i give the login id as  {string} and enter login button")
    public void i_give_the_login_id_as_and_enter_login_button(String email) throws InterruptedException {
        explicit(By.className("android.widget.EditText"),8);
        MobileElement el3 = (MobileElement) driver.findElementByClassName("android.widget.EditText");
        el3.sendKeys(email);
        MobileElement el4 = (MobileElement) driver.findElementByXPath( "//android.widget.Button[contains(@text,'Next')]");
        el4.click();
    }

    @Then("Validate Authentication")
    public void Message_will_appear() throws InterruptedException {
        try {
            explicit(By.xpath("//android.view.View[contains(@text,'Sorry')]"),10);
            MobileElement el5 = (MobileElement) driver.findElementByXPath( "//android.view.View[contains(@text,'Sorry')]");
            Assert.assertTrue(el5.getText().contains("Sorry"));
            System.out.println(el5.getText());
            exit();
        } catch (Exception e) {
            explicit(By.xpath("//android.view.View[contains(@text, 'password')]"),10);
            MobileElement el5 = (MobileElement) driver.findElementByXPath( "//android.view.View[contains(@text, 'password')]");
            Assert.assertTrue(el5.getText().contains("password"));
            System.out.println(el5.getText());


        }

    }
    @Then("If Email is correct then give password as {string}")
    public void if_email_is_correct_then_give_password_as(String pwd) {
        MobileElement e16 = (MobileElement) driver.findElementByClassName("android.widget.EditText");
        e16.sendKeys(pwd);
    }
    @Then("Click the Login button")
    public void click_the_login_button() {
        driver.findElementByXPath("(//android.widget.Button)[2]").click();

    }

}

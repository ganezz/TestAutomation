package TestMethods;

import io.appium.java_client.MobileElement;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import static TestMethods.App.driver;

public class LoginNegative {
    @When("I tab the Already user login")
    public void i_tab_the_already_user_login() throws InterruptedException {
        MobileElement el1 = (MobileElement) driver.findElementById("com.yahoo.mobile.client.android.mail:id/yahoo_sign_in_link");
        el1.click();
        Thread.sleep(15000);
    }

    @Then("Login page will open")
    public void login_page_will_open() {
        MobileElement el2 = (MobileElement) driver.findElementByXPath( "//android.view.View[contains(@text,'Sign in')]");
        Assert.assertTrue(el2.getText().contains("Sign in"));
        System.out.println(el2.getText());
    }

    @Then("i give the login id as  {string} and enter login button")
    public void i_give_the_login_id_as_and_enter_login_button(String email) throws InterruptedException {
        MobileElement el3 = (MobileElement) driver.findElementByClassName("android.widget.EditText");
        el3.sendKeys(email);
        MobileElement el4 = (MobileElement) driver.findElementByXPath( "//android.widget.Button[contains(@text,'Next')]");
        el4.click();
        Thread.sleep(8000);
    }

    @Then("Validate Authentication")
    public void Message_will_appear() {

        try {
            MobileElement el5 = (MobileElement) driver.findElementByXPath( "//android.view.View[contains(@text,'Sorry')]");
            Assert.assertTrue(el5.getText().contains("Sorry"));
            System.out.println(el5.getText());
        } catch (Exception e) {
            MobileElement el5 = (MobileElement) driver.findElementByXPath( "//android.view.View[contains(@text, 'password')]");
            Assert.assertTrue(el5.getText().contains("password"));
            System.out.println(el5.getText());


        }

    }
}

package TestMethods;


import Utilities.Android;
import io.appium.java_client.MobileElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class APIDemos {
    @When("I Tap the Views")
    public void i_tap_the_views() {
        MobileElement el1 = (MobileElement) App.driver.findElementByXPath("//android.widget.TextView[contains(@text , 'Views')]");
        el1.click();
    }
    @When("Scroll down")
    public void scroll_down() {
        Android.scroll("Text");

    }
    @When("Select Text")
    public void select_switches() {
        MobileElement el2 =(MobileElement) App.driver.findElementByXPath("//android.widget.TextView[contains(@text, 'Text')]");
        el2.click();

    }
    @And("Select EditText")
    public void edit_text(){
        MobileElement el3 =(MobileElement) App.driver.findElementByXPath("//android.widget.TextView[contains(@text, 'EditText')]");
        el3.click();
    }
    @And("Longpress on Edit Field")
    public void long_press(){
        MobileElement el4 = (MobileElement) App.driver.findElementById("com.example.android.apis:id/edit0");
        Android.longpress(el4);
    }


}

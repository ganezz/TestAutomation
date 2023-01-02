package testMethods;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import static Utilities.Web.windowNavigator;
import static testMethods.WebCapability.cap;
import static testMethods.WebCapability.driver;


public class tabNavi {
    private String parent;

    @When("Open new window")
    public void open_new_window() {
        parent = driver.getWindowHandle();
        driver.findElement(By.id("opentab")).click();
    }
    @Then("Navigate to the New window")
    public void navigate_to_the_new_window() throws InterruptedException {
        windowNavigator();
        Thread.sleep(2000);
    }
    @Then("Close the Old window")
    public void close_the_old_window() {
        driver.switchTo().window(parent);
       // driver.switchTo().alert().
        driver.close();
    }
}

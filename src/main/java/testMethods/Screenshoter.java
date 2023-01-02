package testMethods;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import static testMethods.WebCapability.cap;
import static testMethods.WebCapability.driver;

public class Screenshoter {
    private WebElement login;

    @Given("Open the Url {string} in {string}")
    public void open_the_url_in(String url, String browser) throws IOException {
        cap();
        driver.get(url);
    }
    @When("find the element in the page")
    public void find_the_element_in_the_page() throws InterruptedException {
        Thread.sleep(3000);
        login = driver.findElement(By.cssSelector("[id='Admin__Login__grid_column_1']"));
    }
    @Then("Take a screen shot and save as {string}")
    public void take_a_screen_shot_and_save_as(String fileName) throws IOException {
        File logSc = login.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(logSc,new File(fileName));
    }

}

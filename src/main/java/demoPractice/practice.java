package demoPractice;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import static Sync.waitMethods.getSleep;
import static Sync.waitMethods.implicit;
import static Utilities.Web.*;
import static testMethods.WebCapability.driver;

public class practice {
    WebElement radio;
    @When("Select the Radio button")
    public void select_the_radio_button() {
        radio = driver.findElement(By.cssSelector("[value='radio1']"));
        jsExeClick(radio);
    }
    @Given("Check the button is clicked")
    public void check_the_button_is_clicked() throws InterruptedException {
        System.out.println("Is Radio button is Clicked "+radio.isSelected());
        getSleep(3000);

    }
    @Then("Select the differnt buttons")
    public void select_the_differnt_buttons() {
        jsExeClick(driver.findElement(By.cssSelector("[value='radio3']")));
        System.out.println("Radio1 is Selected "+radio.isSelected());
    }
    @When("Input the suggest text in country name as {string}")
    public void input_the_suggest_text_in_country_name_as(String text) {
        driver.findElement(By.id("autocomplete")).sendKeys(text);
        //jsExeSendkeysBYId(text);
    }
    @Then("Select the value of {string}")
    public void select_the_value_of_india(String country) {
        WebElement list = driver.findElement(By.id("ui-id-1")),temp;
         dropdownFinder(list.findElements(By.xpath("//li/div")),country,"");
    }
    @When("Select the differnt elements")
    public void select_the_differnt_elements() throws InterruptedException {
        WebElement drops = driver.findElement(By.name("dropdown-class-example"));
        staticdropdownFinder(drops,"value", "option3");
    }
    @When("Select the all checkboxes")
    public void select_the_all_checkboxes() {
        jsExeClick(driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")));
        actionClick(driver.findElement(By.name("checkBoxOption2")));
        //dropdownFinder(driver.findElements(By.cssSelector("[type*='checkbox']")),"Option3","" );
        driver.findElement(By.xpath("(//div[@id='checkbox-example']/fieldset/label/input)[3]")).click();
    }
    @Then("Deselect one box")
    public void deselect_one_box() {
        driver.findElement(By.xpath("//*[@for='benz']/input")).click();
    }
    @Then("Open another child window from the URL {string}")
    public void open_another_child_window_from_the_url(String string) throws MalformedURLException {
            jsExeNewWindow(new URL(string));
    }
    @When("Open alert box and get text from it")
    public void open_alert_box_and_get_text_from_it() {
            driver.findElement(By.cssSelector("[value='Alert']")).click();
            System.out.println(driver.switchTo().alert().getText());
            driver.switchTo().alert().accept();
    }
    @Then("Open promt box and put text on it then accept")
    public void open_promt_box_and_put_text_on_it_then_accept() {
            jsExeSendkeysBYId("name","Sri");
            driver.findElement(By.cssSelector("[value='Confirm']")).click();
            System.out.println(driver.switchTo().alert().getText());
            driver.switchTo().alert().accept();
    }
    @When("Check field is visible , if visible then hide it else Invisible then show it")
    public void check_field_is_visible_if_visible_then_hide_it_else_invisible_then_show_it() throws InterruptedException {
        WebElement input = driver.findElement(By.id("displayed-text"));
            jsWinScroll(0,500);
            getSleep(3000);
            jsExeClick(driver.findElement(By.cssSelector("[value='Hide']")));
            System.out.println("Text Box is visible "+input.isDisplayed());
            getSleep(3000);
            jsExeClick(driver.findElement(By.cssSelector("[value='Show']")));
            System.out.println("Text Box is visible "+input.isDisplayed());
    }

}

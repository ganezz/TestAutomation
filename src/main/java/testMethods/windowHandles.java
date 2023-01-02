package testMethods;

import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.Set;

import static Sync.waitMethods.implicit;
import static Utilities.Web.*;
import static testMethods.WebCapability.cap;
import static testMethods.WebCapability.driver;

public class windowHandles {

    @Then("Choose About Us from the About dropdown")
    public void choose_about_us_from_the_about_dropdown() {
        hover(driver.findElement(By.cssSelector(".dropdown-toggle")));
        WebElement dropdown = driver.findElement(By.cssSelector(".dropdown-toggle"));
        dropdownFinder( driver.findElements(By.xpath("//li/a")),"About Us",newTabClick);
    }
    @Then("Print the total windows opened")
    public void print_the_total_windows_opened() {
        Set<String> window =  driver.getWindowHandles();
        System.out.println("Number of Windows Opoened "+window.size());
        windowNavigator();
    }



    public static void tablecount(){
        WebElement table = driver.findElement(By.cssSelector(".left-align table tbody"));
        System.out.println(table.findElements(By.tagName("tr")).size());
    }
}
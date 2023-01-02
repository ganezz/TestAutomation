package testMethods;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;


import static Sync.waitMethods.*;
import static Utilities.Web.dateSelect;
import static Utilities.Web.hover;

import static testMethods.WebCapability.driver;


public class AppzillonAdmin {
    public  static  JavascriptExecutor js ;
    @When("In Login give username as {string} and password as {string} and click login button")
    public void in_login_give_username_as_and_password_as_and_click_login_button(String username, String password) throws InterruptedException {
        driver.manage().window().maximize();
        driver.findElement(By.id("Admin__Login__userId")).sendKeys(username);
        driver.findElement(By.id("Admin__Login__pswd")).sendKeys(password);
        //explicit("Admin__Login__element_button_1",10);
        getSleep(4000);
        driver.findElement(By.id("Admin__Login__element_button_1")).click();
    }
    @Then("Click the Staff Maintenance in Bank Parameter drop down")
    public void click_the_satff_maintenance_in_bank_parameter_drop_down() {
        explicit("Admin__Landing__ct_mnu_2_Bank Parameters_li",8);
        hover(driver.findElement(By.id("Admin__Landing__ct_mnu_2_Bank Parameters_li")));
        explicit("Admin__Landing__ct_mnu_2_Staff Maintenance_li",2);
        driver.findElement(By.id("Admin__Landing__ct_mnu_2_Staff Maintenance_li")).click();
    }
    @Then("Give the user id as {string} and click the search button")
    public void give_the_user_id_as_and_click_the_search_button(String userId) {
        driver.findElement(By.id("Admin__StaffMaintenanceQuery__userId")).sendKeys(userId);
        driver.findElement(By.id("Admin__StaffMaintenanceQuery__SearchButton")).click();
    }
    @When("Click the table displaying content in user iD column")
    public void click_the_table_displaying_content_in_user_i_d_column() throws InterruptedException {
        getSleep(8000);
        driver.findElement(By.xpath("(//tbody/tr/td/a)[1]")).click();
    }
    @Then("Authorise the user")
    public void authorise_the_user() {
       driver.findElement(By.cssSelector("[id*='Authorize']")).click();
    }
    @When("in following screen click the unlock button and click the Dateof Birth field")
    public void in_following_screen_click_the_unlock_button_and_click_the_dateof_birth_field() {

        driver.findElement(By.id("Admin__StaffMaintenanceDetail__Unlock")).click();
        driver.findElement(By.id("Admin__StaffMaintenanceEdit__o__tbAsmiUser__DATEOFBIRTH")).click();
    }
    @Then("Choose the year as {string} and month as {string} and Date as {string}")
    public void choose_the_year_as_and_momth_as_and_date_as(String year, String month, String date) throws InterruptedException {
        dateSelect(year, month, date);
    }
    @Then("Click the save button")
    public void click_the_save_button() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.id("Admin__StaffMaintenanceDetail__Cancel")).click();
    }

}

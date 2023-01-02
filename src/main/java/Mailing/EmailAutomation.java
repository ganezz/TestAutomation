package Mailing;

import TestMethodsobileApp.Capabilities;
import android.graphics.pdf.PdfDocument;
import com.iexceed.uiframework.implementations.JavaScriptControls;
import com.iexceed.uiframework.utilites.WaitUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import testMethods.WebCapability;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static testMethods.WebCapability.cap;
import static testMethods.WebCapability.driver;

public class EmailAutomation {

    @FindBy(id = "identifierId")
    WebElement emailId;
    @FindBy(name = "password")
    WebElement password;
    @FindBy(css = ".VfPpkd-RLmnJb")
    WebElement nextBtn;
    @FindBy(css = "div.xT>div.y6>span>span")
    List<WebElement> email;
    @FindBy(css = "div.a3s.aiL ,div.iA.g6 >span")
    List<WebElement> emailBodys;

    public static JavascriptExecutor javaScriptControls;

    public EmailAutomation(){
        PageFactory.initElements(driver,this);
        javaScriptControls = (JavascriptExecutor) driver;
    }

    public void explicit(WebElement element, int time){
        WebDriverWait wait = new WebDriverWait(driver, (long)time);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForSeconds(int timeoutInSeconds) throws Exception {
        Thread.sleep((long)(timeoutInSeconds * 1000));
    }

    public void emailLoginGetPswd(String email_value, String pswd) throws Exception {
        explicit(emailId,30);
        emailId.clear();
        emailId.sendKeys(email_value);
        //nextBtn.click();
        javaScriptControls.executeScript("arguments[0].click();",nextBtn);

        explicit(password,30);
        password.clear();
        password.sendKeys(pswd);
        //nextBtn.click();
        javaScriptControls.executeScript("arguments[0].click();",nextBtn);

    }

    public String[] getEmailBody() throws Exception {
        String loginCredential[] = new String[2];
        int i = (emailBodys.size()-2);
        waitForSeconds(10);
        String emailBody = emailBodys.get(i).getText();
        String data[] = emailBody.trim().split("userid is|and password is|Created by|and");
        loginCredential[0] = data[1].trim();
        loginCredential[1] = data[2].trim();
        System.out.println("userid "+loginCredential[0]);
        System.out.println("pswd "+loginCredential[1] );
        return loginCredential;

    }
    public void navigateToUrl(String url) throws Exception {
            driver.get(url);
            driver.manage().window().maximize();
    }

    public static void main(String[] args) throws Exception {
        cap();
        EmailAutomation emailAutomation = new EmailAutomation();
        emailAutomation.navigateToUrl("https://mail.google.com");
        emailAutomation.emailLoginGetPswd("newparadise108@gmail.com","9487891634");
    }

}

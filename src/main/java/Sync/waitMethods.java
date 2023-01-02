package Sync;

import org.openqa.selenium.By;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static testMethods.WebCapability.driver;


public class waitMethods {
    public static void implicit(){

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }


    public static void explicit( String id,int time){
        WebDriverWait wb = new WebDriverWait(driver,time);
        wb.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));

    }
    public static void getSleep(int mSec) throws InterruptedException {

        Thread.sleep(mSec);
    }

}

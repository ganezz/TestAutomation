package Utilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;

import static io.appium.java_client.touch.offset.ElementOption.element;
import static TestMethods.App.driver;

public class Android {
    public static void scroll(String text){
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+text+"\").instance(0))").click();
    }
    public static void longpress(MobileElement el){
        TouchAction action = new TouchAction(driver);
        action.longPress(LongPressOptions.longPressOptions().withElement(element(el))).release().perform();
    }
    public static void hidekeyboard(){
        driver.hideKeyboard();
    }
    public static void tap(MobileElement el){
        TouchAction tap = new TouchAction(driver);
        tap.tap(TapOptions.tapOptions().withElement(element(el))).release().perform();
    }
}

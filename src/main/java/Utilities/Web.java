package Utilities;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.tools.ant.taskdefs.Java;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.io.FileInputStream;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;


import static testMethods.WebCapability.driver;


public class Web {

    public static String newTabClick = Keys.chord(Keys.CONTROL,Keys.ENTER);
    public static JavascriptExecutor js = (JavascriptExecutor) driver;



    public static List<String> getRowValue (String file,String testSheet,String colName,  String rowName) throws IOException {
        FileInputStream fs = new FileInputStream(file);
        XSSFWorkbook ex = new XSSFWorkbook(fs);
        XSSFSheet xs;
        List<String> result = new ArrayList<String>();
        int noSheet = ex.getNumberOfSheets(),i=0,j=0;
        for (i=0;i<noSheet;i++){
            if(ex.getSheetName(i).equalsIgnoreCase(testSheet)){
                break;
            }
        }
        xs = ex.getSheetAt(i);
        Iterator<Row> rows = xs.iterator();
        Row firstRow = rows.next();
        Iterator<Cell> cells= firstRow.iterator();
        while (cells.hasNext()){
            if (cells.next().getStringCellValue().equalsIgnoreCase(colName)){
                break;
            }
            j++;
        }
        Iterator<Cell> reqCells = null;
        while (rows.hasNext()){
            Row reqRow = rows.next();
            if(reqRow.getCell(j).getStringCellValue().equalsIgnoreCase(rowName)){
                reqCells = reqRow.iterator();
                break;
            }
        }
        while (reqCells.hasNext()){
            Cell value = reqCells.next();
              if (value.getCellType() == CellType.STRING) {
                result.add(value.getStringCellValue());
                }else if(value.getCellType() == CellType.NUMERIC){
                  result.add(String.valueOf(value.getNumericCellValue()));
           }
              else {
                  reqCells.next();
              }
        }
        return result;
    }
    public static void hover(WebElement el) {
        Actions act = new Actions(driver);
        Action actii = act.moveToElement(el).build();
        actii.perform();
    }
    public  static void dropdownFinder(List<WebElement> el, String text, String key){
        Iterator<WebElement> dropEl = el.iterator();;
        while (dropEl.hasNext()){
            WebElement tab =dropEl.next();
            if(tab.getText().trim().equalsIgnoreCase(text)){

                if (key.isEmpty()){
                    tab.click();
                }else {
                    tab.sendKeys(key); //for new tab creation send by keyboard events
                }
                break;
            }
        }
    }
    public static void windowNavigator(){
         for(String window : driver.getWindowHandles()){
            driver.switchTo().window(window);
         }

    }
    public static void dateSelect(String year , String month , String date) throws InterruptedException {
        while(!driver.findElement(By.cssSelector(".mbsc-cal-year")).getText().equals(year)){
            driver.findElement(By.xpath("//div[@aria-label='Previous Year']")).click();
            Thread.sleep(500);
        }
        while(!driver.findElement(By.cssSelector(".mbsc-cal-month")).getText().equals(month)){
            driver.findElement(By.xpath("//div[@aria-label='Next Month']")).click();
            Thread.sleep(500);
        }
        List<WebElement> day = driver.findElements(By.cssSelector(".mbsc-cal-day-fg"));
        for (WebElement e : day) {
            if (e.getText().equals(date)) {
                e.click();
                break;
            }
        }

    }
    public static void jsExeNewWindow(URL link){
        js.executeScript("window.open('"+link+"','_blank','toolbar=true,scrollbars=true,resizable=false,top=500,left=300,width=800,height=800')");
    }
    public static void jsExeClick(WebElement el){
        js.executeScript("arguments[0].click()",el);
    }
    public static void jsExeSendkeysBYId(String el ,String text){
        js.executeScript("document.getElementById(arguments[0]).value = arguments[1]",el,text);
    }
    public static void jsWinScroll(int x , int  y){
        js.executeScript("window.scrollBy(arguments[0],arguments[1])",x,y);
    }
    public static void actionClick(WebElement el){
        Actions act = new Actions(driver);
        act.click(el).perform();
    }
    public static void staticdropdownFinder(WebElement drops,String via,String opt) throws InterruptedException {
        Select list = new Select(drops);
        String choise = via.toLowerCase().trim();
            switch (choise){
                case "index":list.selectByIndex(Integer.parseInt(opt));break;
                case "text":list.selectByVisibleText(opt);break;
                case "value":list.selectByValue(opt);break;
                default:System.out.println("Element not found");
            }
    }
}


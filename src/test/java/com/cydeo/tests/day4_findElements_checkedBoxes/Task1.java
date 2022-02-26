package com.cydeo.tests.day4_findElements_checkedBoxes;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class Task1 {
    public static void main(String[] args) throws InterruptedException {

        //TC #1: StaleElementReferenceException handling
        //1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //2. Go to https://practice.cydeo.com/add_remove_elements/
        driver.get("https://practice.cydeo.com/add_remove_elements/");
        //3. Click to “Add Element” button
        driver.findElement(By.xpath("//button[@onclick='addElement()']")).click();
        //4. Verify “Delete” button is displayed after clicking.
        WebElement deleteButton = driver.findElement(By.xpath("//button[@class='added-manually']"));
        System.out.println("deleteButton.isDisplayed() Expected: True = " + deleteButton.isDisplayed());
        //5. Click to “Delete” button.
        deleteButton.click();
        //6. Verify “Delete” button is NOT displayed after clicking.
//        List<WebElement> buttons = driver.findElements(By.tagName("button"));
//        for (WebElement button : buttons) {
//            if(button.getText().equals("Delete")){
//                System.out.println("Delete button found: Test Failed");
//            }else {
//                System.out.println("Test Passed");
//            }
//        }
        try {
            System.out.println(deleteButton.isDisplayed());
        }catch (StaleElementReferenceException e){
            System.out.println("Delete Button is not displayed!");
        }

       // USE XPATH LOCATOR FOR ALL WEBELEMENT LOCATORS

       driver.quit();
    }
}

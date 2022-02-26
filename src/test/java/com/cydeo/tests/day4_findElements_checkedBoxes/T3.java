package com.cydeo.tests.day4_findElements_checkedBoxes;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class T3 {
    public static void main(String[] args) {

        //TC #6:  XPATH LOCATOR practice
        //1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        //2. Go to http://practice.cydeo.com/multiple_buttons
        driver.get("http://practice.cydeo.com/multiple_buttons");
        //3. Click on Button 1
        driver.findElement(By.xpath("//div[@class='container']//button[@onclick='button1()']")).click();
        //4. Verify text displayed is as expected:
        //Expected: “Clicked on button one!”
        String result=(driver.findElement(By.xpath("//p[@id='result']")).getText().equals("Clicked on button one!"))?"Test PASSED":"Test FAILED!!";
        System.out.println("result = " + result);
        //USE XPATH LOCATOR FOR ALL WEBELEMENT LOCATORS
driver.quit();
    }
}

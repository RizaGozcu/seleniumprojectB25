package com.cydeo.tests.day4_findElements_checkedBoxes;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Task2 {
    public static void main(String[] args) throws InterruptedException {
        //TC #2: Radiobutton handling
        //1. Open Chrome browser
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        //2. Go to https://practice.cydeo.com/radio_buttons
        driver.get("https://practice.cydeo.com/radio_buttons");
        //3. Click to “Hockey” radio button
        WebElement hockeyBtn = driver.findElement(By.xpath("//input[@id='hockey']"));
        hockeyBtn.click();

        //Thread.sleep(3000);
        //4. Verify “Hockey” radio button is selected after clicking.
        System.out.println(hockeyBtn.isSelected());
        clickAndVerifyRadioButton(driver,"sport","basketball");

        // System.out.println("hockeyBtn.isSelected() = " + hockeyBtn.isSelected());
        //USE XPATH LOCATOR FOR ALL WEBELEMENT LOCATORS
driver.quit();
    }
    //Create a utility method to handle above logic.
    //Method name: clickAndVerifyRadioButton
    //Return type: void or boolean
    //Method args:
    //1. WebDriver
    //2. Name attribute as String (for providing which group of radio buttons)
    //3. Id attribute as String (for providing which radio button to be clicked)
    //
    //Method should loop through the given group of radio buttons. When it finds the
    //matching option, it should click and verify option is Selected.
    //Print out verification: true

    public static void clickAndVerifyRadioButton(WebDriver driver, String radioGroupAttribute,String radioId ){

        List<WebElement> radioElements = driver.findElements(By.name(radioGroupAttribute));
        for (WebElement radioElement : radioElements) {
           if( driver.findElement(By.id(radioId)).equals(radioElement)){
               radioElement.click();
               System.out.println(radioElement.isSelected());
               break;
           }
        }
    }
}

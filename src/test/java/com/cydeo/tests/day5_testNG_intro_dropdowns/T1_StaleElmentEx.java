package com.cydeo.tests.day5_testNG_intro_dropdowns;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class T1_StaleElmentEx {
    public static void main(String[] args) {

        //XPATH PRACTICES
        //DO NOT USE ANY DEVELOPER TOOLS TO GET ANY LOCATORS.
        //TC #1: StaleElementReferenceException handling
        //1. Open Chrome browser
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //2. Go to https://practice.cydeo.com/add_remove_elements/
        driver.get("https://practice.cydeo.com/add_remove_elements/");
        //3. Click to “Add Element” button
        WebElement addElementBtn= driver.findElement(By.xpath("//button[.='Add Element']"));
        addElementBtn.click();
        //4. Verify “Delete” button is displayed after clicking.
        WebElement deleteBtn=driver.findElement(By.xpath("//button[@class='added-manually']"));
        System.out.println("deleteBtn.isDisplayed() = " + deleteBtn.isDisplayed());
        //5. Click to “Delete” button.
       deleteBtn.click();

        //6. Verify “Delete” button is NOT displayed after clicking.
        try {
            deleteBtn.click();
            System.out.println("deleteBtn.isDisplayed() = " + deleteBtn.isDisplayed());
        }catch (StaleElementReferenceException e){
            System.out.println("Webelement may be deleted : ");

        }

        //USE XPATH LOCATOR FOR ALL WEBELEMENT LOCATORS
        driver.quit();
    }
}

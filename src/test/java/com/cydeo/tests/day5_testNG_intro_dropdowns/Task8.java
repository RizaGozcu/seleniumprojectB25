package com.cydeo.tests.day5_testNG_intro_dropdowns;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Task8 {
    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        //default values
        //1. Open Chrome browser
        //2. Go to https://practice.cydeo.com/dropdown
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://practice.cydeo.com/dropdown");
    }
    @Test
    public void selectAll8(){
        //TC #8: Selecting value from multiple select dropdown
        //3. Select all the options from multiple select dropdown.
        Select selectAll=new Select(driver.findElement(By.xpath("//select[@name='Languages']")));
        //4. Print out all selected values.
        selectAll.selectByVisibleText("Java");
        selectAll.selectByIndex(1);
        selectAll.selectByValue("c#");
        selectAll.selectByValue("python");
        selectAll.selectByIndex(4);
        selectAll.selectByVisibleText("C");
        //5. Deselect all values.
        selectAll.deselectByIndex(5);
        selectAll.deselectByValue("ruby");
        selectAll.deselectByVisibleText("Python");
        selectAll.deselectByIndex(2);
        selectAll.deselectByValue("js");
        selectAll.deselectByIndex(0);
    }
    @AfterMethod
    public void met(){
        driver.quit();
    }
}

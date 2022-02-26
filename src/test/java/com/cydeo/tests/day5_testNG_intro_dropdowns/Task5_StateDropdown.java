package com.cydeo.tests.day5_testNG_intro_dropdowns;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Task5_StateDropdown {
    WebDriver driver;
    @BeforeMethod
    public void setupMethod(){
        //default values
        //1. Open Chrome browser
        //2. Go to http://practice.cybertekschool.com/dropdown
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/dropdown");
    }

    @Test
    public void stateDropdown() throws InterruptedException {
        //3. Select Illinois
        Select statesDropdown=new Select(driver.findElement(By.xpath("//select[@id='state']")));
        Thread.sleep(2000);
        statesDropdown.selectByValue("IL");
        //4. Select Virginia
        Thread.sleep(2000);
        statesDropdown.selectByValue("VA");
        Thread.sleep(2000);
        //5. Select California
        statesDropdown.selectByValue("CA");
        statesDropdown.getFirstSelectedOption().getText();
        String currentSelectedState=statesDropdown.getFirstSelectedOption().getText();
        //6. Verify final selected option is California.
        Assert.assertEquals(currentSelectedState,"California");
        //Use all Select options. (visible text, value, index)
    }
}

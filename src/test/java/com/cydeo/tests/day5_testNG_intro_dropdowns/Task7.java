package com.cydeo.tests.day5_testNG_intro_dropdowns;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Task7 {
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
    public void task7() throws InterruptedException {
        //3. Click to non-select dropdown
        driver.findElement(By.xpath("//a[@class='btn btn-secondary dropdown-toggle']")).click();
        //4. Select Facebook from dropdown
        driver.findElement(By.xpath("//a[@href='https://www.facebook.com/']")).click();
        //5. Verify title is “Facebook - Log In or Sign Up”
        Assert.assertEquals(driver.getTitle(),"Facebook - Log In or Sign Up");
    }
    @AfterMethod
    public void methodAfter(){
        driver.quit();
    }
}

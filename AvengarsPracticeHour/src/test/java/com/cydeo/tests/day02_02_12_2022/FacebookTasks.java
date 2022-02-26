package com.cydeo.tests.day02_02_12_2022;

import com.cydeo.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class FacebookTasks {

    //TC #1: Facebook title verification
    //1. Open Chrome browser
    //2. Go to https://www.facebook.com
    public WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.facebook.com");
    }
    @Test
    public void checkTitle(){
        //3. Verify title:
        //Expected: “Facebook – log in or sign up”
        String expectedTitle="Facebook - Log In or Sign Up";
        Assert.assertEquals(driver.getTitle(),expectedTitle);
    }

    @Test
    public void loginTitle(){
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("ben@hotmail.com");
        driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("1233456");
        driver.findElement(By.xpath("//button[.='Log In']")).click();

        Assert.assertEquals(driver.getTitle(),"Log into Facebook");

    }



    //TC #2: Facebook incorrect login title verification
    //1. Open Chrome browser
    //2. Go to https://www.facebook.com
    //3. Enter incorrect username
    //4. Enter incorrect password
    //5. Verify title changed to:
    //Expected: “Log into Facebook”

    //TC #3: Facebook header verification
    //1. Open Chrome browser
    //2. Go to https://www.facebook.com
    //3. Verify header text is as expected:
    //Expected: “Facebook helps you connect and share with the people in your life.”
    //TC #4: Facebook header verification
    //1. Open Chrome browser
    //2. Go to https://www.facebook.com
    //3. Verify “Create a page” link href value contains text:
    //Expected: “registration_form”

    @AfterMethod
    public void tearDown(){
      //  driver.quit();
    }



}

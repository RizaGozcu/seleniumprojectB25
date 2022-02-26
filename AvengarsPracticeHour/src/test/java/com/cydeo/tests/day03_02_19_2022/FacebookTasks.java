package com.cydeo.tests.day03_02_19_2022;

import com.cydeo.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;
import static org.testng.Assert.*;
public class FacebookTasks {
    public WebDriver driver;
    @BeforeMethod
    public void setUp() {
//1. Open Chrome browser
//2. Go to https://www.facebook.com
       driver= WebDriverFactory.getDriver("chrome");
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       driver.get("https://www.facebook.com");

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }

    @Test
    public void TC1_verifying_title(){
      //TC #1: Facebook title verification
        //3. Verify title:
        //Expected: “Facebook – log in or sign up”
        // */
        String expectedTitle="Facebook - Log In or Sign Up";
        String actualTitle=driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);
    }
    @Test
    public void TC2_verifying_login_title() throws InterruptedException {
        //TC #2: Facebook incorrect login .tle verifica.on
        //1. Open Chrome browser
        //2. Go to h0ps://www.facebook.com
        //3. Enter incorrect username
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("incorrect");
        //4. Enter incorrect password
        driver.findElement(By.xpath("//div[@id='passContainer']/input")).sendKeys("incorrect"+ Keys.ENTER);
        //5. Verify title changed to:
        //Expected: “Log into Facebook”
        String expectedTitle="Log into Facebook";
        Thread.sleep(3000);
        String actualTitle=driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);

    }
    @Test
    public void TC3_verifying_header(){
        //TC #3: Facebook header verifica.on
        //1. Open Chrome browser
        //2. Go to h0ps://www.facebook.com
        //3. Verify header text is as expected:
        String expectedHeader="Connect with friends and the world around you on Facebook.";
        //Expected: “Connect with friends and the world around you on Facebook.”
        String actualHeader=driver.findElement(By.cssSelector("h2._8eso")).getText();
       assertEquals(actualHeader,expectedHeader,"verifying header ");
    }

    @Test
    public void T4_verifying_linkAttribute(){
        //TC #4: Facebook header verifica.on
        //1. Open Chrome browser
        //2. Go to h0ps://www.facebook.com
        //3. Verify “Create a page” link href value contains text:
        //Expected: “registration_form”
        String expectedWord="registration_form";
        String actualAttributeValue=driver.findElement(By.xpath("//a[contains(@href,'registration_form')]")).getAttribute("href");
        assertTrue(actualAttributeValue.contains(expectedWord));
    }


}

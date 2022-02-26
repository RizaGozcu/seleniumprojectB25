package com.cydeo.tests.day6;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AlertPractices1 {
    WebDriver driver;
    @BeforeMethod
    public void setupMethod(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://practice.cydeo.com/javascript_alerts");
    }

    @Test
    public void alert_test1(){
        //3. Click to “Click for JS Alert” button
        WebElement infoAlertBtn = driver.findElement(By.xpath("//button[.='Click for JS Alert']"));
        infoAlertBtn.click();
        //4. Click to OK button from the alert
        Alert alert = driver.switchTo().alert();
        alert.accept();
        //5. Verify “You successfully clicked an alert” text is displayed.
        WebElement resultText = driver.findElement(By.xpath("//p[@id='result']"));
        //Failure mgs will only be displayed if assertion fails: Result text is NOT displayed.
        Assert.assertTrue(resultText.isDisplayed(),"Result text is not displayed");

        String expectedText="You successfully clicked an alert";
        String actualText=resultText.getText();
        driver.quit();


    }
    @Test
    public void alert_test2(){
        //TC #2: Confirmation alert practice
        //1. Open browser
        //2. Go to website: http://practice.cydeo.com/javascript_alerts
        //3. Click to “Click for JS Confirm” button
        driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
        //4. Click to OK button from the alert
        Alert alert=driver.switchTo().alert();
        alert.accept();
        //5. Verify “You clicked: Ok” text is displayed.
        driver.findElement(By.xpath("//p[@id='result']")).isDisplayed();
    }
    @Test
    public void alert_test3(){
        //TC #3: Information alert practice
        //1. Open browser
        //2. Go to website: http://practice.cydeo.com/javascript_alerts
        //3. Click to “Click for JS Prompt” button
        driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
        //4. Send “hello” text to alert
        Alert alert=driver.switchTo().alert();
        alert.sendKeys("hello");
        //5. Click to OK button from the alert
        alert.accept();
        //6. Verify “You entered:  hello” text is displayed
        Assert.assertEquals(driver.findElement(By.xpath("//p[@id='result']")).getText(),"You entered: hello");
    }





}

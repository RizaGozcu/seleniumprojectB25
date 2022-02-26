package com.cydeo.tests.day6;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class WindowPractice {
    //TC #5: Window Handle practice
    //
    //1. Create a new class called: T5_WindowsPractice
    //2. Create new test and make set ups
    //3. Go to : https://practice.cydeo.com/windows



    public WebDriver driver;
    @BeforeMethod
    public void setupMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://practice.cydeo.com/windows");

    }
    @Test
    public void multiple_window_test(){
        String mainHandle= driver.getWindowHandle();
        //4. Assert: Title is “Windows”
        String expectedTitle="Windows";
        String actualTitle=driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);
        System.out.println("Title before click = " + actualTitle);
        //5. Click to: “Click Here” link
        WebElement click_hereLink = driver.findElement(By.linkText("Click Here"));
        click_hereLink.click();
        //6. Switch to new Window.
        Set<String>allWindowHandles=driver.getWindowHandles();
        for(String each:allWindowHandles){
            driver.switchTo().window(each);
            System.out.println("Current title while switching windows: "+driver.getTitle());
        }

        //7. Assert: Title is “New Window”
        String expectedTitleAfterClick="New Window";
        actualTitle=driver.getTitle();
        System.out.println(" title after click :"+actualTitle);
        Assert.assertEquals(actualTitle,expectedTitleAfterClick);

    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}

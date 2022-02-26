package com.cydeo.tests.day6;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class IframePractice {
    //TC #4: Iframe practice
    //
    //1. Create a new class called: T4_Iframes
    //2. Create new test and make set ups
    //3. Go to: https://practice.cydeo.com/iframe
    //4. Assert: “Your content goes here.” Text is displayed.
    //5. Assert: “An iFrame containing the TinyMCE WYSIWYG Editor”

    public WebDriver driver;
    @BeforeMethod
    public void setupMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://practice.cydeo.com/iframe");

    }
    @Test
    public void iFrame(){
        // we need to switch driver focus to iframe

        //option1: switching to iframe using id attribute value
      //driver.switchTo().frame("mce_0_ifr");
        // option2: passing index num of iframe
       // driver.switchTo().frame(0);
        //option3: locate as web element and pass in frame() method
        driver.switchTo().frame((driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"))));
        WebElement yourContGoesHereText=driver.findElement(By.xpath("//p"));
        Assert.assertTrue(yourContGoesHereText.isDisplayed());

        driver.switchTo().parentFrame();

        WebElement headerText = driver.findElement(By.xpath("//h3"));
        assert headerText.isDisplayed();

        driver.quit();

    }

    @Test
    public void iframeEx(){

        //4. Assert: “Your content goes here.” Text is displayed.
        driver.switchTo().frame((driver.findElement(By.xpath("//p[.='Your content goes here.']"))));

        //5. Assert: “An iFrame containing the TinyMCE WYSIWYG Editor”
    }

}

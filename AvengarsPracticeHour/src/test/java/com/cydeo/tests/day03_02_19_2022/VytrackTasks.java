package com.cydeo.tests.day03_02_19_2022;

import com.cydeo.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class VytrackTasks {

    public WebDriver driver;
    @BeforeMethod
    public void setUp() {
//1. Open Chrome browser
//2- Go to “https://vytrack.com/”
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://vytrack.com/");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
    @Test
    public void TC01_verifying_header_labels() {


        //TC 1- As a user I should be able to see the labels [“Home”,”About us”,”Our Approach”,”Products and Services”,”Contact”,”LOGIN”]
        List<WebElement> listOfHeaderWebElements = driver.findElements(By.xpath("//ul[@id='top-menu']/li/a"));
        // solution1:
//        for (WebElement each : listOfHeaderWebElements) {
//            Assert.assertTrue(each.isDisplayed());
//        }
        //solution2:
        List<String> expectedHeaderLabel = new ArrayList<>(Arrays.asList("Home", "About us", "Our Approach", "Products and Services", "Contact", "LOGIN"));
//        for (WebElement each : listOfHeaderWebElements) {
//            Assert.assertTrue(expectedHeaderLabel.contains(each.getText()));
//        }
        // solution3:
        List<String> actualHeaderLabels = new ArrayList<>();
        for (WebElement each : listOfHeaderWebElements) {
            actualHeaderLabels.add(each.getText());
        }
        Assert.assertEquals(actualHeaderLabels, expectedHeaderLabel);
        //3- Verify that [“Home”,”About us”,”Our Approach”,”Products and Services”,”Contact”,” LOGIN”] is displayed
    }
    @Test
    public void TC02_() throws InterruptedException {
        //TC 2- As a user I should be able to see the labels [“Our Mission and Vision”,”Car Fleet Management”,”Newest Technologies”,””]
        // under Our Approach
        //3- Verify that [“Our Mission and Vision”,”Car Fleet Management”] is displayed
        driver.findElement(By.xpath("//ul[@id='top-menu']/li[3]/a")).click();
        Thread.sleep(3000);
        List<WebElement> webElementList = driver.findElements(By.xpath("//ul[@id='top-menu']/li[3]/ul/li/a"));
        List<String>actualTextOfWebElements=new ArrayList<>();

        for (WebElement element : webElementList) {
            actualTextOfWebElements.add(element.getText());
        }
        List<String> expectedTextsOfWebElements=new ArrayList<>(Arrays.asList("Our Mission and Vision","Car Fleet Management","Newest Technologies","Tailor Made Solutions"));

        Assert.assertEquals(actualTextOfWebElements, expectedTextsOfWebElements);
    }


}

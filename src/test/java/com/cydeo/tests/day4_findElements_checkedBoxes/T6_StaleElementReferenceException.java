package com.cydeo.tests.day4_findElements_checkedBoxes;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class T6_StaleElementReferenceException {

    public static void main(String[] args) {

        //TC #6: StaleElementReferenceException Task
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        //Providing extra wait time for our driver before it throws NoSuchElementException
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //2- Go to: https://practice.cydeo.com/abtest
        driver.get("https://practice.cydeo.com/abtest");
        //<a target="_blank" href="https://cydeo.com/">CYDEO</a>
        //3- Locate “CYDEO” link, verify it is displayed.
        WebElement cydeoLink = driver.findElement(By.xpath("//a[text()='CYDEO']"));
        System.out.println(cydeoLink.isDisplayed());
        //4- Refresh the page.
        driver.navigate().refresh();
        // we are refreshing using the web element reference by re-assigning (re-locating) web element
        cydeoLink = driver.findElement(By.xpath("//a[text()='CYDEO']"));
        //5- Verify it is displayed, again.

        System.out.println(cydeoLink.isDisplayed());
        driver.quit();
    }

}

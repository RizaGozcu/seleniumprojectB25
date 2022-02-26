package com.cydeo.tests.day4_findElements_checkedBoxes;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class T4_findElements {
    public static void main(String[] args) {

        //TC #4: FindElements Task
        //1- Open a chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        //2- Go to: https://practice.cydeo.com/abtest
        driver.get("https://practice.cydeo.com/abtest");
        //3- Locate all the links in the page.
        List<WebElement>allLinks=driver.findElements(By.tagName("a"));
        //System.out.println("allLinks = " + allLinks);
        //4- Print out the number of the links on the page.
        System.out.println(allLinks.size());
        //5- Print out the texts of the links.
        for (WebElement each : allLinks) {
            System.out.println(each.getText());
            System.out.println(each.getAttribute("href"));
        }

        //6- Print out the HREF attribute values of the links
        driver.quit();
    }
}

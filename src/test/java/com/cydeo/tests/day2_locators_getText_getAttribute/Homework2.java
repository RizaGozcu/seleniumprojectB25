package com.cydeo.tests.day2_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class Homework2 {
    /*
    TC #2: Zero Bank header verification
3. Verify header text
Expected: “Log in to ZeroBank”
     */
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        //1. Open Chrome browser
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        //2 Go to http://zero.webappsecurity.com/login.html
        driver.get("http://zero.webappsecurity.com/login.html");
        WebElement header=driver.findElement(By.tagName("h3"));
        String actualHeader=header.getText();
        String expectedHeader="Log in to ZeroBank";
        String result=(actualHeader.equals(expectedHeader))?"Header Test Match!: "+actualHeader:"Not Match: "+actualHeader;
        System.out.println(result);
        driver.close();
    }
}

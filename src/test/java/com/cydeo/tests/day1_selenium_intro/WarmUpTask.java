package com.cydeo.tests.day1_selenium_intro;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WarmUpTask {

    public static void main(String[] args) {
//        TC #1: Cydeo practice tool verifications
        // set up browser environment
        WebDriverManager.chromedriver().setup();
        // creating driver object
        WebDriver driver=new ChromeDriver();
       // 1. Open Chrome browser
        driver.navigate();
        //2. Go to https://practice.cydeo.com
        driver.navigate().to("https://practice.cydeo.com");
        //3. Verify URL contains
             //        Expected: cydeo
        String url=driver.getCurrentUrl(); // get the current url
        boolean isUrlContainsCydeo=url.contains("cydeo"); // condition
        System.out.println("isUrlContainsCydeo = " + isUrlContainsCydeo);
        //        4. Verify title:
       //        Expected: Practice
        String actualTitle =driver.getTitle();// get the web page title from browser
        String expectedTitle="Practice";
        boolean isTitleAsExpected= actualTitle.equals(expectedTitle); // compare actual with expected
        System.out.println("isTitleAsExpected = " + isTitleAsExpected);
        driver.quit();
    }
}

package com.cydeo.tests.day01_05_2022;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC04 {
    public static void main(String[] args) {
        /*
        //Setup the "browser driver"

        //Go to "https://www.google.com"

        //Verify the title contains "Google"

        //Navigate to "https://www.etsy.com"

        //Verify not in google page

        //Verify the title  contains "Etsy
         */
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.google.com");
        if(driver.getTitle().contains("Google")){
            System.out.println("Test Passed");
        }else{
            System.out.println("TEST FAILED");
        }
        driver.navigate().to("https://www.etsy.com");
        if(!(driver.getTitle().contains("Google"))){
            System.out.println("Test Passed");
        }else{
            System.out.println("Test Failed");
        }
        driver.close();

    }
}

package com.cydeo.tests.day01_05_2022;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC02 {
    public static void main(String[] args) {

        /*

 //Setup the "browser driver"

        //Go to "https://www.selenium.dev"

        //Verify the title contains "Selenium"
         */
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.selenium.dev");

        if(driver.getTitle().contains("Selenium")){
            System.out.println("Test Passed");
        }else{
            System.err.println("Test Failed");
        }
        driver.close();

    }
}

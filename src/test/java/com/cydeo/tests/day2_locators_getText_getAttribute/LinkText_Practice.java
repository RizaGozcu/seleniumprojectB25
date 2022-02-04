package com.cydeo.tests.day2_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinkText_Practice {

    public static void main(String[] args) throws InterruptedException {


        WebDriverManager.chromedriver().setup();
        //TC #3: Back and forth navigation
        //1- Open a Chrome browser
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        //2- Go to: https://practice.cydeo.com
        driver.get("https://practice.cydeo.com");
        Thread.sleep(5000);
        //3- Click to A/B Testing from top of the list.
      //  driver.findElement(By.linkText("A/B Testing")).click();
        WebElement abTesting= driver.findElement(By.linkText("A/B Testing"));
        abTesting.click();
        //4- Verify title is:
        //Expected: No A/B Test
        String expectedTitle="No A/B Testing";
        String actualTitle=driver.getTitle();
        if(actualTitle.equals(expectedTitle)){
            System.out.println("Title verification Pass!");
        }else{
            System.out.println("Title verification failed!");
        }
        //5- Go back to home page by using the .back();
        Thread.sleep(3000);
        driver.navigate().back();
        //6- Verify title equals:
        Thread.sleep(3000);
        expectedTitle="Practice";
         actualTitle=driver.getTitle();
        //Expected: Practice

        if (actualTitle.equals(expectedTitle)){
            System.out.println("Title verification PASSED!");
        }else{
            System.out.println("Title verification FAILED!!!");
        }

        driver.close();
    }
}

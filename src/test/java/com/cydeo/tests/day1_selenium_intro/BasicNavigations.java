package com.cydeo.tests.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigations {
    public static void main(String[] args) throws InterruptedException {

        // 1- setup the "browser driver"
        WebDriverManager.chromedriver().setup();

        // 2- Create instance of the Selenium WebDriver

        WebDriver driver=new ChromeDriver(); // this line is opening an empty browser


        driver.manage().window().maximize(); // Maximize the browser size
        driver.manage().window().fullscreen();
        //3- Go to https://www.tesla.com
        driver.get("https://www.tesla.com");



        // get the title of the page
        System.out.println("driver.getTitle() = " + driver.getTitle());
        String currentTitle= driver.getTitle();
        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());

        Thread.sleep(4000);

        // use Selenium to navigate back
        driver.navigate().back();

        Thread.sleep(3000); //wait 3 secs

        // use Selenium to forward
        driver.navigate().forward();

        Thread.sleep(3000);
        // use selenium to navigate refresh
        driver.navigate().refresh();

        Thread.sleep(3000);

        // use navigate().to()
        driver.navigate().to("https://www.google.com");

        currentTitle=driver.getTitle();// reassign the variable title

        System.out.println(currentTitle);

        //Get current url using Selenium
        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());

        driver.close(); // closing current browser

        // this will close all of the opened windows
        driver.quit();





    }
}

package com.cydeo.tests.day2_locators_getText_getAttribute;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class HW3 {
    /*
    TC #3: Back and forth navigation
1- Open a chrome browser
2- Go to: https://google.com
3- Click to Gmail from top right.
4- Verify title contains:
  Expected: Gmail
5- Go back to Google by using the .back();
6- Verify title equals:
  Expected: Google
     */
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://google.com");
        driver.findElement(By.className("gb_d")).click();
        String title=driver.getTitle();
        String result=(title.contains("Gmail"))?"Expected Result: "+title:"NOT EXPECTED :"+title;
        driver.navigate().back();
        String result2=(driver.getTitle().equals("Google"))?"Title as EXPECTED: "+driver.getTitle():"Not As Expected (Google)vs "+driver.getTitle();
        System.out.println(result);
        System.out.println(result2);
    }
}

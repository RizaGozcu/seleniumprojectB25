package com.cydeo.tests.day2_locators_getText_getAttribute;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class HW4 {
    /*
    TC #4: Practice Cydeo – Class locator practice
1- Open a chrome browser
2- Go to: https://practice.cydeo.com/inputs
3- Click to “Home” link
4- Verify title is as expected:
Expected: Practice
PS: Locate “Home” link using “className” locato
     */
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://practice.cydeo.com/inputs");
        WebElement homeNav=driver.findElement(By.className("nav-link"));
        homeNav.click();
        String result=(driver.getTitle()).equals("Practice")?"Verification Passed":"Verification FAILED";
        System.out.println(result);
        driver.close();
    }
}

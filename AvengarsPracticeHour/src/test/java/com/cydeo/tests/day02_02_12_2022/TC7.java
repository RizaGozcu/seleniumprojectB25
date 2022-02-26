package com.cydeo.tests.day02_02_12_2022;

import com.cydeo.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class TC7 {
    public static void main(String[] args) throws InterruptedException {
        // TC:7 As a user I should be able to see User is John Doe
        //1-open a chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        //2-goto https://vytrack.com/
        driver.get("https://vytrack.com/");
        //3-click Login label
        driver.findElement(By.xpath("//ul[@id='top-menu']/li[6]")).click();
        //4-enter username "User1"
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("User1");
        //5-enter password "UserUser123"
        driver.findElement(By.xpath("//input[@type='password'][@id='prependedInput2']")).sendKeys("UserUser123");
        //6-click LOG IN
        driver.findElement(By.xpath("//div[@class='form-signin__footer control-group form-row']/button[@type='submit']")).click();
        //7-verify the user John Doe
        Thread.sleep(1000);//why we need this delay?
        String actualName = driver.findElement(By.xpath("//a[@href='javascript: void(0);']")).getText().trim();
        String result=(actualName.equals("John Doe"))?"Name PASSED!":"NAME FAILED!!!!";
        System.out.println("result = " + result);
        driver.quit();

    }
}

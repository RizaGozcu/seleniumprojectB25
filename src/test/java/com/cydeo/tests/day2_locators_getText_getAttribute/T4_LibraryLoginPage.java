package com.cydeo.tests.day2_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T4_LibraryLoginPage {
    public static void main(String[] args) throws InterruptedException {

        /*
        TC #4: Library verifications
1.
2.


PS: Locate username input box using “className” locator
Locate password input box using “id” locator
Locate Sign in button using “tagName” locator
         */
        WebDriverManager.chromedriver().setup();
       // Open Chrome browser
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
      //  Go to http://library2.cybertekschool.com/login.html
        driver.get("https://library2.cybertekschool.com/login.html");

       // 3. Enter username: “incorrect@email.com”
        WebElement userNameInput=driver.findElement(By.className("form-control"));
        userNameInput.sendKeys("incorrect@email.com");
     //   4. Enter password: “incorrect password”
        WebElement userPasscode=driver.findElement(By.id("inputPassword"));
        userPasscode.sendKeys("incorrect password");
      //  5. Click on Sign In Button
       WebElement signInButton=driver.findElement(By.tagName("button"));
       signInButton.click();


        Thread.sleep(5000);
driver.close();

    }
}

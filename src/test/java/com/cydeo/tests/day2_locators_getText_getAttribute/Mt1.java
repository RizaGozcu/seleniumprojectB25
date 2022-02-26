package com.cydeo.tests.day2_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Mt1 {
    public static void main(String[] args) {
        /*

         */
       // TC #1: NextBaseCRM, locators and getText() practice
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        //2- Go to: https://login1.nextbasecrm.com/
        driver.get("https://login1.nextbasecrm.com/");
        //3- Enter incorrect username: “incorrect”
        WebElement userBox=driver.findElement(By.name("USER_LOGIN"));
        userBox.sendKeys("incorrect");
        //4- Enter incorrect password: “incorrect”
        WebElement userPassword=driver.findElement(By.name("USER_PASSWORD"));
        userPassword.sendKeys("incorrect");
        //5- Click to login button.
        WebElement logInBTN=driver.findElement(By.className("login-btn"));
        logInBTN.click();
        //6- Verify error message text is as expected:
        //Expected: Incorrect login or password
        WebElement errMsg=driver.findElement(By.className("errortext"));
        String actualErrorMessage= errMsg.getText();
        String expectedErrorMessage="Incorrect login or password";
        if(actualErrorMessage.equals(expectedErrorMessage)){
            System.out.println("Error Text Message PASSED!");
        }else{
            System.err.println("Error Text Message FAILED");
        }
        driver.close();



    }
}

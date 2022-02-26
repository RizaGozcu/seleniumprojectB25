package com.cydeo.tests.day2_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MT2 {
    public static void main(String[] args) {

        /*
        TC #2: NextBaseCRM, locators, getText(), getAttribute() practice
1- Open a chrome browser
         */

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        //2- Go to: https://login1.nextbasecrm.com/
        driver.get("https://login1.nextbasecrm.com/");
        WebElement rmbrTxtBox=driver.findElement(By.className("login-item-checkbox-label"));
        //3- Verify “remember me” label text is as expected:
        String actualTxt= rmbrTxtBox.getText();
        String expectedText="Expected: Remember me on this computer";

        if(actualTxt.equals(expectedText)){
            System.out.println("Test PASSED");
        }else{
            System.out.println("Test FAILED");
        }
        //4- Verify “forgot password” link text is as expected:
        //Expected: Forgot your password?
        WebElement forgetTxt=driver.findElement(By.linkText("Forgot your password?"));
        String actualforText=forgetTxt.getText();
        String expectedForText="forgot password";

        if(actualforText.equals(expectedForText)){
            System.out.println("Forget Password Text PASSED");
        }else{
            System.out.println("Forget Password Txt FAILED");
        }

       // 5- Verify “forgot password” href attribute’s value contains expected:
       // Expected: forgot_password=yes
        WebElement passForget= driver.findElement(By.linkText("Forgot your password?"));
       String actualPassForTxt= passForget.getAttribute("href");
       String expectedPassForTxt="forgot_password=yes";
       if(actualPassForTxt.equals(expectedPassForTxt)){
           System.out.println("Test PASSED");
       }else{
           System.out.println("Test FAILED");
       }

driver.close();



    }
}

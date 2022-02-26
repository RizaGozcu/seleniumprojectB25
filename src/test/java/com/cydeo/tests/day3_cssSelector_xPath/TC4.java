package com.cydeo.tests.day3_cssSelector_xPath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TC4 {
    public static void main(String[] args) {

        WebDriver driver= WebDriverFactory.getDriver("CHROME");
        driver.manage().window().maximize();
        driver.get("https://login1.nextbasecrm.com/?forgot_password=yes ");
        //<button class="login-btn" value="Reset password" onclick="BX.addClass(this, 'wait');">Reset password</button>
   // driver.findElement(By.cssSelector("button[class='login-btn']"));
        WebElement resetButtonText = driver.findElement(By.cssSelector("button[value='Reset password']"));
        String actualButtonText=resetButtonText.getText();
        String expectedButtonText="Reset password";
        if(actualButtonText.equals(expectedButtonText)){
            System.out.println("Password reset button text PASSED");
        }else{
            System.err.println("Password reset button text FAILED!!");
        }
        driver.quit();
    }
}
/*
TC #4: NextBaseCRM, locators, getText(), getAttribute() practice
1- Open a chrome browser
2- Go to: https://login1.nextbasecrm.com/?forgot_password=yes
3- Verify “Reset password” button text is as expected:
Expected: Reset password

PS: Inspect and decide which locator you should be using to locate web
elements.
PS2: Pay attention to where to get the text of this button from
 */


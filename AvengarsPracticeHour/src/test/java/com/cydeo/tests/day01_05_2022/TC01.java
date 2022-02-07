package com.cydeo.tests.day01_05_2022;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC01 {
   private static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {
        //- Go to "https://app.vytrack.com/user/login"
        forEachVerification("https://app.vytrack.com/user/login");



        //- Verify the url contains "vytrack"
       // verifyingURLContains("vytrack");



        //- Verify the title contains "Login"
       // verifyingTitleContains("Login");



        //- Verify the label "Login"
        verifyingLabel("Login");

        //login
        login("abc","123");



        //- Verify the message "Invalid user name or password"
        verifyingMessage("Invalid username or password");
       // driver.close();
    }

    private static void verifyingMessage(String invalid_username_or_password) {
        WebElement messageElement = driver.findElement(By.className("alert"));
        String actualMessage = messageElement.getText();
        String expectedMessage="Invalid user name or password";
        if(actualMessage.equals(expectedMessage)){
            System.out.println("Message test PASSED");
        }else{
            System.err.println("Message test FAILED");
        }


    }

    private static void login(String username, String password) {
        WebElement userNameBox = driver.findElement(By.id("prependedInput"));
        userNameBox.sendKeys(username);
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement passwordBox = driver.findElement(By.id("prependedInput2"));
        passwordBox.sendKeys(password);
        driver.findElement(By.id("_submit")).click();

    }

    private static void verifyingLabel(String expectedLabel) {
        WebElement labelElement = driver.findElement(By.tagName("h2"));
        String actualElementText = labelElement.getText();
        if(actualElementText.equals(expectedLabel)){
            System.out.println("Label is PASSED");
        }
        else{
            System.err.println("Label is FAILED");
        }

    }

    private static void verifyingTitleContains(String expectedWord) {
        String actualTitle = driver.getTitle();
        if(actualTitle.contains(expectedWord)){
            System.out.println("Title is PASSED");
        }else{
            System.err.println("Title is FAILED");
        }
    }

    private static void verifyingURLContains(String expectedWord) {
        String actualURL =driver.getCurrentUrl();
        if(actualURL.contains(expectedWord)){
            System.out.println("URL is PASSED");
        }else{
            System.err.println("URL is FAILED");
        }
    }

    private static void forEachVerification(String url) {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
    }

}

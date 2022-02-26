package com.cydeo.tests.day5_testNG_intro_dropdowns;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T4_SimpleDropdowns {
    WebDriver driver;
    @BeforeMethod
    public void setupMethod(){
        //default values
        //1. Open Chrome browser
        //2. Go to https://practice.cydeo.com/dropdown
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://practice.cydeo.com/dropdown");
    }

    @Test
    public void simpleDropdownTest(){
        //TC#4: Verifying “Simple dropdown” and “State selection” dropdown

        //3. Verify “Simple dropdown” default selected value is correct
        Select simpleDropdown=new Select(driver.findElement(By.xpath("//select[@id='dropdown']")));
        WebElement currentlySelectedOption = simpleDropdown.getFirstSelectedOption();
        String actualSimpleDropdownText=currentlySelectedOption.getText();
        String expectedSimpleDropdownText="Please select an option";
        System.out.println("actualSimpleDropdownText = " + actualSimpleDropdownText);

        Assert.assertEquals(actualSimpleDropdownText,expectedSimpleDropdownText);

        //Expected: “Please select an option”
        //4. Verify “State selection” default selected value is correct

        Select stateDropdown=new Select(driver.findElement(By.xpath("//select[@id='state']")));
        String expectedStateDropdownText="Select a State";
        String actualStateDropdownText=stateDropdown.getFirstSelectedOption().getText();

        Assert.assertEquals(actualSimpleDropdownText,actualStateDropdownText);

        //Expected: “Select a State”
    }

}

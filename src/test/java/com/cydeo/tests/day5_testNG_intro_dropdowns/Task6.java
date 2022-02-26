package com.cydeo.tests.day5_testNG_intro_dropdowns;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Task6 {
    WebDriver driver;
    @BeforeMethod
    public void setupMethod(){
    //default values
    //1. Open Chrome browser
    //2. Go to https://practice.cydeo.com/dropdown
    driver= WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://practice.cydeo.com/dropdown");
    }
    @Test
    public void selectDate(){
        Select yearSelect=new Select(driver.findElement(By.xpath("//select[@id='year']")));
        //3. Select “December 1st, 1922” and verify it is selected.
        //Select year using  : visible text
        yearSelect.selectByVisibleText("1925");
        //Select month using   : value attribute
        Select monthSelect=new Select(driver.findElement(By.xpath("//select[@id='month']")));
        monthSelect.selectByValue("11");
        //Select day using : index number
        Select selectDay=new Select(driver.findElement(By.xpath("//select[@id='day']")));
        selectDay.selectByIndex(0);
    }
}

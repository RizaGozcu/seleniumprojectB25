package com.cydeo.tests.day5_testNG_intro_dropdowns;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class RadioButton_cont {
    public static void main(String[] args) {

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        //2. Go to https://practice.cydeo.com/radio_buttons
        driver.get("https://practice.cydeo.com/radio_buttons");

        // locate name='sports' radio buttons and store them in a list of web element
        List<WebElement> sportRadioBttns=driver.findElements(By.name("sport"));
        // loop through each element then select matching result "hockey"
        for (WebElement each : sportRadioBttns) {
            String eachId=each.getAttribute("id");
            System.out.println("eachId = " + eachId);
            if(eachId.equals("hockey")){
                each.click();
                System.out.println("Hockey is selected: "+ each.isSelected());
                break;
            }
        }

            clickAndVerifyRadioButton(driver,"color","blue");

        driver.quit();

    }
    private static void clickAndVerifyRadioButton(WebDriver driver, String nameAttribute, String idValue){
        List<WebElement>radioButtons=driver.findElements(By.name(nameAttribute));
        for (WebElement each : radioButtons) {
            String eachId=each.getAttribute("id");
            if(eachId.equals(idValue)){
                each.click();
                System.out.println(eachId+" is selected: "+ each.isSelected());
                break;
            }
        }

    }
}

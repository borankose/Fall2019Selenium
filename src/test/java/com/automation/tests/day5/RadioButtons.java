package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class RadioButtons {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().version("79").setup();

        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/radio_buttons");
        driver.manage().window().maximize();
        BrowserUtils.wait(2);

        List<WebElement> radioButtons = driver.findElements(By.tagName("input"));


        for (WebElement radioButton : radioButtons) {
            // <input type ="radio" id="red" name="color>
            String id= radioButton.getAttribute("id");

            // return true if button already clicked
            boolean isSelected = radioButton.isSelected();
            System.out.println(id+" is selected? "+ isSelected);

            if (radioButton.isEnabled()){
                //if button is eligible to click
                // returns true of you can click on the button
                radioButton.click();
                System.out.println("CLick on :: "+ id);
                BrowserUtils.wait(1);
            }else {
                System.out.println("Button is disable, not click :: "+id);
            }
            System.out.println();
        }

driver.quit();
    }

    }


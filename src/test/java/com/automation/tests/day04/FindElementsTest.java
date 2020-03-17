package com.automation.tests.day04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class FindElementsTest {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/");

        Thread.sleep(3000);

        //how to collect all links from the page
        List<WebElement> links = driver.findElements(By.tagName("a"));

        for (WebElement link: links) {
            System.out.println(link.getText());
            System.out.println(link.getAttribute("href"));
            System.out.println();

        }

        for (int i = 1; i < links.size(); i++) {// int i=1 to skip first "home" button

            links.get(i).click();
            Thread.sleep(4000);

            driver.navigate().back();
            Thread.sleep(4000);
            //refresh List
           links= driver.findElements(By.tagName("a"));
        }

        driver.quit();
    }

}

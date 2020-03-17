package com.automation.tests.warmup;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.swing.*;

public class March4 {

    public static void main(String[] args) throws InterruptedException {
       ebayTask();

    }

    public static void ebayTask() throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("http://ebay.com");
        Thread.sleep(2000);
        driver.findElement(By.id("gh-ac")).sendKeys("java book");
        Thread.sleep(2000);
        driver.findElement(By.id("gh-btn")).click();
        Thread.sleep(7000);

        System.out.println(driver.findElement(By.tagName("h1")).getText());
        System.out.println(driver.findElement(By.tagName("h1")).getText().split(" ")[0]);
      driver.quit();
    }

    public static void amazonTask() {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.get("http://amazon.com");

    }

    public static void wikiTask() {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("http://wikipedia.com");
    }


}

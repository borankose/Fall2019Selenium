package com.automation.tests.day02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BasicNavigation {

    public static void main(String[] args) throws InterruptedException {
        // to start selenium script we need:
        // setup WebDriver(browser driver) and create WebDriver Object
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        // In selenium, everything starts from WebDriver interface
        // RemoteWebDriver you can use with all browsers
        driver.get("http://google.com");// to open a website
        driver.manage().window().maximize();// to maximize browser
        //driver.manage().window().fullscreen();

        Thread.sleep(20000);// for demo, wait 9 seconds
        // method that return page title
        // you can also see it as tab name, in the browser
        String title = driver.getTitle();//returns <title>Some title</title> text
        String expectedTitle = "Google";
        System.out.println("Title is ..."+title);

        if (expectedTitle.equals(title)){
            System.out.println("TEST PASSED!");
        }else {
            System.out.println("TEST FAILED!");
        }

        driver.navigate().to("http://amazon.com");
        if (driver.getTitle().toLowerCase().contains("amazon")){
            System.out.println("TEST PASSED!");
        }else {
            System.out.println("TEST FAILED!");
        }
        // come back to google
        driver.navigate().back();
        // checking if page title is equals to Google
        //.getTitle() - returns page title
        verifyEquals(driver.getTitle(), "Google");
        // move forward in the browser history
        driver.navigate().forward();
      Thread.sleep(9000);// for demo, wait 9 sec


        System.out.println("Title: " + driver.getTitle());
        //driver.getTitle() - returns page title of page that is currently opened
        //to get URL
        System.out.println("URL: "+driver.getCurrentUrl());
        driver.navigate().refresh();// to reload the page
        Thread.sleep(9000);// for demo, wait 9 sec

        //driver.navigate().to() = driver.get()
        //must be at the end
        driver.close();
        // browser cannot close itslef
    }

    /**
     * Check if to strings are same. If print TEST PASSED! message.
     * Otherwise, print TEST FAILED message
     * @param arg1
     * @param arg2
     */
    public static void verifyEquals(String arg1,String arg2){
        if(arg1.equals(arg2)){
            System.out.println("TEST PASSED!");
        }else {
            System.out.println("TEST FAILED");
        }

}






}

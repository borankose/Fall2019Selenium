package com.automation.tests.day02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class JumpToTheNewWindow {

    public static void main(String[] args) throws Exception {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/open_new_tab");

        Thread.sleep(10000);

        // Every window has some id, this id calls window handle
        // based on window handle, we can switch is between windows
        String windowHandle = driver.getWindowHandle();

        System.out.println(windowHandle);
        System.out.println("Before switch: " + driver.getCurrentUrl());
        // etWindowHandles() - returns id's of all currently opened windows
        // Set - doesn't allowed duplicate
        Set<String> windowHandles = driver.getWindowHandles();

        System.out.println(windowHandles);

        //driver.switchTo().window();
        // since we have all windows
        // and we know id of original window
        // we can say switch to something that is not equals to old window id
        for (String windowId :
                windowHandles) {
            if (!windowId.equals(windowHandle)) {
                // to jump to the new window
                driver.switchTo().window(windowId);
            }
        }
        Thread.sleep(10000);
        System.out.println("After switch: " + driver.getCurrentUrl());
       // driver.close();
        driver.quit();




    }

    public static void switchToWindowBasedOnTitle(String pageTitle, WebDriver driver) {
        Set<String> windows = driver.getWindowHandles();
        for (String window : windows) {
            driver.switchTo().window(window);
            if (driver.getTitle().equals(pageTitle)) {
                break;
            }
        }


    }


}

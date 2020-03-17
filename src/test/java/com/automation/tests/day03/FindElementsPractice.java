package com.automation.tests.day03;

import com.automation.utilities.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementsPractice {

    public static void main(String[] args) throws InterruptedException {
       // WebDriverManager.chromedriver().setup();
        //WebDriver driver = new ChromeDriver();

        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/sign_up");
        driver.manage().window().maximize();
        WebElement fullName= driver.findElement(By.name("full_name"));
        fullName.sendKeys("Boran Kose");

        Thread.sleep(2000);

        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("sdet@cybertek.com");

        Thread.sleep(2000);

        WebElement signUp= driver.findElement(By.name("wooden_spoon"));
        // when you see type="submit" , you can use submit() instead ofe click()
        // it make sense to use when click() method doesn't work
        signUp.submit();

        Thread.sleep(2000);

        String expected = "Thank you for signing up. Click the button below to return to the home page.";
        System.out.println("expected message = " + expected);
        WebElement message = driver.findElement(By.className("subheader"));

        String actual = message.getText();

        System.out.println("actual message = " + actual);

        if (expected.equals(actual)){
            System.out.println("TEST PASSED!");
        }else {
            System.out.println("TEST FAILED!");
        }


        driver.quit();//to close everything
    }
}

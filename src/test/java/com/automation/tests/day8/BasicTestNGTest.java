package com.automation.tests.day8;

import org.testng.Assert;
import org.testng.annotations.*;

import javax.sound.midi.Soundbank;

public class BasicTestNGTest {

    ////runs only once before @BeforeClass after @BeforeMethod
    @BeforeTest
    public void beforeTest() {
        System.out.println("BEFORE TEST");
    }

    //runs only once after @AfterClass after @AfterMethod
    @AfterTest
    public void afterTest() {
        System.out.println("AFTER TEST");
    }


    //Runs only once in the class before @BeforeMethod and before any test
    //regardless on number of tests, it runs only once
    @BeforeClass
    public void beforeClass() {
        // spomething that should be done only once in the class before all tests
        System.out.println("BEFORE CLASS!");
    }

    @AfterClass
    public void afterClass() {
        //something that should be done only once in the class after all tests
        System.out.println("AFTER CLASS!");
    }


    //runs before every test automatically
    //works as a pre-condition or setup
    @BeforeMethod
    public void setup() {
        System.out.println("BEFORE METHOD");
    }

    //runs automatically after every test
    @AfterMethod
    public void teardown() {
        System.out.println("AFTER METHOD");
    }

    //annotation
    @Test
    public void test1() {
        System.out.println("TEST 1");
        String expected = "apple";
        String actual = "apple";
        // to verify if expected result is equals to actual
        Assert.assertEquals(actual, expected);

    }

    @Test
    public void test2() {
        System.out.println("TEST 2");
        int num1 = 5;
        int num2 = 10;
        // it calls hard assertion
        // if assertion fails - it stops the execution ( due to exception).
        Assert.assertTrue(num1 < num2);
    }
}
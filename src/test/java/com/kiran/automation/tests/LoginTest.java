package com.kiran.automation.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class LoginTest {

    WebDriver driver;

    @BeforeMethod
    public void setup() {

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://practicetestautomation.com/practice-test-login/");
    }

    @Test
    public void loginTest() {

        WebElement username =
                driver.findElement(By.id("username"));

        username.sendKeys("student");

        WebElement password =
                driver.findElement(By.id("password"));

        password.sendKeys("Password123");

        WebElement loginBtn =
                driver.findElement(By.id("submit"));

        loginBtn.click();

        
        // Actual text after login
        String actualText =
                driver.findElement(By.tagName("h1")).getText();

        // Expected text
        String expectedText =
                "Logged In Successfully";

        // Assertion
        Assert.assertEquals(actualText, expectedText);

        System.out.println("Login Test Passed");

    }

    @AfterMethod
    public void tearDown() {

        driver.quit();
    }
}
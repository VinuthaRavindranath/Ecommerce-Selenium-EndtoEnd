package org.ecomm.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;

    public WebDriver openBrowser(String browserName) {
        switch (browserName) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "safari":
                driver = new SafariDriver();
                break;
            default:
                System.out.println("Please provide a valid browser name");
                break;
        }
        driver.manage().window().maximize();
        return driver;
    }

    @BeforeMethod
    public WebDriver startDriver() {
        return driver = openBrowser("chrome");
    }


    @AfterMethod
    public void closeDriver() {
        if (driver != null) {
            driver.close();
        }
    }
}

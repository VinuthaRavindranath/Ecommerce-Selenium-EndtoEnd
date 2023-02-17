package org.ecomm.base;

import org.ecomm.constants.DriverType;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {
    protected WebDriver driver;


    public WebDriver openBrowser() throws IOException {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/GlobalData.properties");
        prop.load(fis);
        String browserName = System.getProperty("browser") != null ? System.getProperty("browser") : prop.getProperty("browser");

        switch (DriverType.valueOf(browserName)) {
            case CHROME:
                driver = new ChromeDriver();
                break;
            case  CHROME_HEADLESS:
                ChromeOptions options = new ChromeOptions();
                options.addArguments("headless");
                driver = new ChromeDriver(options);
                driver.manage().window().setSize(new Dimension(1440,900));
                break;
            case FIREFOX:
                driver = new FirefoxDriver();
                break;
            case SAFARI:
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
    public WebDriver startDriver() throws IOException {
        return driver = openBrowser();
    }


    @AfterMethod
    public void closeDriver() {
        if (driver != null) {
            driver.close();
        }
    }
}

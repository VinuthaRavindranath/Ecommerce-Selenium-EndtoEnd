package org.ecomm.pages;


import org.openqa.selenium.WebDriver;

public class BasePage {
    WebDriver driver;
    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void loadUrl(String endpoint){
        driver.get("https://askomdch.com"+endpoint);
    }
}

package org.ecomm.pages;

import org.ecomm.utils.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends ElementUtil {

    WebDriver driver;

    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    private final By storeLink = By.linkText("Store");

    public HomePage getUrl(){
        BasePage basePage= new BasePage(driver);
        basePage.loadUrl("/");
        return this;
    }

    public SearchPage clickOnStoreMenuLink() {
        doClick(storeLink);
        return new SearchPage(driver);
    }
}

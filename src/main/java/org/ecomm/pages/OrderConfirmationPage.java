package org.ecomm.pages;

import org.ecomm.utils.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderConfirmationPage extends ElementUtil {
    WebDriver driver;
    public OrderConfirmationPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    private final By OrderSuccessMessage= By.xpath("//p[contains(@class,'thankyou-order-received')]");

    public String getOrderConfirmationSuccessMessage(){
        waitForElementVisible(OrderSuccessMessage,15);
        return doGetText(OrderSuccessMessage);
    }
}

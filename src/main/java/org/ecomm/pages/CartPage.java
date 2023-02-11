package org.ecomm.pages;

import org.ecomm.utils.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends ElementUtil {

    WebDriver driver;
    public CartPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    By cartPageTitle=By.xpath("//h1[contains(@class,'has-text')]");
    By productNameInCart=By.cssSelector("td.product-name a");
    By checkoutButton=By.linkText("PROCEED TO CHECKOUT");

    public String getCartPageTitle(){
        return doGetText(cartPageTitle);
    }

    public String getProductNameAddedInCart(){
        return doGetText(productNameInCart);
    }

    public CheckoutPage clickOnCheckoutButton(){
        doClick(checkoutButton);
        return new CheckoutPage(driver);
    }


}

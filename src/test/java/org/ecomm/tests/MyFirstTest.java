package org.ecomm.tests;

import org.ecomm.base.BaseTest;
import org.ecomm.pages.*;
import org.ecomm.pojo.BillingAddress;
import org.ecomm.pojo.Products;
import org.ecomm.pojo.User;
import org.ecomm.utils.JacksonUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class MyFirstTest extends BaseTest {
    public String searchTerm="Blue";

    @Test
    public void guestCheckoutUsingDirectBankTransfer() throws InterruptedException, IOException {
        BillingAddress billingAddress = JacksonUtils.deserializeJson("myBillingAddress.json", BillingAddress.class);
        Products products = new Products(1215);

        SearchPage searchPage = new HomePage(driver).
                getUrl().
                clickOnStoreMenuLink().
                doSearch(searchTerm);
        Assert.assertEquals(searchPage.getSearchPageTitle(), "Search results: “"+searchTerm+"”");

        searchPage.addProductToCart(products.getName());
        Thread.sleep(3000);
        CartPage cartPage = searchPage.clickViewCartLink();
        Assert.assertEquals(cartPage.getCartPageTitle(), "Cart");
        Assert.assertEquals(cartPage.getProductNameAddedInCart(), products.getName());

        CheckoutPage checkoutPage = cartPage.clickOnCheckoutButton();
        Assert.assertEquals(checkoutPage.getCheckoutPageTitle(), "Checkout");

        checkoutPage.enterBillingDetails(billingAddress).
                clickOnPlaceOrderButton();
        Thread.sleep(5000);

        OrderConfirmationPage orderConfirmationPage = new OrderConfirmationPage(driver);
        Assert.assertEquals(orderConfirmationPage.getOrderConfirmationSuccessMessage(), "Thank you. Your order has been received.");
    }

    @Test
    public void loginAndCheckoutUsingDirectBankTransfer() throws InterruptedException, IOException {
        BillingAddress billingAddress = JacksonUtils.deserializeJson("myBillingAddress.json", BillingAddress.class);
        Products products = new Products(1215);
        User user = new User("demouserVR@gmail.com", "test@123");

        SearchPage searchPage = new HomePage(driver).
                getUrl().
                clickOnStoreMenuLink().
                doSearch(searchTerm);
        Assert.assertEquals(searchPage.getSearchPageTitle(), "Search results: “"+searchTerm+"”");

        searchPage.addProductToCart(products.getName());
        Thread.sleep(3000);
        CartPage cartPage = searchPage.clickViewCartLink();
        Assert.assertEquals(cartPage.getCartPageTitle(), "Cart");
        Assert.assertEquals(cartPage.getProductNameAddedInCart(), products.getName());
        CheckoutPage checkoutPage = cartPage.clickOnCheckoutButton();
        Assert.assertEquals(checkoutPage.getCheckoutPageTitle(), "Checkout");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickLoginLinkOnCheckout().doLoginOnCheckout(user);

        checkoutPage.
                clearInputField().enterBillingDetails(billingAddress).
                clickOnPlaceOrderButton();

        Thread.sleep(5000);
        OrderConfirmationPage orderConfirmationPage = new OrderConfirmationPage(driver);
        Assert.assertEquals(orderConfirmationPage.getOrderConfirmationSuccessMessage(), "Thank you. Your order has been received.");
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Naveen");
        Thread.sleep(3000);
        alert.accept();
    }
}

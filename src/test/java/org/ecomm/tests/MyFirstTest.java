package org.ecomm.tests;

import org.ecomm.base.BaseTest;
import org.ecomm.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyFirstTest extends BaseTest {
     String productName = "Blue Shoes";

    @Test
    public void guestCheckoutUsingDirectBankTransfer() throws InterruptedException {
        driver.get("https://askomdch.com/");

        HomePage homePage = new HomePage(driver);
        SearchPage searchPage = homePage.clickOnStoreMenuLink();
        searchPage.doSearch("Blue");
        Assert.assertEquals(searchPage.getSearchPageTitle(), "Search results: “Blue”");
        searchPage.addProductToCart(productName);
        Thread.sleep(3000);
        CartPage cartPage=searchPage.clickViewCartLink();
        Assert.assertEquals(cartPage.getCartPageTitle(), "Cart");
        Assert.assertEquals(cartPage.getProductNameAddedInCart(), productName);
        CheckoutPage checkoutPage=cartPage.clickOnCheckoutButton();
        Assert.assertEquals(checkoutPage.getCheckoutPageTitle(), "Checkout");
        checkoutPage.enterBillingDetails("Vinutha","Ravindra","8th St",
                "ABC building","Dacono","80514","vinuthatest27@gmail.com").
                clickOnPlaceOrderButton();
        Thread.sleep(3000);
        OrderConfirmationPage orderConfirmationPage= new OrderConfirmationPage(driver);
        Assert.assertEquals(orderConfirmationPage.getOrderConfirmationSuccessMessage(), "Thank you. Your order has been received.");
    }

    @Test
    public void loginAndCheckoutUsingDirectBankTransfer() throws InterruptedException {
        driver.get("https://askomdch.com/");

        HomePage homePage = new HomePage(driver);
        SearchPage searchPage = homePage.clickOnStoreMenuLink();
        searchPage.doSearch("Blue");
        Assert.assertEquals(searchPage.getSearchPageTitle(), "Search results: “Blue”");
        searchPage.addProductToCart(productName);
        Thread.sleep(3000);
        CartPage cartPage = searchPage.clickViewCartLink();
        Assert.assertEquals(cartPage.getCartPageTitle(), "Cart");
        Assert.assertEquals(cartPage.getProductNameAddedInCart(), productName);
        CheckoutPage checkoutPage = cartPage.clickOnCheckoutButton();
        Assert.assertEquals(checkoutPage.getCheckoutPageTitle(), "Checkout");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickLoginLinkOnCheckout().doLoginOnCheckout("demouserVR@gmail.com", "test@123");
        checkoutPage.enterBillingDetails("Vinutha", "Ravindra", "8th St",
                        "ABC building", "Dacono", "80514", "vinuthatest27@gmail.com").
                clickOnPlaceOrderButton();
        Thread.sleep(3000);
        OrderConfirmationPage orderConfirmationPage = new OrderConfirmationPage(driver);
        Assert.assertEquals(orderConfirmationPage.getOrderConfirmationSuccessMessage(), "Thank you. Your order has been received.");

    }
}

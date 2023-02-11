package org.ecomm.pages;

import org.ecomm.utils.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends ElementUtil {
    WebDriver driver;
    public CheckoutPage( WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    By checkoutPageTitle=By.xpath("//h1[contains(@class,'has-text')]");
    By firstNameEle=By.id("billing_first_name");
    By lastNameEle=By.id("billing_last_name");
    By address1Ele=By.id("billing_address_1");
    By address2Ele=By.id("billing_address_2");
    By cityEle=By.id("billing_city");
    By postalCodeEle=By.id("billing_postcode");
    By emailEle=By.id("billing_email");
    By placeOrderButtonEle=By.id("place_order");


    public String getCheckoutPageTitle(){
        return doGetText(checkoutPageTitle);
    }

    public CheckoutPage setFirstName(String firstName){
        doSendKeys(firstNameEle,firstName);
        return this;
    }

    public CheckoutPage setLastName(String lastName){
        doSendKeys(lastNameEle,lastName);
        return this;
    }

    public CheckoutPage setAddress1(String address1){
        doSendKeys(address1Ele,address1);
        return this;
    }

    public CheckoutPage setAddress2(String address2){
        doSendKeys(address2Ele,address2);
        return this;
    }

    public CheckoutPage setCity(String city){
        doSendKeys(cityEle,city);
        return this;
    }

    public CheckoutPage setPostalCode(String postalCode){
        doSendKeys(postalCodeEle,postalCode);
      return this;
    }

    public CheckoutPage setEmail(String email){
        doSendKeys(emailEle,email);
        return this;
    }

    public CheckoutPage clickOnPlaceOrderButton(){
        doClick(placeOrderButtonEle);
        return this;
    }

    public CheckoutPage enterBillingDetails(String firstName,String lastName,String address1,String address2,String city,String postalCode,String email){
        setFirstName(firstName).
                setLastName(lastName).
                setAddress1(address1).
                setAddress2(address2).
                setCity(city).
                setPostalCode(postalCode).
                setEmail(email);
        return this;
    }
}

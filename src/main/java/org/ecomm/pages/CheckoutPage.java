package org.ecomm.pages;

import org.ecomm.pojo.BillingAddress;
import org.ecomm.utils.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckoutPage extends ElementUtil {
    WebDriver driver;
    public CheckoutPage( WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    private final By checkoutPageTitle=By.xpath("//h1[contains(@class,'has-text')]");
    private final By firstNameEle=By.id("billing_first_name");
    private final By lastNameEle=By.id("billing_last_name");
    private final By address1Ele=By.id("billing_address_1");
    private final By address2Ele=By.id("billing_address_2");
    private final By cityEle=By.id("billing_city");
    private final By postalCodeEle=By.id("billing_postcode");
    private final By emailEle=By.id("billing_email");
    private final By placeOrderButtonEle=By.id("place_order");
    private final By loaderElements =By.cssSelector(".blockUI blockOverlay");
    private final By billingAddressInputFields=By.cssSelector("div.woocommerce-billing-fields .input-text ");
    private final By countryDropDown=By.id("billing_country");
    private final By stateDropDown=By.cssSelector("select#billing_state");
    private final By directBankTransfer=By.id("payment_method_bacs");



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
        List<WebElement> loaders=getElements(loaderElements);
        if (loaders.size()>0){
            waitForElementsInVisible(loaders,30);
        }
        doClick(placeOrderButtonEle);
        return this;
    }

    public CheckoutPage clearInputField(){
        clearAllFields(billingAddressInputFields);
        return this;
    }

    public CheckoutPage enterBillingDetails(BillingAddress billingAddress){
        setFirstName(billingAddress.getFirstName()).
                setLastName(billingAddress.getLastName()).
                selectCountry(billingAddress.getCountry()).
                setAddress1(billingAddress.getAddressLineOne()).
                setAddress2(billingAddress.getAddressLineTwo()).
                setCity(billingAddress.getCity()).
                selectState(billingAddress.getState()).
                setPostalCode(billingAddress.getPostalCode()).
                setEmail(billingAddress.getEmail());
        return this;
    }

    public CheckoutPage selectCountry(String countryName){
        selectByVisibleText(countryDropDown,countryName);
        return this;
    }

    public CheckoutPage selectState(String stateName){
        selectByVisibleText(stateDropDown,stateName);
        return this;
    }

    public CheckoutPage selectDirectBankTransfer(){
        WebElement ele=waitForElementToBeClickable(directBankTransfer,15);
        if (!ele.isSelected()){
            ele.click();
        }
        return this;
    }
}

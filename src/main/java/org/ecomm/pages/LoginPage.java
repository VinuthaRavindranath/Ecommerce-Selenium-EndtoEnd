package org.ecomm.pages;

import org.ecomm.utils.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends ElementUtil {
    WebDriver driver;

    public LoginPage( WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    By loginOnCheckout = By.cssSelector(".showlogin");
    By usernameEle = By.id("username");
    By passwordEle= By.id("password");
    By loginButton =By.cssSelector("button[value='Login']");

    public LoginPage clickLoginLinkOnCheckout() {
        doClick(loginOnCheckout);
        return this;
    }

    public LoginPage enterLoginCredentials(String username, String password) {
        doSendKeys(usernameEle,username);
        doSendKeys(passwordEle,password);
        return this;
    }

    public LoginPage clickLoginButton() {
        doClick(loginButton);
        return this;
    }

    public void doLoginOnCheckout(String username, String password) {
                enterLoginCredentials(username,password).
                clickLoginButton();
    }


}

package org.ecomm.pages;

import org.ecomm.pojo.User;
import org.ecomm.utils.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends ElementUtil {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    private final By loginOnCheckout = By.cssSelector(".showlogin");
    private final By usernameEle = By.id("username");
    private final By passwordEle = By.id("password");
    private final By loginButton = By.cssSelector("button[value='Login']");

    public LoginPage clickLoginLinkOnCheckout() {
        doClick(loginOnCheckout);
        return this;
    }

    public LoginPage enterLoginCredentials(String username, String password) {
        waitForElementVisible(usernameEle,15);
        doSendKeys(usernameEle, username);
        doSendKeys(passwordEle, password);
        return this;
    }

    public LoginPage clickLoginButton() {
        doClick(loginButton);
        return this;
    }

    public void doLoginOnCheckout(User user) {
        enterLoginCredentials(user.getUsername(), user.getPassword()).
                clickLoginButton();
    }


}

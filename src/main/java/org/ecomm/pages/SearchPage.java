package org.ecomm.pages;

import org.ecomm.utils.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage extends ElementUtil {

    WebDriver driver;
    public SearchPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }


    private final By searchBox = By.cssSelector("#woocommerce-product-search-field-0");
    private final By searchButton = By.xpath("//button[@type='submit' and text()='Search']");
    private final By searchPageTitle = By.xpath("//h1[contains(@class,'page-title')]");
    private final By viewCartLink= By.linkText("View cart");


    public SearchPage enterTextInSearchBox(String searchTerm) {
        doSendKeys(searchBox,searchTerm);
        return this;
    }

    public SearchPage clickOnSearchButton() {
        doClick(searchButton);
        return this;
    }

    public String getSearchPageTitle(){
        return doGetText(searchPageTitle);
    }

    /**Builder Pattern
     *
     * @param searchTerm
     * @return
     */
    public SearchPage doSearch(String searchTerm) {
        enterTextInSearchBox(searchTerm).clickOnSearchButton();
        return this;
    }

    /**Dynamic Xpath
     *
     * @param productName
     * @return By locator
     */
    private By addToCartButton(String productName){
        return By.xpath("//a[@aria-label='Add “" + productName + "” to your cart']");
    }

    public void addProductToCart(String productName){
        doClick(addToCartButton(productName));
    }


    public CartPage clickViewCartLink() {
        doClick(viewCartLink);
        return new CartPage(driver);

    }

}

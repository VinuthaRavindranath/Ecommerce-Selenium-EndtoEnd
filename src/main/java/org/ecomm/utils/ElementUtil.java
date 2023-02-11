package org.ecomm.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class ElementUtil {
    private WebDriver driver;

    public ElementUtil(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getElement(By locator) {
        return driver.findElement(locator);
    }

    public List<WebElement> getElements(By locator) {
        List<WebElement> elements = driver.findElements(locator);
        return elements;
    }

    public int getElementsSize(By locator) {
        int elements = driver.findElements(locator).size();
        return elements;
    }

    public void doSendKeys(By locator, String text) {
        getElement(locator).sendKeys(text);
    }

    public void doClick(By locator) {
        getElement(locator).click();
    }

    public String doGetText(By locator) {
        String text = getElement(locator).getText();
        return text;
    }

    public String doGetTextFromWebElement(WebElement element) {
        String text = element.getText();
        return text;
    }

    public List<String> getElementsAttributeValue(By locator, String attribute) {
        List<String> eleValues = new ArrayList<String>();
        List<WebElement> eleAttributeValues = getElements(locator);
        for (WebElement element : eleAttributeValues) {
            String values = element.getAttribute(attribute);
            eleValues.add(values);
        }
        return eleValues;
    }

    public List<String> getElementsText(By locator) {
        List<String> eleValues = new ArrayList<String>();
        List<WebElement> eleAttributeValues = getElements(locator);
        for (WebElement element : eleAttributeValues) {
            String values = element.getText();
            eleValues.add(values);
        }
        return eleValues;
    }

    public void getElementsTextAndClick(By locator, String value) {
        List<WebElement> languages = getElements(locator);
        for (WebElement e : languages) {
            String text = e.getText();
            if (text.equals(value)) {
                e.click();
                break;
            }
        }
    }

    public void getElementsByAttributeAndClick(By locator, String attributeValue, String value) {
        List<WebElement> languages = getElements(locator);
        for (WebElement e : languages) {
            String val = e.getAttribute(attributeValue);
            if (val.contains(value)) {
                e.click();
                break;
            }
        }
    }

    /**
     * Select class utils
     */

    public void selectByVisibleText(By locator, String text) {
        Select select = new Select(getElement(locator));
        select.selectByVisibleText(text);
    }

    public void selectByIndex(By locator, int index) {
        Select select = new Select(getElement(locator));
        select.selectByIndex(index);
    }

    public void selectByValue(By locator, String value) {
        Select select = new Select(getElement(locator));
        select.selectByValue(value);
    }

    public List<String> selectGetOptions(By locator) {
        Select select = new Select(getElement(locator));
        List<String> values = new ArrayList<String>();
        List<WebElement> options = select.getOptions();
        for (WebElement element : options) {
            String optionsList = element.getText();
            values.add(optionsList);
        }
        return values;
    }

}

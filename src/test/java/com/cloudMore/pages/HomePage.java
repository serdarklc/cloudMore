package com.cloudMore.pages;

import com.cloudMore.utilities.BrowserUtils;
import com.cloudMore.utilities.ConfigurationReader;
import com.cloudMore.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    @FindBy(xpath = "//a[@class ='navbar-brand']/img")
    private WebElement logo;
    @FindBy(id = "hs-eu-confirmation-button")
    private WebElement cookiesAcceptButton;
    @FindBy(css = "button.btn-search")
    private WebElement searchButton;
    @FindBy(xpath = "//input[@class ='input-search']")
    private WebElement searchField;

    public void searchButtonClick() {
        BrowserUtils.clickWithWait(searchButton, 10);
    }

    public void searchByKeyword(String keyword) {
        BrowserUtils.waitClickability(searchField, 10);
        searchField.sendKeys(keyword, Keys.ENTER);
    }

    public void acceptCookies() {
        BrowserUtils.waitForVisibility(cookiesAcceptButton, 10);
        cookiesAcceptButton.click();
    }

    public void goHomePage() {
        Driver.getDriver().get(ConfigurationReader.get("url"));
        acceptCookies();
    }

    public boolean isDisplayLogo() {
        if (logo.isDisplayed()) {
            return true;
        }
        System.out.println("logo is not displayed");
        return false;
    }

    public boolean navigateToModule(String moduleName) {
        WebElement menuLocator = Driver.getDriver().findElement(By.xpath("(//li/a[text()='" + moduleName + "'])[1]"));
        if (menuLocator.isDisplayed()) {
            return true;
        }
        return false;
    }
}





















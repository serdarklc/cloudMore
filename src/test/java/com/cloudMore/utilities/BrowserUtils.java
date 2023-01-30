package com.cloudMore.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Set;

public class BrowserUtils {
    /**
     * wait for an element to be clickable (with web element)
     */
    public static void waitClickability(WebElement element, int timeOut) {
        try {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeOut);
            wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * wait for an element to be clickable (with By locator)
     */
    public static void waitClickability(By locator, int timeOut) {
        try {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeOut);
            wait.until(ExpectedConditions.elementToBeClickable(Driver.getDriver().findElement(locator)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * wait for clickability of an element then click
     */
    public static void clickWithWait(WebElement element, int timeOut) {
        waitForVisibility(element, timeOut);
        waitClickability(element, timeOut);
        element.click();
    }

    /**
     * wait for clickability of an element then click
     */
    public static void clickWithWait(By by, int timeOut) {
        waitClickability(by, timeOut);
        Driver.getDriver().findElement(by).click();
    }

    /**
     * perform hover over and click
     */
    public static void clickWithMouseHoverAction(WebElement element) {
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(element).pause(500).click(element).build().perform();
    }

    /**
     * wait till URL contains a specific text
     */
    public static void waitForURLContains(String urlPart, int timeOut) {
        try {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeOut);
            wait.until(ExpectedConditions.urlContains(urlPart));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * wait till URL contains a specific text
     */
    public static void waitForTitleContains(String titlePart, int timeOut) {
        try {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeOut);
            wait.until(ExpectedConditions.titleContains(titlePart));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * wait for visibility of a web element
     */
    public static void waitForVisibility(WebElement element, int timeOut) {
        try {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeOut);
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * wait for visibility of a web element
     */
    public static void waitForVisibility(By by, int timeOut) {
        try {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeOut);
            wait.until(ExpectedConditions.visibilityOf(Driver.getDriver().findElement(by)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * wait till a new window gets opened
     */
    public static void waitForNewWindow() {
        try {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 4);
            wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * switch to another window by passing index number
     */
    public static void switchToWindow(int index) {
        try {
            waitForNewWindow();
            Set<String> windowHandles = Driver.getDriver().getWindowHandles();
            ArrayList<String> allTabs = new ArrayList<>(windowHandles);
            Driver.getDriver().switchTo().window(allTabs.get(index));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * wait for a web element till has a specific text
     */
    public static void waitForText(WebElement element, String text) {
        try {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 6);
            wait.until(ExpectedConditions.textToBePresentInElement(element, text));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * switch to iframe
     */
    public static void switchToFrame(WebElement frame) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 4);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame));
    }

    /**
     * click on a web element using JSexecutor
     */
    public static void clickWithJSExe(WebElement element) {
        waitClickability(element, 3);
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", element);
    }

    /**
     * open a new tab using JSexecutor
     */
    public static void openNewTab() {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("window.open();");
    }

    /**
     * scroll into an element
     */
    public static void scrollToElement(WebElement element) {
        try {
            ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * scroll into an element
     */
    public static void scrollToElement(By by) {
        try {
            WebElement element = Driver.getDriver().findElement(by);
            ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

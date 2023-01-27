package com.cloudMore.pages;

import com.cloudMore.utilities.Driver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ResultPage extends BasePage {
    @FindBy(xpath = "//article[@class='search-result']")
    private List<WebElement> resultList;

    public boolean resultListNumberControl() {
        while (resultList.size() > 3) {
            return true;
        }
        return false;
    }

    public void mobilScreenShot(int x, int y) {
        Driver.getDriver().manage().window().setSize(new Dimension(x, y));
    }
}

package com.cloudMore.step_definitions;

import com.cloudMore.pages.HomePage;
import com.cloudMore.pages.ResultPage;
import com.cloudMore.utilities.Driver;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class ResultPageStepDef {

    private Scenario scenario;

    public ResultPageStepDef(Scenario scenario) {
        this.scenario = scenario;
    }

    private ResultPage resultPage = new ResultPage();

    @Then("The user should see results more than 3 items on the result page")
    public void the_user_should_see_results_more_than_3_items_on_the_result_page() {
        Assert.assertTrue(resultPage.resultListNumberControl());
    }

    @Given("The user see results in both Web and Mobil {int} , {int}")
    public void the_user_see_results_in_both_web_and_mobil(Integer x, Integer y) {

        byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);

        // Embed the screenshot in the report
        scenario.attach(screenshot, "image/png", String.valueOf(x+y) );
        resultPage.mobilScreenShot(x,y);
    }
}

package com.cloudMore.step_definitions.ui;

import com.cloudMore.pages.ResultPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import lombok.extern.log4j.Log4j;
import org.junit.Assert;

@Log4j
public class ResultPageStepDef {
    private ResultPage resultPage = new ResultPage();

    @Then("The user should see results more than 3 items on the result page")
    public void the_user_should_see_results_more_than_3_items_on_the_result_page() {
        log.info("Verifying for web maximum size");
        Assert.assertTrue(resultPage.resultListNumberControl());
    }

    @Given("The user see results on Mobil Size {int} , {int}")
    public void the_user_see_results_on_mobil_size(int x, int y) {
        log.info("Verifying for given mobil size");
        resultPage.mobilScreenShot(x, y);
    }
}

package com.cloudMore.step_definitions;

import com.cloudMore.pages.HomePage;
import com.cloudMore.pages.ResultPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class ResultPageStepDef {

    private ResultPage resultPage = new ResultPage();

    @Then("The user should see results more than 3 items on the result page")
    public void the_user_should_see_results_more_than_3_items_on_the_result_page() {
        Assert.assertTrue(resultPage.resultListNumberControl());
    }

    @Given("The user see results in both Web and Mobil {int} , {int}")
    public void the_user_see_results_in_both_web_and_mobil(Integer x, Integer y) {
        resultPage.mobilScreenShot(x,y);
    }
}

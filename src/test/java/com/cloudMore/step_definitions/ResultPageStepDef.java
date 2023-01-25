package com.cloudMore.step_definitions;

import com.cloudMore.pages.HomePage;
import com.cloudMore.pages.ResultPage;
import io.cucumber.java.en.Then;

public class ResultPageStepDef {

    private ResultPage resultPage = new ResultPage();
    @Then("Screenshot will be taken")
    public void screenshot_will_be_taken() {

    }
    @Then("The user should see results more than 3 items on the result page")
    public boolean the_user_should_see_results_more_than_3_items_on_the_result_page() {
        return resultPage.resultListNumberControl();
    }
}

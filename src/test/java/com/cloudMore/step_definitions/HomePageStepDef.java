package com.cloudMore.step_definitions;

import com.cloudMore.pages.HomePage;
import com.cloudMore.utilities.Driver;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.plugin.event.Node;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class HomePageStepDef {

    private HomePage homePage = new HomePage();

    //----------------------------------------------------------------
    @Given("The user is on the home page")
    public void the_user_is_on_the_home_page() {
        homePage.goHomePage();
    }
    @Then("The user can see logo on the nav bar")
    public void the_user_can_see_logo_on_the_nav_bar() {
        Assert.assertTrue(homePage.isDisplayLogo());
    }
    @Then("The user can see all modules which is placed nav bar {string}")
    public void the_user_can_see_all_modules_which_is_placed_nav_bar(String modules) {
        Assert.assertTrue(homePage.navigateToModule(modules));
    }
    @Then("The user can click search button")
    public void the_user_can_click_search_button() {
        homePage.searchButtonClick();
    }
    @Then("The user writes {string} into search field")
    public void the_user_writes_into_search_field(String keyword) {
       homePage.searchByKeyword(keyword);
    }
}

package com.cloudMore.step_definitions.ui;

import com.cloudMore.pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import lombok.extern.log4j.Log4j;
import org.junit.Assert;

@Log4j
public class HomePageStepDef {
    private HomePage homePage = new HomePage();

    @Given("The user is on the home page")
    public void the_user_is_on_the_home_page() {
        log.info("Navigating to home page");
        homePage.goHomePage();
    }

    @Then("The user can see logo on the nav bar")
    public void the_user_can_see_logo_on_the_nav_bar() {
        log.info("Verifying that the logo is displayed");
        Assert.assertTrue(homePage.isDisplayLogo());
    }

    @Then("The user can see all modules which is placed nav bar {string}")
    public void the_user_can_see_all_modules_which_is_placed_nav_bar(String modules) {
        log.info("Verifying that modules are displayed");
        Assert.assertTrue(homePage.navigateToModule(modules));
    }

    @Then("The user can click search button")
    public void the_user_can_click_search_button() {
        log.info("Clicking search icon");
        homePage.searchButtonClick();
    }

    @Then("The user writes {string} into search field")
    public void the_user_writes_into_search_field(String keyword) {
        log.info(String.format("Searching by keyword %s", keyword));
        homePage.searchByKeyword(keyword);
    }
}

@UI
Feature:Create automated tests for result page

  Background:
    Given The user is on the home page
    And The user can click search button
    And The user writes "selenium" into search field

  @TC2Desktop @ui
  Scenario: Search by “Azure” and take a screenshot on a search result page for desktop size screens.
    Then The user should see results more than 3 items on the result page

  @TC2Mobil @ui
  Scenario: Search by “Azure” and take a screenshot on a search result page for mobile size screen.
    And The user see results on Mobil Size 414 , 896
    Then The user should see results more than 3 items on the result page
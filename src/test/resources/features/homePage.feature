@PartB
Feature:Create automated tests for https://web.cloudmore.com:

  1. Verify company logo and menu items are displayed on next pages: Solutions,
  Integrations, Resources, Pricing, Company.

  2. Test Search Page:
  Search by “Azure” and take a screenshot on a search result page for mobile and
  desktop size screens. In case search results have less than 3 items in the list, the test
  should fail (screenshots still needed)

  @TC1Positive @ui
  Scenario Outline: Verify company logo and menu items are displayed on next pages:
  Solutions,Integrations, Resources, Pricing, Company
    Given The user is on the home page
    Then The user can see logo on the nav bar
    Then The user can see all modules which is placed nav bar "<modules>"

    Examples:
      | modules      |
      | Solutions    |
      | Integrations |
      | Resources    |
      | Pricing      |
      | Company      |


  @TC2Positive @ui
  Scenario Outline: Search by “Azure” and take a screenshot on a search result page for mobile and
  desktop size screens.
    Given The user is on the home page
    And The user can click search button
    And The user writes "Azure" into search field
    And The user see results in both Web and Mobil <x> , <y>
    Then The user should see results more than 3 items on the result page

    Examples:
      | x    | y   |
      | 1920  | 961 |
      | 414  | 896 |


  @TC2Negative @ui
  Scenario Outline: Search by “Azure” and take a screenshot on a search result page for mobile and
  desktop size screens.
    Given The user is on the home page
    And The user can click search button
    And The user writes "<keyword>" into search field
    Then The user should see results more than 3 items on the result page

    Examples:
      | keyword |
      | Storing |




@UI
Feature:Create automated tests for https://web.cloudmore.com

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




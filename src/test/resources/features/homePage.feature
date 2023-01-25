Feature:UI test automation

  @TC1Positive
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

  @TC1Negative
  Scenario Outline: Verify company logo and menu items are displayed on next pages:
  Solutions,Integrations, Resources, Pricing, Company
    Given The user is on the home page
    Then The user can see logo on the nav bar
    Then The user can see all modules which is placed nav bar "<modules>"

    Examples:
      | modules |
      | shoes   |
      | 12345   |
      | sign in |
      | prime   |
      | desk    |


  @TC2Positive
  Scenario Outline: Search by “Azure” and take a screenshot on a search result page for mobile and
  desktop size screens.
    Given The user is on the home page
    And The user can click search button
    And The user writes "<keyword>" into search field
    Then Screenshot will be taken
    Then The user should see results more than 3 items on the result page

    Examples:
      | keyword |
      | Azure   |


  @TC2Negative
  Scenario Outline: Search by “Azure” and take a screenshot on a search result page for mobile and
  desktop size screens.
    Given The user is on the home page
    And The user can click search button
    And The user writes "<keyword>" into search field
    Then Screenshot will be taken
    Then The user should see results more than 3 items on the result page

    Examples:
      | keyword |
      | Storing |




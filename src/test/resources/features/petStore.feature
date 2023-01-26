@api
Feature: Cover positive and negative tests for /user endpoint:
  • User Creation,
  • Reading,
  • Updating,
  • Deleting

  @PartC
  Scenario: User account will be created
    Given User can write information
    Then User can create account

  @PartC2
    Scenario: User information can be read
      Given Choose user with created userName
      Then User information will be matched correctly

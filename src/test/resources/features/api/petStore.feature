@API
Feature: Testing API with CRUD methods

  @PartC1
  Scenario: User can create account successfully with valid credentials
    Given User information should be written randomly
    When User should post information
    Then User should see status code like 200
    Then User should see message, code, type and values

  @PartC2
  Scenario: A specific information should be retrieved by username
    When User send a get request with username
    Then User should see status code like 200
    Then User should see all information correctly

  @PartC3
  Scenario: User information will be updated by using update method
    When User send a update request with username
    Then User should see status code like 415
    Then User should see all information correctly

  @PartC4
  Scenario: User information will be deleted by using delete method
    When User send a delete request with username
    Then User should see status code like 200
    Then User information should be deleted

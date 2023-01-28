@API
Feature: Testing API with CRUD methods

  @Creating
  Scenario: User can create account successfully with valid credentials
    When User should post information
    Then User should see status code like 200
    Then User should see response body code 200

  @Reading
  Scenario: A specific information should be retrieved by username
    When User send a get request with username
    Then User should see status code like 200
    Then User should see all information correctly

  @Updating
  Scenario: User information will be updated by using update method
    When User send a update request with username
    Then User should see status code like 200
    Then User should see response body code 200

  @Deleting
  Scenario: User information will be deleted by using delete method
    When User send a delete request with username
    Then User should see status code like 200
    Then User information should be deleted
    Then User should see status code like 200

    @Login
    Scenario: A specific information should not be log in by deleted username
      When User enters username and password on login page
      Then User should see status code like 200
      Then User should see all information correctly

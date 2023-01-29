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

  #@CreatingNegative
  #Scenario: User cannot create account with invalid credentials
  #  When User should post invalid information
  #  Then User cannot see status code like 200

  @Updating
  Scenario: User information will be updated by using update method
    When User send a update request with username
    Then User should see status code like 200
    Then User should see response body code 200

  @ReadingNegative
  Scenario Outline: A specific information should not be retrieved by invalid username
    When User send a get request with invalid "<username>"
    Then User should see status code like 404
    Then User should see response body code 1

    Examples:
      | username |
      | Jackyy    |
      | Ja%ck    |
      | j1Ak     |
      | 123asD   |
      | 12345    |
      | 123 45   |
      | 12%&/    |

  @DeletingNegative
  Scenario Outline: User cannot delete by using invalid username
    When User send a delete request with invalid "<username>"
    Then User should see status code like 404

    Examples:
      | username |
      | 123 45    |
      | 12345    |
      | j12%3 4  |
      | jAcK     |
      | Ja ck    |
      | Jackyy   |









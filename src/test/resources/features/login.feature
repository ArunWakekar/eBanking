Feature: Login Functionality
  As a user
  I want to be able to log in to my account
  So that I can access my profile and settings

  Scenario: Valid Login
    Given I am on the login page
    When I enter valid user name as "username" and "password"
    And I click on the login button
    Then I should be logged in to my account

  Scenario: Invalid Login
    Given I am on the login page
    When I enter invalid credentials
    And I click on the login button
    Then I should see an error message


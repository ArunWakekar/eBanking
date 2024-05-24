Feature: Transfer the amount
  As a user
  I want to transfer the amount from my account to another account
  So that I can manage my finances

  Background:
    Given I am on the login page
    When I enter valid user name as "username" and "password"
    And I click on the login button
    Then I should be logged in to my account

  Scenario: Amount transfer
    Given I am click on transfer fund
    When I select account from
    And I select account to and enter amount
    And I click on transfer money
    Then Amount is transfer successfully with information message.

Feature: Login Functionality
  As a user of the movies app website
  I want to be able to log in to my account
  So that I can access personalized features and make purchases

  Scenario: LoginPage UI

    Given I am on the login page
    Then I should be view UI


  Scenario: Login Functionality
    Given I am on the login page
    When I enter a valid User ID and valid pin
    And I click on the login button
    Then I should be redirected to the homepage


  Scenario: Login with empty input fields

    Given I am on the login page
    When Empty username and passwords test
    And I click on the login button
    Then error message *Username or password is invalid should be visible

  Scenario: Login with empty User ID field

    Given I am on the login page
    When I enter a valid PIN  and empty userId
    And I click on the login button
    Then error message *Username or password is invalid should be visible

  Scenario: Login with empty PIN field

    Given I am on the login page
    When I enter a valid User ID and empty Pin
    And I click on the login button
    Then  error message *Username or password is invalid should be visible

  Scenario: Login with invalid inputs

    Given I am on the login page
    When I enter a valid User ID and I enter an invalid PIN
    And I click on the login button
    Then an error message *username and password didn't match should be visible

  Scenario: Invalid username and correct password test
    Given I am on the login page
    When Invalid username and correct password test
    And I click on the login button
    Then an error message *invalid username should be visible

  Scenario: Invalid username and Incorrect password test
    Given I am on the login page
    When Invalid username and Incorrect password test
    And I click on the login button
    Then an error message *invalid username should be visible




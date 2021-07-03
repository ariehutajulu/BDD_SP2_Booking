Feature: Login

  Scenario: Normal Login
    Given open website
    When sign in and login
    Then go to homepage

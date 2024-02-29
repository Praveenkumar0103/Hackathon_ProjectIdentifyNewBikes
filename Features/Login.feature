Feature: Login Account

  Scenario: Login with invalid account details
    Given the user navigates to Login Account page
    When the user clicks the Google button
    Then enters invalid email the user should get displayed with error message

Feature: Registration.feature

  @createAccount
  Scenario: use create an account
    Given user launch bowser and open the "castcoappurl"
    When user click on the "Sign In / Register" button
    Then user create an account from home page

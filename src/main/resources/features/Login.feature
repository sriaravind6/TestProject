Feature: Login.feature

  @Background:
  Given user launch bowser and open the "castcoappurl"
  @Login
  Scenario:  User click on the Sign in button from the home page and verify the Sign in page
#    Given user launch bowser and open the "castcoappurl"
    When user click on the "Sign In / Register" button
    Then user should be navigated to the Sign in page
    And user login with vaild credintials "validUserName" and "commonPasscode"


  Scenario: BKBJKBJKBJSBLDJB
#    Given user launch bowser and open the "castcoappurl"
    When user click on the "Sign In / Register" button
    Then user should be navigated to the Sign in page
    And user login with vaild credintials "validUserName" and "commonPasscode"
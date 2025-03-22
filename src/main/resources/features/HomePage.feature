Feature: HomePage.feature


    @HomePage
    Scenario Outline:  User click on the Sign in button from the home page and verify the Sign in page
    Given user launch bowser and open the "castcoappurl"
    When user click on the "<button>" button
    Then user should be navigated to the Sign in page
        Examples:
            | button             |
            | Sign In / Register |
            | Orders & Returns   |
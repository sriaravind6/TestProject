Feature: HomePage.feature

    @HomePage  @smoke @aso
    Scenario: Login with vaild credentials
        Given user launch bowser and open the "asourl"
        When user click on the "Sign In Icon" button
        Then user click on the "Sign In Button" button

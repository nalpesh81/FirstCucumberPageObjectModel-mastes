Feature: Registration

@Register
  Scenario: As a user I should be able to register successfully
    Given user is on homepage
    And user clicks on register button
    When user enters registration details and click on register
    Then user should be able to register successfully and see success message.
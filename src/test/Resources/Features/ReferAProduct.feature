@ReferAProduct
Feature: User Refers a Product to friend

  Scenario: As a registered user I should be able to refer a product to friend successfully
    Given user is registered
    And user is on homepage
    When user chooses product to refer a friend
    And user fills referral details
    Then user should see message of successful referral

  Scenario: As a Guest user I should not be able to refer a product to friend
    Given user is on homepage
    When user chooses product to refer a friend
    And user fills referral details as a guest
    Then user should see failure referral message
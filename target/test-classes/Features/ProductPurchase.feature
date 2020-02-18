@ProductPurchase
Feature: User purchases product

  Scenario: As a registered user I should be able to buy a product successfully
    Given user is registered
    And user is on homepage
    When user chooses a product to to add into Shopping Cart
    And user enters details of Shipping Estimate
    And user checkout the product
    And user enters details for checkout
    Then user should see message of successful purchase

  Scenario: As a guest user I should be able to buy a product successfully
    Given user is on homepage
    When user chooses a product to to add into Shopping Cart
    And user enters details of Shipping Estimate
    And user checkout the product
    And user again checkout the product as a guest
    And user enters details for guest checkout
    Then user should see message of successful purchase
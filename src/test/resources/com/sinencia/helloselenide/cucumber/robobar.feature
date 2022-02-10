Feature: Robobar cart
  Scenario: user add one cola
    Given user opens robobar website
    When user adds a cola
    Then total should be €1.25

  Scenario: user add two colas
    Given user opens robobar website
    When user adds a cola
    And user adds a cola
    Then total should be €2.50

  Scenario: user add two colas
    Given user opens robobar website
    When user adds a cola
    And user adds a cola
    Then total should be "€2.50"

  Scenario: user add one cola and one beer
    Given user opens robobar website
    When user adds a cola
    And user adds a beer
    Then total should be €3.25

  Scenario: user add one cola, one beer, and one wine
    Given user opens robobar website
    When user adds a cola
    And user adds a beer
    And user adds a wine
    Then total should be €6.25

  Scenario: user add one beer and age is 17
    Given user opens robobar website
    When user adds a beer
    Then total should be €2.00
    When user press submit button
    And user enter her age is 17
    And user press order button
    Then alert is active
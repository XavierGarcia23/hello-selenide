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
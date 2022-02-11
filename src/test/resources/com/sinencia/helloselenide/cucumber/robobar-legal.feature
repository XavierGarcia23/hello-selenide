Feature: Robobar age checks
  Background: User has already placed alcoholic beverages in her cart but we still don't know her age
    Rule: Underage users can not buy alcohol
      Scenario Outline: Minor tries to buy alcohol
        Given user is ready to checkout with alcohol
        When user enter her age is <age>
        Then robobar does not allow checkout
        Examples:
          | age |
          | 15  |
          | 16  |
          | 17  |

      Scenario Outline: Adult tries to buy alcohol
        Given user is ready to checkout with alcohol
        When user enter her age is <age>
        Then robobar confirms order
        Examples:
          | age |
          | 18  |
          | 19  |
          | 20  |
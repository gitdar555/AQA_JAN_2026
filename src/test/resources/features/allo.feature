Feature: Allo phones test

  Scenario: check iphone prices

    Given open allo ua
    When search iphone
    Then get first 3 phones
    And check phones in db
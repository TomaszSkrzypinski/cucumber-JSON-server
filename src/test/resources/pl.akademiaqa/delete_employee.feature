Feature: Delete existing employee

  Scenario: I am able to delete existing employee
    Given employee already exist
    When I delete existing employee
    Then I should not see deleted employee on employees list
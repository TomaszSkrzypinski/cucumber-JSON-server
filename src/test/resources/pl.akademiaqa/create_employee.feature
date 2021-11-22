Feature: Create new employee

  @cleanEmployees
  Scenario: I am able to create new employee
    Given I read all employee
    When I create new employee
    Then I see created employee on employees list
Feature: Update bug

  @cleanOneBug
  Scenario: I am able to close bag
    Given bug already exist
    When I close existing bug
    Then I can read updated bug and see status as closed
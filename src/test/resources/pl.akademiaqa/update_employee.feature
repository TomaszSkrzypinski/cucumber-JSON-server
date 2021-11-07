Feature: Patch employee email

  Scenario: I am able to update a employee
    Given The employee with email "kniebieska@testerprogramuje.pl" are exist
    When I change this employee email to "patch.email@email.com"
    Then This employee email was changed to "patch.email@email.com"

  Scenario: Clean after test
    Given The employee with email "patch.email@email.com" are exist
    When I change this employee email to "kniebieska@testerprogramuje.pl"
    Then This employee email was changed to "kniebieska@testerprogramuje.pl"
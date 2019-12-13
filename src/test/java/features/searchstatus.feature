Feature: User search flight status
  Scenario Outline: User searches for flight status for route with specific date and verifies the same

  Given user open flight status page with browser "<browser>"
  When user enters departure "<depLoc>" and destination "<desLoc>"
  When user selects "<date>"
  And user clicks search flight status
  Then user flights status should be displayed accordingly and date "<date>" verification should be done
  And user closes the App

  Examples:
    |browser|depLoc|desLoc|date|
    |chrome|CGN|TXL|Today|
    |chrome|CGN|TXL|Tomorrow|

  Scenario Outline: User searches flight status for route and update the status and verifies the same
    Given user open flight status page with browser "<browser>"
    When user enters departure "<depLoc>" and destination "<desLoc>"
    When user selects "<date>"
    And user clicks search flight status
    And user updates flight status
    Then user verifies the updated status
    And user closes the App

    Examples:
      |browser|depLoc|desLoc|date|
      |chrome|CGN|TXL|Today|

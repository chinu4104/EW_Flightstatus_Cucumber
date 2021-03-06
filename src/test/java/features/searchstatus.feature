Feature: User searchs and tracks the flight status

  Scenario Outline: User verifies the flight status page title and webelements

    Given user opens flight status page in "<browser>"
    Then user verifies the flight status page title - "<title>"
    Then user verifies departure, destination, travel date and show flight status webelements
    And user closes the browser

    Examples:
    |browser|title|
    |chrome |Flight status - Information - Eurowings/Eurowings|

  Scenario Outline: User searches flight status for a route with specific date and verifies the same

  Given user opens flight status page in "<browser>"
  When user enters departure "<depLoc>" and destination "<desLoc>"
  When user selects travel date - "<date>"
  And user clicks search flight status
  Then user verifies the search results for user entered date "<date>"
  And user closes the browser

  Examples:
    |browser|depLoc|desLoc|date|
    |chrome|CGN|TXL|Today|
    |chrome|CGN|TXL|Tomorrow|

  Scenario Outline: User searches flight status for a route, updates the flight status and verifies the same
    Given user opens flight status page in "<browser>"
    When user enters departure "<depLoc>" and destination "<desLoc>"
    When user selects travel date - "<date>"
    And user clicks search flight status
    And user updates flight status
    Then user verifies the updated status
    And user closes the browser

    Examples:
      |browser|depLoc|desLoc|date|
      |chrome|CGN|TXL|Today|

  Scenario Outline: User searches flight status for a route and tracks the flight status
    Given user opens flight status page in "<browser>"
    When user enters departure "<depLoc>" and destination "<desLoc>"
    When user selects travel date - "<date>"
    And user clicks search flight status
    And user clicks track flight button of the first search result
    Then user verifies the tracked flights section
    And user closes the browser

    Examples:
      |browser|depLoc|desLoc|date|
      |chrome|CGN|TXL|Today|


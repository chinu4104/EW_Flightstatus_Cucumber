$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/java/features/searchstatus.feature");
formatter.feature({
  "name": "User search flight status",
  "description": "",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "name": "User searches for flight status for route with specific date and verifies the same",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "user open flight status page with browser \"\u003cbrowser\u003e\"",
  "keyword": "Given "
});
formatter.step({
  "name": "user enters departure \"\u003cdepLoc\u003e\" and destination \"\u003cdesLoc\u003e\"",
  "keyword": "When "
});
formatter.step({
  "name": "user selects \"\u003cdate\u003e\"",
  "keyword": "When "
});
formatter.step({
  "name": "user clicks search flight status",
  "keyword": "And "
});
formatter.step({
  "name": "user flights status should be displayed accordingly and date \"\u003cdate\u003e\" verification should be done",
  "keyword": "Then "
});
formatter.step({
  "name": "user closes the App",
  "keyword": "And "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "browser",
        "depLoc",
        "desLoc",
        "date"
      ]
    },
    {
      "cells": [
        "chrome",
        "CGN",
        "TXL",
        "Today"
      ]
    },
    {
      "cells": [
        "chrome",
        "CGN",
        "TXL",
        "Tomorrow"
      ]
    }
  ]
});
formatter.scenario({
  "name": "User searches for flight status for route with specific date and verifies the same",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "user open flight status page with browser \"chrome\"",
  "keyword": "Given "
});
formatter.match({
  "location": "SearchFlights.openApp(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user enters departure \"CGN\" and destination \"TXL\"",
  "keyword": "When "
});
formatter.match({
  "location": "SearchFlights.enterDeptDest(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user selects \"Today\"",
  "keyword": "When "
});
formatter.match({
  "location": "SearchFlights.selectDate(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user clicks search flight status",
  "keyword": "And "
});
formatter.match({
  "location": "SearchFlights.searchFlightstatus()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user flights status should be displayed accordingly and date \"Today\" verification should be done",
  "keyword": "Then "
});
formatter.match({
  "location": "SearchFlights.searchResultDateVerification(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user closes the App",
  "keyword": "And "
});
formatter.match({
  "location": "SearchFlights.closeApp()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "User searches for flight status for route with specific date and verifies the same",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "user open flight status page with browser \"chrome\"",
  "keyword": "Given "
});
formatter.match({
  "location": "SearchFlights.openApp(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user enters departure \"CGN\" and destination \"TXL\"",
  "keyword": "When "
});
formatter.match({
  "location": "SearchFlights.enterDeptDest(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user selects \"Tomorrow\"",
  "keyword": "When "
});
formatter.match({
  "location": "SearchFlights.selectDate(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user clicks search flight status",
  "keyword": "And "
});
formatter.match({
  "location": "SearchFlights.searchFlightstatus()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user flights status should be displayed accordingly and date \"Tomorrow\" verification should be done",
  "keyword": "Then "
});
formatter.match({
  "location": "SearchFlights.searchResultDateVerification(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user closes the App",
  "keyword": "And "
});
formatter.match({
  "location": "SearchFlights.closeApp()"
});
formatter.result({
  "status": "passed"
});
formatter.scenarioOutline({
  "name": "User searches flight status for route and update the status and verifies the same",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "user open flight status page with browser \"\u003cbrowser\u003e\"",
  "keyword": "Given "
});
formatter.step({
  "name": "user enters departure \"\u003cdepLoc\u003e\" and destination \"\u003cdesLoc\u003e\"",
  "keyword": "When "
});
formatter.step({
  "name": "user selects \"\u003cdate\u003e\"",
  "keyword": "When "
});
formatter.step({
  "name": "user clicks search flight status",
  "keyword": "And "
});
formatter.step({
  "name": "user updates flight status",
  "keyword": "And "
});
formatter.step({
  "name": "user verifies the updated status",
  "keyword": "Then "
});
formatter.step({
  "name": "user closes the App",
  "keyword": "And "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "browser",
        "depLoc",
        "desLoc",
        "date"
      ]
    },
    {
      "cells": [
        "chrome",
        "CGN",
        "TXL",
        "Today"
      ]
    }
  ]
});
formatter.scenario({
  "name": "User searches flight status for route and update the status and verifies the same",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "user open flight status page with browser \"chrome\"",
  "keyword": "Given "
});
formatter.match({
  "location": "SearchFlights.openApp(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user enters departure \"CGN\" and destination \"TXL\"",
  "keyword": "When "
});
formatter.match({
  "location": "SearchFlights.enterDeptDest(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user selects \"Today\"",
  "keyword": "When "
});
formatter.match({
  "location": "SearchFlights.selectDate(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user clicks search flight status",
  "keyword": "And "
});
formatter.match({
  "location": "SearchFlights.searchFlightstatus()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user updates flight status",
  "keyword": "And "
});
formatter.match({
  "location": "SearchFlights.clickUpdateStatus()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user verifies the updated status",
  "keyword": "Then "
});
formatter.match({
  "location": "SearchFlights.updateStatusVerification()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user closes the App",
  "keyword": "And "
});
formatter.match({
  "location": "SearchFlights.closeApp()"
});
formatter.result({
  "status": "passed"
});
});
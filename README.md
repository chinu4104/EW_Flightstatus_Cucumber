# EW - Flight status page - Test automation using cucumber

## Built with
* Maven 
* Selenium - Java
* Cucumber 
* Junit - Test framework

## Prerequisites

* [Open JDK 8](https://docs.oracle.com/cd/E19182-01/821-0917/inst_jdk_javahome_t/index.html)
* [Maven](https://maven.apache.org/install.html) 

## To clone this project 
```
git clone git@github.com:chinu4104/EW_Flightstatus_Cucumber.git
```

## Project Structure
* /src/test/java/driver : Common reusable methods
* /src/test/java/features : Feature file
* /src/test/java/runner: Cucumber test runner 
* /src/test/java/stepdefinitions: Step definitions using page object model
* /driver_linux: chrome and firefox drivers for Linux
* /driver_windows: chrome and firefox drivers for windows
* /cucumber-html-report: Test execution report 
* pom.xml : with all project dependencies and build plugins

## To test this project
```
cd <<<project directory path>>>
mvn clean test
```

## Test results
Cucumber HTML report (under projectfolder/cucumber-html-report/index.html)

_**Passed scenario**_

![Image of passed scenario](/images/Passed.png)

_**Failed scenario**_

![Image of Failed scenario](/images/Failed.png)

## Tested Environment
* OS 
  * Windows
  * Linux
* Browser
  * Chrome 79.x
  * Firefox 71.x

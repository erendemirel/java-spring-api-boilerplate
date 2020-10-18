## Automation Framework for Torus
#### Installing
The project doesn't require any external jars or configs. Simply pull it to use. Drivers are inside the project under _/resources_ so when Selenium Grid is deactivated, no need to use any external drivers

## Overview

- Project is based on Cucumber JVM
- Supports Page Object Model pattern
- Uses Allure as main reporting tool. Cucumber Reporting tool is also activated 
- Can be executed via Maven command that can take parameters from external config file
- Supports scenario context sharing among test steps using PicoContainer as dependency injection framework
- Supports any HTTP client library
- Uses an effective way to initialize page objects and supports @FindBy annotation
- Can run on remote with Selenium Grid

### Files

- Allure reports can be configured via

` <configuration>
  <resultsDirectory>${project.basedir}/allure-results</resultsDirectory>
 </configuration>`

- Cucumber reports can be configured via

`<configuration>
     <projectName>CucumberWebGui</projectName>
      <outputDirectory>${project.build.directory}</outputDirectory>
      <cucumberOutput>${project.build.directory}/cucumber.json</cucumberOutput>
       <skippedFails>true</skippedFails>
  </configuration>`

- Properties can be read from _config.properties_ and test data can be read from the file which is in json format, _testdata.json_

### Run 
Since project uses Cucumber, you can use Cucumber tags to organize tests. Also you must pass "grid" parameter to System properties since project runs on Selenium Grid. The default value is false. Example command:  

_mvn test -Dcucumber.filter.tags=@testtag -Dgrid=true_ 

Project uses Lombok. Make sure you have Lombok plugin installed and annotation processor enabled

### Generating Generic Data and Request Body
- javafaker(com.github.javafaker) can be used to generate generic data including credit card numbers. Generated credit card numbers complies with Luhn Check
- EeasyRandom(org.jeasy) can be used to generate random data from DTOs


### Running the API

- I implemented the API mentioned on the case study. **Before running API tests, you should first run the API**, there are two ways for this, the first one is running the API via:

**_mvn spring-boot:run_**

**or** alternatively,

**_mvn clean install_** and **_java -jar case-study-1.0-SNAPSHOT_** which is under target(Spring Boot Maven plugin packages a fat jar file here)

**Note that I used JDK 11**

### Running the Tests

- Web drivers are already included inside the project(_src/test/resources/webdriver_) so no need to change the driver paths. Note that **Chrome drivers are version 86 and Firefox is 0.27.0 and I only put Windows drivers. Also my local Chrome version is 86 and Firefox is 81.0.2**. If you want to use your own drivers, please specify the path inside _src/test/resources/config/config.properties_

To run the tests you may pass the browser parameter in command(It will read the property from config file if you don't), you may use below command to run the tests, after starting the API, you may use Maven commands via your IDE(IDE allows to run 2 Maven commands at the same time) or open different command windows:

For chrome:
_**test -Dcucumber.filter.tags=@casestudytests -Dbrowser=chrome**_

For Firefox:
_**test -Dcucumber.filter.tags=@casestudytests -Dbrowser=firefox**_

Note that it will read browser from configuration file when was not set in Maven command

Also alternatively, you may use your IDE to run tests(UI tests via feature file and API tests via regarding test class)

**Note that I used JDK 11**


## Overview

- The project consists of an API implemented via Spring Boot and tests based on Cucumber, JUnit, Selenium, Rest-assured, Java
- Test pattern is POM. Also Selenium PageFactory and @FindBy annotation is used
- I didn't too many explicit waits and didn't need to rely on implicit wait since Selenium already does the same with get() and click() methods. For page loads, I only checked if javascripts are loaded for once while on homepage. Also note that unfortunately I had to use Thread.sleep() for once, before logging in 
- I organised API tests and UI tests as different Cucumber feature files(_CaseStudyPart1_UI_ and _CaseStudyPart2_API_) which is under _src/test/resources/cucumber.features_. **Also, API tests are donated with JUnit @Test annotation and under** _src/test/java/restassured/tests/BookServiceTests.java_

### Files

- Properties can be read from _config.properties_ and test data can be read from the file which is in json format, _testdata.json_



### Swagger UI 

Swagger is integrated. You can use it instead of Postman etc. if you wish to. Once Spring Boot application is started up, you can access Swagger UI from:

_localhost:8080/swagger-ui/_



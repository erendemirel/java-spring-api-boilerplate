#### Başlamadan Önce
Spring boot uygulamasını ayağa kaldırın## Overview

- Project is based on Cucumber JVM
-  Page Object Model pattern
- Can be executed via Maven command that can take parameters from external config file
- Supports scenario context sharing among test steps using PicoContainer as dependency injection framework

### Files


- Properties can be read from _config.properties_ and test data can be read from the file which is in json format, _testdata.json_

### Run 
Since project uses Cucumber, you can use Cucumber tags to organize tests. Also you must pass "grid" parameter to System properties since project runs on Selenium Grid. The default value is false. Example command:  

_mvn test -Dcucumber.filter.tags=@casestudytests_ 


localhost:8080/swagger-ui/


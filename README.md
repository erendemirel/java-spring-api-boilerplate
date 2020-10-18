#### Başlamadan Önce
Spring boot uygulamasını ayağa kaldırın

## Overview

- 
-  

### Files


- Properties can be read from _config.properties_ and test data can be read from the file which is in json format, _testdata.json_

### Run 
Since project uses Cucumber, you can use Cucumber tags to organize tests. Also you must pass "grid" parameter to System properties since project runs on Selenium Grid. The default value is false. Example command:  

_mvn test -Dcucumber.filter.tags=@casestudytests_ 


localhost:8080/swagger-ui/


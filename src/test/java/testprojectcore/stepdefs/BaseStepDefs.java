package testprojectcore.stepdefs;

import org.apache.log4j.Logger;
import testprojectcore.base.DriverUtils;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.junit.jupiter.api.Order;


public class BaseStepDefs {
    @Before("@browser")
    @Order(Integer.MIN_VALUE)
    public void initOtherBrowsers() throws Exception {       //Here, initialize the driver before each step and close the browser after each step, these operations are done via cucumber tags therefore no need for inheritance and composition
        DriverUtils.initDriver();
    }

    @After("@browser")
    public void tearDown(Scenario scenario) {
        Logger logger = Logger.getLogger("Scenario Fail Status Logger");
        if (scenario.isFailed()) {
            logger.warn("Scenario failed: " + scenario.getName());
        }
        DriverUtils.closeDriver();
    }
}

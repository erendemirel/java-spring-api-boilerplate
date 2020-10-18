package stepdefs;

import testprojectcore.base.DriverUtils;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import org.junit.jupiter.api.Order;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.ByteArrayInputStream;


/**
 * @author Eren Demirel <eren.demirel@payten.com>
 */
public class BaseStepDefs {
    @Before("@browser")
    @Order(Integer.MIN_VALUE)
    public void initOtherBrowsers() throws Exception {       //Here, initialize the driver before each step and close the browser after each step, these operations are done via cucumber tags therefore no need for inheritance and composition
        DriverUtils.initDriver();
    }

    @After
    public void tearDown(Scenario scenario) {       //Take screenshot and add the attachment to the report if failed
        if (scenario.isFailed()) {
            if(scenario.getSourceTagNames().contains("@browser")){
                Allure.addAttachment("Scenario is failed...",
                        new ByteArrayInputStream(((TakesScreenshot) DriverUtils.getDriver()).getScreenshotAs(OutputType.BYTES)));
            }
            Allure.addAttachment("Scenario error: ", scenario.getName());
        }
        DriverUtils.closeDriver();
    }
}

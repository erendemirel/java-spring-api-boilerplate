package stepdefs;

import org.apache.log4j.Logger;
import testprojectcore.driverutil.PageObjectFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import pageobjects.*;
import testprojectcore.testcontext.ScenarioContext;
import testprojectcore.util.Helper;

public class UIStepDefs {

    private LoginPage loginPage;

    Logger logger = Logger.getLogger("Step Definitions Logger");

    public uistepDefs(ScenarioContext scenarioContext) {
        this.scenarioContext = scenarioContext;
        loginPage = PageObjectFactory.createClass(LoginPage.class);
    }


    @Given("Navigate")
    public void navigate() throws InterruptedException {
        homePage.navigateToHomepage();
    }

    @And("Login")
    public void login() throws Exception {
        homePage.waitForLoginButtonToBeClickable();
        homePage.clickLoginButton();
        loginPage.enterUsername();
        loginPage.enterPassword();
        loginPage.clickSubmit();
    }
}

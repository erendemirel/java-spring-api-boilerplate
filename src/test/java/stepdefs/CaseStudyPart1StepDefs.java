package stepdefs;

import testprojectcore.driverutil.PageObjectFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import pageobjects.*;
import testprojectcore.testcontext.ScenarioContext;
import testprojectcore.util.Helper;

public class CaseStudyPart1StepDefs {

    private ScenarioContext scenarioContext;
    private HomePage homePage;
    private LoginPage loginPage;
    private BoutiquePage boutiquePage;
    private CategoryPage categoryPage;


    public CaseStudyPart1StepDefs(ScenarioContext scenarioContext) {
        this.scenarioContext = scenarioContext;
        homePage = PageObjectFactory.createClass(HomePage.class);
        loginPage = PageObjectFactory.createClass(LoginPage.class);
        boutiquePage = PageObjectFactory.createClass(BoutiquePage.class);
        categoryPage = PageObjectFactory.createClass(CategoryPage.class);
    }


    @Given("Navigate to trendyol.com homepage")
    public void iNavigatedToNComHomepage() throws InterruptedException {
        homePage.navigateToHomepage();
        Helper.waitForJavascript(15000, 50);
    }

    @And("Close kadın-erkek fancybox")
    public void closeKadınErkekFancybox() {
        homePage.closeFancyBox();
    }


    @And("Login to trendyol.com")
    public void loginToTrendyolCom() throws Exception {
        homePage.waitForLoginButtonToBeClickable();
        homePage.clickLoginButton();
        loginPage.enterUsername();
        loginPage.enterPassword();
        loginPage.clickSubmit();
    }
}

package stepdefs;

import org.apache.log4j.Logger;
import testprojectcore.driverutil.PageObjectFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import pageobjects.*;
import testprojectcore.testcontext.ScenarioContext;
import testprojectcore.util.Helper;

public class CaseStudyPart1UIStepDefs {

    private ScenarioContext scenarioContext;
    private HomePage homePage;
    private LoginPage loginPage;
    private BoutiquePage boutiquePage;
    private CategoryPage categoryPage;
    private ProductDetailsPage productDetailsPage;

    Logger logger = Logger.getLogger("Step Definitions Logger");

    public CaseStudyPart1UIStepDefs(ScenarioContext scenarioContext) {
        this.scenarioContext = scenarioContext;
        homePage = PageObjectFactory.createClass(HomePage.class);
        loginPage = PageObjectFactory.createClass(LoginPage.class);
        boutiquePage = PageObjectFactory.createClass(BoutiquePage.class);
        categoryPage = PageObjectFactory.createClass(CategoryPage.class);
        productDetailsPage = PageObjectFactory.createClass(ProductDetailsPage.class);

    }


    @Given("Navigate to trendyol.com homepage")
    public void iNavigatedToNComHomepage() throws InterruptedException {
        homePage.navigateToHomepage();
    }

    @And("Close kadın-erkek fancybox if exists")
    public void closeKadınErkekFancybox() {
        homePage.closeFancyBoxIfExists();
    }


    @And("Login to trendyol.com")
    public void loginToTrendyolCom() throws Exception {
        homePage.waitForLoginButtonToBeClickable();
        homePage.clickLoginButton();
        loginPage.enterUsername();
        loginPage.enterPassword();
        loginPage.clickSubmit();
    }

    @And("Click all categories and check if all boutique images are loaded")
    public void clickAllCategoriesAndCheckIfAllBoutiqueImagesAreLoaded() throws Exception {
        for (int i = 0; i < homePage.returnCategoryHeadersListSize(); i++) {
            homePage.clickCategoryHeadersAccordingToALoopIndex(i);
            try {
                categoryPage.checkIfBoutiqueImagesAreDisplayed();
            } catch (Exception e) {
                logger.error(e);
            }
        }
    }

    @And("Click a random boutique")
    public void clickARandomBoutique() {
        categoryPage.clickARandomBoutique();
    }

    @And("Check if all product images are loaded")
    public void checkIfAllProductImagesAreLoaded() throws Exception {
        try {
            boutiquePage.checkIfProductImagesAreDisplayed();
        } catch (Exception e) {
            logger.error(e);
        }
    }

    @And("Click a random product")
    public void clickARandomProduct() {
        boutiquePage.clickARandomProduct();
    }

    @And("Add the product to the cart")
    public void addTheProductToTheCart() {
    }

    @And("Wait for javascript to load")
    public void waitForScriptsToLoad() throws InterruptedException {
        Helper.waitForJavascript(20000, 50);
    }

    @And("Close indirim popup if exists")
    public void closeIndirimPopupIfExists() {
        homePage.closeIndirimleriKacirmaPopupIfExists();
    }
}

package stepdefs;

import testprojectcore.base.DriverUtils;
import testprojectcore.driverutil.PageObjectFactory;
import io.cucumber.java.en.Given;
import org.junit.jupiter.api.Assertions;
import pageobjects.ExamplePage;
import testprojectcore.testcontext.ScenarioContext;


/**
 * @author Eren Demirel <eren.demirel@payten.com>
 */
public class ExampleStepDefs extends PageObjectFactory{

    private ExamplePage examplePage;
    private ScenarioContext scenarioContext;


    public ExampleStepDefs(ScenarioContext scenarioContext) {       //Inialize scenario context for context sharing among steps. PicoContainer is used for dependency injection
        this.scenarioContext = scenarioContext;
        examplePage = PageObjectFactory.createClass(ExamplePage.class);    //Initialize page objects. Initialize in step definitions class constructor using Pagefactory.createClass<>
    }


    @Given("Navigate to Wikipedia")
    public void navigateToWikipedia() {
        examplePage.navigateToHomePage();
        Assertions.assertEquals(DriverUtils.getDriver().getTitle(), "Wikipedia");
        scenarioContext.strInContext = DriverUtils.getDriver().getTitle();    //Put a data(String in this specific example) e.g. title of the page into the scenario context
    }

    @Given("Check if different language option links exist")
    public void checkIfDifferentLanguageOptionLinksExist() {
        Assertions.assertTrue(examplePage.verifyLanguageOptionsExist());
        System.out.println("Data in scenario context: " + scenarioContext.strInContext);    //Get the data from the scenario context
    }

    @Given("Go for Wikipedia articles in French")
    public void goForWikipediaArticlesInFrench() {
        examplePage.clickWikiInFrench();
    }
}

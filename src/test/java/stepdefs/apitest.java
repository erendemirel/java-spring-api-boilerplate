package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import restassured.tests.BookServiceTests;

public class APIStepDefs {

    BookServiceTests bookServiceTests = new BookServiceTests();


    @Given("Verify that the API starts with an empty store")
    public void verifyThatTheAPIStartsWithAnEmptyStore() {
        bookServiceTests.apiShouldStartWithAnEmptyStore();
    }


    @And("Verify that title and author are required fields")
    public void verifyThatTitleAndAuthorAreRequiredFields() {
        bookServiceTests.titleRequestParamShouldBeMandatory();
        bookServiceTests.authorRequestParamShouldBeMandatory();
    }

    @And("Verify that title and author cannot be empty")
    public void verifyThatTitleAndAuthorCannotBeEmpty() {
        bookServiceTests.titleRequestParamCannotBeEmpty();
        bookServiceTests.authorRequestParamCannotBeEmpty();
    }

    @And("Verify that the id field is read−only")
    public void verifyThatTheIdFieldIsReadOnly() {
        bookServiceTests.idShouldBeReadOnly();
    }

    @And("Verify that you can create a new book via PUT, created book returns in body and GET path param returns the same")
    public void verifyThatYouCanCreateANewBookViaPUTCreatedBookReturnsInBodyAndGETPathParamReturnsTheSame() {
        bookServiceTests.shouldGetTheCreatedBook();
    }

    @And("Verify that you cannot create a duplicate book")
    public void verifyThatYouCannotCreateADuplicateBook() {
        bookServiceTests.shouldNotCreateADuplicateBook();
    }
}

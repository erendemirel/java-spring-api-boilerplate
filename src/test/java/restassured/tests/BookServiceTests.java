package restassured.tests;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;


public class BookServiceTests extends APITestCase {


    @Test
    public void apiShouldStartWithAnEmptyStore() {
        RestAssured.baseURI = API_ROOT;

        Response response = given()
                .contentType("application/json")
                .when().log().all()
                .get("/books")
                .then().log().all()
                .contentType("")
                .statusCode(200)
                .extract().
                        response();

    }


    @Test
    public void authorRequestParamShouldBeMandatory() {
        RestAssured.baseURI = API_ROOT;

        JSONObject jsonObj = new JSONObject()
                .put("title", "test");
        Response response = (Response) given()
                .contentType("application/json")
                .body(jsonObj.toString())
                .when().log().all()
                .put("/books")
                .then().log().all()
                .contentType(JSON)
                .statusCode(400)
                .extract();

        Assertions.assertTrue(response.jsonPath().getString("errors[0]").equals(authorErrors_Required[0]));
        Assertions.assertTrue(response.jsonPath().getString("errors[1]").equals(authorErrors_Required[1]));

    }

    @Test
    public void titleRequestParamShouldBeMandatory() {
        RestAssured.baseURI = API_ROOT;

        JSONObject jsonObj = new JSONObject()
                .put("author", "test");
        Response response = (Response) given()
                .contentType("application/json")
                .body(jsonObj.toString())
                .when().log().all()
                .put("/books")
                .then().log().all()
                .contentType(JSON)
                .statusCode(400)
                .extract();

        Assertions.assertTrue(response.jsonPath().getString("errors[0]").equals(titleErrors_Required[0]));
        Assertions.assertTrue(response.jsonPath().getString("errors[1]").equals(titleErrors_Required[1]));

    }


    @Test
    public void authorRequestParamCannotBeEmpty() {
        RestAssured.baseURI = API_ROOT;

        JSONObject jsonObj = new JSONObject()
                .put("author", "")
                .put("title", "test");
        Response response = (Response) given()
                .contentType("application/json")
                .body(jsonObj.toString())
                .when().log().all()
                .put("/books")
                .then().log().all()
                .contentType(JSON)
                .statusCode(400)
                .extract();

        Assertions.assertTrue(response.jsonPath().getString("errors[0]").equals(authorErrors_Empty));

    }

    @Test
    public void titleRequestParamCannotBeEmpty() {
        RestAssured.baseURI = API_ROOT;

        JSONObject jsonObj = new JSONObject()
                .put("author", "test")
                .put("title", "");
        Response response = (Response) given()
                .contentType("application/json")
                .body(jsonObj.toString())
                .when().log().all()
                .put("/books")
                .then().log().all()
                .contentType(JSON)
                .statusCode(400)
                .extract();

        Assertions.assertTrue(response.jsonPath().getString("errors[0]").equals(titleErrors_Empty));

    }

    @Test
    public void idShouldBeReadOnly() {
        RestAssured.baseURI = API_ROOT;

        JSONObject jsonObj = new JSONObject()
                .put("id", 99)
                .put("author", "test")
                .put("title", "test");
        Response response = (Response) given()
                .contentType("application/json")
                .body(jsonObj.toString())
                .when().log().all()
                .put("/books")
                .then().log().all()
                .contentType("")
                .statusCode(400)
                .extract();

    }

    public Response createANewBook() {
        RestAssured.baseURI = API_ROOT;

        JSONObject jsonObj = new JSONObject()
                .put("author", "test" + Faker.instance().name().firstName())
                .put("title", "test" + Faker.instance().name().lastName());
        Response response = (Response) given()
                .contentType("application/json")
                .body(jsonObj.toString())
                .when().log().all()
                .put("/books")
                .then().log().all()
                .contentType(JSON)
                .statusCode(201)
                .extract();

        return response;

    }

    @Test
    public void shouldGetTheCreatedBook() {
        Response createANewBookResponse = createANewBook();
        RestAssured.baseURI = API_ROOT;

        Response response = given().pathParam("book_id", createANewBookResponse.jsonPath().get("id")).
                when().get("/books/{book_id}").then().contentType(JSON).statusCode(200).extract().
                response();

        Assertions.assertTrue(response.jsonPath().getString("author").equals(createANewBookResponse.jsonPath().getString("author")));
        Assertions.assertTrue(response.jsonPath().getString("title").equals(createANewBookResponse.jsonPath().getString("title")));


    }

    @Test
    public void shouldNotCreateADuplicateBook() {
        RestAssured.baseURI = API_ROOT;
        String author = Faker.instance().idNumber().valid();
        String title = Faker.instance().name().username();

        JSONObject jsonObj = new JSONObject()
                .put("author", "test" + author)
                .put("title", "test" + title);
        Response response = (Response) given()
                .contentType("application/json")
                .body(jsonObj.toString())
                .when().log().all()
                .put("/books")
                .then().log().all()
                .contentType(JSON)
                .statusCode(201)
                .extract();

        JSONObject secondJsonObj = new JSONObject()
                .put("author", "test" + author)
                .put("title", "test" + title);
        Response secondResponse = (Response) given()
                .contentType("application/json")
                .body(secondJsonObj.toString())
                .when().log().all()
                .put("/books")
                .then().log().all()
                .contentType(JSON)
                .statusCode(400)
                .extract();

    }

}


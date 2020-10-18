package testprojectcore.testcontext;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;

public class ScenarioContext {

    protected Response restassuredResponse;
    protected ValidatableResponse restassuredResponseJson;
    protected RequestSpecification restassredRequest;
    public String strInContext;
    public int intInContext;
    public Object objInContext;
    public HashMap<String, String> hashMapInContext = new HashMap<>();
}

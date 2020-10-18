package restassured.tests;

public class APITestCase {

    static final String API_ROOT = "http://localhost:8080/api/";
    static final String authorErrors_Empty = "Field 'author' cannot be empty.";
    static final String titleErrors_Empty = "Field 'title' cannot be empty.";
    static final String authorErrors_Required[] = new String[]{
            "Field 'author' is required.", "Field 'author' cannot be empty."};
    static final String titleErrors_Required[] = new String[]{
            "Field 'title' is required.", "Field 'title' cannot be empty."};
}

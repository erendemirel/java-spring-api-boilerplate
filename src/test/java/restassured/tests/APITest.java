package restassured.tests;

public class APITestCase {

    static final String API_ROOT = "http://localhost:8080/api/";

    static final String ERR_AUTHOR_EMPTY = "Field 'author' cannot be empty.";

    static final String ERR_TITLE_EMPTY = "Field 'title' cannot be empty.";

    static final String ERR_AUTHOR_REQUIRED[] = new String[]{
            "Field 'author' is required.", "Field 'author' cannot be empty."};

    static final String ERR_TITLE_REQUIRED[] = new String[]{
            "Field 'title' is required.", "Field 'title' cannot be empty."};

    static final String ERR_DUPLICATE_BOOK = "Another book with similar title and author already exists.";

}

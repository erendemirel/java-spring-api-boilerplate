@tests

Feature: Some API tests

  Scenario: Test basic functionality

    * Verify that the API starts with an empty store
    * Verify that title and author are required fields
    * Verify that title and author cannot be empty
    * Verify that the id field is read−only
    * Verify that you can create a new book via PUT, created book returns in body and GET path param returns the same
    * Verify that you cannot create a duplicate book

@casestudytests

Feature: Case study section-II.

  Scenario: Apply given steps in case study, API Part

    Given Verify that the API starts with an empty store
    And Verify that title and author are required fields
    And Verify that title and author cannot be empty
    And Verify that the id field is read−only
    And Verify that you can create a new book via PUT, created book returns in body and GET path param returns the same
    And Verify that you cannot create a duplicate book

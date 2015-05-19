@~test
Feature: Testing DynamoDB

  Scenario: Fetching the data from DynamoDB
    Given a user
    When user query the data from db
    Then he should get the correct data

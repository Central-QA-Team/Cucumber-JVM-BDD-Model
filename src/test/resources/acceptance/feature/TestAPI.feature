@TestAPI

Feature: To test API through REST Assured

  Scenario: Test UAS POST Plays request

    Given the server is up and running
    When the client perform the POST request "/my/plays"
    Then the client should get an "Accepted" response
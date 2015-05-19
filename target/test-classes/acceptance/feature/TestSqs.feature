@noWebDriver
@test1

Feature: Testing Sqs

  Scenario: Sending message to sqs
    Given a user
    When user send a message to queue
    Then he should be able to view the message in queue
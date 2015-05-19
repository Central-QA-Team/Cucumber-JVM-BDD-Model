$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("\u0027acceptance\\feature\\TestDynamoDB.feature\u0027");
formatter.feature({
  "id": "testing-dynamodb",
  "tags": [
    {
      "name": "@test",
      "line": 1
    }
  ],
  "description": "",
  "name": "Testing DynamoDB",
  "keyword": "Feature",
  "line": 2
});
formatter.scenario({
  "id": "testing-dynamodb;fetching-the-data-from-dynamodb",
  "description": "",
  "name": "Fetching the data from DynamoDB",
  "keyword": "Scenario",
  "line": 4,
  "type": "scenario"
});
formatter.step({
  "name": "a user",
  "keyword": "Given ",
  "line": 5
});
formatter.step({
  "name": "user query the data from db",
  "keyword": "When ",
  "line": 6
});
formatter.step({
  "name": "he should get the correct data",
  "keyword": "Then ",
  "line": 7
});
formatter.match({
  "location": "DynamoStepdefs.a_user()"
});
formatter.result({
  "duration": 79958110,
  "status": "passed"
});
formatter.match({
  "location": "DynamoStepdefs.user_query_the_data_from_db()"
});
formatter.result({
  "duration": 1403307651,
  "status": "passed"
});
formatter.match({
  "location": "DynamoStepdefs.he_should_get_the_correct_data()"
});
formatter.result({
  "duration": 27099808,
  "status": "passed"
});
});
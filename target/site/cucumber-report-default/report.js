$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("GoogleScenarios.feature");
formatter.feature({
  "line": 2,
  "name": "Validate Google search result",
  "description": "As a user\r\nI want to validate the Google search result",
  "id": "validate-google-search-result",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@GoogleScenarios"
    }
  ]
});
formatter.scenario({
  "comments": [
    {
      "line": 6,
      "value": "#  Scenario: 01 - Validate Google search result"
    },
    {
      "line": 7,
      "value": "#    Given I open the Google website"
    },
    {
      "line": 8,
      "value": "#    When I search for the \"the beatles\" keyword"
    },
    {
      "line": 9,
      "value": "#    Then I verify all the main results contains the keyword"
    },
    {
      "line": 10,
      "value": "#    And I verify all the results in People also ask section contains the keyword"
    },
    {
      "line": 11,
      "value": "#    And I verify all the results in the Top Stories section contains the keyword"
    },
    {
      "line": 12,
      "value": "#    And I verify all the results in the Videos section contains the keyword"
    },
    {
      "line": 13,
      "value": "#    And I verify the inputted string remained on the search box"
    }
  ],
  "line": 15,
  "name": "02 - Validate YouTube result from Google search",
  "description": "",
  "id": "validate-google-search-result;02---validate-youtube-result-from-google-search",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 16,
  "name": "I open the Google website",
  "keyword": "Given "
});
formatter.step({
  "line": 17,
  "name": "I search for the \"the beatles\" keyword",
  "keyword": "When "
});
formatter.step({
  "line": 18,
  "name": "I open the first Youtube video result on Google search",
  "keyword": "And "
});
formatter.step({
  "line": 19,
  "name": "I pause the video after 10 seconds",
  "keyword": "And "
});
formatter.step({
  "line": 20,
  "name": "I verify the video tittle is same to Google result",
  "keyword": "Then "
});
formatter.step({
  "line": 21,
  "name": "the video is paused accordingly",
  "keyword": "And "
});
formatter.match({
  "location": "GoogleSteps.i_open_the_Google_website()"
});
formatter.result({
  "duration": 7610087200,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "the beatles",
      "offset": 18
    }
  ],
  "location": "GoogleSteps.i_search_for_the_keyword(String)"
});
formatter.result({
  "duration": 2257045300,
  "status": "passed"
});
formatter.match({
  "location": "GoogleSteps.i_open_the_first_Youtube_video_result_on_Google_search()"
});
formatter.result({
  "duration": 1599119900,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "10",
      "offset": 24
    }
  ],
  "location": "GoogleSteps.i_pause_the_video_after_seconds(int)"
});
formatter.result({
  "duration": 9354898900,
  "status": "passed"
});
formatter.match({
  "location": "GoogleSteps.i_verify_the_video_tittle_is_same_to_Google_result()"
});
formatter.result({
  "duration": 25549200,
  "status": "passed"
});
formatter.match({
  "location": "GoogleSteps.the_video_is_paused_accordingly()"
});
formatter.result({
  "duration": 182569600,
  "error_message": "java.lang.NullPointerException\r\n\tat commons.AbstractTest.checkTrue(AbstractTest.java:71)\r\n\tat commons.AbstractTest.verifyTrue(AbstractTest.java:77)\r\n\tat stepDefinitions.GoogleSteps.the_video_is_paused_accordingly(GoogleSteps.java:97)\r\n\tat ✽.And the video is paused accordingly(GoogleScenarios.feature:21)\r\n",
  "status": "failed"
});
formatter.after({
  "duration": 806546600,
  "status": "passed"
});
});
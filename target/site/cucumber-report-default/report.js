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
  "line": 6,
  "name": "01 - Validate Google search result",
  "description": "",
  "id": "validate-google-search-result;01---validate-google-search-result",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 7,
  "name": "I open the Google website",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "I search for the \"the beatles\" keyword",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "I verify all the main results contains the keyword",
  "keyword": "Then "
});
formatter.step({
  "line": 10,
  "name": "I verify all the results in People also ask section contains the keyword",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "I verify all the results in the Top Stories section contains the keyword",
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "I verify all the results in the Videos section contains the keyword",
  "keyword": "And "
});
formatter.step({
  "line": 13,
  "name": "I verify the inputted string remained on the search box",
  "keyword": "And "
});
formatter.match({
  "location": "GoogleSteps.i_open_the_Google_website()"
});
formatter.result({
  "duration": 10409432000,
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
  "duration": 4920589400,
  "status": "passed"
});
formatter.match({
  "location": "GoogleSteps.i_verify_all_the_main_results_contains_the_keyword()"
});
formatter.result({
  "duration": 468966600,
  "status": "passed"
});
formatter.match({
  "location": "GoogleSteps.i_verify_all_the_results_in_People_also_ask_section_contains_the_keyword()"
});
formatter.result({
  "duration": 274799900,
  "status": "passed"
});
formatter.match({
  "location": "GoogleSteps.i_verify_all_the_results_in_the_Top_Stories_section_contains_the_keyword()"
});
formatter.result({
  "duration": 100646500,
  "status": "passed"
});
formatter.match({
  "location": "GoogleSteps.i_verify_all_the_results_in_the_Videos_section_contains_the_keyword()"
});
formatter.result({
  "duration": 535753700,
  "status": "passed"
});
formatter.match({
  "location": "GoogleSteps.i_verify_the_inputted_string_remained_on_the_search_box()"
});
formatter.result({
  "duration": 28320800,
  "status": "passed"
});
formatter.after({
  "duration": 896035700,
  "status": "passed"
});
formatter.scenario({
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
formatter.match({
  "location": "GoogleSteps.i_open_the_Google_website()"
});
formatter.result({
  "duration": 8371993300,
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
  "duration": 8446181800,
  "status": "passed"
});
formatter.match({
  "location": "GoogleSteps.i_open_the_first_Youtube_video_result_on_Google_search()"
});
formatter.result({
  "duration": 6582382000,
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
  "duration": 10728618700,
  "status": "passed"
});
formatter.match({
  "location": "GoogleSteps.i_verify_the_video_tittle_is_same_to_Google_result()"
});
formatter.result({
  "duration": 177975000,
  "status": "passed"
});
formatter.after({
  "duration": 894657800,
  "status": "passed"
});
});
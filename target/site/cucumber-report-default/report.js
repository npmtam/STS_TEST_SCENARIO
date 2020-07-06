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
  "duration": 7756585400,
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
  "duration": 2083053000,
  "status": "passed"
});
formatter.match({
  "location": "GoogleSteps.i_verify_all_the_main_results_contains_the_keyword()"
});
formatter.result({
  "duration": 209442900,
  "status": "passed"
});
formatter.match({
  "location": "GoogleSteps.i_verify_all_the_results_in_People_also_ask_section_contains_the_keyword()"
});
formatter.result({
  "duration": 89448000,
  "status": "passed"
});
formatter.match({
  "location": "GoogleSteps.i_verify_all_the_results_in_the_Top_Stories_section_contains_the_keyword()"
});
formatter.result({
  "duration": 66136100,
  "status": "passed"
});
formatter.match({
  "location": "GoogleSteps.i_verify_all_the_results_in_the_Videos_section_contains_the_keyword()"
});
formatter.result({
  "duration": 231670200,
  "status": "passed"
});
formatter.match({
  "location": "GoogleSteps.i_verify_the_inputted_string_remained_on_the_search_box()"
});
formatter.result({
  "duration": 19517800,
  "status": "passed"
});
});
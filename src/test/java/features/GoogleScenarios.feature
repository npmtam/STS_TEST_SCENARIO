@GoogleScenarios
Feature: Validate Google search result
  As a user
  I want to validate the Google search result

#  Scenario: 01 - Validate Google search result
#    Given I open the Google website
#    When I search for the "the beatles" keyword
#    Then I verify all the main results contains the keyword
#    And I verify all the results in People also ask section contains the keyword
#    And I verify all the results in the Top Stories section contains the keyword
#    And I verify all the results in the Videos section contains the keyword
#    And I verify the inputted string remained on the search box

  Scenario: 02 - Validate YouTube result from Google search
    Given I open the Google website
    When I search for the "the beatles" keyword
    And I open the first Youtube video result on Google search
    And I pause the video after 10 seconds
    Then I verify the video tittle is same to Google result
    And the video is paused accordingly
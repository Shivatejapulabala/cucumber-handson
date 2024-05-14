Feature: Click Counter Functionality
  As a user of the click counter page
  I want to click the button
  So that the counter display the click count.

  Scenario: Correct Counter Display
    Given I am on the click counter page with initial count as 0
    When I click the 'Click Me!' button 5 times
    Then the counter should show the count of the clicks

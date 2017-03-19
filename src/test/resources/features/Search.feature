@SetupDriver
Feature: Search
  As a user
  I want to search the web app
  In order to know what available product follow my search criteria

  @GoHomePage
  Scenario: A user makes a search clicking one specific result of the suggestion dropdown
    Given I am at the home page
    When I look for "kindle fire" in the search bar
    And I choose the "kindle fire hd" item in the suggestion dropdown
    Then the page returns the result for "kindle fire hd"
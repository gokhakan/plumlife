@regression @search
Feature: Search functionality

  Scenario: [1] Search property based on location
      Given user is on home page
      When user searches properties in "Manchester"
      Then user gets properties in "Manchester"

  @wip
  Scenario: [2] Search property based on  number of bedrooms
    Given user is on home page
    When user searches properties in "Manchester" with "4" bedrooms
    Then user gets properties in "Manchester" with "4" bedrooms




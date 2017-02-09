Feature: Find taxi stands by location
  In order to plan my getaway
  As a car-less bank robber
  I want to know all the taxi stands in a given location

  Scenario: Provie useful practical information about each taxi rank
    Given Joe is planning a getaway from Canary Wharf
    When he looks for the closest taxi rank within 100 meters
    Then he should find the taxi ranks with the following details
      | commonName     | NumberOfSpaces | OperationDays | OperationTimes |
      | 40 Bank Street | 1              | Mon - Sun     | 24 hours       |
      | Bank Street    | 4              | Mon - Sun     | 24 hours       |
      | 50 Bank Street | 10             | Mon - Sun     | 24 hours       |

Feature: Find taxi stands by location
  In order to plan my getaway
  As a car-less bank robber
  I want to know all the taxi stands in a given location

#  @manual
#    @manual-result:failure
  Scenario Outline: Provide useful practical information about each taxi rank at <Location>
    Given Joe is planning a getaway from <Location>
    When he looks for the closest taxi rank within <Distance> meters
    Then he should find the taxi ranks with the following details
      | commonName     | NumberOfSpaces | OperationDays | OperationTimes |
      | 40 Bank Street | 1              | Mon - Sun     | 24 hours       |
      | Bank Street    | 4              | Mon - Sun     | 24 hours       |
      | 50 Bank Street | 10             | Mon - Sun     | 24 hours       |

    Examples:
      | Location     | Distance |
      | Canary Wharf | 90       |
      | Canary Wharf | 100      |
      | Canary Wharf | 120      |
      | Canary Wharf | 150      |

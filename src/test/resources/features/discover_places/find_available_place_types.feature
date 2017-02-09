Feature: Find available place types
  In order to make my application more flexible
  As an application developer
  I want to know about the types of places supported by the TFL API

  Scenario Outline: List all available place types in different formats
    When I retrieve all the available place types in <format>
    Then I should see at least the following place types:
      | CarPark   |
      | CyclePark |
      | SpeedCam  |
      | TaxiRank  |

    Examples:
      | format |
      | XML    |
      | JSON   |

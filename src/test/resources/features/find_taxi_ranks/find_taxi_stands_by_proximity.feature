Feature: Find taxi stands by proximity
  In order to get home alive
  As an inebriated business man
  I want to find the taxi stand nearest to my current location

  Scenario Outline: All the taxi ranks within a given distance should be shown
    Given Joe is at <station>
    When he looks for the closest taxi rank within <distance> meters
    Then <number-of-taxis> taxi ranks should be found
    And all of the taxi ranks should be no more than <distance> meters away
    Examples:
      | station               | distance | number-of-taxis |
      | London Bridge Station | 500      | 5               |
      | London Bridge Station | 1000     | 18              |
      | Canary Wharf          | 100      | 3               |
      | Canary Wharf          | 20       | 0               |

  Scenario: The closest taxi rank should appear first
    Given Joe is at London Bridge Station
    When he looks for the closest taxi rank within 500 meters
    Then the first taxi rank should be:
      | commonName                       | distance  |
      | Tooley Street (Duke Street Hill) | 182.06776 |

  Scenario: Where there are no taxi stands nearby none should be found
    Given Joe is at London Bridge Station
    When he looks for the closest taxi rank within 50 meters
    Then no taxi racks should be returned

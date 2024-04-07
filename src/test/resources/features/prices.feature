Feature: IT of prices REST Endpoint

  Scenario: 1 GET to /prices at 10:00 on the 14th of product 35455 for brand 1 (ZARA)
    Given GET to prices at "2020-06-14-10.00.00" of product 35455 for brand 1
    When http request executed
    Then the response status code is 200
    And the response body contains prices/get-scenario-1.json

  Scenario: 2 GET to /prices at 16:00 on the 14th of product 35455 for brand 1 (ZARA)
    Given GET to prices at "2020-06-14-16.00.00" of product 35455 for brand 1
    When http request executed
    Then the response status code is 200
    And the response body contains prices/get-scenario-2.json

  Scenario: 3 GET to /prices at 21:00 on the 14th of product 35455 for brand 1 (ZARA)
    Given GET to prices at "2020-06-14-21.00.00" of product 35455 for brand 1
    When http request executed
    Then the response status code is 200
    And the response body contains prices/get-scenario-3.json

  Scenario: 4 GET to /prices at 10:00 on the 15th of product 35455 for brand 1 (ZARA)
    Given GET to prices at "2020-06-15-10.00.00" of product 35455 for brand 1
    When http request executed
    Then the response status code is 200
    And the response body contains prices/get-scenario-4.json

  Scenario: 5 GET to /prices at 21:00 on the 16th of product 35455 for brand 1 (ZARA)
    Given GET to prices at "2020-06-16-21.00.00" of product 35455 for brand 1
    When http request executed
    Then the response status code is 200
    And the response body contains prices/get-scenario-5.json

  Scenario: 6 GET to /prices at 21:00 on the 16th of product 45455 for brand 1 (ZARA)
    Given GET to prices at "2020-06-16-21.00.00" of product 45455 for brand 1
    When http request executed
    Then the response status code is 404
    And the response body contains prices/get-scenario-6.json

  Scenario: 7 GET to /prices at 25:00 on the 32th of product 45455 for brand 1 (ZARA)
    Given GET to prices at "2020-06-32-25.00.00" of product 45455 for brand 1
    When http request executed
    Then the response status code is 400
    And the response body contains prices/get-scenario-7.json

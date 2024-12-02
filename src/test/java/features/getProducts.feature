Feature: Get all products from the api
  Scenario: Verify the get api for the products
    Given I hit the url of get api products endpoint
    When I pass the url of product in the request
    Then I receive the response code as 200

  Scenario: Verify the rate of the first product is correct
      Given I hit the url of get api products endpoint
      When I pass the url of product in the request
      Then I verify the rate of the first product is <FirstProductRate>
    Example:
      |FirstProductRate|
      |3.9             |
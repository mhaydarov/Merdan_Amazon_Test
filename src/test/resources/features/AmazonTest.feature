Feature: User should be able to search a product and add it to basket

  @mh
  Scenario: Searching a product and adding to the basket
    Given the user is on the login page
    When user login with valid credentials
    When user types "iphone 13 pro max" though the top search field
    Then user sees the results page for "iphone 13 pro max"
    When user clicks on product number 3 from the list and adds it to basket
    Then user sees basket containing the product
    When user increases product quantity by 2 the subtotal changes accordingly

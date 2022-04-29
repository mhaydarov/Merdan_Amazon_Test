Feature: User should be able to search a product and add it to basket

  @mh
  Scenario: Searching a product and adding to the basket
    Given the user is on the login page
    When user login with valid credentials
    When user types "Rick and Morty" though the top search field
    Then user sees the results page for "Rick and Morty"

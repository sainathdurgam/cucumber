Feature: Search Page
  as user of moviesapp
  i want search movies
  and watch movie





  Scenario: Search Functionality
    Given am on Home pagee
    When Should display the search icon in header Section and click search icon
    And After clicking search icon Search Input Box should display and Ok button should display
    Then user enter valid movie name in searchInput and clicking ok button movies should display
    Then user enter Invalid movie name in serachInput and clikcing ok button error message should display



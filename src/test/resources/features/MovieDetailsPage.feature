Feature: Movie Details Page
  As a user of Moviesapp
  after clicking on movie in home page or popular page
  user want to know movie details , review etc

  Scenario: Movie detail in Home page
    Given Iam on Home page
    When clicking on movie
    Then movie details will display in movie page

  Scenario: Movie detail in popular page
    Given Iam on Home page
    When  clicking on popular anchar
    And   clicking on popular movie
    Then  movie details will display in movie page
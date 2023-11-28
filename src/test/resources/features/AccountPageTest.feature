Feature: AccountPage
  as user of Movieapp
  user can able to see account details
  he can bale to logout

  Scenario: account details
    Given Iam on homepage
    When click on account Icon
    Then see account details

   Scenario: account logout
     Given Iam on homepage
     When click on account Icon
     And click on logout button
     Then redirect to login page

Feature: Identification

  Scenario: compare identification
    Given user logged in homepage
    And user clicks "my" button
    And user clicks "self" title
    When user takes user's "fullname" and user's "role"
    And user gets fullname and role from API
    And user obtains fullname and roles from Database
    Then UI information matches with API
    And API information matches with Database
    And UI information matches with Database





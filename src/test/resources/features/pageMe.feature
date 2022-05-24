Feature: Identification

  @wip38
  Scenario Outline: compare identification
    Given user logged in homepage with following credentials "<username>" and "<password>"
    And user clicks "my" button
    And user clicks "self" title
    When user takes user's fullName and user's role
    And user gets fullName and role from API
    #And user obtains fullname and roles from Database
    Then UI information matches with API
    #And API information matches with Database
    #And UI information matches with Database

    Examples:
      | username                 | password     |
      | sbirdbj@fc2.com          | asenorval    |
      #| wboeck5c@theguardian.com | waiteboeck   |
      #| ccornil1h@usnews.com     | corniecornil |





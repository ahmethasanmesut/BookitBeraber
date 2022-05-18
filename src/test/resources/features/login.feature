Feature: login functionality
 @wip
  Scenario Outline: login to bookIt app
    Given user is on the login page
    When user write "<username>" and "<password>"
    Then user is on the home page

    Examples:
      | username                 | password     |
      | sbirdbj@fc2.com          | asenorval    |
      | wboeck5c@theguardian.com | waiteboeck   |
      | ccornil1h@usnews.com     | corniecornil |
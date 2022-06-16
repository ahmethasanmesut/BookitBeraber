Feature: Booking

  @wip1
  Scenario: Booking for Apple
    Given user logged in homepage with following credentials "sbirdbj@fc2.com" and "asenorval"
    When user books one "amazon" room for tomorrow at time slot between "7:00am" and "8:00am"
    Then reserved room is displayed in schedule
     @db
    Scenario: End2End Testing
      Given user logged in homepage with following credentials "sbirdbj@fc2.com" and "asenorval"
      When user books one "amazon" room for tomorrow at time slot between "7:00am" and "8:00am"
      Then UI booking matches with Database information


Feature: Booking

  @wip1
  Scenario: Booking for Apple
    Given user logged in homepage with following credentials "sbirdbj@fc2.com" and "asenorval"
    When user books one "google" room on this "May 31, 2022" at time slot between "07:00" and "09:00"
    Then reserved room is displayed in schedule

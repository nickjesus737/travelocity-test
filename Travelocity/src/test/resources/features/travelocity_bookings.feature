Feature: Travelocity bookings
  As a traveler
  I want to make some bookings in the travelocity page
  So that I can test its features

  @SuccessfulScenario
  Scenario: The user books a one-way flight
    Given The actor "traveler" is in the Travelocity home page
    When He tries to book the cheapest one-way flight from "Medellin" to "Cartagena" for 2 "adults" and 7 days from today
    Then he should see that the flight has the right origin, destination, travelers and price

  @SuccessfulScenario
  Scenario: The user books a one-way flight making different filters

  @SuccessfulScenario
  Scenario: The user books a hotel room

  @FailedScenario
  Scenario: The user tries to book a flight without completing the information

  @FailedScenario
  Scenario: The user tries to book a flight with the wrong information
Feature: Travelocity bookings
  As a traveler
  I want to make some bookings in the travelocity page
  So that I can test its features

  @SuccessfulScenario
  Scenario: The user books a one-way flight
    Given The actor "traveler" is in the Travelocity home page
    When He tries to book the cheapest flight one-way flight from "Medellin" to "Cartagena" for 2 "adults" and 7 days from today
    And He Books the flight
    Then he should see that the flight has the right origin, destination, travelers and price

  @SuccessfulScenario
  Scenario: The user books a one-way flight making different filters
    Given The actor "traveler" is in the Travelocity home page
    When He tries to book a one-way flight from "Medellin" to "Cartagena" for 2 "adults" and 14 days from today
    And He filters for 0 stops, "LATAM" airline and "Afternoon" departure
    And He Books the flight
    Then he should see that the flight has the right origin, destination, travelers, filters and price

  @SuccessfulScenario
  Scenario: The user books a hotel room
    Given The actor "traveler" is in the Travelocity home page
    When He tries to book the first recommended stay to "Cartagena" for 2 "adults" for 5 days and 14 days from today
    And He Books the Stay
    Then he should see that the stay has the right travelers, dates and price

  @FailedScenario
  Scenario: The user tries to book a flight without completing the information
    Given The actor "traveler" is in the Travelocity home page
    When He tries to book a flight without completing the information
    Then He should see an error message with the text "To continue, please correct the 2 errors below."

  @FailedScenario
  Scenario: The user tries to book a stay without completing the information
    Given The actor "traveler" is in the Travelocity home page
    When He tries to book a stay without completing the information
    Then He should see an error message with the text "To continue, please correct the error below."
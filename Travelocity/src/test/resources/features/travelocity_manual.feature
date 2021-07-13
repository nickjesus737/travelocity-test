Feature: Travelocity Manual Test
  As a traveler
  I want to make some bookings in the travelocity page
  So that I can test its features

  @manual
  Scenario: The user changes the flight type from One-way to Roundtrip and see the new fields
    Given The actor is in the Travelocity home page
    When He selects the One-Way option and then selects the Roundtrip option
    Then He should see that the form shows the Returning and Add a Car fileds

  @manual
  Scenario: The user adds a new stop to a multi-city flight
    Given The actor is in the Travelocity home page
    When He selects the Multic-City option and then clicks the Add another flight option
    Then He should see that the form shows the fields for another flight

  @manual
  Scenario: The user deletes a stop in the multi-city flight
    Given The actor is in the Travelocity home page
    When He selects the Multic-City option, clicks the Add another flight option and the clicks the Remove flight option
    Then He should see that the form deletes the fields of the flight

  @manual
  Scenario: The user filters for nonstop flights
    Given The actor is in the Travelocity home page
    When He searches for a flight and selects the nonstop filter
    Then He should see that in the results there are only nonstop flights

  @manual
  Scenario: The user filters for morning flights
    Given The actor is in the Travelocity home page
    When He searches for a flight and selects the departure in the morning filter
    Then He should see that in the results there are only flights that departure in the morning

  @manual
  Scenario: The user filters for one specific airline in the flights results
    Given The actor is in the Travelocity home page
    When He searches for a flight and selects one airline from the filters
    Then He should see that in the results there are only flights from that airline

  @manual
  Scenario: The user changes the departure date in the flights results
    Given The actor is in the Travelocity home page
    When He searches for a flight and change the date in the date slider
    Then He should see that the results updates

  @manual
  Scenario: The user clicks on the tab of the stay description page
    Given The actor is in the Travelocity home page
    When He searches for a stay, goes to the description page and clicks on the tabs
    Then He should see that the information is shown according to the tab selected

  @manual
  Scenario: The user clicks on the map of the stay description page
    Given The actor is in the Travelocity home page
    When He searches for a stay, goes to the description page and clicks on the map
    Then He should see that a new window is open and the map with the location of the stay is shown

  @manual
  Scenario: The user adds a flight in the stay search
    Given The actor is in the Travelocity home page
    When He searches for a stay and checks the Add a flight checkbox
    Then He should see that a field for the departure city is shown

  @manual
  Scenario: The user filters for 5 stars in the stays results
    Given The actor is in the Travelocity home page
    When He searches for a stay and selects the 5 stars filter
    Then He should see that in the results there are only stays with 5 stars

  @manual
  Scenario: The user filters for property type in the stays results
    Given The actor is in the Travelocity home page
    When He searches for a stay and selects the hotel property type
    Then He should see that in the results there are only hotels

  @manual
  Scenario: The user filters for neighborhood in the stays results
    Given The actor is in the Travelocity home page
    When He searches for a stay and selects a neighborhood from the filters
    Then He should see that in the results there are only stays from that neighborhood

  @manual
  Scenario: The user changes the days of stay in the stay description page
    Given The actor is in the Travelocity home page
    When He searches for a stay, changes the days of stay and checks the rates
    Then He should see that the results updates with the new dates

  @manual
  Scenario: The user check the hotel room pictures
    Given The actor is in the Travelocity home page
    When He searches for a stay, selects a hotel and clicks on the pictures of a room
    Then He should see that a pge with the room description and pictures of the room are shown
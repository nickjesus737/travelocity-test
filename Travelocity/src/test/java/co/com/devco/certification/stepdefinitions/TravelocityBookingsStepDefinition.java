package co.com.devco.certification.stepdefinitions;

import co.com.devco.certification.exceptions.flights.BookFlightException;
import co.com.devco.certification.questions.TheFlight;
import co.com.devco.certification.questions.TheStay;
import co.com.devco.certification.tasks.OpenThe;
import co.com.devco.certification.tasks.flights.*;
import co.com.devco.certification.tasks.stays.BookTheHotel;
import co.com.devco.certification.tasks.stays.SearchAStay;
import co.com.devco.certification.tasks.stays.SelectTheFirstRecommended;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static co.com.devco.certification.exceptions.flights.BookFlightException.BOOK_INCONSISTENT_INFORMATION_MESSAGE;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.*;

public class TravelocityBookingsStepDefinition {

    @Before
    public void startTheStage() {
        setTheStage(new OnlineCast());
    }

    @After
    public void finishTheStage() {
        drawTheCurtain();
    }

    @Given("The actor {string} is in the Travelocity home page")
    public void theActorIsInTheTravelocityHomePage(String actorName) {
        theActorCalled(actorName).wasAbleTo(
                OpenThe.travelocityUrl()
        );
    }

    @When("He tries to book the cheapest flight one-way flight from {string} to {string} for {int} {string} and {int} days from today")
    public void heTriesToBookTheCheapestFlightOneWayFlightFromToForAndDaysFromToday(String originCity, String destinationCity, int travelersNumber, String typeOfTraveler, int daysToDeparture) {
        theActorInTheSpotlight().attemptsTo(
                SearchAOneWay.trip(originCity, destinationCity, travelersNumber, typeOfTraveler, daysToDeparture),
                FilterByCheapest.flight()
        );
    }

    @And("He Books the flight")
    public void heBooksTheFlight() {
        theActorInTheSpotlight().attemptsTo(
                BookThe.flight()
        );
    }

    @Then("he should see that the flight has the right origin, destination, travelers and price")
    public void heShouldSeeThatTheFlightHasTheRightOriginDestinationTravelersAndPrice() {
        theActorInTheSpotlight().should(
                seeThat(TheFlight.hasTheRightInformation()).orComplainWith(BookFlightException.class, BOOK_INCONSISTENT_INFORMATION_MESSAGE)
        );
    }

    @When("He tries to book a one-way flight from {string} to {string} for {int} {string} and {int} days from today")
    public void heTriesToBookAOneWayFlightFromToForAndDaysFromToday(String originCity, String destinationCity, int travelersNumber, String typeOfTraveler, int daysToDeparture) {
        theActorInTheSpotlight().attemptsTo(
                SearchAOneWay.trip(originCity, destinationCity, travelersNumber, typeOfTraveler, daysToDeparture)
        );
    }

    @And("He filters for {int} stops, {string} airline and {string} departure")
    public void heFiltersForStopsAirlineAndDeparture(int stops, String airline, String departureTime) {
        theActorInTheSpotlight().attemptsTo(
                FilterForStops.number(stops),
                FilterForAirline.name(airline),
                FilterForDeparture.time(departureTime)
        );
    }

    @Then("he should see that the flight has the right origin, destination, travelers, filters and price")
    public void heShouldSeeThatTheFlightHasTheRightOriginDestinationTravelersFiltersAndPrice() {
        theActorInTheSpotlight().should(
                seeThat(TheFlight.hasTheRightInformation()).orComplainWith(BookFlightException.class, BOOK_INCONSISTENT_INFORMATION_MESSAGE),
                seeThat(TheFlight.hasTheRightFilter()).orComplainWith(BookFlightException.class, BOOK_INCONSISTENT_INFORMATION_MESSAGE)
        );
    }

    @When("He tries to book the first recommended stay to {string} for {int} {string} for {int} days and {int} days from today")
    public void heTriesToBookTheFirstRecommendedStayToForForDaysAndDaysFromToday(String destinationCity, int travelersNumber, String typeOfTraveler, int daysOfTrip, int daysToDeparture) {
        theActorInTheSpotlight().attemptsTo(
                SearchAStay.trip(destinationCity, travelersNumber, typeOfTraveler, daysOfTrip, daysToDeparture),
                SelectTheFirstRecommended.hotel()
        );
    }

    @And("He Books the Stay")
    public void heBooksTheStay() {
        theActorInTheSpotlight().attemptsTo(
                BookTheHotel.room()
        );
    }

    @Then("he should see that the stay has the right travelers, dates and price")
    public void heShouldSeeThatTheStayHasTheRightTravelersDatesAndPrice() {
        theActorInTheSpotlight().should(
                seeThat(TheStay.hasTheRightInformation())
        );
    }
}

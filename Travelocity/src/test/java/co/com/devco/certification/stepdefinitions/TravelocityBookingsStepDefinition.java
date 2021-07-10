package co.com.devco.certification.stepdefinitions;

import co.com.devco.certification.exceptions.flights.BookFlightException;
import co.com.devco.certification.questions.TheFlight;
import co.com.devco.certification.tasks.OpenThe;
import co.com.devco.certification.tasks.flights.*;
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
                SelectTheCheapestFlight.fromTheResults()
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
}

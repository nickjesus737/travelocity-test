package co.com.devco.certification.tasks.flights;

import co.com.devco.certification.interactions.flights.SelectTheDestination;
import co.com.devco.certification.interactions.flights.SelectTheOrigin;
import co.com.devco.certification.interactions.flights.SelectTheTravelers;
import co.com.devco.certification.interactions.flights.SetTheDate;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import static co.com.devco.certification.userinterfaces.FlightsTab.*;
import static co.com.devco.certification.userinterfaces.Travelocity.FLIGHTS_TAB;
import static co.com.devco.certification.utils.Utils.getDateFromToday;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SearchAOneWay implements Task {

    private final String originCity;
    private final String destinationCity;
    private final int travelersNumber;
    private final String typeOfTraveler;
    private final int daysToDeparture;

    public SearchAOneWay(String originCity, String destinationCity, int travelersNumber, String typeOfTraveler, int daysToDeparture) {
        this.originCity = originCity;
        this.destinationCity = destinationCity;
        this.travelersNumber = travelersNumber;
        this.typeOfTraveler = typeOfTraveler;
        this.daysToDeparture = daysToDeparture;
    }

    @Override
    @Step("{0} tries to book a one-way flight from #originCity to #destinationCity for #travelersNumber #typeOfTraveler and #daysToDepartur from today")
    public <T extends Actor> void performAs(T actor) {

        String dateForDepartureFormatted = getDateFromToday(daysToDeparture);

        actor.attemptsTo(
                WaitUntil.the(FLIGHTS_TAB, isVisible()),
                Click.on(FLIGHTS_TAB),
                WaitUntil.the(ONE_WAY_OPTION, isVisible()),
                Click.on(ONE_WAY_OPTION),
                SelectTheOrigin.city(originCity),
                SelectTheDestination.city(destinationCity),
                SelectTheTravelers.number(typeOfTraveler, travelersNumber),
                SetTheDate.onTheInput(dateForDepartureFormatted, DEPARTING_DATE_INPUT),
                Click.on(SEARCH_FLIGHT_BUTTON)
        );

        actor.remember("originCity", originCity);
        actor.remember("destinationCity", destinationCity);
        actor.remember("travelersNumber", travelersNumber);

    }

    public static SearchAOneWay trip(String originCity, String destinationCity, int travelersNumber, String typeOfTraveler, int daysToDeparture){
        return Tasks.instrumented(SearchAOneWay.class, originCity, destinationCity, travelersNumber, typeOfTraveler, daysToDeparture);
    }
}

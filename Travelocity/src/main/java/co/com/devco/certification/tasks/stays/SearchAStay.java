package co.com.devco.certification.tasks.stays;

import co.com.devco.certification.interactions.flights.SelectTheTravelers;
import co.com.devco.certification.interactions.stays.SelectTheDestination;
import co.com.devco.certification.interactions.stays.SetTheDate;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.devco.certification.userinterfaces.Travelocity.DEPARTING_DATE_INPUT;
import static co.com.devco.certification.userinterfaces.Travelocity.STAYS_TAB;
import static co.com.devco.certification.userinterfaces.stays.StaysTab.*;
import static co.com.devco.certification.utils.Utils.getDateFormatted;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SearchAStay implements Task {

    private final String destinationCity;
    private final int travelersNumber;
    private final String typeOfTraveler;
    private final int daysOfTrip;
    private final int daysToDeparture;

    public SearchAStay(String destinationCity, int travelersNumber, String typeOfTraveler, int daysOfTrip, int daysToDeparture) {
        this.destinationCity = destinationCity;
        this.travelersNumber = travelersNumber;
        this.typeOfTraveler = typeOfTraveler;
        this.daysOfTrip = daysOfTrip;
        this.daysToDeparture = daysToDeparture;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        String dateForCheckInFormatted = getDateFormatted(daysToDeparture, "MMM d, yyyy");
        String dateForCheckOutFormatted = getDateFormatted(daysToDeparture + daysOfTrip, "MMM d, yyyy");

        actor.attemptsTo(
                WaitUntil.the(STAYS_TAB, isVisible()),
                Click.on(STAYS_TAB),
                WaitUntil.the(ORIGIN_INPUT_BUTTON, isVisible()),
                SelectTheDestination.stayCity(destinationCity),
                SetTheDate.rangeForTheStay(dateForCheckInFormatted, dateForCheckOutFormatted, DEPARTING_DATE_INPUT),
                SelectTheTravelers.number(typeOfTraveler, travelersNumber, TRAVELERS_BUTTON),
                Click.on(SEARCH_STAYS_BUTTON)
        );

        actor.remember("travelersNumber", travelersNumber);
        actor.remember("typeOfTraveler", typeOfTraveler);
        actor.remember("daysOfTrip", daysOfTrip);
        actor.remember("daysToDeparture", daysToDeparture);
    }

    public static SearchAStay trip (String destinationCity, int travelersNumber, String typeOfTraveler, int daysOfTrip, int daysToDeparture){
        return Tasks.instrumented(SearchAStay.class, destinationCity, travelersNumber, typeOfTraveler, daysOfTrip, daysToDeparture);
    }

}

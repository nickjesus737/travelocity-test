package co.com.devco.certification.tasks.flights;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import static co.com.devco.certification.userinterfaces.Travelocity.FLIGHTS_TAB;
import static co.com.devco.certification.userinterfaces.flights.FlightsTab.SEARCH_FLIGHT_BUTTON;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class BookAFlight implements Task {

    @Override
    @Step("{0} tries to book a flight without completing the information")
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitUntil.the(FLIGHTS_TAB, isVisible()),
                Click.on(FLIGHTS_TAB),
                Click.on(SEARCH_FLIGHT_BUTTON)
        );

    }

    public static BookAFlight withoutCompletingTheInformation(){
        return Tasks.instrumented(BookAFlight.class);
    }
}

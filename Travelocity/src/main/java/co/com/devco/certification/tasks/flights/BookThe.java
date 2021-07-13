package co.com.devco.certification.tasks.flights;

import co.com.devco.certification.interactions.ChangeToThe;
import co.com.devco.certification.interactions.flights.GetTheTotal;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import static co.com.devco.certification.userinterfaces.flights.FlightsResults.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class BookThe implements Task {

    @Override
    @Step("{0} books the selected flight")
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitUntil.the(FIRST_OPTION_IN_FLIGHTS_RESULTS, isVisible()),
                Click.on(FIRST_OPTION_IN_FLIGHTS_RESULTS),
                WaitUntil.the(FLIGHT_DETAILS_WINDOW, isVisible()),
                GetTheTotal.flightPrice(),
                Click.on(FLIGHT_DETAILS_WINDOW_CONTINUE_BUTTON)
        );

        if (HOTEL_SEARCH_MODAL.resolveFor(actor).isVisible()) {
            actor.attemptsTo(
                    Click.on(HOTEL_SEARCH_MODAL_NO_THANKS_BUTTON)
            );
        }

        actor.attemptsTo(
                ChangeToThe.newWindow()
        );
    }

    public static BookThe flight() {
        return Tasks.instrumented(BookThe.class);
    }
}

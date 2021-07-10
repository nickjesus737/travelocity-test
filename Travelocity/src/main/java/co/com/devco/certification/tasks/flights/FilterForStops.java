package co.com.devco.certification.tasks.flights;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import static co.com.devco.certification.userinterfaces.FlightsResults.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class FilterForStops implements Task {

    private final int stopsNumber;

    public FilterForStops(int stopsNumber) {
        this.stopsNumber = stopsNumber;
    }

    @Override
    @Step("{0} filters for flight with #stopsNumber stops")
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitUntil.the(SORTING_OPTIONS, isVisible())
        );

        if (stopsNumber == 0){
            actor.attemptsTo(
                    Click.on(ZERO_STOPS_CHECKBOX)
            );
        } else if (stopsNumber == 1){
            actor.attemptsTo(
                    Click.on(ONE_STOP_CHECKBOX)
            );
        } else if (stopsNumber == 2){
            actor.attemptsTo(
                    Click.on(TWO_STOPS_CHECKBOX)
            );
        } else {
            throw new AssertionError("No se pueden realizar vuelos con menos de 0 o más de 2 paradas");
        }

        actor.attemptsTo(
                WaitUntil.the(FIRST_OPTION_IN_FLIGHTS_RESULTS, isVisible())
        );

        actor.remember("stopsNumber", stopsNumber);

    }

    public static FilterForStops number(int stopsNumber){
        return Tasks.instrumented(FilterForStops.class, stopsNumber);
    }

}

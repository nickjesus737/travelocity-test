package co.com.devco.certification.tasks.flights;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import static co.com.devco.certification.userinterfaces.flights.FlightsResults.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class FilterForAirline implements Task {

    private final String airline;

    public FilterForAirline(String airline) {
        this.airline = airline;
    }

    @Override
    @Step("{0} filters for the Airline #airline")
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitUntil.the(SORTING_OPTIONS, isVisible()),
                Click.on(AIRLINE_FILTER.of(airline)),
                WaitUntil.the(FIRST_OPTION_IN_FLIGHTS_RESULTS, isVisible())
        );

        actor.remember("airline", airline);
    }

    public static FilterForAirline name(String airline){
        return Tasks.instrumented(FilterForAirline.class, airline);
    }

}

package co.com.devco.certification.tasks.flights;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import static co.com.devco.certification.userinterfaces.FlightsResults.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class FilterForDeparture implements Task {

    private final String departureTime;

    public FilterForDeparture(String departureTime) {
        this.departureTime = departureTime;
    }

    @Override
    @Step("{0} filters for flight departure time")
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitUntil.the(SORTING_OPTIONS, isVisible()),
                Click.on(DEPARTURE_TIME_FILTER.of(departureTime)),
                WaitUntil.the(FIRST_OPTION_IN_FLIGHTS_RESULTS, isVisible())
        );

        actor.remember("departureTime", departureTime);
    }

    public static FilterForDeparture time(String departureTime){
        return Tasks.instrumented(FilterForDeparture.class, departureTime);
    }

}

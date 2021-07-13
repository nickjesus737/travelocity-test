package co.com.devco.certification.tasks.flights;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import static co.com.devco.certification.userinterfaces.flights.FlightsResults.SORTING_OPTIONS;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class FilterByCheapest implements Task {

    @Override
    @Step("{0} filters the results by cheapest")
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitUntil.the(SORTING_OPTIONS, isVisible())
        );

        if (!SORTING_OPTIONS.resolveFor(actor).isDisabled()) {
            actor.attemptsTo(
                    SelectFromOptions.byVisibleText("Price (Lowest)").from(SORTING_OPTIONS)
            );
        }

    }

    public static FilterByCheapest flight() {
        return Tasks.instrumented(FilterByCheapest.class);
    }
}

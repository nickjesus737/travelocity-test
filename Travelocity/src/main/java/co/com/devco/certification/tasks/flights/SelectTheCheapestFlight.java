package co.com.devco.certification.tasks.flights;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import static co.com.devco.certification.userinterfaces.FlightsResults.SORTING_OPTIONS;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SelectTheCheapestFlight implements Task {

    @Override
    @Step("{0} selects the cheapest flight from the results of the search")
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

    public static SelectTheCheapestFlight fromTheResults() {
        return Tasks.instrumented(SelectTheCheapestFlight.class);
    }
}

package co.com.devco.certification.tasks.stays;

import co.com.devco.certification.interactions.ChangeToThe;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import static co.com.devco.certification.userinterfaces.StaysResults.FIRST_OPTION_IN_STAYS_RESULTS;
import static co.com.devco.certification.userinterfaces.StaysResults.SORTING_OPTIONS;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SelectTheFirstRecommended implements Task {

    @Override
    @Step("{0} selects the first recommended hotel")
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitUntil.the(SORTING_OPTIONS, isVisible())
        );

        if (!SORTING_OPTIONS.resolveFor(actor).isDisabled()) {
            actor.attemptsTo(
                    SelectFromOptions.byVisibleText("Recommended").from(SORTING_OPTIONS)
            );
        }

        actor.attemptsTo(
                WaitUntil.the(FIRST_OPTION_IN_STAYS_RESULTS, isVisible()),
                Click.on(FIRST_OPTION_IN_STAYS_RESULTS)
        );

        actor.attemptsTo(
                ChangeToThe.newWindow()
        );

    }

    public static SelectTheFirstRecommended hotel() {
        return Tasks.instrumented(SelectTheFirstRecommended.class);
    }
}

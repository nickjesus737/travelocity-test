package co.com.devco.certification.tasks.stays;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import static co.com.devco.certification.userinterfaces.Travelocity.STAYS_TAB;
import static co.com.devco.certification.userinterfaces.flights.FlightsTab.SEARCH_FLIGHT_BUTTON;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class BookAStay implements Task {

    @Override
    @Step("{0} tries to book a flight without completing the information")
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitUntil.the(STAYS_TAB, isVisible()),
                Click.on(STAYS_TAB),
                Click.on(SEARCH_FLIGHT_BUTTON)
        );

    }

    public static BookAStay withoutCompletingTheInformation(){
        return Tasks.instrumented(BookAStay.class);
    }
}

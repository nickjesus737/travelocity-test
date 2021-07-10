package co.com.devco.certification.interactions.flights;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import static co.com.devco.certification.userinterfaces.FlightsTab.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SelectTheDestination implements Interaction {

    private final String destinationCity;

    public SelectTheDestination(String destinationCity) {
        this.destinationCity = destinationCity;
    }

    @Override
    @Step("{0} selects the destination city")
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitUntil.the(DESTINATION_INPUT_BUTTON, isVisible()),
                Click.on(DESTINATION_INPUT_BUTTON),
                Enter.theValue(destinationCity).into(DESTINATION_INPUT),
                WaitUntil.the(DESTINATION_RESULTS_ELEMENT, isVisible()),
                Click.on(DESTINATION_RESULTS_ELEMENT)
        );

    }

    public static SelectTheDestination city(String destinationCity){
        return Tasks.instrumented(SelectTheDestination.class, destinationCity);
    }
}

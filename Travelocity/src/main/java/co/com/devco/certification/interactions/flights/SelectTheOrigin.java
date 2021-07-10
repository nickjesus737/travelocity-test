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

public class SelectTheOrigin implements Interaction {

    private final String originCity;

    public SelectTheOrigin(String originCity) {
        this.originCity = originCity;
    }

    @Override
    @Step("{0} selects the origin city")
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitUntil.the(ORIGIN_INPUT_BUTTON, isVisible()),
                Click.on(ORIGIN_INPUT_BUTTON),
                Enter.theValue(originCity).into(ORIGIN_INPUT),
                WaitUntil.the(ORIGIN_RESULTS_ELEMENT, isVisible()),
                Click.on(ORIGIN_RESULTS_ELEMENT)
        );

    }

    public static SelectTheOrigin city(String originCity){
        return Tasks.instrumented(SelectTheOrigin.class, originCity);
    }
}

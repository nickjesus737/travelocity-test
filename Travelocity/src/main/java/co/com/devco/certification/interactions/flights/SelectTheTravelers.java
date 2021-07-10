package co.com.devco.certification.interactions.flights;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import static co.com.devco.certification.userinterfaces.FlightsTab.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SelectTheTravelers implements Interaction {

    private String typeOfTraveler;
    private int travelersNumber;

    public SelectTheTravelers(String typeOfTraveler, int travelersNumber) {
        this.typeOfTraveler = typeOfTraveler;
        this.travelersNumber = travelersNumber;
    }

    @Override
    @Step("{0} adds #travelersNumber #typeOfTraveler to the flight")
    public <T extends Actor> void performAs(T actor) {

        Target travelerType = null;

        if (typeOfTraveler.equals("adults")){
            travelerType = ADD_ADULTS_BUTTON;
        }else if (typeOfTraveler.equals("children")){
            travelerType = ADD_CHILDREN_BUTTON;
        }

        actor.attemptsTo(
                WaitUntil.the(NUMBER_OF_TRAVELERS_DIV, isVisible()),
                Click.on(NUMBER_OF_TRAVELERS_DIV),
                WaitUntil.the(travelerType, isVisible())
        );

        for (int i = 1; i < travelersNumber; i++){
            actor.attemptsTo(
                    Click.on(travelerType)
            );
        }

        actor.attemptsTo(
                Click.on(TRAVELERS_DONE_BUTTON)
        );

    }

    public static SelectTheTravelers number(String typeOfTraveler, int travelersNumber){
        return Tasks.instrumented(SelectTheTravelers.class, typeOfTraveler, travelersNumber);
    }
}

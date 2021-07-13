package co.com.devco.certification.interactions.flights;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import static co.com.devco.certification.userinterfaces.Travelocity.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SelectTheTravelers implements Interaction {

    private final String typeOfTraveler;
    private final int travelersNumber;
    private final Target travelerDiv;

    public SelectTheTravelers(String typeOfTraveler, int travelersNumber, Target travelerDiv) {
        this.typeOfTraveler = typeOfTraveler;
        this.travelersNumber = travelersNumber;
        this.travelerDiv = travelerDiv;
    }

    @Override
    @Step("{0} adds #travelersNumber #typeOfTraveler to the flight")
    public <T extends Actor> void performAs(T actor) {

        Target travelerType = null;
        Target travelerCount = null;

        if (typeOfTraveler.equals("adults")){
            travelerType = ADD_ADULTS_BUTTON;
            travelerCount = ADULTS_COUNT;
        }else if (typeOfTraveler.equals("children")){
            travelerType = ADD_CHILDREN_BUTTON;
            travelerCount = CHILDREN_COUNT;
        }

        actor.attemptsTo(
                WaitUntil.the(travelerDiv, isVisible()),
                Click.on(travelerDiv),
                WaitUntil.the(travelerType, isVisible())
        );

        if (Integer.parseInt(travelerCount.resolveFor(actor).getValue()) < travelersNumber){
            for (int i = 1; i < travelersNumber; i++){
                actor.attemptsTo(
                        Click.on(travelerType)
                );
            }
        }

        actor.attemptsTo(
                Click.on(TRAVELERS_DONE_BUTTON)
        );

    }

    public static SelectTheTravelers number(String typeOfTraveler, int travelersNumber, Target travelerDiv){
        return Tasks.instrumented(SelectTheTravelers.class, typeOfTraveler, travelersNumber, travelerDiv);
    }
}

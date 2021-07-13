package co.com.devco.certification.interactions.flights;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Step;

import static co.com.devco.certification.userinterfaces.Travelocity.CALENDAR_SELECTOR;
import static co.com.devco.certification.userinterfaces.Travelocity.CALENDAR_SELECTOR_DONE_BUTTON;

public class SetTheDate implements Interaction {

    private final String date;
    private final Target target;

    public SetTheDate(String date, Target target) {
        this.date = date;
        this.target = target;
    }

    @Override
    @Step("{0} sets a date on an input")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(target),
                Click.on(CALENDAR_SELECTOR.of(date)),
                Click.on(CALENDAR_SELECTOR_DONE_BUTTON)
        );

    }

    public static SetTheDate onTheInput(String date, Target target){
        return Tasks.instrumented(SetTheDate.class, date, target);
    }
}

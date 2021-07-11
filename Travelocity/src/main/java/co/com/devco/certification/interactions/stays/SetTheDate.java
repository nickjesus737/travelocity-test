package co.com.devco.certification.interactions.stays;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Step;

import static co.com.devco.certification.userinterfaces.Travelocity.CALENDAR_SELECTOR;
import static co.com.devco.certification.userinterfaces.Travelocity.CALENDAR_SELECTOR_DONE_BUTTON;

public class SetTheDate implements Interaction {

    private final String startDate;
    private final String finishDate;
    private final Target target;

    public SetTheDate(String startDate, String finishDate, Target target) {
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.target = target;
    }

    @Override
    @Step("{0} selects the dates for the stay from #startDate to #finishDate")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(target),
                Click.on(CALENDAR_SELECTOR.of(startDate)),
                Click.on(CALENDAR_SELECTOR.of(finishDate)),
                Click.on(CALENDAR_SELECTOR_DONE_BUTTON)
        );
    }

    public static SetTheDate rangeForTheStay(String startDate, String finishDate, Target target){
        return Tasks.instrumented(SetTheDate.class, startDate, finishDate, target);
    }
}

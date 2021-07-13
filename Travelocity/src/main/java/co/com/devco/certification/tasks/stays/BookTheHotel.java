package co.com.devco.certification.tasks.stays;

import co.com.devco.certification.interactions.stays.GetTheTotalHotel;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import java.util.List;

import static co.com.devco.certification.userinterfaces.stays.StaysResults.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class BookTheHotel implements Task {

    @Override
    @Step("{0} books the hotel room")
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitUntil.the(FIRST_OPTION_IN_HOTEL_RESULTS, isVisible()),
                Scroll.to(FIRST_OPTION_IN_HOTEL_RESULTS)
        );

        if (FIRST_OPTION_IN_HOTEL_RESULTS_RESERVE_BUTTON.resolveFor(actor).isVisible()){
            actor.attemptsTo(
                    Click.on(FIRST_OPTION_IN_HOTEL_RESULTS_RESERVE_BUTTON),
                    WaitUntil.the(MODAL_WINDOW_RESERVE_BUTTON, isVisible())
            );

            List<WebElementFacade> buttons = MODAL_WINDOW_RESERVE_BUTTON.resolveAllFor(actor);

            actor.attemptsTo(
                    GetTheTotalHotel.roomPrice(),
                    Click.on(buttons.get(1))
            );

        } else if (FIRST_OPTION_IN_HOTEL_RESULTS_RESERVE_BUTTON_1.resolveFor(actor).isVisible()){

            actor.attemptsTo(
                    GetTheTotalHotel.roomPrice()
            );

            List<WebElementFacade> buttons = FIRST_OPTION_IN_HOTEL_RESULTS_RESERVE_BUTTON_1.resolveAllFor(actor);

            actor.attemptsTo(
                    Click.on(buttons.get(1))
            );

        }

    }

    public static BookTheHotel room(){
        return Tasks.instrumented(BookTheHotel.class);
    }
}

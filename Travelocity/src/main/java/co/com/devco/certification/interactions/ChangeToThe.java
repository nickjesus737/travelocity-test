package co.com.devco.certification.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Switch;
import net.thucydides.core.annotations.Step;

public class ChangeToThe implements Interaction {

    @Override
    @Step("{0} switches to the new window")
    public <T extends Actor> void performAs(T actor) {

        String currentHandle = BrowseTheWeb.as(actor).getDriver().getWindowHandle();

        actor.attemptsTo(
                Switch.toWindow(getNewWindowHandle(actor, currentHandle))
        );
    }

    public static ChangeToThe newWindow(){
        return Tasks.instrumented(ChangeToThe.class);
    }

    private static String getNewWindowHandle(Actor actor, String currentWindowHandle){
        for (String windowHandle : BrowseTheWeb.as(actor).getDriver().getWindowHandles()) {
            if (!windowHandle.equals(currentWindowHandle)) {
                return windowHandle;
            }
        }
        return null;
    }
}

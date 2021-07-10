package co.com.devco.certification.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Step;

import static co.com.devco.certification.utils.TravelocityProperties.getUrl;

public class OpenThe implements Task {

    @Override
    @Step("{0} opens the browser and loads the travelocity homepage")
    public <T extends Actor> void performAs(T actor) {

        String url = getUrl();

        actor.attemptsTo(
                Open.url(url)
        );

    }

    public static OpenThe travelocityUrl(){
        return Tasks.instrumented(OpenThe.class);
    }
}

package co.com.devco.certification.stepdefinitions;

import co.com.devco.certification.tasks.OpenThe;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static net.serenitybdd.screenplay.actors.OnStage.*;

public class TravelocityBookingsStepDefinition {

    @Before
    public void startTheStage() {
        setTheStage(new OnlineCast());
    }

    @After
    public void finishTheStage(){
        drawTheCurtain();
    }

    @Given("The actor {string} is in the Travelocity home page")
    public void theActorIsInTheTravelocityHomePage(String actorName) {

        theActorCalled(actorName).wasAbleTo(
                OpenThe.travelocityUrl()
        );

    }

}

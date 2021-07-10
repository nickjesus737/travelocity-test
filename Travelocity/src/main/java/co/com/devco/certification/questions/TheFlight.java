package co.com.devco.certification.questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.devco.certification.userinterfaces.FlightSummary.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class TheFlight {

    public static Question<Boolean> hasTheRightInformation(){

        return actor -> {

            String originCity = actor.recall("originCity");
            String destinationCity = actor.recall("destinationCity");
            String totalFlightPrice = actor.recall("totalFlightPrice");
            int travelersNumber = actor.recall("travelersNumber");

            actor.attemptsTo(
                    WaitUntil.the(TOTAL_PRICE, isVisible()).forNoMoreThan(20).seconds(),
                    Ensure.that(ORIGIN_AND_DESTINATION).text().contains(originCity + " to " + destinationCity),
                    Ensure.that(NUMBER_OF_TRAVELERS).values().hasSize(travelersNumber),
                    Ensure.that(TOTAL_PRICE).text().contains(totalFlightPrice)
            );

            return true;
        };

    }

}

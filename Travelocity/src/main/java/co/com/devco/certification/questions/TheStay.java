package co.com.devco.certification.questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.devco.certification.userinterfaces.stays.StaysSummary.*;
import static co.com.devco.certification.utils.Utils.getDateFormatted;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class TheStay {

    public static Question<Boolean> hasTheRightInformation(){

        return actor -> {

            int travelersNumber = actor.recall("travelersNumber");
            String typeOfTraveler = actor.recall("typeOfTraveler");
            int daysOfTrip = actor.recall("daysOfTrip");
            int daysToDeparture = actor.recall("daysToDeparture");
            Double totalFlightPrice = actor.recall("totalHotelRoomPrice");

            String checkInDate = getDateFormatted(daysToDeparture, "EEE, MMM d");
            String checkOutDate = getDateFormatted(daysToDeparture + daysOfTrip, "EEE, MMM d");
            String travelers = String.valueOf(travelersNumber) + " " + typeOfTraveler;

            actor.attemptsTo(
                    WaitUntil.the(TOTAL_PRICE, isVisible()).forNoMoreThan(20).seconds(),
                    Ensure.that(NUMBER_OF_TRAVELERS).text().isEqualToIgnoringCase(travelers),
                    Ensure.that(CHECK_IN_TIME).text().contains(checkInDate),
                    Ensure.that(CHECK_OUT_TIME).text().contains(checkOutDate)
            );

            String totalPrice = TOTAL_PRICE.resolveFor(actor).getText().replace("$", "");

            actor.attemptsTo(
                    Ensure.that(totalPrice).asADouble().isCloseTo(totalFlightPrice, 5.0f)
            );

            return true;
        };


    }

}

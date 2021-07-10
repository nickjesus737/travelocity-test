package co.com.devco.certification.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.List;

import static co.com.devco.certification.userinterfaces.FlightSummary.*;
import static co.com.devco.certification.utils.Utils.getDateFromToday;
import static co.com.devco.certification.utils.Utils.getTimeSplatted;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class TheFlight {

    public static Question<Boolean> hasTheRightInformation(){

        return actor -> {

            String originCity = actor.recall("originCity");
            String destinationCity = actor.recall("destinationCity");
            String totalFlightPrice = actor.recall("totalFlightPrice");
            int travelersNumber = actor.recall("travelersNumber");
            int daysToDeparture = actor.recall("daysToDeparture");

            String flightDate = getDateFromToday(daysToDeparture, "EEE, MMM d");

            actor.attemptsTo(
                    WaitUntil.the(TOTAL_PRICE, isVisible()).forNoMoreThan(20).seconds(),
                    Ensure.that(ORIGIN_AND_DESTINATION).text().contains(originCity + " to " + destinationCity),
                    Ensure.that(AIRLINE_AND_DATE).text().contains(flightDate),
                    Ensure.that(NUMBER_OF_TRAVELERS).values().hasSize(travelersNumber),
                    Ensure.that(TOTAL_PRICE).text().contains(totalFlightPrice)
            );

            return true;
        };

    }

    public static Question<Boolean> hasTheRightFilter(){

        return actor -> {

            int stopsNumber = actor.recall("stopsNumber");
            String airline = actor.recall("airline");
            String departureDate = actor.recall("departureTime");

            String stops = stopsNumber == 0 ? "Nonstop" : String.valueOf(stopsNumber);
            String departureTime = DEPARTURE_TIME.resolveFor(actor).getText();

            actor.attemptsTo(
                    WaitUntil.the(TOTAL_PRICE, isVisible()).forNoMoreThan(20).seconds(),
                    Ensure.that(STOPS).text().contains(stops),
                    Ensure.that(AIRLINE_AND_DATE).text().contains(airline),
                    Ensure.that(validateDepartureDate(actor, departureTime, departureDate)).isTrue()
            );

            return true;
        };

    }

    private static boolean validateDepartureDate(Actor actor, String departureTime, String departureDate){

        List<String> timeSplatted = getTimeSplatted(departureTime);

        int hour = Integer.parseInt(timeSplatted.get(0));
        String time = timeSplatted.get(2);

        switch (departureDate){
            case "Morning":
                actor.attemptsTo(
                        Ensure.that(hour).isBetween(5,11),
                        Ensure.that(time).isEqualToIgnoringCase("am")
                );
                break;
            case "Afternoon":

                if (hour != 12){
                    actor.attemptsTo(
                            Ensure.that(hour).isBetween(1,5)
                    );
                } else {
                    actor.attemptsTo(
                            Ensure.that(hour).isEqualTo(12)
                    );
                }

                actor.attemptsTo(
                        Ensure.that(time).isEqualToIgnoringCase("pm")
                );

                break;
            case "Evening":
                actor.attemptsTo(
                        Ensure.that(hour).isBetween(6,12),
                        Ensure.that(time).isEqualToIgnoringCase("pm")
                );
                break;
        }

        return true;

    }

}

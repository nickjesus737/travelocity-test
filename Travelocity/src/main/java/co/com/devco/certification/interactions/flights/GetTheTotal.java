package co.com.devco.certification.interactions.flights;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.thucydides.core.annotations.Step;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static co.com.devco.certification.userinterfaces.flights.FlightsResults.FLIGHT_DETAILS_FINAL_PRICE;

public class GetTheTotal implements Interaction {

    @Override
    @Step("{0} gets the total flight price")
    public <T extends Actor> void performAs(T actor) {

        String totalFlightPriceText = FLIGHT_DETAILS_FINAL_PRICE.resolveFor(actor).getText();

        Pattern p = Pattern.compile("^[$0-9.]*");
        Matcher m = p.matcher(totalFlightPriceText);

        m.find();

        String totalFlightPrice = m.group(0);

        actor.remember("totalFlightPrice", totalFlightPrice);
    }

    public static GetTheTotal flightPrice(){
        return Tasks.instrumented(GetTheTotal.class);
    }
}

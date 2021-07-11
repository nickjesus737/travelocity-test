package co.com.devco.certification.interactions.stays;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.thucydides.core.annotations.Step;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static co.com.devco.certification.userinterfaces.StaysResults.STAY_DETAILS_FINAL_PRICE;
import static co.com.devco.certification.userinterfaces.StaysResults.STAY_DETAILS_FINAL_PRICE_1;

public class GetTheTotalHotel implements Interaction {

    @Override
    @Step("{0} gets the total hotel room price")
    public <T extends Actor> void performAs(T actor) {

        String totalFlightPriceText;

        if (STAY_DETAILS_FINAL_PRICE.resolveFor(actor).isVisible()){
            totalFlightPriceText = STAY_DETAILS_FINAL_PRICE.resolveFor(actor).getText();
        } else {
            totalFlightPriceText = STAY_DETAILS_FINAL_PRICE_1.resolveFor(actor).getText();
        }


        Pattern p = Pattern.compile("^[$0-9.]*");
        Matcher m = p.matcher(totalFlightPriceText);

        m.find();

        Double totalFlightPrice = Double.parseDouble(m.group(0).replace("$",""));

        actor.remember("totalHotelRoomPrice", totalFlightPrice);
    }

    public static GetTheTotalHotel roomPrice(){
        return Tasks.instrumented(GetTheTotalHotel.class);
    }

}

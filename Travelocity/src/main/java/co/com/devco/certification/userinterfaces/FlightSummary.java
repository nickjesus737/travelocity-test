package co.com.devco.certification.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class FlightSummary {

    public static final Target ORIGIN_AND_DESTINATION = Target.the("selected rigin y destination").locatedBy("//div[@data-test-id='flight-review-0']//child::h2");
    public static final Target NUMBER_OF_TRAVELERS = Target.the("selected number of traveleres").locatedBy("//div[@data-test-id='price-summary-card']//child::table[contains(@data-test-id,'price-summary-travelers')]");
    public static final Target AIRLINE_AND_DATE = Target.the("selected arline and date").locatedBy("//div[@data-test-id='flight-operated']");
    public static final Target DEPARTURE_TIME = Target.the("selected departure time range").locatedBy("//div[@data-test-id='flight-summary']//child::h3//span");
    public static final Target STOPS = Target.the("stops selected").locatedBy("//div[@data-test-id='flight-summary']//child::h3//following-sibling::span");
    public static final Target TOTAL_PRICE = Target.the("total price of the flight").locatedBy("//div[@data-test-id='price-summary-card']//child::table[@data-test-id='trip-total']//child::span");

}

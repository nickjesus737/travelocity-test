package co.com.devco.certification.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class FlightSummary {

    public static final Target ORIGIN_AND_DESTINATION = Target.the("").locatedBy("//div[@data-test-id='flight-review-0']//child::h2");
    public static final Target NUMBER_OF_TRAVELERS = Target.the("").locatedBy("//div[@data-test-id='price-summary-card']//child::table[contains(@data-test-id,'price-summary-travelers')]");
    public static final Target TOTAL_PRICE = Target.the("").locatedBy("//div[@data-test-id='price-summary-card']//child::table[@data-test-id='trip-total']//child::span");

}

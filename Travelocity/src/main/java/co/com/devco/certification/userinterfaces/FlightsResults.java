package co.com.devco.certification.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class FlightsResults {

    public static final Target SORTING_OPTIONS = Target.the("sorting options on flights results page").located(By.id("listings-sort"));
    public static final Target FIRST_OPTION_IN_FLIGHTS_RESULTS = Target.the("first element in the flights results page").locatedBy("//ul[@data-test-id='listings']//li[1]");

    public static final Target FLIGHT_DETAILS_WINDOW = Target.the("flight details window").locatedBy("//div[@data-test-id='details-and-fares']");
    public static final Target FLIGHT_DETAILS_WINDOW_CONTINUE_BUTTON = Target.the("flight details window continue button").locatedBy("//button[@data-test-id='select-button']");
    public static final Target FLIGHT_DETAILS_FINAL_PRICE = Target.the("flight details final price").locatedBy("//div[@data-test-id='details-and-fares-footer']//child::b");

    public static final Target HOTEL_SEARCH_MODAL = Target.the("hotel search modal").located(By.id("app-layer-forced-choice-modal-dialog"));
    public static final Target HOTEL_SEARCH_MODAL_NO_THANKS_BUTTON = Target.the("hotel search modal no thanks button").locatedBy("//a[@data-test-id='forcedChoiceNoThanks']");



}

package co.com.devco.certification.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class FlightsTab {

    public static final Target ROUNDTRIP_OPTION = Target.the("Rountrip option in the flights tab").locatedBy("//form[@id='wizard-flight-pwa-1']//child::ul[@id='uitk-tabs-button-container']//li[1]");
    public static final Target ONE_WAY_OPTION = Target.the("One-way option in the flights tab").locatedBy("//form[@id='wizard-flight-pwa-1']//child::ul[@id='uitk-tabs-button-container']//li[2]");

    public static final Target ORIGIN_INPUT_BUTTON = Target.the("origin button on input element").locatedBy("//input[@id='location-field-leg1-origin-input']//following-sibling::button");
    public static final Target ORIGIN_INPUT = Target.the("origin input element").located(By.id("location-field-leg1-origin"));
    public static final Target ORIGIN_RESULTS_ELEMENT = Target.the("origin city first result element").locatedBy("//ul[@data-stid='location-field-leg1-origin-results']//li[1]");

    public static final Target DESTINATION_INPUT_BUTTON = Target.the("destination button on input element").locatedBy("//input[@id='location-field-leg1-destination-input']//following-sibling::button");
    public static final Target DESTINATION_INPUT = Target.the("destination input element").located(By.id("location-field-leg1-destination"));
    public static final Target DESTINATION_RESULTS_ELEMENT = Target.the("destination city first result element").locatedBy("//ul[@data-stid='location-field-leg1-destination-results']//li[1]");

    public static final Target DEPARTING_DATE_INPUT = Target.the("departing date input").locatedBy("//button[@id='d1-btn']");
    public static final Target CALENDAR_SELECTOR = Target.the("calendar selector").locatedBy("//button[contains(@aria-label, '{0}')]");
    public static final Target CALENDAR_SELECTOR_DONE_BUTTON = Target.the("calendar done button").locatedBy("//button[@data-stid='apply-date-picker']");

    public static final Target NUMBER_OF_TRAVELERS_DIV = Target.the("number of travelers div").located(By.id("adaptive-menu"));
    public static final Target ADD_ADULTS_BUTTON = Target.the("add adults button").locatedBy("//input[@id='adult-input-0']//following-sibling::button");
    public static final Target ADD_CHILDREN_BUTTON = Target.the("add children button").locatedBy("//input[@id='child-input-0']//following-sibling::button");
    public static final Target TRAVELERS_DONE_BUTTON = Target.the("add travelers done button").locatedBy("//button[@data-testid='guests-done-button']");

    public static final Target SEARCH_FLIGHT_BUTTON = Target.the("search flight button").locatedBy("//button[@type='submit']");

}

package co.com.devco.certification.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class StaysTab {

    public static final Target ORIGIN_INPUT_BUTTON = Target.the("destination button on input element").locatedBy("//input[@id='location-field-destination-input']//following-sibling::button");
    public static final Target ORIGIN_INPUT = Target.the("destination input element").located(By.id("location-field-destination"));
    public static final Target ORIGIN_RESULTS_ELEMENT = Target.the("destination city first result element").locatedBy("//ul[@data-stid='location-field-destination-results']//li[1]");

    public static final Target TRAVELERS_BUTTON = Target.the("travelers input element").locatedBy("//button[@data-testid='travelers-field-trigger']");

    public static final Target SEARCH_STAYS_BUTTON = Target.the("search stays button").locatedBy("//button[@type='submit']");

}

package co.com.devco.certification.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class Travelocity {

    public static final Target STAYS_TAB = Target.the("Stays tab").locatedBy("//ul[@id='uitk-tabs-button-container']//li[1]");
    public static final Target FLIGHTS_TAB = Target.the("Flights tab").locatedBy("//ul[@id='uitk-tabs-button-container']//li[2]");

    public static final Target DEPARTING_DATE_INPUT = Target.the("departing date input").locatedBy("//button[@id='d1-btn']");
    public static final Target CALENDAR_SELECTOR = Target.the("calendar selector").locatedBy("//button[contains(@aria-label, '{0}')]");
    public static final Target CALENDAR_SELECTOR_DONE_BUTTON = Target.the("calendar done button").locatedBy("//button[@data-stid='apply-date-picker']");

    public static final Target ADD_ADULTS_BUTTON = Target.the("add adults button").locatedBy("//input[@id='adult-input-0']//following-sibling::button");
    public static final Target ADULTS_COUNT = Target.the("adults travelers count").locatedBy("//input[@id='adult-input-0']");
    public static final Target ADD_CHILDREN_BUTTON = Target.the("children travelers count").locatedBy("//input[@id='child-input-0']//following-sibling::button");
    public static final Target CHILDREN_COUNT = Target.the("add children button").locatedBy("//input[@id='child-input-0']");
    public static final Target TRAVELERS_DONE_BUTTON = Target.the("add travelers done button").locatedBy("//button[@data-testid='guests-done-button']");

}

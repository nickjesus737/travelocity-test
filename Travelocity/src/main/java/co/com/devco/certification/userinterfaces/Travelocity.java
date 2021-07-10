package co.com.devco.certification.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class Travelocity {

    public static final Target STAYS_TAB = Target.the("Stays tab").locatedBy("//ul[@id='uitk-tabs-button-container']//li[1]");
    public static final Target FLIGHTS_TAB = Target.the("Flights tab").locatedBy("//ul[@id='uitk-tabs-button-container']//li[2]");

}

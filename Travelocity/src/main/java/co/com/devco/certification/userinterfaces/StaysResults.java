package co.com.devco.certification.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class StaysResults {

    public static final Target SORTING_OPTIONS = Target.the("sorting options on stays results page").located(By.id("sort"));
    public static final Target FIRST_OPTION_IN_STAYS_RESULTS = Target.the("first element in the stays results page").locatedBy("//ol//li[@data-stid='property-listing'][1]");

    public static final Target FIRST_OPTION_IN_HOTEL_RESULTS = Target.the("first element in the hotel results page").locatedBy("//div[@data-stid='property-offer-1']");

    public static final Target FIRST_OPTION_IN_HOTEL_RESULTS_RESERVE_BUTTON = Target.the("reserve button on the first element in the hotel results page").locatedBy("//div[@data-stid='property-offer-1']//div[2]/div/div/div[2]//button");
    public static final Target FIRST_OPTION_IN_HOTEL_RESULTS_RESERVE_BUTTON_1 = Target.the("reserve button on the first element in the hotel results page").locatedBy("//div[@data-stid='property-offer-1']/div/div/div[2]/div/div[2]//form//button");

    public static final Target MODAL_WINDOW_RESERVE_BUTTON = Target.the("reserve button on the modal window").locatedBy("//div[@data-stid='payment-options-type']//button[@data-stid='submit-hotel-reserve']");

    public static final Target STAY_DETAILS_FINAL_PRICE = Target.the("stay details final price").locatedBy("//div[@data-stid='payment-options-type']//b");
    public static final Target STAY_DETAILS_FINAL_PRICE_1 = Target.the("stay details final price").locatedBy("//div[@data-stid='property-offer-1']//b[@data-stid='price-lockup-bold-subtext']");

}

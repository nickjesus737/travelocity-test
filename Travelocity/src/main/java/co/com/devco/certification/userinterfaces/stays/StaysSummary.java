package co.com.devco.certification.userinterfaces.stays;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class StaysSummary {

    public static final Target NUMBER_OF_TRAVELERS = Target.the("selected number of traveleres").located(By.id("adultCount-1"));
    public static final Target CHECK_IN_TIME = Target.the("selected check-in time").locatedBy("//div[@class='duration-check-in']//span[@class='date-range']");
    public static final Target CHECK_OUT_TIME = Target.the("selected check-out time").locatedBy("//div[@class='duration-check-out']//span[@class='date-range']");
    public static final Target TOTAL_PRICE = Target.the("total price of the stay").locatedBy("//span[@class='amount-value' and @data-price-update='total']");

}

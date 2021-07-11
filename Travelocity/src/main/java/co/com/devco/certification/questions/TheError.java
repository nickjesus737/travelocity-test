package co.com.devco.certification.questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.devco.certification.userinterfaces.Travelocity.ERROR_MESSAGE;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class TheError {

    public static Question<Boolean> hasTheRightMessage(String errorMessage){

        return actor -> {

            actor.attemptsTo(
                    WaitUntil.the(ERROR_MESSAGE, isVisible()).forNoMoreThan(20).seconds(),
                    Ensure.that(ERROR_MESSAGE).text().contains(errorMessage)
            );

            return true;
        };

    }

}

package co.com.devco.certification.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features="src/test/resources/features/travelocity_manual.feature",
        tags= {},
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        monochrome = true
)
public class TraveloCityManualRunner {
}

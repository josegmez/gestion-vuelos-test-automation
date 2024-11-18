package co.edu.udea.codefactory.gestion_vuelos.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/flights",
        glue = "co.edu.udea.codefactory.gestion_vuelos.stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class FlightRunner {
}
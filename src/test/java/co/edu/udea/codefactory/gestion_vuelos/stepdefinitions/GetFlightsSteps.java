package co.edu.udea.codefactory.gestion_vuelos.stepdefinitions;

import co.edu.udea.codefactory.gestion_vuelos.questions.TableHeaders;
import co.edu.udea.codefactory.gestion_vuelos.tasks.Navigate;
import co.edu.udea.codefactory.gestion_vuelos.userinterfaces.FlightsInterface;
import co.edu.udea.codefactory.gestion_vuelos.userinterfaces.MainInterface;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import co.edu.udea.codefactory.gestion_vuelos.questions.UserLocation;

import java.util.Arrays;
import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class GetFlightsSteps {

    Actor user;

    @Before
    public void config() {
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("user");
        this.user = OnStage.theActorInTheSpotlight();
    }

    @Given("que el usuario navega a la pagina principal de la aplicacion")
    public void locatedToHomePage() {
        user.attemptsTo(
                Navigate.to(new MainInterface(), "")
        );
    }

    @When("el usuario navega a la sección de gestiones de vuelos")
    public void navigateToFlightsPage() {
        user.attemptsTo(Navigate.to(new FlightsInterface(), "/flights"));
    }

    @Then("se muestran los vuelos en el sistema en una tabla con las columnas “Número de Vuelo”, “Estado”, “Tipo de Vuelo”, “Origen”, “Destino”, “Fecha de salida” y “Fecha de llegada”")
    public void showFlights() {
        List<String> expectedHeaders = Arrays.asList(
                "Número de vuelo", "Estado", "Tipo de vuelo",
                "Origen", "Destino", "Fecha de salida", "Fecha de llegada"
        );


        user.should(seeThat(
                TableHeaders.includes(FlightsInterface.TABLE_HEADERS, expectedHeaders)
        ));
    }
}

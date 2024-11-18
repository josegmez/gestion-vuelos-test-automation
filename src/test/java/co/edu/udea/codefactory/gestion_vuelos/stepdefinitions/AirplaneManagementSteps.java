package co.edu.udea.codefactory.gestion_vuelos.stepdefinitions;

import co.edu.udea.codefactory.gestion_vuelos.interactions.Click;
import co.edu.udea.codefactory.gestion_vuelos.tasks.Navigate;
import co.edu.udea.codefactory.gestion_vuelos.userinterfaces.AirplanesInterface;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;

public class AirplaneManagementSteps {

    private final Actor user = OnStage.theActorInTheSpotlight();

    @Given("que el usuario navega a la sección de gestión de tipos de avión")
    public void navigateToAirplaneManagement() {
        user.attemptsTo(Navigate.to(new AirplanesInterface(), "/airplane-types"));
    }

    @And("da clic en el botón {string}")
    public void clickOnAddAirplaneButton(String button) {
        user.attemptsTo(Click.on(AirplanesInterface.ADD_AIRPLANE_BUTTON));
    }
}

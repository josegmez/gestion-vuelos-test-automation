package co.edu.udea.codefactory.gestion_vuelos.stepdefinitions;

import co.edu.udea.codefactory.gestion_vuelos.models.AirplaneType;
import co.edu.udea.codefactory.gestion_vuelos.questions.Item;
import co.edu.udea.codefactory.gestion_vuelos.questions.ToastMessage;
import co.edu.udea.codefactory.gestion_vuelos.questions.UserLocation;
import co.edu.udea.codefactory.gestion_vuelos.tasks.Navigate;
import co.edu.udea.codefactory.gestion_vuelos.tasks.RegisterAirplane;
import co.edu.udea.codefactory.gestion_vuelos.tasks.SearchAirplane;
import co.edu.udea.codefactory.gestion_vuelos.userinterfaces.AirplanesInterface;
import co.edu.udea.codefactory.gestion_vuelos.userinterfaces.RegisterAirplaneInterface;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.targets.Target;

import java.util.Map;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class RegisterAirplaneSteps {

    Actor user;

    @Before
    public void config() {
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("user");
        this.user = OnStage.theActorInTheSpotlight();
    }


    @Given("que el usuario navega a la sección de gestión de tipos de avión")
    public void navigateToAirplaneManagement() {
        user.attemptsTo(Navigate.to(new AirplanesInterface(), "/airplane-types"));
    }

    @And("da clic en el botón Agregar aeronave")
    public void clickOnAddAirplaneButton() {
        user.attemptsTo(Click.on(AirplanesInterface.ADD_AIRPLANE_BUTTON));
    }

    @And("es redirigido al formulario para crear un tipo de avión")
    public void isRedirectedToAirplaneForm() {
        user.should(seeThat(
                UserLocation.isAt("/airplane-types/create")
        ));
    }

    @When("^ingresa datos válidos en todos los campos requeridos$")
    public void fillAirplaneForm(Map<String, Object> data) {
        AirplaneType airplaneType = AirplaneType.FromMap(data);
        user.attemptsTo(RegisterAirplane.withDetails(airplaneType));
    }

    @And("intenta dar clic en el botón {string} dentro del formulario")
    public void tryClickButtonInsideForm(String arg0) {
        user.attemptsTo(Click.on(RegisterAirplaneInterface.SUBMIT_BUTTON));
    }

    @Then("debe mostrar el mensaje de éxito, {string}")
    public void showSuccesMessage(String message) {
        user.should(seeThat(ToastMessage.is(message)));
    }

    @And("redirige hacia la sección de aeronaves")
    public void isRedirectedToAirplanesSection() {
        user.should(seeThat(
                UserLocation.isAt("/airplane-types")
        ));
    }

    @And("muestra el tipo de avión {string} registrado en el sistema")
    public void showRegisteredAirplane(String model) {
        user.attemptsTo(
                SearchAirplane.byModel(model)
        );
        user.should(seeThat(
                Item.isVisible(AirplanesInterface.airplaneRow(model))
        ));
    }
}

package co.edu.udea.codefactory.gestion_vuelos.stepdefinitions;

import co.edu.udea.codefactory.gestion_vuelos.models.AirplaneType;
import co.edu.udea.codefactory.gestion_vuelos.questions.Item;
import co.edu.udea.codefactory.gestion_vuelos.questions.ToastMessage;
import co.edu.udea.codefactory.gestion_vuelos.tasks.EditAirplane;
import co.edu.udea.codefactory.gestion_vuelos.tasks.Navigate;
import co.edu.udea.codefactory.gestion_vuelos.tasks.SearchAirplane;
import co.edu.udea.codefactory.gestion_vuelos.userinterfaces.AirplanesInterface;
import co.edu.udea.codefactory.gestion_vuelos.userinterfaces.AirplaneFormInterface;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import java.util.Map;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class EditAirplaneSteps {

    Actor user;

    @Before
    public void config() {
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("user");
        this.user = OnStage.theActorInTheSpotlight();
    }

    @Given("que el usuario navega a la sección de Aeronaves")
    public void navigateToAirplaneManagement() {
        user.attemptsTo(Navigate.to(new AirplanesInterface(), "/airplane-types"));
    }

    @When("se busca el tipo de avión {string}")
    public void searchAirplaneType(String model) {
        user.attemptsTo(SearchAirplane.byModel(model));
        user.should(seeThat(
                Item.isVisible(AirplanesInterface.airplaneRow(model))
        ));
    }

    @And("da clic en el botón de acciones")
    public void clicksOnActionsButton() {
        user.attemptsTo(Click.on(AirplanesInterface.ACTIONS_BUTTON));
    }

    @And("da clic en la opción de “Editar”")
    public void clicksOnEditOption() {
        user.attemptsTo(Click.on(AirplanesInterface.EDIT_ACTION_BUTTON));
    }

    @And("^modifica los datos existentes con información válida, en los campos modificables$")
    public void modifiesExistingDataWithValidInfo(Map<String, Object> data) {
        AirplaneType airplaneType = AirplaneType.FromMap(data);
        user.attemptsTo(EditAirplane.withDetails(airplaneType));
    }

    @And("da clic en el botón de Guardar cambios")
    public void clicksOnSaveChangesButton() {
        user.attemptsTo(Click.on(AirplaneFormInterface.SUBMIT_BUTTON));
    }

    @Then("el sistema debe mostrar un mensaje de éxito: {string}")
    public void successMessageSuccessfully(String expectedMessage) {
        user.should(seeThat(ToastMessage.is(expectedMessage)));
    }

}

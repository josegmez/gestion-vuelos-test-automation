package co.edu.udea.codefactory.gestion_vuelos.stepdefinitions;

import co.edu.udea.codefactory.gestion_vuelos.questions.Item;
import co.edu.udea.codefactory.gestion_vuelos.questions.ToastMessage;
import co.edu.udea.codefactory.gestion_vuelos.tasks.Navigate;
import co.edu.udea.codefactory.gestion_vuelos.tasks.SearchFlight;
import co.edu.udea.codefactory.gestion_vuelos.userinterfaces.FlightsInterface;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class DeleteFlightSteps {
    Actor user;

    @Before
    public void config() {
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("user");
        this.user = OnStage.theActorInTheSpotlight();
    }

    @Given("que el usuario navega a la sección de gestión de vuelos")
    public void navigateToFlightsManagement() {
        user.attemptsTo(Navigate.to(new FlightsInterface(), "/flights"));
    }

    @When("se busca el vuelo {string}")
    public void searchFlight(String flightNumber) {
        user.attemptsTo(SearchFlight.byFlightNumber(flightNumber));
    }

    @And("da click en el botón de acciones")
    public void clicksOnActionsButton() {
        user.attemptsTo(Click.on(FlightsInterface.ACTIONS_BUTTON));
    }

    @And("da clic en la opción de Eliminar")
    public void clicksOnDelete() {
        user.attemptsTo(Click.on(FlightsInterface.DELETE_ACTION_BUTTON));
    }

    @And("aparece un mensaje de confirmación")
    public void confirmModalIsVisible() {
        user.should(seeThat(Item.isVisible(FlightsInterface.CONFIRM_DELETE_BUTTON)));
    }

    @And("hago clic en el boton de eliminar")
    public void clicksOnConfirmDelete() {
        user.attemptsTo(Click.on(FlightsInterface.CONFIRM_DELETE_BUTTON));
    }

    @Then("debe mostrar el mensaje de éxito {string}")
    public void successMessageIsShown(String expectedMessage) {
        user.should(seeThat(ToastMessage.is(expectedMessage)));
    }
}

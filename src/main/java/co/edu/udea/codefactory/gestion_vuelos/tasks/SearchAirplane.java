package co.edu.udea.codefactory.gestion_vuelos.tasks;

import co.edu.udea.codefactory.gestion_vuelos.userinterfaces.AirplanesInterface;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class SearchAirplane implements Task {
    private final String model;

    public SearchAirplane(String model) {
        this.model = model;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(AirplanesInterface.FILTER_BY_MODEL_INPUT, WebElementStateMatchers.isEnabled()),
                Enter.theValue(model).into(AirplanesInterface.FILTER_BY_MODEL_INPUT)
        );
    }

    public static SearchAirplane byModel(String model) {
        return Tasks.instrumented(SearchAirplane.class, model);
    }
}

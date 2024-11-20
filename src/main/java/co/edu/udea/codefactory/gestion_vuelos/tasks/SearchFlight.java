package co.edu.udea.codefactory.gestion_vuelos.tasks;

import co.edu.udea.codefactory.gestion_vuelos.userinterfaces.FlightsInterface;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;

public class SearchFlight implements Task{
    private final String flightNumber;

    public SearchFlight(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(flightNumber).into(FlightsInterface.FILTER_BY_FLIGHT_NUMBER_INPUT)
        );
    }

    public static SearchFlight byFlightNumber(String flightNumber) {
        return Tasks.instrumented(SearchFlight.class, flightNumber);
    }
}

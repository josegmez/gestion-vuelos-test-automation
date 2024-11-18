package co.edu.udea.codefactory.gestion_vuelos.tasks;

import co.edu.udea.codefactory.gestion_vuelos.userinterfaces.RegisterAirplaneInterface;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class RegisterAirplane implements Task {

    private final String name;
    private final String family;
    private final int seatNumber;
    private final String seatLayout;

    public RegisterAirplane(String name, String family, int seatNumber, String seatLayout) {
        this.name = name;
        this.family = family;
        this.seatNumber = seatNumber;
        this.seatLayout = seatLayout;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(name).into(RegisterAirplaneInterface.AIRPLANE_NAME_FIELD),
                Enter.theValue(family).into(RegisterAirplaneInterface.FAMILY_FIELD),
                Enter.theValue(String.valueOf(seatNumber)).into(RegisterAirplaneInterface.SEAT_NUMBER_FIELD),
                Enter.theValue(seatLayout).into(RegisterAirplaneInterface.SEAT_LAYOUT_FIELDS),
                Click.on(RegisterAirplaneInterface.SUBMIT_BUTTON)
        );
    }

    public static RegisterAirplane withDetails(String name, String family, int seatNumber, String seatLayout) {
        return Tasks.instrumented(RegisterAirplane.class, name, family, seatNumber, seatLayout);
    }
}
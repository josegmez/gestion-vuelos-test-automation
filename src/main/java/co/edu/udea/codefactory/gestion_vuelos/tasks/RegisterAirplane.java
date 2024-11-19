package co.edu.udea.codefactory.gestion_vuelos.tasks;

import co.edu.udea.codefactory.gestion_vuelos.models.AirplaneType;
import co.edu.udea.codefactory.gestion_vuelos.userinterfaces.RegisterAirplaneInterface;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class RegisterAirplane implements Task {

    private final AirplaneType airplaneType;

    public RegisterAirplane(AirplaneType airplaneType) {
        this.airplaneType = airplaneType;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Integer[] seatValues = this.airplaneType.getSeatLayoutParts();

        actor.attemptsTo(
                Enter.theValue(airplaneType.getName()).into(RegisterAirplaneInterface.AIRPLANE_NAME_FIELD),
                Click.on(RegisterAirplaneInterface.FAMILY_FIELD),
                Click.on(RegisterAirplaneInterface.FAMILY_OPTION.of(airplaneType.getFamily())),
                Enter.theValue(String.valueOf(airplaneType.getSeatNumber())).into(RegisterAirplaneInterface.SEAT_NUMBER_FIELD),
                Click.on(RegisterAirplaneInterface.ADD_SEAT_LAYOUT_ROW_BUTTON),
                Click.on(RegisterAirplaneInterface.ADD_SEAT_LAYOUT_ROW_BUTTON)
        );

        for (int i = 0; i < seatValues.length; i++) {
            actor.attemptsTo(
                    Enter.theValue(String.valueOf(seatValues[i]))
                            .into(RegisterAirplaneInterface.SEAT_LAYOUT_FIELDS.of(String.valueOf(i + 1)))
            );
        }
    }

    public static RegisterAirplane withDetails(AirplaneType airplaneType) {
        return Tasks.instrumented(RegisterAirplane.class, airplaneType);
    }
}
package co.edu.udea.codefactory.gestion_vuelos.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;

public class FlightsInterface extends PageObject {
    public static final Target TABLE_HEADERS = Target.the("Encabezados tabla")
            .locatedBy("//table//th/*[1]");

    public static final Target ACTIONS_BUTTON = Target.the("Boton acciones")
            .locatedBy("#actions");

    public static final Target DELETE_ACTION_BUTTON = Target.the("Eliminar vuelo")
            .locatedBy("#delete");

    public static final Target CONFIRM_DELETE_BUTTON = Target.the("Confirmar eliminación")
            .locatedBy("#confirm-delete-flight");

    public static final Target FILTER_BY_FLIGHT_NUMBER_INPUT = Target.the("Filtrar por numero de vuelo")
            .locatedBy("#filter-flight-number");

    public static Target flightRow(String flightNumber) {
        return Target.the("Fila vuelo")
                .locatedBy("//tr[td[contains(., '" + flightNumber + "')]]");
    }
}

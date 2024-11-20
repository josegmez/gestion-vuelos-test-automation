package co.edu.udea.codefactory.gestion_vuelos.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;

public class AirplaneFormInterface extends PageObject {
    public static final Target AIRPLANE_NAME_FIELD = Target.the("Nombre field")
            .locatedBy("#name");

    public static final Target FAMILY_FIELD = Target.the("Familia dropdown")
            .locatedBy("#family");

    public static final Target FAMILY_OPTION = Target.the("Opción en el dropdown de familia")
            .locatedBy("//div[@id='Airbus']");

    public static final Target ADD_SEAT_LAYOUT_ROW_BUTTON = Target.the("Agregar fila a la distribución de asientos").locatedBy(
            "#add-seats-distribution-row"
    );

    public static final Target SEAT_NUMBER_FIELD = Target.the("Número de asientos field")
            .locatedBy("#maxSeats");
    public static final Target SEAT_LAYOUT_FIELDS = Target.the("Distribución de asientos field")
            .locatedBy("(//*[@id[contains(., 'seatsDistribution')]])[{0}]");

    public static final Target SUBMIT_BUTTON = Target.the("Agregar aeronave button")
            .locatedBy("#submit-airplane-form");

}

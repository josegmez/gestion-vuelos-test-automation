package co.edu.udea.codefactory.gestion_vuelos.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;

public class AirplanesInterface extends PageObject {
    public static final Target ADD_AIRPLANE_BUTTON = Target.the("Agregar aeronave button")
            .locatedBy("#add-airplane-type");

    public static final Target ACTIONS_BUTTON = Target.the("Boton acciones")
            .locatedBy("#actions>div>button:first-of-type");

    public static final Target EDIT_ACTION_BUTTON = Target.the("Editar aeronave button")
            .locatedBy("#edit");

    public static final Target FILTER_BY_MODEL_INPUT = Target.the("Filtrar por modelo")
            .locatedBy("#filter-airplane-type-model");

    public static Target airplaneRow(String model) {
        return Target.the("Airplane Row")
                .locatedBy("#" + model);
    }
}

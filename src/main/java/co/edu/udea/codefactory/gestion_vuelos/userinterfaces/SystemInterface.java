package co.edu.udea.codefactory.gestion_vuelos.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;

public class SystemInterface extends PageObject {
    public static final Target TOAST_MESSAGE = Target.the("Toast message")
            .locatedBy("#__next > div:nth-child(3) > ol > li > div > div.text-sm.opacity-90");
}

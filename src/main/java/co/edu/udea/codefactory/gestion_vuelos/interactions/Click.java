package co.edu.udea.codefactory.gestion_vuelos.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.Tasks;

public class Click implements Interaction {
    private final Target target;

    public Click(Target target) {
        this.target = target;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        target.resolveFor(actor).click();
    }

    public static Click on(Target target) {
        return Tasks.instrumented(Click.class, target);
    }

}
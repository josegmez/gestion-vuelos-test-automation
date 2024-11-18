package co.edu.udea.codefactory.gestion_vuelos.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.targets.Target;

public class Type implements Interaction {

    private final String text;
    private final Target target;

    public Type(String text, Target target) {
        this.text = text;
        this.target = target;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        target.resolveFor(actor).sendKeys(text);
    }

    public static Type theText(String text, Target target) {
        return Tasks.instrumented(Type.class, text, target);
    }
}


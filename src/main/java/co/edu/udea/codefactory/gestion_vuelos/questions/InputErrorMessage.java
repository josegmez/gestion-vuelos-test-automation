package co.edu.udea.codefactory.gestion_vuelos.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;

public class InputErrorMessage implements Question<Boolean> {
    private Target inputField;

    public InputErrorMessage(Target inputField) {
        this.inputField = inputField;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return inputField.resolveFor(actor).getAttribute("validationMessage") != null;
    }

    public static InputErrorMessage isVisible(Target inputField) {
        return new InputErrorMessage(inputField);
    }
}

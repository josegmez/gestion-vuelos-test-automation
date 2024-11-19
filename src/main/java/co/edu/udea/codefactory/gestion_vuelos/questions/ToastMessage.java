package co.edu.udea.codefactory.gestion_vuelos.questions;

import co.edu.udea.codefactory.gestion_vuelos.userinterfaces.SystemInterface;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class ToastMessage implements Question<Boolean> {

    private String expectedMessage;

    private ToastMessage(String expectedMessage) {
        this.expectedMessage = expectedMessage;
    }

    public static ToastMessage is(String expectedMessage) {
        return new ToastMessage(expectedMessage);
    }

    /**
     * Evaluates the Question by comparing the current URL to the expected URL.
     *
     * @param actor The actor performing the Question.
     * @return True if the current URL matches the expected URL, otherwise false.
     */
    @Override
    public Boolean answeredBy(Actor actor){
        return Text.of(SystemInterface.TOAST_MESSAGE).answeredBy(actor).equals(this.expectedMessage);
    }
}

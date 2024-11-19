package co.edu.udea.codefactory.gestion_vuelos.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.questions.Visibility;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.Question;

public class Item implements Question<Boolean>{
    private final Target target;
    public Item(Target target) {
        this.target = target;
    }

    public static Item isVisible(Target target) {
        return new Item(target);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return Visibility.of(target).answeredBy(actor);
    }
}

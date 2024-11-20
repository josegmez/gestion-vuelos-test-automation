package co.edu.udea.codefactory.gestion_vuelos.questions;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;

import java.util.List;
import java.util.stream.Collectors;

public class TableHeaders implements Question<Boolean> {
    private Target target;
    private String expectedTextContent;

    public TableHeaders(Target target, String expectedTextContent) {
        this.target = target;
        this.expectedTextContent = expectedTextContent;
    }

    public static TableHeaders includes(Target target, String expectedTextContent) {
        return new TableHeaders(target, expectedTextContent);
    }

    @Override
    public Boolean answeredBy(Actor actor){
        List<WebElementFacade> elements = this.target.resolveAllFor(actor);

        List<String> headerTexts = elements.stream()
                .map(WebElementFacade::getText)
                .collect(Collectors.toList());

        return headerTexts.stream().anyMatch(text -> text.equals(this.expectedTextContent));
    }
}

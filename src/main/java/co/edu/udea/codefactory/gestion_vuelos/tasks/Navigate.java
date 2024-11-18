package co.edu.udea.codefactory.gestion_vuelos.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.model.environment.SystemEnvironmentVariables;
import net.thucydides.model.util.EnvironmentVariables;

public class Navigate implements Task {

    private EnvironmentVariables enviromentVariable = SystemEnvironmentVariables.createEnvironmentVariables();
    private String appUrl;
    private final PageObject page;

    public Navigate(PageObject page, String view) {
        this.appUrl = enviromentVariable.optionalProperty("webdriver.base.url").orElse("http://localhost:3000");
        this.appUrl = appUrl + view;
        this.page = page;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        page.setDefaultBaseUrl(appUrl);
        actor.attemptsTo(Open.browserOn(page));
    }

    public static Navigate to(PageObject page, String view) {
        return Tasks.instrumented(Navigate.class, page, view);
    }
}
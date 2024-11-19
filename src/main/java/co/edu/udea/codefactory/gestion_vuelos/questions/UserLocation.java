package co.edu.udea.codefactory.gestion_vuelos.questions;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.model.environment.SystemEnvironmentVariables;
import net.thucydides.model.util.EnvironmentVariables;

public class UserLocation implements Question<Boolean> {

    private String expectedUrl;
    private EnvironmentVariables enviromentVariable = SystemEnvironmentVariables.createEnvironmentVariables();
    private String appUrl;

    private UserLocation(String expectedPath) {
        this.appUrl = enviromentVariable.optionalProperty("webdriver.base.url").orElse("http://localhost:3000");
        this.expectedUrl = appUrl + expectedPath;
    }


    public static UserLocation isAt(String expectedPath) {
        return new UserLocation(expectedPath);
    }

    /**
     * Evaluates the Question by comparing the current URL to the expected URL.
     *
     * @param actor The actor performing the Question.
     * @return True if the current URL matches the expected URL, otherwise false.
     */
    @Override
    public Boolean answeredBy(Actor actor) {
        String currentUrl = BrowseTheWeb.as(actor).getDriver().getCurrentUrl();
        return currentUrl.equals(this.expectedUrl);
    }
}

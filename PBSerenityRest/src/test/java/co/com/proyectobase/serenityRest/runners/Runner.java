package co.com.proyectobase.serenityRest.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;


@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/consumir.feature",
        glue = "co.com.proyectobase.serenityRest.stepdefinitions",
        tags = "@TipoPost",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class Runner {
}

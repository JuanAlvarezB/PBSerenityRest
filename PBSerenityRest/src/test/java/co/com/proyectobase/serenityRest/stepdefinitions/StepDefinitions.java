package co.com.proyectobase.serenityRest.stepdefinitions;

import co.com.proyectobase.serenityRest.exceptions.IncorrectExpectedResponse;
import co.com.proyectobase.serenityRest.questions.ValidarEmail;
import co.com.proyectobase.serenityRest.tasks.*;
import co.com.proyectobase.serenityRest.utils.MessageForFailures;
import co.com.proyectobase.serenityRest.utils.Schema;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import org.apache.http.HttpStatus;
import org.junit.Assert;

import static co.com.proyectobase.serenityRest.utils.Constants.*;
import static net.serenitybdd.screenplay.actors.OnStage.*;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;


public class StepDefinitions {


    @Before
    public void setUp() {
        setTheStage(new OnlineCast());
    }

    @When("consume the reqres.in service")
    public void consumeTheReqresInService() {
        theActorInTheSpotlight().attemptsTo(GetReqresIn.MethodGet());

    }

    @Then("validate the {int} the service")
    public void validateTheTheService(int statusCode) {
        theActorInTheSpotlight().should(seeThatResponse("The response code is:",
                response -> response.statusCode(statusCode))
        );
    }

    @And("validate {string} the response")
    public void validateTheResponse(String schemaFile) {
        String schemaPath = Schema.getSchemaPath(schemaFile);
        theActorInTheSpotlight().should(
                seeThatResponse(
                        is -> is.statusCode(HttpStatus.SC_OK)
                ).orComplainWith(IncorrectExpectedResponse.class,
                        MessageForFailures.MESSAGE_WRONG_RESPONSE_CODE_200.getMessage()),
                seeThatResponse(
                        is -> is.body(JsonSchemaValidator.matchesJsonSchemaInClasspath(schemaPath))
                ).orComplainWith(IncorrectExpectedResponse.class, MessageForFailures.MESSAGE_SCHEMA_INVALID.getMessage())
        );
    }

    @Given("I consumer URL base")
    public void iConsumerURLBase() {
        theActorCalled("User").whoCan(CallAnApi.at(URL_BASE));
    }

    @When("consume method POST by reqres service")
    public void consumeMethodPOSTByReqresService() {
        theActorInTheSpotlight().attemptsTo(
                PostConsumer.validatePost()
        );
    }

    @Then("the service response {int}")
    public void theServiceResponseStatuscode(int statusCode) {
        theActorInTheSpotlight().should(seeThatResponse("The response code is:",
                response -> response.statusCode(statusCode))
        );
    }

    @And("validate {string} the service by method POST")
    public void validateTheServiceByMethodPOST(String schemaFile) {
        String schemaPath = Schema.getSchemaPath(schemaFile);
        theActorInTheSpotlight().should(
                seeThatResponse(
                        is -> is.statusCode(HttpStatus.SC_CREATED)
                ).orComplainWith(IncorrectExpectedResponse.class, MessageForFailures
                        .MESSAGE_WRONG_RESPONSE_CODE_201.getMessage()),
                seeThatResponse(
                        is -> is.body(JsonSchemaValidator.matchesJsonSchemaInClasspath(schemaPath))
                ).orComplainWith(IncorrectExpectedResponse.class, MessageForFailures.MESSAGE_SCHEMA_INVALID.getMessage())
        );

    }

    @And("validate {string} of user")
    public void validateOfUser(String email) {

        OnStage.theActorInTheSpotlight().should(
                GivenWhenThen.seeThat(ValidarEmail.validation(email))
        );


    }
}

package co.com.proyectobase.serenityRest.tasks;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Put;

import java.nio.file.Files;
import java.nio.file.Paths;

import static co.com.proyectobase.serenityRest.utils.Constants.*;


public class PutConsumer implements Task {
    private String fileJson;
    public static String NAMERESULT;


    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            fileJson = new String(Files.readAllBytes(Paths.get(PATH_JSON + "/methodPut.json")));
            actor.attemptsTo(
                    Put.to(PATH_PUT).with(
                            request -> request
                                    .relaxedHTTPSValidation()
                                    .header("Content-type", "application/json")
                                    .header("x-api-key", "reqres-free-v1")
                                    .body(fileJson)
                                    .response().statusCode(200).request()
                    )
            );
        } catch (Exception e) {
            e.printStackTrace();
        }

        String getName = SerenityRest.lastResponse().jsonPath().getString("name").trim();
        if (getName.isEmpty()) {
            throw new RuntimeException("Fallo al extraer el name");
        }
        actor.remember(NAMERESULT, getName);
    }

    public static PutConsumer validatePut() {
        return new PutConsumer();
    }
}

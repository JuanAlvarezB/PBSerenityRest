package co.com.proyectobase.serenityRest.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static co.com.proyectobase.serenityRest.utils.Constants.PATH_GET;

public class GetReqresIn implements Task {



    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            actor.attemptsTo(
                    Get.resource(PATH_GET).with(
                            request -> request
                                    .relaxedHTTPSValidation()
                                    .header("accept","application/json")
                                    .header("Content-Type","application/json")
                                    .response().statusCode(200).request()
                    )
            );
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public static GetReqresIn MethodGet(){return new GetReqresIn();}
}

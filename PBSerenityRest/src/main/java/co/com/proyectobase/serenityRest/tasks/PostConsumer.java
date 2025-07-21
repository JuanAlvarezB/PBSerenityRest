package co.com.proyectobase.serenityRest.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;

import java.nio.file.Files;
import java.nio.file.Paths;

import static co.com.proyectobase.serenityRest.utils.Constants.*;

public class PostConsumer implements Task {
    private String fileJson;

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            fileJson = new String(Files.readAllBytes(Paths.get(PATH_JSON + "/methodPost.json")));
            actor.attemptsTo(
                    Post.to(URL_BASE + PATH_POST).with(
                            request -> request
                                    .relaxedHTTPSValidation()
                                    .header("Content-type","application/json")
                                    .header("x-api-key","reqres-free-v1")
                                    .body(fileJson)
                                    .response().statusCode(201).request()

                    )
            );
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static PostConsumer validatePost(){return new PostConsumer(); }
}

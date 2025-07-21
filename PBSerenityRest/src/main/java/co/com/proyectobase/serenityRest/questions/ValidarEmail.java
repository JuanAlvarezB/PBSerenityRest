package co.com.proyectobase.serenityRest.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.proyectobase.serenityRest.tasks.PostConsumer.EMAIL;

public class ValidarEmail implements Question<Boolean> {
private final String email;

    public ValidarEmail(String email) {
        this.email = email;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        String emailObtenido = actor.recall(EMAIL);
        return email.equals(emailObtenido);

    }

    public static ValidarEmail validation(String email){
        return new ValidarEmail(email);
    }
}

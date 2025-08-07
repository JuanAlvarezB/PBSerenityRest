package co.com.proyectobase.serenityRest.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.proyectobase.serenityRest.tasks.PutConsumer.NAMERESULT;


public class ValidarName implements Question<Boolean> {
    private String name;

    public ValidarName(String name) {
        this.name = name;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        String nameObtenido = actor.recall(NAMERESULT);
        return name.equals(nameObtenido);
    }

    public static ValidarName validationName(String name) {
        return new ValidarName(name);
    }
}

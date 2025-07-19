package co.com.proyectobase.serenityRest.exceptions;

public class IncorrectExpectedResponseCode extends AssertionError {
    public IncorrectExpectedResponseCode(String message, Throwable e) {
        super(message, e);
    }
}

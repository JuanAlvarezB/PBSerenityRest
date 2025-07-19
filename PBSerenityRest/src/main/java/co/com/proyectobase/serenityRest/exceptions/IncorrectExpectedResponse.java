package co.com.proyectobase.serenityRest.exceptions;

public class IncorrectExpectedResponse extends AssertionError {
  public IncorrectExpectedResponse(String message, Throwable e) {
    super(message, e);
  }
}

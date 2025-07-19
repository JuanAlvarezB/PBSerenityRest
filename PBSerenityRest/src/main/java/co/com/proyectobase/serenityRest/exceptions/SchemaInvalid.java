package co.com.proyectobase.serenityRest.exceptions;

public class SchemaInvalid extends AssertionError {
  public SchemaInvalid(String message, Throwable e) {
    super(message, e);
  }
}

package co.com.proyectobase.serenityRest.utils;

public enum MessageForFailures {
    MESSAGE_WRONG_RESPONSE_CODE_200("200 response code was expected"),
    MESSAGE_WRONG_RESPONSE_CODE_201("201 response code was expected"),
    MESSAGE_WRONG_RESPONSE_CODE_400("400 response code was expected"),
    MESSAGE_SCHEMA_INVALID("The structure of the response body is not correct");

    private final String message;

    MessageForFailures(String message){this.message = message; }

    public String getMessage() {
        return message;
    }
}

package edu.vistula.mjask.springcrud.shared.api.response;

public class ErrorMessageResponse {
    private final String message;
    public ErrorMessageResponse(String localizedMessage) {
        this.message = localizedMessage;
    }
    public String getMessage() {
        return message;
    }
}

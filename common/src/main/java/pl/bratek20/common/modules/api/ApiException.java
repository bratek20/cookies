package pl.bratek20.common.modules.api;

public class ApiException extends RuntimeException {

    public ApiException() {
        super();
    }
    public ApiException(String message) {
        super(message);
    }
}

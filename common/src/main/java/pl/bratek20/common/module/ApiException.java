package pl.bratek20.common.module;

public class ApiException extends RuntimeException {

    public ApiException() {
        super();
    }
    public ApiException(String message) {
        super(message);
    }
}

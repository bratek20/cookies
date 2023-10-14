package pl.bratek20.cookies.module;

public class ApiException extends RuntimeException {

    public ApiException() {
        super();
    }
    public ApiException(String message) {
        super(message);
    }
}

package pl.bratek20.cookies.user.api.exceptions;

import pl.bratek20.cookies.module.ApiException;

public class WrongUserPasswordException extends ApiException {
    public WrongUserPasswordException() {
        super("Wrong user password");
    }
}

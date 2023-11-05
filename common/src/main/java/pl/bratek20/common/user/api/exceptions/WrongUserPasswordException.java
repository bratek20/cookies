package pl.bratek20.common.user.api.exceptions;

import pl.bratek20.common.modules.api.ApiException;

public class WrongUserPasswordException extends ApiException {
    public WrongUserPasswordException() {
        super("Wrong user password");
    }
}

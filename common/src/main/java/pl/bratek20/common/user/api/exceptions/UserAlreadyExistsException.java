package pl.bratek20.common.user.api.exceptions;

import pl.bratek20.common.modules.api.ApiException;

public class UserAlreadyExistsException extends ApiException {

    public UserAlreadyExistsException(String login) {
        super("User with name " + login + " already exists");
    }
}

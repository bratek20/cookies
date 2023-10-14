package pl.bratek20.cookies.user.api.exceptions;

import pl.bratek20.cookies.module.ApiException;

public class UserAlreadyExistsException extends ApiException {

    public UserAlreadyExistsException(String login) {
        super("User with name " + login + " already exists");
    }
}

package pl.bratek20.cookies.users.api.exceptions;

import pl.bratek20.cookies.module.ApiException;

public class UserAlreadyExistsException extends ApiException {

    public UserAlreadyExistsException(String login) {
        super("User with login " + login + " already exists");
    }
}

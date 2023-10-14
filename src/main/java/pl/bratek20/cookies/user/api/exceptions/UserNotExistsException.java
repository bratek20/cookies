package pl.bratek20.cookies.user.api.exceptions;

import pl.bratek20.cookies.module.ApiException;

public class UserNotExistsException extends ApiException {

    public UserNotExistsException(String login) {
        super("User with login " + login + " not exists");
    }
}

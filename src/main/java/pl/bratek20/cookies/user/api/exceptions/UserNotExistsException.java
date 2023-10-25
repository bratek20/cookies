package pl.bratek20.cookies.user.api.exceptions;

import pl.bratek20.common.module.ApiException;

public class UserNotExistsException extends ApiException {

    public UserNotExistsException(String login) {
        super("User with name " + login + " not exists");
    }
}

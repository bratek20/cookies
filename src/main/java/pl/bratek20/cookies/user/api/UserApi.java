package pl.bratek20.cookies.user.api;

import pl.bratek20.cookies.identity.api.IdentityId;
import pl.bratek20.cookies.user.api.exceptions.UserAlreadyExistsException;
import pl.bratek20.cookies.user.api.exceptions.UserNotExistsException;
import pl.bratek20.cookies.user.api.exceptions.WrongUserPasswordException;

public interface UserApi {
    IdentityId create(User user) throws UserAlreadyExistsException;

    IdentityId getIdentityId(User user) throws UserNotExistsException, WrongUserPasswordException;
}

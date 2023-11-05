package pl.bratek20.common.user.api;

import pl.bratek20.common.identity.api.IdentityId;
import pl.bratek20.common.user.api.exceptions.UserNotExistsException;
import pl.bratek20.common.user.api.exceptions.WrongUserPasswordException;
import pl.bratek20.common.user.api.exceptions.UserAlreadyExistsException;
import pl.bratek20.common.user.api.exceptions.UserNotExistsException;
import pl.bratek20.common.user.api.exceptions.WrongUserPasswordException;

public interface UserApi {
    IdentityId create(User user) throws UserAlreadyExistsException;

    IdentityId getIdentityId(User user) throws UserNotExistsException, WrongUserPasswordException;
}

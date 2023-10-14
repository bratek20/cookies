package pl.bratek20.cookies.user.impl.appli;

import lombok.RequiredArgsConstructor;
import pl.bratek20.cookies.identity.api.IdentityApi;
import pl.bratek20.cookies.identity.api.IdentityId;
import pl.bratek20.cookies.user.api.User;
import pl.bratek20.cookies.user.api.UserApi;
import pl.bratek20.cookies.user.api.exceptions.UserAlreadyExistsException;
import pl.bratek20.cookies.user.api.exceptions.UserNotExistsException;
import pl.bratek20.cookies.user.api.exceptions.WrongUserPasswordException;

@RequiredArgsConstructor
public class UserService implements UserApi {
    private final UserRepository repository;

    private final IdentityApi identityApi;

    @Override
    public IdentityId create(User user) {
        if (repository.hasUserLogin(user.login())) {
            throw new UserAlreadyExistsException(user.login());
        }

        var identityId = identityApi.generate();
        repository.save(new UserIdentity(user, identityId));

        return identityId;
    }

    @Override
    public IdentityId getIdentityId(User user) {
        return repository.findByLogin(user.login())
            .map(
                u -> {
                    if (u.user().password().equals(user.password())) {
                        return u.identityId();
                    }
                    throw new WrongUserPasswordException();
                }
            )
            .orElseThrow(() -> new UserNotExistsException(user.login()));
    }
}

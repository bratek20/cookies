package pl.bratek20.cookies.users.impl.appli;

import pl.bratek20.cookies.identity.api.IdentityId;
import pl.bratek20.cookies.users.api.User;

import java.util.Optional;

public interface UsersRepository {

    boolean hasUserLogin(String login);

    void save(UserIdentity user);

    Optional<UserIdentity> findByLogin(String login);
}

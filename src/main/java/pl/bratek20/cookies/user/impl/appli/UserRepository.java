package pl.bratek20.cookies.user.impl.appli;

import java.util.Optional;

public interface UserRepository {

    boolean hasUserLogin(String login);

    void save(UserIdentity user);

    Optional<UserIdentity> findByLogin(String login);
}

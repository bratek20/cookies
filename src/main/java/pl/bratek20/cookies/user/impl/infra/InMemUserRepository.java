package pl.bratek20.cookies.user.impl.infra;

import pl.bratek20.cookies.user.impl.appli.UserIdentity;
import pl.bratek20.cookies.user.impl.appli.UserRepository;

import java.util.*;

public class InMemUserRepository implements UserRepository {
    private Map<String, UserIdentity> users = new HashMap<>();

    @Override
    public boolean hasUserLogin(String login) {
        return users.containsKey(login);
    }

    @Override
    public void save(UserIdentity user) {
        users.put(user.user().name(), user);
    }

    @Override
    public Optional<UserIdentity> findByLogin(String login) {
        return Optional.ofNullable(users.get(login));
    }
}

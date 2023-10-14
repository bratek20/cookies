package pl.bratek20.cookies.users.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.bratek20.cookies.users.api.exceptions.UserAlreadyExistsException;
import pl.bratek20.cookies.users.api.exceptions.UserNotExistsException;
import pl.bratek20.cookies.users.api.exceptions.WrongUserPasswordException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

abstract class ApiTest {

    protected abstract Users createUsers();

    private Users users;

    @BeforeEach
    void setUp() {
        users = createUsers();
    }

    @Test
    void shouldCreateUser() {
        User user = new User("login", "password");

        var id = users.create(user);

        assertThat(id).isNotNull();
    }

    @Test
    void shouldCreateDifferentUsers() {
        User user1 = new User("login1", "password");
        User user2 = new User("login2", "password");

        var id1 = users.create(user1);
        var id2 = users.create(user2);

        assertThat(id1).isNotEqualTo(id2);
    }

    @Test
    void shouldGetIdentityId() {
        User user = new User("login", "password");
        var id = users.create(user);

        var identityId = users.getIdentityId(user);

        assertThat(identityId).isEqualTo(id);
    }

    @Test
    void shouldThrowOnCreateWhenUserAlreadyExists() {
        User user = new User("login", "password");
        User sameLoginUser = new User("login", "otherPassword");
        users.create(user);

        assertThatThrownBy(() -> users.create(sameLoginUser))
                .isInstanceOf(UserAlreadyExistsException.class);
    }

    @Test
    void shouldThrowOnGetIdentityIdWhenUserNotExists() {
        User user = new User("login", "password");

        assertThatThrownBy(() -> users.getIdentityId(user))
                .isInstanceOf(UserNotExistsException.class);
    }

    @Test
    void shouldThrowOnGetIdentityIdWhenPasswordIsWrong() {
        User user = new User("login", "password");
        User wrongPasswordUser = new User("login", "wrongPassword");
        users.create(user);

        assertThatThrownBy(() -> users.getIdentityId(wrongPasswordUser))
                .isInstanceOf(WrongUserPasswordException.class);
    }
}
package pl.bratek20.cookies.users.impl.appli;

import pl.bratek20.cookies.identity.api.IdentityId;
import pl.bratek20.cookies.users.api.User;

public record UserIdentity(User user, IdentityId identityId) {

}

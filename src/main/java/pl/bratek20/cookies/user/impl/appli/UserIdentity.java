package pl.bratek20.cookies.user.impl.appli;

import pl.bratek20.common.identity.api.IdentityId;
import pl.bratek20.cookies.user.api.User;

public record UserIdentity(User user, IdentityId identityId) {

}

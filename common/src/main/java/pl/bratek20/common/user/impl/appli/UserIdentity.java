package pl.bratek20.common.user.impl.appli;

import pl.bratek20.common.identity.api.IdentityId;
import pl.bratek20.common.user.api.User;

public record UserIdentity(User user, IdentityId identityId) {

}

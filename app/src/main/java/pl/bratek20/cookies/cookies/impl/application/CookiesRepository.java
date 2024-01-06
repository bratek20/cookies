package pl.bratek20.cookies.cookies.impl.application;

import pl.bratek20.cookies.cookies.api.CookieFlavor;
import pl.bratek20.commons.identity.api.IdentityId;

public interface CookiesRepository {
    int getAmount(IdentityId identityId, CookieFlavor flavor);
    void setAmount(IdentityId identityId, CookieFlavor flavor, int amount);
}

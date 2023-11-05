package pl.bratek20.cookies.cookies.api;

import pl.bratek20.common.identity.api.IdentityId;

public interface CookiesApi {
    void addCookie(Cookie cookie, IdentityId identityId);
    void consumeCookie(CookieFlavor flavor, IdentityId identityId);
    int countCookies(CookieFlavor flavor, IdentityId identityId);
}

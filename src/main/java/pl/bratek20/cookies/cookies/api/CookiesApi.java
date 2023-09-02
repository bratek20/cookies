package pl.bratek20.cookies.cookies.api;

import pl.bratek20.cookies.identity.api.IdentityId;

public interface CookiesApi {
    void addCookie(Cookie cookie, IdentityId identityId);
    void consumeCookie(IdentityId identityId);
    int countCookies(IdentityId identityId);
}

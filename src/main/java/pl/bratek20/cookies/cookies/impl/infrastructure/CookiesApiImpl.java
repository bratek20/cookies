package pl.bratek20.cookies.cookies.impl.infrastructure;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.bratek20.cookies.cookies.api.Cookie;
import pl.bratek20.cookies.cookies.api.CookieFlavor;
import pl.bratek20.cookies.cookies.api.CookiesApi;
import pl.bratek20.cookies.cookies.impl.application.CookiesService;
import pl.bratek20.cookies.identity.api.IdentityId;

@RequiredArgsConstructor
public class CookiesApiImpl implements CookiesApi {

    private final CookiesService cookiesService;

    @Override
    public void addCookie(Cookie cookie, IdentityId identityId) {
        cookiesService.addCookie(cookie, identityId);
    }

    @Override
    public void consumeCookie(CookieFlavor flavor, IdentityId identityId) {
        cookiesService.consumeCookie(flavor, identityId);
    }

    @Override
    public int countCookies(CookieFlavor flavor, IdentityId identityId) {
        return cookiesService.countCookies(flavor, identityId);
    }
}

package pl.bratek20.cookies.cookies.impl;

import org.springframework.stereotype.Service;
import pl.bratek20.cookies.cookies.api.Cookie;
import pl.bratek20.cookies.cookies.api.CookiesApi;
import pl.bratek20.cookies.identity.api.IdentityId;

import java.util.HashMap;
import java.util.Map;

@Service
public class CookiesService implements CookiesApi {

    private final Map<IdentityId, Integer> cookies = new HashMap<>();

    @Override
    public void addCookie(Cookie cookie, IdentityId identityId) {
        cookies.put(identityId, cookies.getOrDefault(identityId, 0) + 1);
    }

    @Override
    public void consumeCookie(Cookie cookie, IdentityId identityId) {

    }

    @Override
    public int countCookies(IdentityId identityId) {
        return cookies.getOrDefault(identityId, 0);
    }
}

package pl.bratek20.cookies.cookies.impl;

import org.springframework.stereotype.Service;
import pl.bratek20.cookies.cookies.api.Cookie;
import pl.bratek20.cookies.cookies.api.CookieFlavor;
import pl.bratek20.cookies.cookies.api.CookiesApi;
import pl.bratek20.cookies.cookies.api.NoCookiesToConsumeException;
import pl.bratek20.cookies.identity.api.IdentityId;

import java.util.HashMap;
import java.util.Map;

@Service
public class CookiesService implements CookiesApi {

    class Cookies {
        private final Map<CookieFlavor, Integer> amounts = new HashMap<>();

        public void setAmount(CookieFlavor flavor, int amount) {
            amounts.put(flavor, amount);
        }

        public int getAmount(CookieFlavor flavor) {
            return amounts.getOrDefault(flavor, 0);
        }
    }

    private final Map<IdentityId, Cookies> identitiesCookies = new HashMap<>();

    @Override
    public void addCookie(Cookie cookie, IdentityId identityId) {
        var cookies = getOrCreateCookies(identityId);
        cookies.setAmount(cookie.flavor(), cookies.getAmount(cookie.flavor()) + 1);
    }

    @Override
    public void consumeCookie(CookieFlavor flavor, IdentityId identityId) {
        var cookies = getOrCreateCookies(identityId);
        if (cookies.getAmount(flavor) == 0) {
            throw new NoCookiesToConsumeException();
        }
        cookies.setAmount(flavor, cookies.getAmount(flavor) - 1);
    }

    @Override
    public int countCookies(CookieFlavor flavor, IdentityId identityId) {
        return getOrCreateCookies(identityId).getAmount(flavor);
    }

    private Cookies getOrCreateCookies(IdentityId identityId) {
        return identitiesCookies.computeIfAbsent(identityId, id -> new Cookies());
    }
}

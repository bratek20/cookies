package pl.bratek20.cookies.cookies.impl.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.bratek20.cookies.cookies.api.Cookie;
import pl.bratek20.cookies.cookies.api.CookieFlavor;
import pl.bratek20.cookies.cookies.api.CookiesApi;
import pl.bratek20.cookies.cookies.api.NoCookiesToConsumeException;
import pl.bratek20.cookies.identity.api.IdentityId;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CookiesService implements CookiesApi {

    private final CookiesRepository repository;

    @Override
    public void addCookie(Cookie cookie, IdentityId identityId) {
        var current = repository.getAmount(identityId, cookie.flavor());
        repository.setAmount(identityId, cookie.flavor(), current + 1);
    }

    @Override
    public void consumeCookie(CookieFlavor flavor, IdentityId identityId) {
        var current = repository.getAmount(identityId, flavor);
        if (current == 0) {
            throw new NoCookiesToConsumeException();
        }
        repository.setAmount(identityId, flavor, current - 1);
    }

    @Override
    public int countCookies(CookieFlavor flavor, IdentityId identityId) {
        return repository.getAmount(identityId, flavor);
    }
}

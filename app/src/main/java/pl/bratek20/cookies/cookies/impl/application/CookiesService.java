package pl.bratek20.cookies.cookies.impl.application;

import lombok.RequiredArgsConstructor;
import pl.bratek20.commons.events.api.EventsApi;
import pl.bratek20.cookies.cookies.api.*;
import pl.bratek20.common.identity.api.IdentityId;

@RequiredArgsConstructor
public class CookiesService implements CookiesApi {

    private final CookiesRepository repository;
    private final EventsApi eventsApi;

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

        eventsApi.publish(new CookieConsumedEvent(flavor));
    }

    @Override
    public int countCookies(CookieFlavor flavor, IdentityId identityId) {
        return repository.getAmount(identityId, flavor);
    }
}

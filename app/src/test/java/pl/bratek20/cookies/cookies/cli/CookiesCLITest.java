package pl.bratek20.cookies.cookies.cli;

import lombok.RequiredArgsConstructor;
import pl.bratek20.architecture.events.EventsApiMock;
import pl.bratek20.common.cli.CLILineHandler;
import pl.bratek20.commons.identity.api.IdentityId;
import pl.bratek20.cookies.cookies.api.Cookie;
import pl.bratek20.cookies.cookies.api.CookieFlavor;
import pl.bratek20.cookies.cookies.api.CookiesApi;
import pl.bratek20.cookies.cookies.api.CookiesApiTest;
import pl.bratek20.cookies.cookies.impl.CookiesTestConfig;
import pl.bratek20.spring.context.SpringContextBuilder;

class CookiesCLITest extends CookiesApiTest {

    @Override
    protected CookiesApiTest.Context createContext() {
        var context = new SpringContextBuilder(
            CookiesTestConfig.class,
            CookiesCLIServerConfig.class
        ).build();

        var eventsApiMock = context.get(EventsApiMock.class);
        var cliLineHandler = context.get(CLILineHandler.class);

        var api = new CLIClient(cliLineHandler);
        return new CookiesApiTest.Context(api, eventsApiMock);
    }

    @RequiredArgsConstructor
    static class CLIClient implements CookiesApi {
        private final CLILineHandler cliLineHandler;

        @Override
        public void addCookie(Cookie cookie, IdentityId identityId) {
            cliLineHandler.handleLine("add %s %s".formatted(cookie.flavor().name(), identityId.value()));
        }

        @Override
        public void consumeCookie(CookieFlavor flavor, IdentityId identityId) {
            cliLineHandler.handleLine("consume %s %s".formatted(flavor.name(), identityId.value()));
        }

        @Override
        public int countCookies(CookieFlavor flavor, IdentityId identityId) {
            var out = cliLineHandler.handleLine("count %s %s".formatted(flavor.name(), identityId.value()));
            var count = out.split("Cookies count: ")[1];
            return Integer.parseInt(count);
        }
    }
}
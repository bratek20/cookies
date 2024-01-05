package pl.bratek20.cookies.cookies.cli;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import pl.bratek20.common.app.cli.BaseCLIConfig;
import pl.bratek20.common.cli.CLILineHandler;
import pl.bratek20.commons.events.EventsApiMock;
import pl.bratek20.cookies.cookies.api.CookiesApiTest;
import pl.bratek20.cookies.cookies.api.Cookie;
import pl.bratek20.cookies.cookies.api.CookieFlavor;
import pl.bratek20.cookies.cookies.api.CookiesApi;
import pl.bratek20.cookies.cookies.impl.CookiesTestConfig;
import pl.bratek20.common.identity.api.IdentityId;

@SpringBootTest(
    classes = {
        BaseCLIConfig.class,
        CookiesTestConfig.class,
        CookiesCLIServerConfig.class,
    }
)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class CookiesCLITest extends CookiesApiTest {
    @Autowired
    private CLILineHandler cliLineHandler;

    @Autowired
    private EventsApiMock eventsApiMock;

    @Override
    protected CookiesApiTest.Context createContext() {
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
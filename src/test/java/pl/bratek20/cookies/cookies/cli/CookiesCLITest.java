package pl.bratek20.cookies.cookies.cli;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import pl.bratek20.cookies.app.cli.BaseCLIConfig;
import pl.bratek20.cookies.cli.CLILineHandler;
import pl.bratek20.cookies.cookies.api.CookiesApiTest;
import pl.bratek20.cookies.cookies.api.Cookie;
import pl.bratek20.cookies.cookies.api.CookieFlavor;
import pl.bratek20.cookies.cookies.api.CookiesApi;
import pl.bratek20.cookies.cookies.impl.infrastructure.configs.CookiesInMemoryConfig;
import pl.bratek20.common.identity.api.IdentityId;

@SpringBootTest(
    classes = {
        BaseCLIConfig.class,
        CookiesInMemoryConfig.class,
        CookiesCLIServerConfig.class,
    }
)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class CookiesCLITest extends CookiesApiTest {
    @Autowired
    private CLILineHandler cliLineHandler;

    @Override
    protected CookiesApi createApi() {
        return new CLIClient(cliLineHandler);
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
package pl.bratek20.cookies.cookies.script;

import pl.bratek20.cookies.cookies.api.Cookie;
import pl.bratek20.cookies.cookies.api.CookieFlavor;
import pl.bratek20.cookies.cookies.api.CookiesApi;
import pl.bratek20.cookies.cookies.api.CookiesApiTest;
import pl.bratek20.cookies.cookies.impl.infrastructure.configs.CookiesInMemoryConfig;
import pl.bratek20.cookies.identity.api.IdentityId;
import pl.bratek20.cookies.spring.ContextCreator;

class CookiesScriptTest extends CookiesApiTest {

    @Override
    protected CookiesApi createApi() {
        var api = ContextCreator.createAndGet(CookiesInMemoryConfig.class, CookiesApi.class);
        return new ScriptClient(api);
    }


    static class ScriptClient implements CookiesApi {
        private final CookiesScript script;

        public ScriptClient(CookiesApi api) {
            script = new CookiesScript(api);
        }

        @Override
        public void addCookie(Cookie cookie, IdentityId identityId) {
            String[] args = new String[] {
                "--method", "add",
                "--flavor", cookie.flavor().name(),
                "--identityId", String.valueOf(identityId.value()),
            };

            script.run(args);
        }

        @Override
        public void consumeCookie(CookieFlavor flavor, IdentityId identityId) {
           String[] args = new String[] {
                "--method", "consume",
                "--flavor", flavor.name(),
                "--identityId", String.valueOf(identityId.value()),
            };

            script.run(args);
        }

        @Override
        public int countCookies(CookieFlavor flavor, IdentityId identityId) {
            String[] args = new String[] {
                "--method", "count",
                "--flavor", flavor.name(),
                "--identityId", String.valueOf(identityId.value()),
            };

            var result = script.run(args);

            return Integer.parseInt(result.split("Cookies count: ")[1]);
        }
    }
}

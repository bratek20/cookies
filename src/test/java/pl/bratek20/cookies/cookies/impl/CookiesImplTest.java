package pl.bratek20.cookies.cookies.impl;

import pl.bratek20.cookies.cookies.api.CookiesApiTest;
import pl.bratek20.cookies.cookies.api.CookiesApi;
import pl.bratek20.cookies.cookies.impl.infrastructure.configs.InMemoryCookiesConfig;
import pl.bratek20.cookies.test.ContextCreator;

class CookiesImplTest extends CookiesApiTest {

    @Override
    protected CookiesApi createCookiesApi() {
        return ContextCreator.createAndGet(InMemoryCookiesConfig.class, CookiesApi.class);
    }
}

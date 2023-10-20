package pl.bratek20.cookies.cookies.impl;

import pl.bratek20.cookies.cookies.api.CookiesApiTest;
import pl.bratek20.cookies.cookies.api.CookiesApi;
import pl.bratek20.cookies.cookies.impl.infrastructure.configs.CookiesInMemoryConfig;
import pl.bratek20.cookies.spring.ContextCreator;

class CookiesImplTest extends CookiesApiTest {

    @Override
    protected CookiesApi createCookiesApi() {
        return ContextCreator.createAndGet(CookiesInMemoryConfig.class, CookiesApi.class);
    }
}

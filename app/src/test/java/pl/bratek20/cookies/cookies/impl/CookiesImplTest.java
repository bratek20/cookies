package pl.bratek20.cookies.cookies.impl;

import pl.bratek20.common.spring.ContextCreator;
import pl.bratek20.cookies.cookies.api.CookiesApi;
import pl.bratek20.cookies.cookies.api.CookiesApiTest;
import pl.bratek20.cookies.cookies.impl.infrastructure.configs.CookiesInMemoryConfig;

class CookiesImplTest extends CookiesApiTest {

    @Override
    protected CookiesApiTest.Context createContext() {
        var api = ContextCreator.createAndGet(CookiesInMemoryConfig.class, CookiesApi.class);
        return new CookiesApiTest.Context(api);
    }
}

package pl.bratek20.cookies.cookies.impl;

import pl.bratek20.common.events.EventsApiMock;
import pl.bratek20.common.events.TestEventsConfig;
import pl.bratek20.common.spring.ContextHelper;
import pl.bratek20.cookies.cookies.api.CookiesApi;
import pl.bratek20.cookies.cookies.api.CookiesApiTest;
import pl.bratek20.cookies.cookies.impl.infrastructure.configs.CookiesInMemoryConfig;

class CookiesImplTest extends CookiesApiTest {

    @Override
    protected CookiesApiTest.Context createContext() {
        var helper = new ContextHelper(
            CookiesInMemoryConfig.class,
            TestEventsConfig.class
        );
        var api = helper.get(CookiesApi.class);
        var eventsApiMock = helper.get(EventsApiMock.class);
        return new CookiesApiTest.Context(api, eventsApiMock);
    }
}

package pl.bratek20.cookies.cookies.impl;

import pl.bratek20.common.events.EventsApiMock;
import pl.bratek20.common.spring.ContextHelper;
import pl.bratek20.cookies.cookies.api.CookiesApi;
import pl.bratek20.cookies.cookies.api.CookiesApiTest;

public class CookiesImplTest extends CookiesApiTest {

    @Override
    protected CookiesApiTest.Context createContext() {
        return createImplContext();
    }

    public static CookiesApiTest.Context createImplContext() {
        var helper = new ContextHelper(CookiesTestConfig.class);
        var api = helper.get(CookiesApi.class);
        var eventsApiMock = helper.get(EventsApiMock.class);
        return new CookiesApiTest.Context(api, eventsApiMock);
    }
}

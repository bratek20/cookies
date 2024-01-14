package pl.bratek20.cookies.cookies.impl;

import pl.bratek20.commons.events.EventsApiMock;
import pl.bratek20.cookies.cookies.api.CookiesApi;
import pl.bratek20.cookies.cookies.api.CookiesApiTest;
import pl.bratek20.spring.context.SpringContextBuilder;

public class CookiesImplTest extends CookiesApiTest {

    @Override
    protected CookiesApiTest.Context createContext() {
        return createImplContext();
    }

    public static CookiesApiTest.Context createImplContext() {
        var context = new SpringContextBuilder(CookiesTestConfig.class).build();
        var api = context.get(CookiesApi.class);
        var eventsApiMock = context.get(EventsApiMock.class);
        return new CookiesApiTest.Context(api, eventsApiMock);
    }
}

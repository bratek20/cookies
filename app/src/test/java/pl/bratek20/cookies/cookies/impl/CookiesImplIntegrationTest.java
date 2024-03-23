package pl.bratek20.cookies.cookies.impl;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.extension.ExtendWith;
import pl.bratek20.architecture.events.EventsApiMock;
import pl.bratek20.architecture.events.TestEventsConfig;
import pl.bratek20.cookies.cookies.api.CookiesApi;
import pl.bratek20.cookies.cookies.api.CookiesApiTest;
import pl.bratek20.cookies.cookies.impl.infrastructure.configs.CookiesConfig;
import pl.bratek20.spring.context.SpringContextBuilder;
import pl.bratek20.spring.data.DefaultDataConfig;
import pl.bratek20.spring.data.MySQLExtension;
import pl.bratek20.spring.data.dbcleaner.DBCleanerConfig;

@Disabled //TODO proper flyway modularisation
@ExtendWith(MySQLExtension.class)
class CookiesImplIntegrationTest extends CookiesApiTest {

    @Override
    protected CookiesApiTest.Context createContext() {
        var context = new SpringContextBuilder(
            DefaultDataConfig.class,
            CookiesConfig.class,
            DBCleanerConfig.class,
            TestEventsConfig.class
        ).build();

        var cookiesApi = context.get(CookiesApi.class);
        var eventsApiMock = context.get(EventsApiMock.class);

        return new CookiesApiTest.Context(cookiesApi, eventsApiMock);
    }
}
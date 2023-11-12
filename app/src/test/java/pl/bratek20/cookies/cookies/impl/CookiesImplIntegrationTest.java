package pl.bratek20.cookies.cookies.impl;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import pl.bratek20.common.app.BaseAppConfig;
import pl.bratek20.common.events.EventsApiMock;
import pl.bratek20.common.events.TestEventsConfig;
import pl.bratek20.cookies.cookies.api.CookiesApi;
import pl.bratek20.cookies.cookies.api.CookiesApiTest;
import pl.bratek20.cookies.cookies.impl.infrastructure.configs.CookiesConfig;
import pl.bratek20.cookies.test.MySQLExtension;
import pl.bratek20.cookies.test.dbcleaner.DBCleanerConfig;

@SpringBootTest(classes = {
    BaseAppConfig.class,
    CookiesConfig.class,
    DBCleanerConfig.class,
    TestEventsConfig.class,
})
@ExtendWith(MySQLExtension.class)
class CookiesImplIntegrationTest extends CookiesApiTest {

    @Autowired
    private CookiesApi cookiesApi;

    @Autowired
    private EventsApiMock eventsApiMock;

    @Override
    protected void setup() {
        eventsApiMock.reset();
    }

    @Override
    protected CookiesApiTest.Context createContext() {
        return new CookiesApiTest.Context(cookiesApi, eventsApiMock);
    }
}
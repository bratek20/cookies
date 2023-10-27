package pl.bratek20.cookies.cookies.impl;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.bratek20.common.app.BaseAppConfig;
import pl.bratek20.cookies.cookies.api.CookiesApiTest;
import pl.bratek20.cookies.cookies.api.CookiesApi;
import pl.bratek20.cookies.cookies.impl.infrastructure.configs.CookiesConfig;
import pl.bratek20.cookies.test.MySQLExtension;
import pl.bratek20.cookies.test.dbcleaner.DBCleanerConfig;

@SpringBootTest(classes = {
    BaseAppConfig.class,
    CookiesConfig.class,
    DBCleanerConfig.class,
})
@ExtendWith(MySQLExtension.class)
class CookiesImplIntegrationTest extends CookiesApiTest {

    @Autowired
    private CookiesApi cookiesApi;

    @Override
    protected CookiesApi createApi() {
        return cookiesApi;
    }
}
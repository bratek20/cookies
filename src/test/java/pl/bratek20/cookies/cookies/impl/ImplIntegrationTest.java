package pl.bratek20.cookies.cookies.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.bratek20.cookies.CookiesApplication;
import pl.bratek20.cookies.cookies.api.ApiTest;
import pl.bratek20.cookies.cookies.api.CookiesApi;
import pl.bratek20.cookies.cookies.impl.infrastructure.configs.CookiesConfig;
import pl.bratek20.cookies.test.DBCleaner;
import pl.bratek20.cookies.test.DBCleanerConfig;
import pl.bratek20.cookies.test.MySQLExtension;

@SpringBootTest(classes = {
    CookiesApplication.BaseConfig.class,
    CookiesConfig.class,
    DBCleanerConfig.class,
})
@ExtendWith(MySQLExtension.class)
class ImplIntegrationTest extends ApiTest {

    @Autowired
    private CookiesApi cookiesApi;

    @Autowired
    private DBCleaner dbCleaner;

    @Override
    protected CookiesApi createCookiesApi() {
        return cookiesApi;
    }

    @BeforeEach
    void tearDown() {
        dbCleaner.deleteAll("cookies");
    }
}
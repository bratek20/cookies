package pl.bratek20.cookies.cookies.impl;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import pl.bratek20.cookies.CookiesApplication;
import pl.bratek20.cookies.cookies.api.ApiTest;
import pl.bratek20.cookies.cookies.api.CookiesApi;
import pl.bratek20.cookies.cookies.impl.infrastructure.configs.CookiesConfig;
import pl.bratek20.cookies.test.MySQLExtension;

@SpringBootTest(classes = {
    CookiesApplication.BaseConfig.class,
    CookiesConfig.class,
})
@ExtendWith(MySQLExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class ImplIntegrationTest extends ApiTest {

    @Autowired
    private CookiesApi cookiesApi;

    @Override
    protected CookiesApi createCookiesApi() {
        return cookiesApi;
    }
}
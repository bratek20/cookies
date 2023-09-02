package pl.bratek20.cookies.cookies.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import pl.bratek20.cookies.cookies.api.ApiTest;
import pl.bratek20.cookies.cookies.api.CookiesApi;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class ImplTest extends ApiTest {

    @Autowired
    private CookiesApi cookiesApi;

    @Override
    protected CookiesApi createCookiesApi() {
        return cookiesApi;
    }
}

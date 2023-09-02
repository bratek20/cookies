package pl.bratek20.cookies.cookies.impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import pl.bratek20.cookies.cookies.api.CookiesApi;
import pl.bratek20.cookies.identity.api.IdentityId;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class ModuleTest {
    private static final IdentityId ID_1 = new IdentityId("1");
    private static final IdentityId ID_2 = new IdentityId("2");

    @Autowired
    private CookiesApi cookiesApi;

    @Test
    void shouldAddCookiesForGivenIdentity() {
        cookiesApi.addCookie(null, ID_1);

        assertThat(cookiesApi.countCookies(ID_1)).isEqualTo(1);
        assertThat(cookiesApi.countCookies(ID_2)).isZero();
    }

    @Test
    void shouldConsumeCookies() {
        cookiesApi.addCookie(null, ID_1);

        cookiesApi.consumeCookie(ID_1);

        assertThat(cookiesApi.countCookies(ID_1)).isZero();
    }
}

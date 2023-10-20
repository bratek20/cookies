package pl.bratek20.cookies.cookies.api;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.bratek20.cookies.identity.api.IdentityId;
import pl.bratek20.cookies.module.test.BaseApiTest;

import static org.assertj.core.api.Assertions.assertThat;

public abstract class CookiesApiTest extends BaseApiTest<CookiesApi> {
    private static final IdentityId ID_1 = new IdentityId(1);
    private static final IdentityId ID_2 = new IdentityId(2);

    private static final CookieFlavor COOKIE_FLAVOR = CookieFlavor.CHOCOLATE;
    private static final Cookie COOKIE = new Cookie(COOKIE_FLAVOR);
    
    @Test
    void shouldAddCookiesForGivenIdentity() {
        api.addCookie(COOKIE, ID_1);

        assertThat(api.countCookies(COOKIE_FLAVOR, ID_1)).isEqualTo(1);
        assertThat(api.countCookies(COOKIE_FLAVOR, ID_2)).isZero();
    }

    @Test
    void shouldConsumeCookies() {
        api.addCookie(COOKIE, ID_1);

        api.consumeCookie(COOKIE_FLAVOR, ID_1);

        assertThat(api.countCookies(COOKIE_FLAVOR, ID_1)).isZero();
    }

    @Test
    void shouldCountCookiesByFlavor() {
        api.addCookie(new Cookie(CookieFlavor.COCONUT), ID_1);

        assertThat(api.countCookies(CookieFlavor.COCONUT, ID_1)).isEqualTo(1);
        assertThat(api.countCookies(CookieFlavor.CHOCOLATE, ID_1)).isZero();
    }

    @Test
    void shouldThrowWhenNoCookiesToConsume() {
        Assertions.assertThatThrownBy(() -> api.consumeCookie(COOKIE_FLAVOR, ID_1))
            .isInstanceOf(NoCookiesToConsumeException.class);
    }
}

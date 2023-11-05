package pl.bratek20.cookies.cookies.api;

import lombok.Value;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.bratek20.common.events.EventsApiMock;
import pl.bratek20.common.identity.api.IdentityId;
import pl.bratek20.common.module.BaseApiWithContextTest;

import static org.assertj.core.api.Assertions.assertThat;

public abstract class CookiesApiTest extends BaseApiWithContextTest<CookiesApiTest.Context> {

    public record Context(CookiesApi api, EventsApiMock eventsApiMock) { }

    private static final IdentityId ID_1 = new IdentityId(1);
    private static final IdentityId ID_2 = new IdentityId(2);

    private static final CookieFlavor COOKIE_FLAVOR = CookieFlavor.CHOCOLATE;
    private static final Cookie COOKIE = new Cookie(COOKIE_FLAVOR);

    private CookiesApi api;
    private EventsApiMock eventsApiMock;

    @Override
    protected void applyContext(Context context) {
        api = context.api;
        eventsApiMock = context.eventsApiMock;
    }

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
    void shouldPublishEventWhenCookieConsumed() {
        api.addCookie(COOKIE, ID_1);

        api.consumeCookie(COOKIE_FLAVOR, ID_1);

        eventsApiMock.assertOneEventPublished(new CookieConsumedEvent(COOKIE_FLAVOR));
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

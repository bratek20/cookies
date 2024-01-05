package pl.bratek20.cookies.cookies.web;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.annotation.DirtiesContext;
import pl.bratek20.common.app.web.BaseWebConfig;
import pl.bratek20.commons.events.EventsApiMock;
import pl.bratek20.common.identity.api.IdentityId;
import pl.bratek20.cookies.cookies.api.*;
import pl.bratek20.cookies.cookies.impl.CookiesTestConfig;

@SpringBootTest(
    classes = {
        BaseWebConfig.class,
        CookiesTestConfig.class,
        CookiesWebServerConfig.class,
    },
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class CookiesWebTest extends CookiesApiTest {

    @LocalServerPort
    private int port;

    @Autowired
    private EventsApiMock eventsApiMock;

    @Override
    protected CookiesApiTest.Context createContext() {
        var api = new WebClient();
        return new CookiesApiTest.Context(api, eventsApiMock);
    }

    @Override
    protected void setup() {
        RestAssured.port = port;
    }

    static class WebClient implements CookiesApi {

        @Override
        public void addCookie(Cookie cookie, IdentityId identityId) {
            String url = "/cookies/add/" + identityId.value();
            String body = """
                {
                    "flavor": "%s"
                }
                """.formatted(cookie.flavor().name());

            RestAssured.given()
                .contentType(ContentType.JSON)
                .body(body)
            .when()
                .post(url)
            .then()
                .statusCode(200);
        }

        @Override
        public void consumeCookie(CookieFlavor flavor, IdentityId identityId) {
            String url = "/cookies/consume/" + identityId.value() + "/" + flavor.name();

            var response = RestAssured.when()
                .post(url);

            if (response.statusCode() == 500) {
                throw new NoCookiesToConsumeException();
            }
        }

        @Override
        public int countCookies(CookieFlavor flavor, IdentityId identityId) {
            String url = "/cookies/count/" + identityId.value() + "/" + flavor.name();

            String count = RestAssured.when()
                .get(url)
            .then()
                .statusCode(200)
                .extract().body().asString();

            return Integer.parseInt(count);
        }
    }
}


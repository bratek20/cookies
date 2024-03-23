package pl.bratek20.cookies.cookies.web;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import pl.bratek20.architecture.events.EventsApiMock;
import pl.bratek20.commons.identity.api.IdentityId;
import pl.bratek20.cookies.cookies.api.*;
import pl.bratek20.cookies.cookies.impl.CookiesTestConfig;
import pl.bratek20.spring.web.TestWebAppRunner;

class CookiesWebTest extends CookiesApiTest {

    @Override
    protected CookiesApiTest.Context createContext() {
        var runner = new TestWebAppRunner(
            CookiesWebServerConfig.class,
            CookiesTestConfig.class
        );
        RestAssured.port = runner.getPort();

        var context = runner.run();

        var eventsApiMock = context.get(EventsApiMock.class);

        var api = new WebClient();
        return new CookiesApiTest.Context(api, eventsApiMock);
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


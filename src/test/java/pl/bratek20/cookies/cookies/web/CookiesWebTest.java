package pl.bratek20.cookies.cookies.web;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.annotation.DirtiesContext;
import pl.bratek20.cookies.app.web.BaseWebConfig;
import pl.bratek20.cookies.cookies.api.*;
import pl.bratek20.cookies.cookies.impl.infrastructure.configs.CookiesInMemoryConfig;
import pl.bratek20.cookies.identity.api.IdentityId;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

@SpringBootTest(
    classes = {
        BaseWebConfig.class,
        CookiesInMemoryConfig.class,
        CookiesWebServerConfig.class,
    },
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class CookiesWebTest extends CookiesApiTest {

    @LocalServerPort
    private int port;

    @Override
    protected CookiesApi createCookiesApi() {
        return new WebClient();
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

            given()
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

            var response = when()
                .post(url);

            if (response.statusCode() == 500) {
                throw new NoCookiesToConsumeException();
            }
        }

        @Override
        public int countCookies(CookieFlavor flavor, IdentityId identityId) {
            String url = "/cookies/count/" + identityId.value() + "/" + flavor.name();

            String count = when()
                .get(url)
            .then()
                .statusCode(200)
                .extract().body().asString();

            return Integer.parseInt(count);
        }
    }
}


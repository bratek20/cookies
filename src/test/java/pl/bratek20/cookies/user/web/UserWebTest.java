package pl.bratek20.cookies.user.web;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.annotation.DirtiesContext;
import pl.bratek20.cookies.app.web.BaseWebConfig;
import pl.bratek20.common.identity.api.IdentityId;
import pl.bratek20.cookies.user.api.User;
import pl.bratek20.cookies.user.api.UserApi;
import pl.bratek20.cookies.user.api.UserApiTest;
import pl.bratek20.cookies.user.api.exceptions.UserAlreadyExistsException;
import pl.bratek20.cookies.user.api.exceptions.UserNotExistsException;
import pl.bratek20.cookies.user.api.exceptions.WrongUserPasswordException;

import static io.restassured.RestAssured.given;

@SpringBootTest(
    classes = {
        BaseWebConfig.class,
        UserWebServerConfig.class,
    },
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class UserWebTest extends UserApiTest {

    @LocalServerPort
    private int port;

    @Override
    protected void setup() {
        RestAssured.port = port;
    }

    @Override
    protected UserApi createApi() {
        return new WebClient();
    }

    static class WebClient implements UserApi {

        @Override
        public IdentityId create(User user) throws UserAlreadyExistsException {
            String url = "/user/create";

            String body = """
                {
                    "name": "%s",
                    "password": "%s"
                }
                """.formatted(user.name(), user.password());

            var response = given()
                .contentType(ContentType.JSON)
                .body(body)
            .when()
                .post(url);

            if (response.statusCode() == 404) {
                throw new UserAlreadyExistsException(user.name());
            }

            var id = response.then()
                .statusCode(200)
                .extract().body().as(Long.class);
            return new IdentityId(id);
        }

        @Override
        public IdentityId getIdentityId(User user) throws UserNotExistsException, WrongUserPasswordException {
            String url = "/user/getIdentityId";

            String body = """
                {
                    "name": "%s",
                    "password": "%s"
                }
                """.formatted(user.name(), user.password());

            var response = given()
                .contentType(ContentType.JSON)
                .body(body)
            .when()
                .post(url);

            if (response.statusCode() == 404) {
                if (response.getBody().asString().equals("Wrong user password")) {
                    throw new WrongUserPasswordException();
                }
                throw new UserNotExistsException(user.name());
            }

            var id = response.then()
                .statusCode(200)
                .extract().body().as(Long.class);
            return new IdentityId(id);
        }
    }
}

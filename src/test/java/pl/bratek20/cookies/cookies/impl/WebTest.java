package pl.bratek20.cookies.cookies.impl;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import pl.bratek20.cookies.CookiesApplication;
import pl.bratek20.cookies.cookies.test.TestCookiesConfig;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.is;

@SpringBootTest(
    classes = {
        CookiesApplication.BaseConfig.class,
        TestCookiesConfig.class,
    },
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
class WebTest {

    @LocalServerPort
    private int port;

    @BeforeEach
    public void setUp() {
        RestAssured.port = port;
    }

    @Test
    void shouldSupportAllRequests() {
        assertCookiesCount(0);

        addCookieAndAssert(1);
        assertCookiesCount(1);

        consumeCookieAndAssert(0);
        assertCookiesCount(0);
    }

    private void assertCookiesCount(int count) {
        when()
            .get("/cookies/count/user123/CHOCOLATE")
        .then()
            .statusCode(200)
            .body(is(String.valueOf(count)));
    }

    private void addCookieAndAssert(int expectedValue) {
        given()
            .contentType(ContentType.JSON)
            .body("{" +"\"flavor\": \"CHOCOLATE\"" + "}")
        .when()
            .post("/cookies/add/user123")
        .then()
            .statusCode(200)
            .body(is(String.valueOf(expectedValue)));
    }

    private void consumeCookieAndAssert(int expectedValue) {
        when()
            .post("/cookies/consume/user123/CHOCOLATE")
        .then()
            .statusCode(200)
            .body(is(String.valueOf(expectedValue)));

    }
}


package pl.bratek20.cookies.cookies.impl;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.is;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
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

        addCookie();
        assertCookiesCount(1);

        consumeCookie();
        assertCookiesCount(0);
    }

    private void assertCookiesCount(int count) {
        when()
            .get("/cookies/count/user123/CHOCOLATE")
        .then()
            .statusCode(200)
            .body(is(String.valueOf(count)));
    }

    private void addCookie() {
        given()
            .contentType(ContentType.JSON)
            .body("{" +"\"flavor\": \"CHOCOLATE\"" + "}")
        .when()
            .post("/cookies/add/user123")
        .then()
            .statusCode(200);
    }

    private void consumeCookie() {
        when()
            .post("/cookies/consume/user123/CHOCOLATE")
            .then()
            .statusCode(200);
    }
}


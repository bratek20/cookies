package pl.bratek20.cookies;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import pl.bratek20.cookies.app.web.WebCookiesAppConfig;
import pl.bratek20.cookies.test.MySQLExtension;

@SpringBootTest(classes = WebCookiesAppConfig.class)
@ExtendWith(MySQLExtension.class)
class WebCookiesAppTest {

    @Test
    void contextLoads() {
    }
}

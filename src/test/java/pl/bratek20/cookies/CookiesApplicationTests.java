package pl.bratek20.cookies;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import pl.bratek20.cookies.cookies.impl.infrastructure.configs.InMemoryCookiesConfig;

@SpringBootTest(classes = InMemoryCookiesConfig.class)
class CookiesApplicationTests {

    @Test
    void contextLoads() {
    }

}

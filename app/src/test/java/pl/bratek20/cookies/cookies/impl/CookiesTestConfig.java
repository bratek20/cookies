package pl.bratek20.cookies.cookies.impl;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import pl.bratek20.architecture.events.TestEventsConfig;
import pl.bratek20.cookies.cookies.impl.infrastructure.configs.CookiesInMemoryConfig;

@Configuration
@Import({
    CookiesInMemoryConfig.class,
    TestEventsConfig.class,
})
public class CookiesTestConfig {

}

package pl.bratek20.cookies.cookies.impl.infrastructure.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import pl.bratek20.cookies.cookies.impl.infrastructure.repostiories.inmemory.InMemoryRepositoryConfig;

@Configuration
@Import({
        BaseCookiesConfig.class,
        InMemoryRepositoryConfig.class
})
public class TestCookiesConfig {

}

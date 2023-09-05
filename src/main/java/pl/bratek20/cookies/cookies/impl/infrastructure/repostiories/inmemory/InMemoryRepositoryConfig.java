package pl.bratek20.cookies.cookies.impl.infrastructure.repostiories.inmemory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import pl.bratek20.cookies.cookies.impl.application.CookiesRepository;

@Configuration
@Profile("test")
public class InMemoryRepositoryConfig {
    @Bean
    public CookiesRepository cookiesRepository() {
        return new InMemoryCookiesRepository();
    }
}

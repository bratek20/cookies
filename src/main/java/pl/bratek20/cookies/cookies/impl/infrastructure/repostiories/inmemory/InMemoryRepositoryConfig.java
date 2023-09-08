package pl.bratek20.cookies.cookies.impl.infrastructure.repostiories.inmemory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.bratek20.cookies.cookies.impl.application.CookiesRepository;

@Configuration
public class InMemoryRepositoryConfig {
    @Bean
    public CookiesRepository cookiesRepository() {
        return new InMemoryCookiesRepository();
    }
}

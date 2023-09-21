package pl.bratek20.cookies.cookies.impl.infrastructure.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.bratek20.cookies.cookies.api.CookiesApi;
import pl.bratek20.cookies.cookies.impl.application.CookiesRepository;
import pl.bratek20.cookies.cookies.impl.application.CookiesService;

@Configuration
public class BaseCookiesConfig {

    @Bean
    public CookiesApi cookiesService(CookiesRepository cookiesRepository) {
        return new CookiesService(cookiesRepository);
    }
}

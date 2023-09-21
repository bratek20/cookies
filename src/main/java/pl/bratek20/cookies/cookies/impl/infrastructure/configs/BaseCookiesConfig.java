package pl.bratek20.cookies.cookies.impl.infrastructure.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.bratek20.cookies.cookies.api.CookiesApi;
import pl.bratek20.cookies.cookies.impl.application.CookiesRepository;
import pl.bratek20.cookies.cookies.impl.application.CookiesService;
import pl.bratek20.cookies.cookies.impl.infrastructure.CookiesApiImpl;
import pl.bratek20.cookies.cookies.impl.infrastructure.CookiesController;

@Configuration
public class BaseCookiesConfig {
    @Bean
    public CookiesApi cookiesApi(CookiesService cookiesService) {
        return new CookiesApiImpl(cookiesService);
    }

    @Bean
    public CookiesService cookiesService(CookiesRepository cookiesRepository) {
        return new CookiesService(cookiesRepository);
    }

    @Bean
    public CookiesController cookiesController(CookiesService cookiesService) {
        return new CookiesController(cookiesService);
    }
}

package pl.bratek20.cookies.cookies.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.bratek20.cookies.cookies.api.CookiesApi;

@Configuration
public class WebServerCookiesConfig {
    @Bean
    public CookiesController cookiesController(CookiesApi cookiesApi) {
        return new CookiesController(cookiesApi);
    }
}

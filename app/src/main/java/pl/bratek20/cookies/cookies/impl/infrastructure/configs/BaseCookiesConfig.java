package pl.bratek20.cookies.cookies.impl.infrastructure.configs;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.bratek20.commons.events.api.EventsApi;
import pl.bratek20.cookies.cookies.api.CookiesApi;
import pl.bratek20.cookies.cookies.impl.application.CookiesRepository;
import pl.bratek20.cookies.cookies.impl.application.CookiesService;

@Configuration
@RequiredArgsConstructor
class BaseCookiesConfig {
    private final CookiesRepository cookiesRepository;
    private final EventsApi eventsApi;

    @Bean
    public CookiesApi cookiesService() {
        return new CookiesService(cookiesRepository, eventsApi);
    }
}

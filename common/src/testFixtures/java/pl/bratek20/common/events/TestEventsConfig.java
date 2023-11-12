package pl.bratek20.common.events;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.bratek20.common.events.api.EventsApi;

@Configuration
public class TestEventsConfig {
    @Bean
    public EventsApi eventsApi() {
        return new EventsApiMock();
    }
}

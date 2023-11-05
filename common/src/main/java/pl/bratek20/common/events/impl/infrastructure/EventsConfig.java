package pl.bratek20.common.events.impl.infrastructure;

import com.google.common.eventbus.EventBus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.bratek20.common.events.api.EventsApi;
import pl.bratek20.common.events.impl.application.EventsService;

@Configuration
public class EventsConfig {
    @Bean
    public EventBus eventBus() {
        return new EventBus();
    }

    @Bean
    public EventsApi eventsApi(EventBus eventBus) {
        return new EventsService(eventBus);
    }
}

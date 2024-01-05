package pl.bratek20.cookies.reporter.impl.infrastructure;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.bratek20.commons.events.api.EventsApi;
import pl.bratek20.cookies.reporter.api.Reporter;
import pl.bratek20.cookies.reporter.api.ReporterApi;
import pl.bratek20.cookies.reporter.impl.application.ReporterService;

@Configuration
@RequiredArgsConstructor
public class NoReporterConfig {
    private final Reporter reporter;
    private final EventsApi eventsApi;

    @Bean
    public ReporterApi reporterApi() {
        return new ReporterService(reporter, eventsApi);
    }
}

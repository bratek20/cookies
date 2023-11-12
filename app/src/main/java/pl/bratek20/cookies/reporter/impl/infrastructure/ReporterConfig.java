package pl.bratek20.cookies.reporter.impl.infrastructure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import pl.bratek20.cookies.reporter.api.Reporter;
import pl.bratek20.cookies.reporter.impl.application.LogReporter;

@Configuration
@Import(NoReporterConfig.class)
public class ReporterConfig {
    @Bean
    public Reporter reporter() {
        return new LogReporter();
    }
}

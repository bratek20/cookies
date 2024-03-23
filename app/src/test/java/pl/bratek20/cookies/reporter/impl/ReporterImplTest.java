package pl.bratek20.cookies.reporter.impl;

import pl.bratek20.architecture.events.api.EventsApi;
import pl.bratek20.architecture.events.impl.infrastructure.EventsConfig;
import pl.bratek20.cookies.reporter.api.Reporter;
import pl.bratek20.cookies.reporter.api.ReporterApi;
import pl.bratek20.cookies.reporter.api.ReporterApiTest;
import pl.bratek20.cookies.reporter.impl.infrastructure.NoReporterConfig;
import pl.bratek20.spring.context.SpringContextBuilder;

public class ReporterImplTest extends ReporterApiTest {

    @Override
    protected ReporterApiTest.Context createContext(Reporter reporter) {
        var context = new SpringContextBuilder(
                EventsConfig.class,
                NoReporterConfig.class
            )
            .registerSingleton("testReporter", reporter)
            .build();

        var api = context.get(ReporterApi.class);
        var eventsApi = context.get(EventsApi.class);
        return new Context(api, eventsApi);
    }
}

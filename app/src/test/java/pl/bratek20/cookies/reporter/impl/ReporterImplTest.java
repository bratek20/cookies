package pl.bratek20.cookies.reporter.impl;

import pl.bratek20.common.events.api.EventsApi;
import pl.bratek20.common.events.impl.infrastructure.EventsConfig;
import pl.bratek20.common.spring.ContextHelper;
import pl.bratek20.cookies.reporter.api.Reporter;
import pl.bratek20.cookies.reporter.api.ReporterApi;
import pl.bratek20.cookies.reporter.api.ReporterApiTest;
import pl.bratek20.cookies.reporter.impl.infrastructure.NoReporterConfig;

public class ReporterImplTest extends ReporterApiTest {

    @Override
    protected ReporterApiTest.Context createContext(Reporter reporter) {
        var helper = new ContextHelper(
                EventsConfig.class,
                NoReporterConfig.class
            )
            .registerSingleton("testReporter", reporter);

        var api = helper.get(ReporterApi.class);
        var eventsApi = helper.get(EventsApi.class);
        return new Context(api, eventsApi);
    }
}

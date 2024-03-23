package pl.bratek20.cookies.reporter.impl.application;

import lombok.RequiredArgsConstructor;
import pl.bratek20.architecture.events.api.EventsApi;
import pl.bratek20.cookies.cookies.api.CookieConsumedEvent;
import pl.bratek20.cookies.reporter.api.Reporter;
import pl.bratek20.cookies.reporter.api.ReporterApi;

@RequiredArgsConstructor
public class ReporterService implements ReporterApi {
    private final Reporter reporter;
    private final EventsApi eventsApi;

    @Override
    public void start() {
        eventsApi.subscribe(CookieConsumedEvent.class, event -> reporter.report("Cookie consumed: " + event.getFlavor()));
    }
}

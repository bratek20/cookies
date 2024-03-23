package pl.bratek20.cookies.reporter.api;

import org.junit.jupiter.api.Test;
import pl.bratek20.architecture.events.api.EventsApi;
import pl.bratek20.cookies.cookies.api.CookieConsumedEvent;
import pl.bratek20.cookies.cookies.api.CookieFlavor;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public abstract class ReporterApiTest {
    public record Context(ReporterApi api, EventsApi eventsApi) {}

    private ReporterApi api;
    private EventsApi eventsApi;
    private TestReporter reporter;

    abstract protected Context createContext(Reporter reporter);

    static class TestReporter implements Reporter {
        List<String> messages = new ArrayList<>();

        @Override
        public void report(String message) {
            messages.add(message);
        }

        public void assertOneMessage(String message) {
            assertThat(messages).containsExactly(message);
        }
    }

    private void applyContext() {
        reporter = new TestReporter();
        var context = createContext(reporter);
        this.api = context.api();
        this.eventsApi = context.eventsApi();
    }

    @Test
    void shouldWork() {
        applyContext();
        api.start();

        eventsApi.publish(new CookieConsumedEvent(CookieFlavor.CHOCOLATE));

        reporter.assertOneMessage("Cookie consumed: CHOCOLATE");
    }
}
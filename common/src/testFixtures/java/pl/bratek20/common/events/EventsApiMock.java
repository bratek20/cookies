package pl.bratek20.common.events;

import pl.bratek20.common.events.api.Event;
import pl.bratek20.common.events.api.EventListener;
import pl.bratek20.common.events.api.EventsApi;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class EventsApiMock implements EventsApi {
    private final List<Event> publishedEvents = new ArrayList<>();

    @Override
    public void publish(Event event) {
        publishedEvents.add(event);
    }

    public void assertOneEventPublished(Event event) {
        assertThat(publishedEvents).containsExactly(event);
    }

    @Override
    public <T extends Event> void subscribe(Class<T> eventType, EventListener<T> listener) {

    }
}

package pl.bratek20.common.events.impl.application;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import lombok.RequiredArgsConstructor;
import pl.bratek20.common.events.api.Event;
import pl.bratek20.common.events.api.EventListener;
import pl.bratek20.common.events.api.EventsApi;

@RequiredArgsConstructor
public class EventsService implements EventsApi {
    private final EventBus eventBus;

    @Override
    public void publish(Event event) {
        eventBus.post(event);
    }

    @Override
    public <T extends Event> void subscribe(Class<T> eventType, EventListener<T> listener) {
        class EventListenerWrapper {
            @Subscribe
            public void handleEvent(T event) {
                listener.handleEvent(event);
            }
        }
        eventBus.register(new EventListenerWrapper());
    }
}

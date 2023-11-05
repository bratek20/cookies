package pl.bratek20.common.events.api;

public interface EventsApi {
    void publish(Event event);

    <T extends Event> void subscribe(Class<T> eventType, EventListener<T> listener);
}

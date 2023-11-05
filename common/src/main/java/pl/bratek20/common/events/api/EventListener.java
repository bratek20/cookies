package pl.bratek20.common.events.api;

public interface EventListener<T extends Event> {
    void handleEvent(T event);
}

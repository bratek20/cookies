package pl.bratek20.common.events.impl;

import pl.bratek20.common.events.api.EventsApi;
import pl.bratek20.common.events.api.EventsApiTest;
import pl.bratek20.common.events.impl.infrastructure.EventsConfig;
import pl.bratek20.common.spring.ContextCreator;

public class EventsImplTest extends EventsApiTest {

    @Override
    protected EventsApi createApi() {
        return ContextCreator.createAndGet(EventsConfig.class, EventsApi.class);
    }
}

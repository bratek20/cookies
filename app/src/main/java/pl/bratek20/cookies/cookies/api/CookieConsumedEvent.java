package pl.bratek20.cookies.cookies.api;

import lombok.Value;
import pl.bratek20.commons.events.api.Event;

@Value
public class CookieConsumedEvent implements Event {
    CookieFlavor flavor;

}

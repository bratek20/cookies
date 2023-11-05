package pl.bratek20.cookies.app.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import pl.bratek20.common.app.web.BaseWebConfig;
import pl.bratek20.common.events.impl.infrastructure.EventsConfig;
import pl.bratek20.common.user.web.UserWebServerConfig;
import pl.bratek20.cookies.cookies.impl.infrastructure.configs.CookiesConfig;
import pl.bratek20.cookies.cookies.web.CookiesWebServerConfig;

@Configuration
@Import({
    BaseWebConfig.class,
    CookiesConfig.class,
    CookiesWebServerConfig.class,
    UserWebServerConfig.class,
    EventsConfig.class,
})
public class WebCookiesAppConfig {

}

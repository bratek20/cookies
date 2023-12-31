package pl.bratek20.cookies.app.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import pl.bratek20.common.app.web.BaseWebConfig;
import pl.bratek20.commons.events.impl.infrastructure.EventsConfig;
import pl.bratek20.commons.modules.impl.ModulesConfig;
import pl.bratek20.commons.user.web.UserWebServerConfig;
import pl.bratek20.cookies.cookies.impl.infrastructure.configs.CookiesInMemoryConfig;
import pl.bratek20.cookies.cookies.web.CookiesWebServerConfig;
import pl.bratek20.cookies.reporter.impl.infrastructure.ReporterConfig;

@Configuration
@Import({
    BaseWebConfig.class,
    CookiesInMemoryConfig.class,
    CookiesWebServerConfig.class,
    UserWebServerConfig.class,
    EventsConfig.class,
    ReporterConfig.class,
    ModulesConfig.class
})
public class WebCookiesAppConfig {

}

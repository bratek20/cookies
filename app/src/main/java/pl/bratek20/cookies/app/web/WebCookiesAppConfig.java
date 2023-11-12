package pl.bratek20.cookies.app.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import pl.bratek20.common.app.web.BaseWebConfig;
import pl.bratek20.common.events.impl.infrastructure.EventsConfig;
import pl.bratek20.common.modules.impl.ModulesConfig;
import pl.bratek20.common.user.web.UserWebServerConfig;
import pl.bratek20.cookies.cookies.impl.infrastructure.configs.CookiesConfig;
import pl.bratek20.cookies.cookies.web.CookiesWebServerConfig;
import pl.bratek20.cookies.reporter.impl.infrastructure.ReporterConfig;

@Configuration
@Import({
    BaseWebConfig.class,
    CookiesConfig.class,
    CookiesWebServerConfig.class,
    UserWebServerConfig.class,
    EventsConfig.class,
    ReporterConfig.class,
    ModulesConfig.class
})
public class WebCookiesAppConfig {

}

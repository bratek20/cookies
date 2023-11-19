package pl.bratek20.cookies.app.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import pl.bratek20.common.app.web.BaseWebConfig;
import pl.bratek20.common.events.impl.infrastructure.EventsConfig;
import pl.bratek20.common.modules.impl.ModulesConfig;
import pl.bratek20.common.user.web.UserWebServerConfig;
import pl.bratek20.cookies.cookies.impl.infrastructure.configs.CookiesConfig;
import pl.bratek20.cookies.cookies.impl.infrastructure.configs.CookiesInMemoryConfig;
import pl.bratek20.cookies.cookies.web.CookiesWebServerConfig;
import pl.bratek20.cookies.reporter.impl.infrastructure.ReporterConfig;
import pl.bratek20.cookies.view.ViewController;

@Configuration
@Import({
    BaseWebConfig.class,
    CookiesInMemoryConfig.class,
    CookiesWebServerConfig.class,
    UserWebServerConfig.class,
    EventsConfig.class,
    ReporterConfig.class,
    ModulesConfig.class,
    ViewController.class
})
public class WebCookiesAppConfig {

}

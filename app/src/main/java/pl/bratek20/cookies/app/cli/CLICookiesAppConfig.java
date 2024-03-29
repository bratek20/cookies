package pl.bratek20.cookies.app.cli;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import pl.bratek20.architecture.events.impl.infrastructure.EventsConfig;
import pl.bratek20.common.cli.CLIApp;
import pl.bratek20.cookies.cookies.cli.CookiesCLIServerConfig;
import pl.bratek20.cookies.cookies.impl.infrastructure.configs.CookiesInMemoryConfig;

@Configuration
@Import({
    CookiesInMemoryConfig.class,
    CookiesCLIServerConfig.class,
    CLIApp.class,
    EventsConfig.class,
})
public class CLICookiesAppConfig {

}

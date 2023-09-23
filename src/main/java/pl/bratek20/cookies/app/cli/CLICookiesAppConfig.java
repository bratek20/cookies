package pl.bratek20.cookies.app.cli;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import pl.bratek20.cookies.cookies.cli.CLIServerCookiesConfig;
import pl.bratek20.cookies.cookies.impl.infrastructure.configs.InMemoryCookiesConfig;

@Configuration
@Import({
    BaseCLIConfig.class,
    InMemoryCookiesConfig.class,
    CLIServerCookiesConfig.class,
    CLIApp.class,
})
public class CLICookiesAppConfig {

}

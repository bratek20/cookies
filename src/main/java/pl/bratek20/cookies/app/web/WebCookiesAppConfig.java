package pl.bratek20.cookies.app.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import pl.bratek20.cookies.cookies.impl.infrastructure.configs.InMemoryCookiesConfig;
import pl.bratek20.cookies.cookies.web.WebServerCookiesConfig;

@Configuration
@Import({
    BaseWebConfig.class,
    InMemoryCookiesConfig.class,
    WebServerCookiesConfig.class,
})
public class WebCookiesAppConfig {

}

package pl.bratek20.cookies.app.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import pl.bratek20.common.app.web.BaseWebConfig;
import pl.bratek20.cookies.cookies.impl.infrastructure.configs.CookiesInMemoryConfig;
import pl.bratek20.cookies.cookies.web.CookiesWebServerConfig;
import pl.bratek20.common.user.web.UserWebServerConfig;

@Configuration
@Import({
    BaseWebConfig.class,
    CookiesInMemoryConfig.class,
    CookiesWebServerConfig.class,
    UserWebServerConfig.class,
})
public class WebCookiesAppConfig {

}

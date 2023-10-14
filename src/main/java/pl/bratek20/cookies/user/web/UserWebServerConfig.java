package pl.bratek20.cookies.user.web;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import pl.bratek20.cookies.user.impl.infra.UserConfig;

@Configuration
@Import({
    UserConfig.class,
})
@ComponentScan
public class UserWebServerConfig {
}

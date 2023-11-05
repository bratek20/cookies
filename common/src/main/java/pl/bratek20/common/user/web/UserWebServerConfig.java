package pl.bratek20.common.user.web;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import pl.bratek20.common.user.impl.infra.UserConfig;
import pl.bratek20.common.user.impl.infra.UserConfig;

@Configuration
@Import({
    UserConfig.class,
})
@ComponentScan
public class UserWebServerConfig {
}

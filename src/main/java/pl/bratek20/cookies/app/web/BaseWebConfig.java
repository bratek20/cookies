package pl.bratek20.cookies.app.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import pl.bratek20.cookies.app.BaseAppConfig;

@Configuration
@Import({
    BaseAppConfig.class,
})
public class BaseWebConfig {

}

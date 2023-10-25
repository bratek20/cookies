package pl.bratek20.common.app.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import pl.bratek20.common.app.BaseAppConfig;

@Configuration
@Import({
    BaseAppConfig.class,
})
public class BaseWebConfig {

}

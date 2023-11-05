package pl.bratek20.common.app.cli;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import pl.bratek20.common.app.BaseAppConfig;

@Configuration
@Import({
    BaseAppConfig.class,
})
public class BaseCLIConfig {

}

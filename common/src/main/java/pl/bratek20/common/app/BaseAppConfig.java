package pl.bratek20.common.app;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootConfiguration
@EnableAutoConfiguration(
    exclude = {
        DataSourceAutoConfiguration.class,
    }
)
public class BaseAppConfig {

}

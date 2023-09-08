package pl.bratek20.cookies;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import pl.bratek20.cookies.cookies.impl.infrastructure.CookiesConfig;


@SpringBootApplication(
        exclude = {
                DataSourceAutoConfiguration.class,
        }
)
@ComponentScan(useDefaultFilters = false)
@Import(CookiesConfig.class)
public class CookiesApplication {

    public static void main(String[] args) {
        SpringApplication.run(CookiesApplication.class, args);
    }

}

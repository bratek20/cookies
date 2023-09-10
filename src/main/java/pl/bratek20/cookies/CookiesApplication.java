package pl.bratek20.cookies;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Import;
import pl.bratek20.cookies.cookies.impl.infrastructure.configs.CookiesConfig;

public class CookiesApplication {

    @SpringBootConfiguration
    @EnableAutoConfiguration(
        exclude = {
            //DataSourceAutoConfiguration.class,
        }
    )
    public static class BaseConfig { }

    @Import({
        BaseConfig.class,
        CookiesConfig.class
    })
    static class MainConfig { }

    public static void main(String[] args) {
        SpringApplication.run(MainConfig.class, args);
    }

}

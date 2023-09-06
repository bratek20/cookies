package pl.bratek20.cookies;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@SpringBootApplication(
        exclude = {
                DataSourceAutoConfiguration.class,
        }
)
public class CookiesApplication {

    public static void main(String[] args) {
        SpringApplication.run(CookiesApplication.class, args);
    }

}

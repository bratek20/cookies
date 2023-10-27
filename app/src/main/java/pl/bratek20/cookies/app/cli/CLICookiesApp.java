package pl.bratek20.cookies.app.cli;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;

public class CLICookiesApp {

    public static void main(String[] args) {
        new SpringApplicationBuilder(CLICookiesAppConfig.class)
            .web(WebApplicationType.NONE)
            .run(args);
    }
}

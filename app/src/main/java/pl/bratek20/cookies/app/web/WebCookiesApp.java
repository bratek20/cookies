package pl.bratek20.cookies.app.web;

import org.springframework.boot.SpringApplication;
import pl.bratek20.cookies.reporter.api.ReporterApi;

public class WebCookiesApp {

    public static void main(String[] args) {
        var c = SpringApplication.run(WebCookiesAppConfig.class, args);
    }
}

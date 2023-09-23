package pl.bratek20.cookies.cookies.cli;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.bratek20.cookies.cookies.api.CookiesApi;

@RequiredArgsConstructor
@Configuration
public class CLIServerCookiesConfig {
    private final CookiesApi cookiesApi;

    @Bean
    public CLICookiesLineHandler cliCookiesRunner() {
        return new CLICookiesLineHandler(cookiesApi);
    }
}

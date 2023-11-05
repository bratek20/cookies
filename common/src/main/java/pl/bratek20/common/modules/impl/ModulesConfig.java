package pl.bratek20.common.modules.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.bratek20.common.modules.api.Startable;

import java.util.Collection;

@Configuration
public class ModulesConfig {
    @Bean
    public StartCaller startCaller(Collection<Startable> startables) {
        return new StartCaller(startables);
    }
}

package pl.bratek20.cookies.cookies.impl.infrastructure.repostiories.crud;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.bratek20.cookies.cookies.impl.application.CookiesRepository;

@Configuration
public class CrudRepositoryConfig {
    @Bean
    public CookiesRepository cookiesRepository(CrudCookiesEntityRepository crudCookiesEntityRepository) {
        return new CrudCookiesRepository(crudCookiesEntityRepository);
    }
}

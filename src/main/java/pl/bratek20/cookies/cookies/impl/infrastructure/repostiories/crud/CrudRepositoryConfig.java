package pl.bratek20.cookies.cookies.impl.infrastructure.repostiories.crud;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import pl.bratek20.cookies.cookies.impl.application.CookiesRepository;

@Configuration
@Import({
    DataSourceAutoConfiguration.class,
})
@EnableJpaRepositories
@EntityScan
public class CrudRepositoryConfig {

    @Bean
    public CookiesRepository cookiesRepository(CrudCookiesEntityRepository crudCookiesEntityRepository) {
        return new CrudCookiesRepository(crudCookiesEntityRepository);
    }
}

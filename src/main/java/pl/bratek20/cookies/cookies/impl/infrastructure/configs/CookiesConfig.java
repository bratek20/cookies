package pl.bratek20.cookies.cookies.impl.infrastructure.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import pl.bratek20.cookies.cookies.impl.infrastructure.repostiories.crud.CrudRepositoryConfig;

@Configuration
@Import({
        BaseCookiesConfig.class,
        CrudRepositoryConfig.class
})
public class CookiesConfig {

}

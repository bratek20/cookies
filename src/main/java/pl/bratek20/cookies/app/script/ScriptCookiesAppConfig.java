package pl.bratek20.cookies.app.script;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import pl.bratek20.cookies.app.BaseAppConfig;
import pl.bratek20.cookies.cookies.impl.infrastructure.configs.CookiesInMemoryConfig;

@Configuration
@Import({
    BaseAppConfig.class,
    CookiesInMemoryConfig.class,
})
public class ScriptCookiesAppConfig {

}

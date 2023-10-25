package pl.bratek20.cookies.user.impl.infra;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import pl.bratek20.common.identity.api.IdentityApi;
import pl.bratek20.common.identity.impl.IdentityConfig;
import pl.bratek20.cookies.user.api.UserApi;
import pl.bratek20.cookies.user.impl.appli.UserRepository;
import pl.bratek20.cookies.user.impl.appli.UserService;

@Configuration
@Import({
    IdentityConfig.class
})
public class UserConfig {
    @Bean
    public UserRepository userRepository() {
        return new InMemUserRepository();
    }

    @Bean
    public UserApi userApi(UserRepository userRepository, IdentityApi identityApi) {
        return new UserService(userRepository, identityApi);
    }
}

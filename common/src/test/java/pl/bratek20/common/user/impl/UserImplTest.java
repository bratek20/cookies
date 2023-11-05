package pl.bratek20.common.user.impl;

import pl.bratek20.common.spring.ContextCreator;
import pl.bratek20.common.user.api.UserApi;
import pl.bratek20.common.user.api.UserApiTest;
import pl.bratek20.common.user.impl.infra.UserConfig;

public class UserImplTest extends UserApiTest {

    @Override
    protected UserApi createApi() {
        return ContextCreator.createAndGet(UserConfig.class, UserApi.class);
    }
}

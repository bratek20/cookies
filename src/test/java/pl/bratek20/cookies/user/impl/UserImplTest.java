package pl.bratek20.cookies.user.impl;

import pl.bratek20.cookies.test.ContextCreator;
import pl.bratek20.cookies.user.api.UserApiTest;
import pl.bratek20.cookies.user.api.UserApi;
import pl.bratek20.cookies.user.impl.infra.UserConfig;

public class UserImplTest extends UserApiTest {

    @Override
    protected UserApi createApi() {
        return ContextCreator.createAndGet(UserConfig.class, UserApi.class);
    }
}

package pl.bratek20.cookies.identity.impl;

import pl.bratek20.cookies.identity.api.ApiTest;
import pl.bratek20.cookies.identity.api.IdentityApi;
import pl.bratek20.cookies.test.ContextCreator;

public class ImplTest extends ApiTest {

    @Override
    protected IdentityApi createApi() {
        return ContextCreator.createAndGet(IdentityConfig.class, IdentityApi.class);
    }
}

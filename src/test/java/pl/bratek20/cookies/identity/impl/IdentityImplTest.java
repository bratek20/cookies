package pl.bratek20.cookies.identity.impl;

import pl.bratek20.cookies.identity.api.IdentityApiTest;
import pl.bratek20.cookies.identity.api.IdentityApi;
import pl.bratek20.cookies.spring.ContextCreator;

public class IdentityImplTest extends IdentityApiTest {

    @Override
    protected IdentityApi createApi() {
        return ContextCreator.createAndGet(IdentityConfig.class, IdentityApi.class);
    }
}

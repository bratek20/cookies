package pl.bratek20.common.identity.impl;

import pl.bratek20.common.identity.api.IdentityApi;
import pl.bratek20.common.identity.api.IdentityApiTest;
import pl.bratek20.common.spring.ContextCreator;

public class IdentityImplTest extends IdentityApiTest {

    @Override
    protected IdentityApi createApi() {
        return ContextCreator.createAndGet(IdentityConfig.class, IdentityApi.class);
    }
}

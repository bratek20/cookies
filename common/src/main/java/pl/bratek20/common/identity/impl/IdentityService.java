package pl.bratek20.common.identity.impl;

import pl.bratek20.common.identity.api.IdentityApi;
import pl.bratek20.common.identity.api.IdentityId;

public class IdentityService implements IdentityApi {
    private int nextId = 1;

    @Override
    public IdentityId generate() {
        return new IdentityId(nextId++);
    }
}

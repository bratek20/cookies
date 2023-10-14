package pl.bratek20.cookies.identity.impl;

import pl.bratek20.cookies.identity.api.IdentityApi;
import pl.bratek20.cookies.identity.api.IdentityId;

public class IdentityService implements IdentityApi {
    private int nextId = 1;

    @Override
    public IdentityId generate() {
        return new IdentityId(nextId++);
    }
}

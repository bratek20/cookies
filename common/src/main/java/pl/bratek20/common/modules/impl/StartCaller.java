package pl.bratek20.common.modules.impl;

import pl.bratek20.common.modules.api.Startable;

import java.util.Collection;

public class StartCaller {
    public StartCaller(Collection<Startable> startables) {
        startables.forEach(Startable::start);
    }
}

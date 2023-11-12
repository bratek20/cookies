package pl.bratek20.common.modules.impl;

import pl.bratek20.common.modules.api.ModulesApiTest;
import pl.bratek20.common.spring.ContextHelper;

import java.util.List;

public class ModulesImplTest extends ModulesApiTest {

    @Override
    protected StartContext start(List<Class<? extends BaseModule>> moduleClasses) {
        var helper = new ContextHelper(ModulesConfig.class);
        moduleClasses.forEach(helper::registerSingletonClass);
        helper.build();

        var modules = moduleClasses.stream()
            .map(helper::get)
            .toList();

        return new StartContext(modules);
    }
}

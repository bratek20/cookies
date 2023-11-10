package pl.bratek20.common.modules.impl;

import lombok.SneakyThrows;
import pl.bratek20.common.modules.api.ModulesApiTest;
import pl.bratek20.common.modules.api.Startable;
import pl.bratek20.common.spring.ContextHelper;

public class ModulesImplTest extends ModulesApiTest {

    @Override
    @SneakyThrows
    protected <T extends Startable> ModulesApiTest.StartContext start(
        Class<ModulesApiTest.Module1> module1Class,
        Class<ModulesApiTest.Module2> module2Class
    ) {
        var helper = new ContextHelper(ModulesConfig.class)
            .registerSingleton("module1", module1Class.getConstructor().newInstance())
            .registerSingleton("module2", module2Class.getConstructor().newInstance())
            .build();

        var module1 = helper.get(module1Class);
        var module2 = helper.get(module2Class);
        return new StartContext(module1, module2);
    }
}

package pl.bratek20.common.modules.api;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public abstract class ModulesApiTest {
    static class BaseModule implements Startable {
        int startCalled = 0;

        @Override
        public void start() {
            startCalled++;
        }

        public void assertStartCalledOnce() {
            assertThat(startCalled).isEqualTo(1);
        }
    }

    public static class Module1 extends BaseModule {
    }

    public static class Module2 extends BaseModule {
    }

    public record StartContext(Module1 module1, Module2 module2) {
    }
    protected abstract <T extends Startable> StartContext start(Class<Module1> module1Class, Class<Module2> module2Class);

    @Test
    void shouldStartModules() {
        var context = start(Module1.class, Module2.class);

        context.module1.assertStartCalledOnce();
        context.module2.assertStartCalledOnce();
    }
}

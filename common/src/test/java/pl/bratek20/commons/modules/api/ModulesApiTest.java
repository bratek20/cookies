package pl.bratek20.commons.modules.api;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public abstract class ModulesApiTest {
    protected static class BaseModule implements Startable {
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

    public record StartContext(List<? extends BaseModule> modules) {
    }
    protected abstract StartContext start(List<Class<? extends BaseModule>> moduleClasses);

    @Test
    void shouldStartModules() {
        var context = start(List.of(
            Module1.class,
            Module2.class
        ));

        assertThat(context.modules).hasSize(2);
        context.modules.forEach(BaseModule::assertStartCalledOnce);
    }
}

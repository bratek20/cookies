package pl.bratek20.common.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class ContextHelper {
    private final List<Class<?>> configurations;
    private AnnotationConfigApplicationContext context;

    public ContextHelper(Class<?>... configurations) {
        this.configurations = List.of(configurations);
    }

    public <T> T get(Class<T> bean) {
        ensureBuilt();
        return context.getBean(bean);
    }

    private void ensureBuilt() {
        if (context == null) {
            context = new AnnotationConfigApplicationContext(configurations.toArray(Class[]::new));
        }
    }
}

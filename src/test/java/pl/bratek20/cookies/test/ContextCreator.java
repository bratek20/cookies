package pl.bratek20.cookies.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ContextCreator {
    public static <T> T createAndGet(Class<?> configuration, Class<T> bean) {
        var context = new AnnotationConfigApplicationContext(configuration);
        return context.getBean(bean);
    }
}

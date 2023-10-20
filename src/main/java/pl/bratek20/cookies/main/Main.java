package pl.bratek20.cookies.main;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.stream.Stream;

@Slf4j
public class Main {

    public static void main(String[] args) {
        if (args.length < 1) {
            log.error("Specify the class path as the first argument");
            return;
        }

        String classPath = args[0];
        var remainingArgs = Stream.of(args).skip(1).toArray(String[]::new);

        Class<?> clazz = null;
        try {
            clazz = Class.forName(classPath);
        } catch (ClassNotFoundException e) {
            log.error("Class not found for path: {}", classPath);
            return;
        }

        Method mainMethod = null;
        try {
            mainMethod = clazz.getMethod("main", String[].class);
        } catch (NoSuchMethodException e) {
            log.error("Main method not found for class: {}", clazz.getName());
            return;
        }

        try {
            mainMethod.invoke(null, (Object) remainingArgs);
        } catch (IllegalAccessException | InvocationTargetException e) {
            log.error("Error while invoking main method for class: {}", clazz);
        }
    }
}

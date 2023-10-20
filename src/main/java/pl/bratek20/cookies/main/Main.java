package pl.bratek20.cookies.main;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Method;

@Slf4j
public class Main {

    @SneakyThrows
    public static void main(String[] args) {
        if (args.length < 1) {
            log.info("Usage: <classPath> [args...]");
            return;
        }

        // Get the class path and remaining arguments
        String classPath = args[0];
        String[] remainingArgs = new String[args.length - 1];
        System.arraycopy(args, 1, remainingArgs, 0, args.length - 1);

        // Load the class using the provided class path
        Class<?> clazz = Class.forName(classPath);

        // Find the main method with the expected signature (String[] args)
        Method mainMethod = clazz.getMethod("main", String[].class);

        // Invoke the main method, passing the remaining arguments
        mainMethod.invoke(null, (Object) remainingArgs);
    }
}

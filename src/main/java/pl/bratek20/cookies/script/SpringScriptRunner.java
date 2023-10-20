package pl.bratek20.cookies.script;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import pl.bratek20.cookies.spring.ContextCreator;

@RequiredArgsConstructor
public class SpringScriptRunner<TApi, TArgs> {
    private final Script<TApi, TArgs> script;

    @SneakyThrows
    public <T extends Script<TApi, TArgs>>SpringScriptRunner(Class<?> configClass, Class<TApi> apiClass, Class<T> scriptClass) {
        var api = ContextCreator.createAndGet(configClass, apiClass);
        this.script = scriptClass.getConstructor(apiClass).newInstance(api);
    }

    public void run(String[] args) {
        script.run(args);
    }
}
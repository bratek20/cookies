package pl.bratek20.cookies.script;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.cli.*;
import pl.bratek20.cookies.spring.ContextCreator;

@Slf4j
public abstract class Script<TConfig, TApi, TArgs> {
    protected abstract void addOptions(Options options);

    protected abstract TArgs createArgs(CommandLine cmd) throws CreateArgsException;

    protected abstract void run(TApi api, TArgs args);

    protected abstract Class<TApi> getApiClass();
    protected abstract Class<TConfig> getConfigClass();

    public void run (String[] rawArgs) {
        Options options = new Options();
        addOptions(options);

        CommandLineParser parser = new DefaultParser();
        CommandLine cmd;

        try {
            cmd = parser.parse(options, rawArgs);
            var args = createArgs(cmd);
            var api = createApi();
            run(api, args);
        } catch (ParseException e) {
            log.error("Parsing arguments failed: " + e.getMessage());
            new HelpFormatter().printHelp("Script", options);
            System.exit(1);
        } catch (CreateArgsException e) {
            log.error("Creating arguments failed: " + e.getMessage());
            System.exit(1);
        }
    }

    private TApi createApi() {
        return ContextCreator.createAndGet(getConfigClass(), getApiClass());
    }
}

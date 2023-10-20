package pl.bratek20.cookies.cookies.script;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Options;
import pl.bratek20.cookies.cookies.api.CookiesApi;
import pl.bratek20.cookies.cookies.impl.infrastructure.configs.CookiesConfig;
import pl.bratek20.cookies.script.CreateArgsException;
import pl.bratek20.cookies.script.Script;
import pl.bratek20.cookies.script.SpringScriptRunner;

public class CookiesScript extends Script<CookiesApi, CookiesScript.Args> {

    public CookiesScript(CookiesApi cookiesApi) {
        super(cookiesApi);
    }

    class Args {

    }

    @Override
    protected void addOptions(Options options) {
    }

    @Override
    protected Args createArgs(CommandLine cmd) throws CreateArgsException {
        return null;
    }

    @Override
    protected String run(CookiesApi api, Args args) {
        return "Done";
    }

    public static void main(String[] args) {
        new SpringScriptRunner<>(
            CookiesConfig.class,
            CookiesApi.class,
            CookiesScript.class
        ).run(args);
    }
}

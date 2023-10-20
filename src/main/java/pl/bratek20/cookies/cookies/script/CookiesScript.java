package pl.bratek20.cookies.cookies.script;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Options;
import pl.bratek20.cookies.cookies.api.CookiesApi;
import pl.bratek20.cookies.cookies.impl.infrastructure.configs.CookiesConfig;
import pl.bratek20.cookies.script.CreateArgsException;
import pl.bratek20.cookies.script.Script;

public class CookiesScript extends Script<CookiesConfig, CookiesApi, CookiesScript.Args> {
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
    protected void run(CookiesApi api, Args args) {

    }

    @Override
    protected Class<CookiesApi> getApiClass() {
        return CookiesApi.class;
    }

    @Override
    protected Class<CookiesConfig> getConfigClass() {
        return CookiesConfig.class;
    }
}
